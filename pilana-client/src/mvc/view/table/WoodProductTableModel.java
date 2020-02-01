/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mvc.view.table;

import domain.Client;
import domain.WoodProduct;
import java.util.List;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author Dudat
 */
public class WoodProductTableModel extends AbstractTableModel {
    private List<WoodProduct> list; 

    public WoodProductTableModel(List<WoodProduct> list) {
        this.list = list;
    }
    
    @Override
    public int getRowCount() {
        return this.list.size();
    }

    @Override
    public int getColumnCount() {
        return 2;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        WoodProduct wp = list.get(rowIndex);
        switch(columnIndex){
            case 0:
                return wp.getId();
            case 1:
                return wp.getName();
            default:
                return "nothing";
        }
    }

    @Override
    public String getColumnName(int column) {
        if(column == 0){
            return "ID";
        } else {
            return "Name";
        }
    }

    public void setWoodProducts(List<WoodProduct> list) {
        this.list = list;
        fireTableDataChanged();
    }

    public WoodProduct getSelected(int selectedRow) {
        return list.get(selectedRow);
    }
    
}
