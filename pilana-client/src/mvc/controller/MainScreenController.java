/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mvc.controller;

import domain.Employee;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import mvc.ViewMode;
import mvc.view.FMainScreen;
import mvc.model.ClientModel;

/**
 *
 * @author Dudat
 */
public class MainScreenController extends AbstractController{
    FMainScreen view; 
    ClientModel model;
   
    public MainScreenController(Employee emp) {
        view = new FMainScreen(emp);
        model = new ClientModel();
        
        view.setVisible(true);
        view.setNewClientListener(new NewClientListener());
        view.setPreviewClientListener(new ClientPreviewListener());
        view.setEditClientListener(new EditClientListener());
        view.setDeleteClientListener(new DeleteClientListener());
    }
    
    private class NewClientListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            new NewClientController(view, model.getClientTypes());
        }
    }
    
    private class ClientPreviewListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            try {
                new SearchClientController(view, model.getClients(), ViewMode.PREVIEW);
            } catch (Exception ex) {
                showError(view, ex.getMessage(), MainScreenController.class.getName(), ex);
            }
        }
    }
    
    private class EditClientListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            try {
                new SearchClientController(view, model.getClients(), ViewMode.EDIT);
            } catch (Exception ex) {
                showError(view, ex.getMessage(), MainScreenController.class.getName(), ex);
            }
        }
    }
    
    private class DeleteClientListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            try {
                new SearchClientController(view, model.getClients(), ViewMode.DELETE);
            } catch (Exception ex) {
                showError(view, ex.getMessage(), MainScreenController.class.getName(), ex);
            }
        }
    }
}
