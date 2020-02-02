/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package util;

import util.PropertyReader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author Dudat
 */
public class ConnectionFactory {

    private Connection connection;
    private static ConnectionFactory instance;

    private ConnectionFactory() throws SQLException {
        try {
            String url = PropertyReader.getInstance().getProperty("db.url");
            String username = PropertyReader.getInstance().getProperty("db.user");
            String password = PropertyReader.getInstance().getProperty("db.pass");
            connection = DriverManager.getConnection(url, username, password);
            connection.setAutoCommit(Boolean.valueOf(PropertyReader.getInstance().getProperty("db.autocommit"))); 
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
