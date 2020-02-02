/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bl.dao;

import domain.IGeneralObject;
import domain.Invoice;
import domain.InvoiceItem;
import java.util.List;

/**
 *
 * @author Dudat
 */
public interface InvoiceItemDao {

    public void insert(InvoiceItem ii) throws Exception;

    public List<IGeneralObject> findByInvoiceId(Integer invoiceId) throws Exception;
    
}
