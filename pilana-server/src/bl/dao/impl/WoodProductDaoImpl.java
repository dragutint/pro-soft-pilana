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
    
}
