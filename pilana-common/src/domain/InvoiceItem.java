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
public class InvoiceItem implements Serializable, IGeneralObject{
    private Integer invoiceId;
    private Integer ordinal;
    private Integer amount;
    private WoodProduct woodProduct;

    public InvoiceItem() {
    }

    public InvoiceItem(Integer invoiceId) {
        this.invoiceId = invoiceId;
    }
    
    public InvoiceItem(Integer invoiceId, Integer ordinal, Integer amount, WoodProduct woodProduct) {
        this.invoiceId = invoiceId;
        this.ordinal = ordinal;
        this.amount = amount;
        this.woodProduct = woodProduct;
    }

    public Integer getInvoiceId() {
        return invoiceId;
    }

    public void setInvoiceId(Integer invoiceId) {
        this.invoiceId = invoiceId;
    }

    public Integer getOrdinal() {
        return ordinal;
    }

    public void setOrdinal(Integer ordinal) {
        this.ordinal = ordinal;
    }

    public Integer getAmount() {
        return amount;
    }

    public void setAmount(Integer amount) {
        this.amount = amount;
    }

    public WoodProduct getWoodProduct() {
        return woodProduct;
    }

    public void setWoodProduct(WoodProduct woodProduct) {
        this.woodProduct = woodProduct;
    }

    @Override
    public String getTableName() {
        return "invoice_item";
    }

    @Override
    public String getColumnNamesForInsert() {
        return "invoice_id, ordinal, amount, wood_product_id";
    }

    @Override
    public String getInsertValues() {
        return new StringBuilder()
                .append(this.getInvoiceId())
                .append(", ")
                .append(this.getOrdinal())
                .append(", ")
                .append(this.getAmount())
                .append(", ")
                .append(this.getWoodProduct().getId())
                .toString();
    }

    @Override
    public void setId(int id) {
        this.invoiceId = id;
    }

    @Override
    public IGeneralObject getObject(ResultSet rs) throws SQLException {
        return null;
    }

    @Override
    public String getObjectCase() {
        return "invoice_id = " + this.getInvoiceId();
    }

    @Override
    public List<IGeneralObject> getList(ResultSet rs) throws SQLException {
        List<IGeneralObject> list = new ArrayList<>();
        while(rs.next()){
            list.add(new InvoiceItem(
                            rs.getInt("invoice_id"),
                            rs.getInt("ordinal"),
                            rs.getInt("amount"),
                            new WoodProduct(rs.getInt("wood_product_id"))
                    )
            );
        }
        return list;
    }

    @Override
    public Integer getId() {
        return this.getId();
    }

    @Override
    public String getUpdateValues() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
