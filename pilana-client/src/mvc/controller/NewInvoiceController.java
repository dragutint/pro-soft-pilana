/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mvc.controller;

import domain.Client;
import domain.Invoice;
import domain.InvoiceItem;
import domain.WoodProduct;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import mvc.model.NewInvoiceModel;
import mvc.view.FNewInvoice;
import thread.ThreadController;
import transfer.ResponseObject;
import util.DOperation;

/**
 *
 * @author Dudat
 */
public class NewInvoiceController extends AbstractController {
    FNewInvoice view;
    NewInvoiceModel model;
    
    final List<WoodProduct> allWoodProducts;

    public NewInvoiceController() throws Exception {
        this.model = new NewInvoiceModel();
        allWoodProducts = model.findWoodProducts();
        
        this.view = new FNewInvoice(allWoodProducts, model.findClients());
        this.view.setOnChangeInputListener(new OnChangeListener());
        this.view.setAddWoodProductListener(new AddWoodProductListener());
        this.view.setClearAllItemsListener(new ClearAllItemsListener());
        this.view.setRemoveInvoiceItemListener(new RemoveInvoiceItemListener());
        this.view.setSubmitListener(new SubmitListener());
        view.setVisible(true);
    }
    
    private class OnChangeListener implements DocumentListener {
        @Override
        public void insertUpdate(DocumentEvent e) {
            String term = view.getTxtSearchCriteria().getText();
            view.getWoodProductsTableModel().setWoodProducts(model.search(term, allWoodProducts));
        }

        @Override
        public void removeUpdate(DocumentEvent e) {
            String term = view.getTxtSearchCriteria().getText();
            view.getWoodProductsTableModel().setWoodProducts(model.search(term, allWoodProducts));
        }

        @Override
        public void changedUpdate(DocumentEvent e) {
            String term = view.getTxtSearchCriteria().getText();
            view.getWoodProductsTableModel().setWoodProducts(model.search(term, allWoodProducts));
        }
        
    }
    
    private class AddWoodProductListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            try {
                WoodProduct selectedWoodProduct = view.getWoodProductsTableModel().getSelected(view.getSelectedWoodProduct());
                Integer amount = Integer.valueOf(view.getTxtAmount().getText());
                
                view.getInvoiceItemsTableModel().addWoodProduct(new InvoiceItem(null, null, amount, selectedWoodProduct));
            } catch (NumberFormatException ex){
                showError(view, "You have not entered amount", NewInvoiceController.class.getName(), ex);
            } catch (Exception ex) {
                showError(view, ex.getMessage(), NewInvoiceController.class.getName(), ex);
            } 
        }
    }
    
    private class RemoveInvoiceItemListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            view.getInvoiceItemsTableModel().removeItem(view.getSelectedInvoiceItem());
        }
    }
    
    private class ClearAllItemsListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            view.getInvoiceItemsTableModel().removeAll();
        }
    }
    
    private class SubmitListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            try {
                Invoice invoice = new Invoice(null,
                        new Date(System.currentTimeMillis()),
                        view.getTxtDescription().getText(),
                        view.getInvoiceItemsTableModel().getItems(),
                        (Client) view.getCmbClient().getSelectedItem(),
                        ThreadController.getInstance().getLoggedEmployee());
                
                ResponseObject response = (ResponseObject) ThreadController.getInstance().request(DOperation.NEW_INVOICE, invoice);
                showMessage(view, response.getMessage());
            } catch (Exception ex) {
                showError(view, ex.getMessage(), this.getClass().getName(), ex);
            }
        }
    }
}
