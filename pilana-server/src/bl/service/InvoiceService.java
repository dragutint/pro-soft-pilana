/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bl.service;

import domain.Invoice;
import java.util.List;

/**
 *
 * @author Dudat
 */
public interface InvoiceService {

    public Invoice addNewInvoice(Invoice invoice) throws Exception;

    public List<Invoice> find() throws Exception;
}
