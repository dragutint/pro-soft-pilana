/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mvc.controller;

import domain.Client;
import domain.ClientType;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Date;
import java.util.List;
import javax.swing.JOptionPane;
import mvc.model.NewClientModel;
import mvc.view.FClient;
import mvc.view.FNewClient;
import transfer.ResponseObject;

/**
 *
 * @author Dudat
 */
public class NewClientController extends AbstractController{
    FNewClient view;
    NewClientModel model;
    
    public NewClientController(FClient mainForm, List<ClientType> clientTypes) {
        view = new FNewClient(clientTypes);
        view.setComponentOrientation(mainForm.getComponentOrientation());
        model = new NewClientModel();
        
        view.setVisible(true);
        
        view.setAddNewClientListener(new AddNewClientListener());
    }
    
    private class AddNewClientListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            Client newClient = new Client(
                    null,
                    view.getTxtFirstName().getText().trim(),
                    view.getTxtLastName().getText().trim(),
                    new Date(System.currentTimeMillis()), 
                    (ClientType) view.getCmbClientType().getSelectedItem());
            
            try {
                ResponseObject response = model.addNewClient(newClient);
                showMessage(view, response.getMessage());
            } catch (Exception ex) {
                showError(view, ex.getMessage());
            }
        }
    }
}
