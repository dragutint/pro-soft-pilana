/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bl.service.impl;

import bl.dao.ClientDao;
import bl.dao.EmployeeDao;
import bl.dao.InvoiceDao;
import bl.dao.InvoiceItemDao;
import bl.dao.WoodProductDao;
import bl.dao.impl.ClientDaoImpl;
import bl.dao.impl.EmployeeDaoImpl;
import bl.dao.impl.InvoiceDaoImpl;
import bl.dao.impl.InvoiceItemDaoImpl;
import bl.dao.impl.WoodProductDaoImpl;
import bl.dao.util.ConnectionFactory;
import bl.service.InvoiceService;
import domain.Invoice;
import domain.InvoiceItem;
import bl.service.util.validation.InvoiceItemValidation;
import bl.service.util.validation.InvoiceValidation;
import domain.IGeneralObject;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Dudat
 */
public class InvoiceServiceImpl implements InvoiceService {
    private final InvoiceDao invoiceDao;
    private final InvoiceItemDao invoiceItemDao;
    private final WoodProductDao woodProductDao;
    private final EmployeeDao employeeDao;
    private final ClientDao clientDao;
    
    public InvoiceServiceImpl() {
        invoiceDao = new InvoiceDaoImpl();
        invoiceItemDao = new InvoiceItemDaoImpl();
        woodProductDao = new WoodProductDaoImpl();
        clientDao = new ClientDaoImpl();
        employeeDao = new EmployeeDaoImpl();
    }
    
    
    @Override
    public Invoice addNewInvoice(Invoice invoice) throws Exception {
        InvoiceValidation.validate(invoice);
        
        Invoice savedInvoice = invoiceDao.insert(invoice);
        
        int i = 0;
        for(InvoiceItem ii : invoice.getItems()){
            InvoiceItemValidation.validate(ii);
    
            ii.setInvoiceId(savedInvoice.getId());
            ii.setOrdinal(++i);
            invoiceItemDao.insert(ii);
            woodProductDao.updateBalance(ii.getWoodProduct(), ii.getAmount());
        }

        ConnectionFactory.getInstance().getConnection().commit();
        return savedInvoice;
    }

    @Override
    public List<Invoice> find() throws Exception {
        List<Invoice> invoices = invoiceDao.find();
        
        for(Invoice i : invoices){
            mapItems(i);
            mapClient(i);
            mapEmployee(i);
        }
        return invoices;
    }

    private void mapItems(Invoice i) throws Exception {
        List<IGeneralObject> items = invoiceItemDao.findByInvoiceId(i.getId());
        List<InvoiceItem> returnList = new ArrayList<>();
        
        for(IGeneralObject igo : items){
            returnList.add((InvoiceItem)igo);
        }
        
        for(InvoiceItem ii : returnList){
            mapWoodProduct(ii);
        }
        
        i.setItems(returnList);
    }

    private void mapClient(Invoice i) throws Exception {
        i.setClient(clientDao.get(i.getClient().getId()));
    }

    private void mapEmployee(Invoice i) throws Exception {
        i.setEmployee(employeeDao.get(i.getEmployee().getId()));
    }

    private void mapWoodProduct(InvoiceItem ii) throws Exception{
        ii.setWoodProduct(woodProductDao.get(ii.getWoodProduct().getId()));
    }
}
