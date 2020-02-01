/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package validation;

import domain.Invoice;

/**
 *
 * @author Dudat
 */
public class InvoiceValidation extends AbstractValidation {
    public static void validate(Invoice invoice) throws Exception{
        notNull("Invoice", invoice);
        notEmpty("Description", invoice.getDescription());
        notLessThan("Description", Double.valueOf(invoice.getDescription().length()), 20.0);
    }
}
