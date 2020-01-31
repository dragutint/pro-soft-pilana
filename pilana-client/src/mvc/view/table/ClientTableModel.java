/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mvc.view.table;

import domain.Client;
import java.util.List;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author Dudat
 */
public class ClientTableModel extends AbstractTableModel {
    private List<Client> list;

    public ClientTableModel(List<Client> clients) {
        this.list = clients;
        fireTableDataChanged();
    }
    
    @Override
    public int getRowCount() {
        return list.size();
    }

    @Override
    public int getColumnCount() {
        return 5;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Client c = list.get(rowIndex);
        switch(columnIndex){
            case 0:
                return c.getId();
            case 1:
                return c.getFirstName();
            case 2:
                return c.getLastName();
            case 3:
                return c.getRegistrationDate();
            case 4:
                return c.getClientType();
            default:
                return "haha";
        }
    }
    
    public Client getSelected(int rowNum){
        return list.get(rowNum);
    }

    public void setClients(List<Client> clients) {
        this.list = clients; 
        fireTableDataChanged();
    }
    
}
