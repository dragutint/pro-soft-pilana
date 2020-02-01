/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mvc.controller;

import domain.Client;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import mvc.ViewMode;
import mvc.model.EditClientModel;
import mvc.view.FClientView;
import mvc.view.util.form_getter.ClientFormGetter;
import transfer.ResponseObject;

/**
 *
 * @author Dudat
 */
public class EditClientController extends AbstractController {
    FClientView view;
    EditClientModel model;
    
    public EditClientController(Client selectedClient) {
        view = new FClientView(selectedClient, ViewMode.EDIT);
        model = new EditClientModel();
        
        view.addClientTypes(model.getClientTypes(), selectedClient.getClientType());
        view.setSaveChangesListener(new SaveChangesListener());
        
        view.setVisible(true);
    }
    
    private class SaveChangesListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            try {
                Client client = ClientFormGetter.get(view.getTxtId(), view.getTxtFirstName(), view.getTxtLastName(), view.getTxtRegistrationDate(), view.getCmbClientType());
                ResponseObject response = model.editClient(client);
                showMessage(view, response.getMessage());
            } catch (Exception ex) {
                showError(view, ex.getMessage(), NewClientController.class.getName(), ex);
            }
        }
    }
}
