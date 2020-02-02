/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bl.dao;

import domain.IGeneralObject;
import domain.Invoice;
import java.util.List;

/**
 *
 * @author Dudat
 */
public interface InvoiceDao {

    public Invoice insert(Invoice invoice) throws Exception;

    public List<Invoice> find() throws Exception;
    
}
