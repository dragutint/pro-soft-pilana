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
public class Invoice implements Serializable, IGeneralObject{
    private Integer id;
    private Date dateCreated;
    private String description;
    private List<InvoiceItem> items;
    private Client client;
    private Employee employee;

    public Invoice() {
    }

    public Invoice(Integer id, Date dateCreated, String description, List<InvoiceItem> items, Client client, Employee employee) {
        this.id = id;
        this.dateCreated = dateCreated;
        this.description = description;
        this.items = items;
        this.client = client;
        this.employee = employee;
    }
    
    public Integer getId() {
        return id;
    }

    public Date getDateCreated() {
        return dateCreated;
    }

    public void setDateCreated(Date dateCreated) {
        this.dateCreated = dateCreated;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public List<InvoiceItem> getItems() {
        return items;
    }

    public void setItems(List<InvoiceItem> items) {
        this.items = items;
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    public Employee getEmployee() {
        return employee;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }

    @Override
    public String getTableName() {
        return "invoice";
    }

    @Override
    public String getColumnNamesForInsert() {
        return "date_created, description, client_id, employee_id";
    }

    @Override
    public String getInsertValues() {
        return new StringBuilder()
                .append("SYSDATE()")
                .append(", '")
                .append(this.getDescription())
                .append("', ")
                .append(this.client.getId())
                .append(", ")
                .append(this.employee.getId())
                .toString();
    }

    @Override
    public void setId(int id) {
        this.id = id;
    }

    @Override
    public IGeneralObject getObject(ResultSet rs) throws SQLException {
        Invoice invoice = new Invoice();
        invoice.setId(rs.getInt("id"));
        invoice.setDateCreated(rs.getDate("date_created"));
        invoice.setDescription(rs.getString("description"));
        invoice.setClient(new Client(rs.getInt("client_id")));
        invoice.setEmployee(new Employee(rs.getInt("employee_id")));
        return invoice;
    }

    @Override
    public String getObjectCase() {
        return "id = " + this.id;
    }

    @Override
    public List<IGeneralObject> getList(ResultSet rs) throws SQLException {
        List<IGeneralObject> list = new ArrayList<>();
        
        while(rs.next()){
            Invoice invoice = new Invoice();
            invoice.setId(rs.getInt("id"));
            invoice.setDateCreated(rs.getDate("date_created"));
            invoice.setDescription(rs.getString("description"));
            invoice.setClient(new Client(rs.getInt("client_id")));
            invoice.setEmployee(new Employee(rs.getInt("employee_id")));
            list.add(invoice);
        }
        
        return list;
    }
}
