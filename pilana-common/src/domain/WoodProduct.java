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

    public WoodProduct() {
    }

    public WoodProduct(Integer id, String name, Double price) {
        this.id = id;
        this.name = name;
        this.price = price;
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
        return "name, price";
    }

    @Override
    public String getInsertValues() {
        return new StringBuilder()
                .append("'")
                .append(this.name)
                .append("', ")
                .append(this.price)
                .toString();
    }

    @Override
    public void setId(int id) {
        this.id = id;
    }

    @Override
    public IGeneralObject getObject(ResultSet rs) throws SQLException {
        WoodProduct wp = new WoodProduct();
        
        wp.setId(rs.getInt("id"));
        wp.setName(rs.getString("name"));
        wp.setPrice(rs.getDouble("price"));
        
        return wp;
    }

    @Override
    public String getObjectCase() {
        return "id = " + this.getId();
    }

    @Override
    public List<IGeneralObject> getList(ResultSet rs) throws SQLException {
        List<IGeneralObject> list = new ArrayList<>();
        
        while(rs.next()){
            WoodProduct wp = new WoodProduct();

            wp.setId(rs.getInt("id"));
            wp.setName(rs.getString("name"));
            wp.setPrice(rs.getDouble("price"));
            
            list.add(wp);
        }
        
        return list;
    }
    
    
}
