/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bl.dao.impl;

import bl.dao.WoodProductDao;
import bl.dao.util.ConnectionFactory;
import domain.IGeneralObject;
import domain.WoodProduct;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.List;

/**
 *
 * @author Dudat
 */
public class WoodProductDaoImpl implements WoodProductDao{

    @Override
    public List<IGeneralObject> find() throws Exception {
        Connection con = ConnectionFactory.getInstance().getConnection();
        
        String query = new StringBuilder()
                .append("SELECT * FROM sawmill.")
                .append(new WoodProduct().getTableName())
                .toString();
        Statement stmt = con.createStatement();
        ResultSet rs = stmt.executeQuery(query);
        
        return new WoodProduct().getList(rs);
    }

    @Override
    public void updateBalance(WoodProduct woodProduct) throws Exception {
        Connection con = ConnectionFactory.getInstance().getConnection();
        
        String upd = "UPDATE sawmill.wood_product SET balance = ?";
        String update = new StringBuilder()
                .append("SELECT * FROM sawmill.")
                .append(woodProduct.getTableName())
                .append(" SET balance = ")
                .append(woodProduct.getBalance())
                .append(" WHERE ")
                .append(woodProduct.getObjectCase())
                .toString();
        
        PreparedStatement ps = con.prepareStatement(update);
        
        if(ps.executeUpdate() < 1){
            throw new Exception("System cannot update balance on wood product with id: " + woodProduct.getId());
        }
    }
    
}
