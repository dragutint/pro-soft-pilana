/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bl.service.util.validation;

import util.AbstractValidation;
import domain.Invoice;

/**
 *
 * @author Dudat
 */
public class InvoiceValidation extends AbstractValidation {
    public static void validate(Invoice invoice) throws Exception{
        System.out.println("Invoice items validation: " + invoice.getItems().size());
        notNull("Invoice is null", invoice);
        notEmpty("Description is not entered", invoice.getDescription());
        notLessThan("Description must have at least 20 characters", Double.valueOf(invoice.getDescription().length()), 20.0);
        notLessThan("You must enter at least 1 invoice item", Double.valueOf(invoice.getItems().size()), 1.0);
    }
}
