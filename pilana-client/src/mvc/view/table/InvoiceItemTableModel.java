/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mvc.view.table;

import domain.InvoiceItem;
import domain.WoodProduct;
import java.util.List;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author Dudat
 */
public class InvoiceItemTableModel extends AbstractTableModel{
    List<InvoiceItem> items;
    boolean extended; 
    
    public InvoiceItemTableModel(List<InvoiceItem> list, boolean extended) {
        this.items = list;
        this.extended = extended;
    }
    
    @Override
    public int getRowCount() {
        return items.size();
    }

    @Override
    public int getColumnCount() {
        if(extended){
            return 5;
        }
        return 2;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        InvoiceItem ii = items.get(rowIndex);
        if(!extended){
            switch(columnIndex){
                case 0:
                    return ii.getWoodProduct().getName();
                case 1:
                    return ii.getAmount();
                default:
                    return "nothing";
            }
        }
        switch (columnIndex) {
            case 0:
                return ii.getOrdinal();
            case 1:
                return ii.getWoodProduct().getName();
            case 2:
                return ii.getWoodProduct().getPrice();
            case 3:
                return ii.getAmount();
            case 4:
                return ii.getWoodProduct().getPrice() * ii.getAmount();
            default:
                return "nothing";
        }
    }

    @Override
    public String getColumnName(int column) {
        if(!extended){
            switch(column){
                case 0:
                    return "Wood product";
                case 1:
                    return "Amount";
                default:
                    return "nothing";
            }
        }
        
        switch (column) {
            case 0: 
                return "Ordinal";
            case 1:
                return "Wood product";
            case 2:
                return "Price";
            case 3:
                return "Amount";
            case 4:
                return "Total";
            default:
                return "nothing";
        }
    }
    
    public void addWoodProduct(InvoiceItem item) throws Exception{
        int index = getIndexByWoodProduct(item.getWoodProduct());
        
        if(index == -1){
            items.add(item);
        } else {
            items.get(index).setAmount(items.get(index).getAmount() + item.getAmount());
        }
        
        fireTableDataChanged();
    }

    private int getIndexByWoodProduct(WoodProduct wp) {
        for(int i = 0; i < items.size(); i++)
            if(items.get(i).getWoodProduct().getId().equals(wp.getId())) return i;
        return -1;
    }

    public List<InvoiceItem> getItems() {
        return items;
    }

    public void removeItem(int selectedInvoiceItem) {
        items.remove(selectedInvoiceItem);
        fireTableDataChanged();
    }

    public void removeAll() {
        items.clear();
        fireTableDataChanged();
    }
}
