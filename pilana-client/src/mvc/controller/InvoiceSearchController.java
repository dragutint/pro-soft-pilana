/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mvc.controller;

import domain.Client;
import domain.Invoice;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import mvc.model.SearchInvoiceModel;
import mvc.view.FSearchInvoice;

/**
 *
 * @author Dudat
 */
public class InvoiceSearchController extends AbstractController {
    FSearchInvoice view;
    SearchInvoiceModel model;
    final List<Invoice> allInvoices;
    
    public InvoiceSearchController() throws Exception {
        this.model = new SearchInvoiceModel();
        allInvoices = model.findInvoices();
        
        this.view = new FSearchInvoice(allInvoices, model.findClients());
        
        this.view.setShowInvoiceListener(new ShowInvoiceListener());
        this.view.setOnChangeListener(new ItemChangeListener());
        
        view.setVisible(true);
    }
    
    private class ShowInvoiceListener implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent e) {
            try {
                Invoice selectedInvoice = view.getTableModel().getSelectedInvoice(view.getSelectedItem());
                new InvoiceViewController(selectedInvoice);
            } catch (Exception ex) {
                showError(view, ex.getMessage(), this.getClass().getName(), ex);
            }
        }
    }
    
    private class ItemChangeListener implements ItemListener {
        @Override
        public void itemStateChanged(ItemEvent event) {
            if (event.getStateChange() == ItemEvent.SELECTED) {
                Client client = (Client) event.getItem();
                view.getTableModel().setInvoices(model.search(client, allInvoices));
            }
        }
    }
    
}
