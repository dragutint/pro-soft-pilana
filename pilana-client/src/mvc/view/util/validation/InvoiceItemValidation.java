/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mvc.view.util.validation;

import domain.InvoiceItem;

/**
 *
 * @author Dudat
 */
public class InvoiceItemValidation extends AbstractValidation {
    public static void validate(InvoiceItem item) throws Exception{
        notNull("Invoice item", item);
        notNull("Wood product", item.getWoodProduct());
        notNull("Amount", item.getAmount());
        notLessThan("Amount", item.getAmount().doubleValue(), 1.0);
    }
}
