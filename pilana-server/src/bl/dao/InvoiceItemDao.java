/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bl.dao;

import domain.InvoiceItem;

/**
 *
 * @author Dudat
 */
public interface InvoiceItemDao {

    public void insert(InvoiceItem ii) throws Exception;
    
}
