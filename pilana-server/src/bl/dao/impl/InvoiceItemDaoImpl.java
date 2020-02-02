/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bl.dao.impl;

import bl.dao.InvoiceItemDao;
import util.ConnectionFactory;
import domain.IGeneralObject;
import domain.InvoiceItem;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.Statement;
import java.util.List;

/**
 *
 * @author Dudat
 */
public class InvoiceItemDaoImpl implements InvoiceItemDao{

    @Override
    public void insert(InvoiceItem ii) throws Exception {
        Connection con = ConnectionFactory.getInstance().getConnection();
        
        String insert = new StringBuilder()
                .append("INSERT INTO sawmill.")
                .append(ii.getTableName())
                .append("(")
                .append(ii.getColumnNamesForInsert())
                .append(") VALUES (")
                .append(ii.getInsertValues())
                .append(")")
                .toString();
        
        PreparedStatement ps = con.prepareStatement(insert);
        
        if(ps.executeUpdate() < 1){
            throw new Exception("System cannot insert invoice item: " + ii.getWoodProduct());
        }
    }

    @Override
    public List<IGeneralObject> findByInvoiceId(Integer invoiceId) throws Exception {
        Connection con = ConnectionFactory.getInstance().getConnection();
        
        String query = new StringBuilder()
                .append("SELECT * FROM sawmill.")
                .append(new InvoiceItem().getTableName())
                .append(" WHERE ")
                .append(new InvoiceItem(invoiceId).getObjectCase())
                .toString();
        
        Statement stmt = con.createStatement();
        
        return new InvoiceItem().getList(stmt.executeQuery(query));
    }
    
}
