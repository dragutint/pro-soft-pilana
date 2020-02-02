/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bl.service.util.validation;

import util.AbstractValidation;
import domain.InvoiceItem;

/**
 *
 * @author Dudat
 */
public class InvoiceItemValidation extends AbstractValidation {
    public static void validate(InvoiceItem item) throws Exception{
        notNull("Invoice item is null", item);
        notNull("Wood product is null", item.getWoodProduct());
        notNull("Amount is not entered", item.getAmount());
        notLessThan("Amount is less than 1", item.getAmount().doubleValue(), 1.0);
        notGreaterThan("We dont have enough wood products, balance: " + item.getWoodProduct().getBalance() + ", you requested: " + item.getAmount(), item.getAmount().doubleValue(), item.getWoodProduct().getBalance().doubleValue());
    }
}
