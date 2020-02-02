/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bl.service.so.impl;

import bl.service.so.AbstractGenericOperation;
import domain.Client;
import domain.Employee;
import domain.IGeneralObject;
import domain.Invoice;
import domain.InvoiceItem;
import domain.WoodProduct;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Dudat
 */
public class SOFindInvoices extends AbstractGenericOperation {

    @Override
    protected void preconditions(Object entity) throws Exception {
        return;
    }

    @Override
    protected Object executeOperation(Object entity) throws Exception {
        List<Invoice> invoices = convertToInvoices(genericDao.find((IGeneralObject) entity));

        for (Invoice i : invoices) {
            mapItems(i);
            mapClient(i);
            mapEmployee(i);
        }
        return invoices;
    }
    
    private void mapItems(Invoice i) throws Exception {
        List<IGeneralObject> items = genericDao.findBy(new InvoiceItem(), "invoice_id", i.getId() + "");
        List<InvoiceItem> returnList = new ArrayList<>();

        for (IGeneralObject igo : items) {
            returnList.add((InvoiceItem) igo);
        }

        for (InvoiceItem ii : returnList) {
            mapWoodProduct(ii);
        }

        i.setItems(returnList);
    }

    private void mapClient(Invoice i) throws Exception {
//        i.setClient(clientDao.get(i.getClient().getId()));
        i.setClient((Client) genericDao.get(i.getClient()));
    }

    private void mapEmployee(Invoice i) throws Exception {
        i.setEmployee((Employee) genericDao.get(i.getEmployee()));
    }

    private void mapWoodProduct(InvoiceItem ii) throws Exception {
        ii.setWoodProduct((WoodProduct) genericDao.get(ii.getWoodProduct()));
    }

    private List<Invoice> convertToInvoices(List<IGeneralObject> find) {
        List<Invoice> list = new ArrayList<>();
        for(IGeneralObject i : find){
            list.add((Invoice) i);
        }
        return list;
    }
    
}
