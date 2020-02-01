/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bl.dao.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author student1
 */
public class ConnectionFactory {

    private Connection connection;
    private static ConnectionFactory instance;

    private ConnectionFactory() throws SQLException {
        try {
            // TODO move to properties file
            String url = "jdbc:mysql://localhost:3306/sawmill";
            String username = "root";
            String password = "";
            connection = DriverManager.getConnection(url, username, password);
        } catch (SQLException ex) {
            throw new SQLException("Connection is not created!");
        }
    }

    public Connection getConnection() {
        return connection;
    }

    public static ConnectionFactory getInstance() throws SQLException {
        if (instance == null) {
            instance = new ConnectionFactory();
        }
        return instance;
    }
}
