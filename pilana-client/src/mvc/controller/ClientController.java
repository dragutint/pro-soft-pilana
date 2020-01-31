/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mvc.controller;

import domain.Employee;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
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
    }
    
    private class NewClientListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            new NewClientController(view, model.getClientTypes());
        }
    }
}
