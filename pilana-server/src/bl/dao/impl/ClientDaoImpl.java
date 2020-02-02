/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bl.dao.impl;

import bl.dao.ClientDao;
import util.ConnectionFactory;
import domain.Client;
import domain.IGeneralObject;
import java.sql.Connection;
import java.sql.PreparedStatement;
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
        
        String query = new StringBuilder()
                .append("SELECT * FROM sawmill.")
                .append(new Client().getTableName())
                .toString();
        
        Statement stmt = con.createStatement();
        ResultSet rs = stmt.executeQuery(query);

        return new Client().getList(rs);
    }

    @Override
    public Client add(Client client) throws Exception {
        String insert = new StringBuilder()
                .append("INSERT INTO sawmill.client ")
                .append("(")
                .append(client.getColumnNamesForInsert())
                .append(")")
                .append(" VALUES ")
                .append("(")
                .append(client.getInsertValues())
                .append(")")
                .toString();
        System.out.println(insert);
        PreparedStatement ps = ConnectionFactory.getInstance().getConnection().prepareStatement(insert, Statement.RETURN_GENERATED_KEYS);
        
        if(ps.executeUpdate() > 0){
            ResultSet rs = ps.getGeneratedKeys();
            if(rs.next()){
                client.setId(rs.getInt(1));
                return client;
            } else 
                throw new Exception("Something went wrong");
        } else {
            throw new Exception("System cannot add new client");
        }
    }

    @Override
    public void update(Client client) throws Exception {
        Connection con = ConnectionFactory.getInstance().getConnection();
        
        String update = "UPDATE sawmill.client SET first_name = ?, last_name = ?, client_type_id = ? WHERE id = ?";
        
        PreparedStatement ps = con.prepareStatement(update);
        ps.setString(1, client.getFirstName());
        ps.setString(2, client.getLastName());
        ps.setInt(3, client.getClientType().getId());
        ps.setInt(4, client.getId());
        
        if(ps.executeUpdate() == 0){
            throw new Exception("System cannot update client");
        }
    }   

    @Override
    public void delete(Client client) throws Exception {
        Connection con = ConnectionFactory.getInstance().getConnection();
        String delete = "DELETE FROM sawmill.client WHERE id = ?";
        
        PreparedStatement ps = con.prepareStatement(delete);
        
        ps.setInt(1, client.getId());
        
        if(ps.executeUpdate() == 0){
            throw new Exception("System cannot delete client");
        }
    }

    @Override
    public Client get(int id) throws Exception {
        Connection con = ConnectionFactory.getInstance().getConnection();
        String query = new StringBuilder()
                .append("SELECT * FROM sawmill.")
                .append(new Client().getTableName())
                .append(" WHERE ")
                .append(new Client(id).getObjectCase())
                .toString();
        
        Statement stmt = con.createStatement();
        
        return (Client) new Client().getObject(stmt.executeQuery(query));
    }
    
}
