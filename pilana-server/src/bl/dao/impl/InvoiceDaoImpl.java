/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bl.dao.impl;

import bl.dao.InvoiceDao;
import bl.dao.util.ConnectionFactory;
import domain.Invoice;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

/**
 *
 * @author Dudat
 */
public class InvoiceDaoImpl implements InvoiceDao {

    @Override
    public Invoice insert(Invoice invoice) throws Exception {
        Connection con = ConnectionFactory.getInstance().getConnection();
        
        String insert = new StringBuilder()
                .append("INSERT INTO sawmill.")
                .append(invoice.getTableName())
                .append(" (")
                .append(invoice.getColumnNamesForInsert())
                .append(") VALUES (")
                .append(invoice.getInsertValues())
                .append(")")
                .toString();
        
        PreparedStatement ps = con.prepareStatement(insert, Statement.RETURN_GENERATED_KEYS);
        
        if(ps.executeUpdate() < 1){
            throw new Exception("System cannot save new invoice");
        }
        
        ResultSet rs = ps.getGeneratedKeys();
        
        if(rs.next()){
            invoice.setId(rs.getInt(1));
            return invoice;
        } else {
            throw new Exception("Something went wrong");
        }
    }
    
}