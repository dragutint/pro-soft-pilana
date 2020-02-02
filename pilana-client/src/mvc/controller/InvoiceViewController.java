/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mvc.controller;

import domain.Invoice;
import mvc.view.FInvoiceView;

/**
 *
 * @author Dudat
 */
public class InvoiceViewController extends AbstractController {
    FInvoiceView view;
    
    public InvoiceViewController(Invoice invoice) {
        this.view = new FInvoiceView(invoice);
        
        view.setVisible(true);
    }
    
}
