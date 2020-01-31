/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mvc.controller;

import domain.Employee;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.logging.Level;
import java.util.logging.Logger;
import mvc.view.FClient;
import mvc.model.ClientModel;

/**
 *
 * @author Dudat
 */
public class ClientController extends AbstractController{
    FClient view; 
    ClientModel model;
   
    public ClientController(Employee emp) {
        view = new FClient(emp);
        model = new ClientModel();
        
        view.setVisible(true);
        view.setNewClientListener(new NewClientListener());
        view.setSearchClientListener(new SearchClientListener());
    }
    
    private class NewClientListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            new NewClientController(view, model.getClientTypes());
        }
    }
    
    private class SearchClientListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            try {
                new SearchClientController(view, model.getClients());
            } catch (Exception ex) {
                showError(view, ex.getMessage(), ClientController.class.getName(), ex);
            }
        }
    }
}
