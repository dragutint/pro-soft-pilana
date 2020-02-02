/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bl.service.so.impl;

import bl.service.validation.InvoiceItemValidation;
import bl.service.validation.InvoiceValidation;
import bl.service.so.AbstractGenericOperation;
import domain.IGeneralObject;
import domain.Invoice;
import domain.InvoiceItem;

/**
 *
 * @author Dudat
 */
public class SOSaveInvoice extends AbstractGenericOperation {

    @Override
    protected void preconditions(Object entity) throws Exception {
        InvoiceValidation.validate((Invoice) entity);
    }

    @Override
    protected Object executeOperation(Object entity) throws Exception {
        Invoice invoice = (Invoice) entity;
        
        Invoice savedInvoice = (Invoice) genericDao.save((IGeneralObject) entity);

        int i = 0;
        for (InvoiceItem ii : invoice.getItems()) {
            InvoiceItemValidation.validate(ii);

            ii.getWoodProduct().setBalance(ii.getWoodProduct().getBalance() - ii.getAmount());
            ii.setInvoiceId(savedInvoice.getId());
            ii.setOrdinal(++i);
            
            genericDao.save(ii);
            genericDao.update(ii.getWoodProduct());
        }

        return savedInvoice;
    }
    
}
