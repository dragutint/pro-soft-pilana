/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mvc.controller;

import domain.Employee;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import mvc.view.ViewMode;
import mvc.view.FMainScreen;
import mvc.model.ClientModel;
import thread.ThreadController;

/**
 *
 * @author Dudat
 */
public class MainScreenController extends AbstractController{
    FMainScreen view; 
    ClientModel model;
   
    public MainScreenController(Employee emp) throws IOException {
        ThreadController.getInstance().setLoggedEmployee(emp);
        view = new FMainScreen(emp);
        model = new ClientModel();
        
        view.setVisible(true);
        view.setNewClientListener(new NewClientListener());
        view.setPreviewClientListener(new ClientPreviewListener());
        view.setEditClientListener(new EditClientListener());
        view.setDeleteClientListener(new DeleteClientListener());
        view.setPreviewWoodProductListener(new WoodProductPreviewListener());
        view.setNewInvoiceListener(new NewInvoiceListener());
        view.setPreviewInvoiceListener(new InvoicePreviewListener());
    }
    
    private class NewClientListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            new NewClientController(model.getClientTypes());
        }
    }
    
    private class ClientPreviewListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            try {
                new SearchClientController(ViewMode.PREVIEW);
            } catch (Exception ex) {
                showError(view, ex.getMessage(), MainScreenController.class.getName(), ex);
            }
        }
    }
    
    private class EditClientListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            try {
                new SearchClientController(ViewMode.EDIT);
            } catch (Exception ex) {
                showError(view, ex.getMessage(), MainScreenController.class.getName(), ex);
            }
        }
    }
    
    private class DeleteClientListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            try {
                new SearchClientController(ViewMode.DELETE);
            } catch (Exception ex) {
                showError(view, ex.getMessage(), MainScreenController.class.getName(), ex);
            }
        }
    }
    
    private class WoodProductPreviewListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            try {
                new SearchWoodProductController();
            } catch (Exception ex) {
                showError(view, ex.getMessage(), MainScreenController.class.getName(), ex);
            }
        }
    }
    
    private class NewInvoiceListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            try {
                new NewInvoiceController();
            } catch (Exception ex) {
                showError(view, ex.getMessage(), MainScreenController.class.getName(), ex);
            }
        }
    }
    
    private class InvoicePreviewListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            try {
                new InvoiceSearchController();
            } catch (Exception ex) {
                showError(view, ex.getMessage(), MainScreenController.class.getName(), ex);
            }
        }
    }
}
