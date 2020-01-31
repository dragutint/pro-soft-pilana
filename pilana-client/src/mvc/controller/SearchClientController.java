/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mvc.controller;

import domain.Client;
import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import mvc.model.SearchClientModel;
import mvc.view.FSearchClient;

/**
 *
 * @author Dudat
 */
public class SearchClientController extends AbstractController{
    FSearchClient view;
    SearchClientModel model;
    private final List<Client> allClients;
    
    public SearchClientController(Component comp, List<Client> clients) {
        view = new FSearchClient(clients);
        model = new SearchClientModel();
        
        allClients = clients;
        
        view.setVisible(true);
        view.setShowClientListener(new ShowClientListener());
        view.setOnChangeListener(new OnChangeListener());
    }
    
    private class OnChangeListener implements DocumentListener{

        @Override
        public void insertUpdate(DocumentEvent e) {
            view.getTableModel().setClients(model.search(view.getTxtSearchCriteria().getText().trim(), allClients));
        }

        @Override
        public void removeUpdate(DocumentEvent e) {
            view.getTableModel().setClients(allClients);
        }

        @Override
        public void changedUpdate(DocumentEvent e) {
            view.getTableModel().setClients(model.search(view.getTxtSearchCriteria().getText().trim(), allClients));
        }
    }
    
    private class ShowClientListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            Client selectedClient = view.getTableModel().getSelected(view.getSelectedRow());
            new ClientPreviewController(selectedClient);
        }
    }
    
}
