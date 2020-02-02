/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mvc.view.table;

import domain.Invoice;
import java.util.List;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author Dudat
 */
public class InvoiceTableModel extends AbstractTableModel{
    private List<Invoice> list;

    public InvoiceTableModel(List<Invoice> invoices) {
        this.list = invoices;
    }
    
    @Override
    public int getRowCount() {
        return list.size();
    }

    @Override
    public int getColumnCount() {
        return 4;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Invoice i = list.get(rowIndex);
        switch(columnIndex){
            case 0:
                return i.getId();
            case 1:
                return i.getClient().toString();
            case 2:
                return i.getEmployee().toString();
            case 3:
                return i.calculatePrice();
            default:
                return "nothing";
        }
    }

    @Override
    public String getColumnName(int column) {
        switch (column) {
            case 0:
                return "ID";
            case 1:
                return "Client";
            case 2:
                return "Employee";
            case 3:
                return "Price";
            default:
                return "nothing";
        }
    }

    public Invoice getSelectedInvoice(int selectedItem) throws Exception {
        if(selectedItem == -1)
            throw new Exception("You have not selected invoice");
        return list.get(selectedItem);
    }
    
    public void setInvoices(List<Invoice> list){
        this.list = list;
        fireTableDataChanged();
    }
}
