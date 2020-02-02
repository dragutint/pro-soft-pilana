/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bl.dao.impl;

import bl.dao.EmployeeDao;
import bl.dao.util.ConnectionFactory;
import domain.Employee;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author Dudat
 */
public class EmployeeDaoImpl implements EmployeeDao{

    @Override
    public Employee get(String username) throws SQLException {
        Connection con = ConnectionFactory.getInstance().getConnection();

        String query = new StringBuilder()
                .append("SELECT * FROM sawmill.")
                .append(new Employee().getTableName())
                .append(" WHERE username = '")
                .append(username)
                .append("'")
                .toString();

        Statement stmt = con.createStatement();

        return (Employee) new Employee().getObject(stmt.executeQuery(query));
    }

    @Override
    public Employee get(Integer id) throws Exception {
        Connection con = ConnectionFactory.getInstance().getConnection();
        
        String query = new StringBuilder()
                .append("SELECT * FROM sawmill.")
                .append(new Employee().getTableName())
                .append(" WHERE ")
                .append(new Employee(id).getObjectCase())
                .toString();
        
        Statement stmt = con.createStatement();
        
        return (Employee) new Employee().getObject(stmt.executeQuery(query));
    }
    
}
