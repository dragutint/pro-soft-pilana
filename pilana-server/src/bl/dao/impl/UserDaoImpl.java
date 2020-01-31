/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bl.dao.impl;

import bl.dao.UserDao;
import bl.dao.util.ConnectionFactory;
import domain.Employee;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Dudat
 */
public class UserDaoImpl implements UserDao{

    @Override
    public Employee get(String username) throws SQLException {
        Connection con = ConnectionFactory.getInstance().getConnection();
        String query = "SELECT * FROM sawmill.employee WHERE username = ?";
        
        PreparedStatement ps = con.prepareStatement(query);
        ps.setString(1, username);
        
        ResultSet rs = ps.executeQuery();
        Employee emp = new Employee();
        
        if(rs.next()){
            emp.setId(rs.getInt("id"));            
            emp.setFirstName(rs.getString("first_name"));
            emp.setLastName(rs.getString("last_name"));
            emp.setUsername(rs.getString("username"));
            emp.setPassword(rs.getString("password"));
            return emp;
        } else {
            return null;
        }
    }
    
}
