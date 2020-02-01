/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mvc.controller;

import domain.Client;
import domain.ClientType;
import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;
import mvc.model.NewClientModel;
import mvc.view.util.validation.ClientValidation;
import mvc.view.FNewClient;
import mvc.view.util.form_getter.ClientFormGetter;
import transfer.ResponseObject;

/**
 *
 * @author Dudat
 */
public class NewClientController extends AbstractController{
    FNewClient view;
    NewClientModel model;
    
    public NewClientController(Component comp, List<ClientType> clientTypes) {
        view = new FNewClient(clientTypes);
        model = new NewClientModel();
        
        view.setVisible(true);
        
        view.setAddNewClientListener(new AddNewClientListener());
    }
    
    private class AddNewClientListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {        
            try {
                Client newClient = ClientFormGetter.get(null, view.getTxtFirstName(), view.getTxtLastName(), null, view.getCmbClientType());
                ClientValidation.validate(newClient);
                ResponseObject response = model.addNewClient(newClient);
                showMessage(view, response.getMessage());
            } catch (Exception ex) {
                showError(view, ex.getMessage(), NewClientController.class.getName(), ex);
            }
        }
    }
}
