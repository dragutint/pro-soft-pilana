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
import java.util.List;

/**
 *
 * @author Dudat
 */
public class WoodProduct implements Serializable, IGeneralObject{
    private Integer id;
    private String name;
    private Double price;
    private Integer balance;

    public WoodProduct() {
    }

    public WoodProduct(Integer id) {
        this.id = id;
    }
    
    public WoodProduct(Integer id, String name, Double price, Integer balance) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.balance = balance;
    }

    public void setBalance(Integer balance) {
        this.balance = balance;
    }

    public Integer getBalance() {
        return balance;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    @Override
    public String getTableName() {
        return "wood_product";
    }

    @Override
    public String getColumnNamesForInsert() {
        return "name, price, balance";
    }

    @Override
    public String getInsertValues() {
        return new StringBuilder()
                .append("'")
                .append(this.name)
                .append("', ")
                .append(this.price)
                .append(", ")
                .append(this.balance)
                .toString();
    }

    @Override
    public void setId(int id) {
        this.id = id;
    }

    @Override
    public IGeneralObject getObject(ResultSet rs) throws SQLException {
        if(rs.next())
            return new WoodProduct(
                    rs.getInt("id"),
                    rs.getString("name"),
                    rs.getDouble("price"),
                    rs.getInt("balance")
            );
        throw new SQLException("No wood product in result set");
    }

    @Override
    public String getObjectCase() {
        return "id = " + this.getId();
    }

    @Override
    public List<IGeneralObject> getList(ResultSet rs) throws SQLException {
        List<IGeneralObject> list = new ArrayList<>();
        
        while(rs.next()){
            list.add(new WoodProduct(
                    rs.getInt("id"),
                    rs.getString("name"),
                    rs.getDouble("price"),
                    rs.getInt("balance")
            ));
        }
        
        return list;
    }

    @Override
    public String getUpdateValues() {
        return new StringBuilder()
                .append("name = '").append(this.getName()).append("', ")
                .append("price = ").append(this.getPrice()).append(", ")
                .append("balance = ").append(this.getBalance())
                .toString();
    }
}
