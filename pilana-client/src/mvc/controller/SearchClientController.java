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
import mvc.ViewMode;
import mvc.model.SearchClientModel;
import mvc.view.FSearchClient;
import thread.ThreadController;
import transfer.ResponseObject;
import util.DOperation;

/**
 *
 * @author Dudat
 */
public class SearchClientController extends AbstractController{
    FSearchClient view;
    SearchClientModel model;
    ViewMode mode;
    private final List<Client> allClients;
    
    public SearchClientController(Component comp, List<Client> clients, ViewMode mode) {
        this.view = new FSearchClient(clients, mode);
        this.model = new SearchClientModel();
        this.mode = mode;
        allClients = clients;
        
        view.setOnChangeListener(new OnChangeListener());

        switch (mode){
            case PREVIEW:
                view.setActionButtonListener(new ShowClientListener());
                break;

            case EDIT:
                view.setActionButtonListener(new EditClientListener());
                break;

            case DELETE:
                view.setActionButtonListener(new DeleteClientListener());
                break;
        }
        view.setVisible(true);
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
            new ClientViewController(selectedClient, mode);
            view.dispose();
        }
    }
    
    private class EditClientListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            Client selectedClient = view.getTableModel().getSelected(view.getSelectedRow());
            new EditClientController(selectedClient);
            view.dispose();
        }
    }
    
    private class DeleteClientListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            try {
                Client selectedClient = view.getTableModel().getSelected(view.getSelectedRow());
                ResponseObject response = (ResponseObject) ThreadController.getInstance().request(DOperation.DELETE_CLIENT, selectedClient);
                showMessage(view, response.getMessage());
                view.dispose();
            } catch (Exception ex) {
                showError(view, ex.getMessage(), SearchClientController.class.getName(), ex);
                view.dispose();
            }
        }
    }
}
