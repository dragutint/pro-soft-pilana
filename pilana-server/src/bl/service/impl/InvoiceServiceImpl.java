/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bl.service.impl;

import bl.dao.InvoiceDao;
import bl.dao.InvoiceItemDao;
import bl.dao.WoodProductDao;
import bl.dao.impl.InvoiceDaoImpl;
import bl.dao.impl.InvoiceItemDaoImpl;
import bl.dao.impl.WoodProductDaoImpl;
import bl.dao.util.ConnectionFactory;
import bl.service.InvoiceService;
import domain.Invoice;
import domain.InvoiceItem;
import validation.InvoiceItemValidation;
import validation.InvoiceValidation;

/**
 *
 * @author Dudat
 */
public class InvoiceServiceImpl implements InvoiceService {
    private final InvoiceDao invoiceDao;
    private final InvoiceItemDao invoiceItemDao;
    private final WoodProductDao woodProductDao;
    
    public InvoiceServiceImpl() {
        invoiceDao = new InvoiceDaoImpl();
        invoiceItemDao = new InvoiceItemDaoImpl();
        woodProductDao = new WoodProductDaoImpl();
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
            woodProductDao.updateBalance(ii.getWoodProduct());
        }

        ConnectionFactory.getInstance().getConnection().commit();
        return savedInvoice;
    }
    
}
