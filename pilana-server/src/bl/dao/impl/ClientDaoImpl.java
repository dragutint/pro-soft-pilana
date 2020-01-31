/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bl.dao.impl;

import bl.dao.ClientDao;
import bl.dao.util.ConnectionFactory;
import domain.Client;
import domain.IGeneralObject;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.List;

/**
 *
 * @author Dudat
 */
public class ClientDaoImpl implements ClientDao {

    @Override
    public List<IGeneralObject> find() throws Exception {
        Connection con = ConnectionFactory.getInstance().getConnection();
        
        String query = "SELECT * FROM sawmill.client";
        Statement stmt = con.createStatement();
        ResultSet rs = stmt.executeQuery(query);

        Client c = new Client();
        List<IGeneralObject> list = c.getList(rs);
        
        return list;
    }

    @Override
    public Client add(Client client) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
