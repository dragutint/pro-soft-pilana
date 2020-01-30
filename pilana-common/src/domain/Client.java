/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package domain;

import java.io.Serializable;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 *
 * @author Dudat
 */
public class Client implements Serializable, IGeneralObject {
    private Integer id;
    private String firstName;
    private String lastName;
    private Date registrationDate;
    private ClientType clientType;

    public Client() {
    }
    
    public Client(Integer id) {
        this.id = id;
    }

    public Client(int id, String firstName, String lastName, Date registrationDate, ClientType clientType) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.registrationDate = registrationDate;
        this.clientType = clientType;
    }
    
    
  
    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public Date getRegistrationDate() {
        return registrationDate;
    }

    public void setRegistrationDate(Date registrationDate) {
        this.registrationDate = registrationDate;
    }

    public ClientType getClientType() {
        return clientType;
    }

    public void setClientType(ClientType clientType) {
        this.clientType = clientType;
    }
    
    public int getId() {
        return id;
    }

    @Override
    public String getTableName() {
        return "client";
    }

    @Override
    public String getColumnNamesForInsert() {
        return "first_name, last_name, registration_date, client_type_id";
    }

    @Override
    public String getInsertValues() {
        return new StringBuilder()
                .append("'")
                .append(this.firstName)
                .append("', '")
                .append(this.lastName)
                .append("', ")
                .append(this.registrationDate)
                .append(", ")
                .append(this.clientType.getId())
                .toString();
    }

    @Override
    public void setId(int id) {
        this.id = id;
    }

    @Override
    public IGeneralObject getObject(ResultSet rs) throws SQLException {
        Client c = new Client();
        c.setId(rs.getInt("id"));
        c.setFirstName(rs.getString("first_name"));
        c.setLastName(rs.getString("last_name"));
        c.setRegistrationDate(rs.getDate("registration_date"));
        return c;
    }

    @Override
    public String getObjectCase() {
        return "id = " + this.getId();
    }

    @Override
    public List<IGeneralObject> getList(ResultSet rs) throws SQLException{
        List<IGeneralObject> list = new ArrayList<>();
        
        while(rs.next()){
            Client c = new Client();
            c.setId(rs.getInt("id"));
            c.setFirstName(rs.getString("first_name"));
            c.setLastName(rs.getString("last_name"));
            c.setRegistrationDate(rs.getDate("registration_date"));
            list.add(c);
        }
        
        return list;
    }
    
    
}
