/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mvc.view.util.form_validation;

import domain.InvoiceItem;
import util.AbstractValidation;

/**
 *
 * @author Dudat
 */
public class InvoiceItemFormValidation extends AbstractValidation {

    public static void validate(InvoiceItem item) throws Exception {
        notNull("Item is null", item);
        notNull("You have not selected wood product", item.getWoodProduct());
        notNull("You have not entered amount", item.getAmount());
    }
    
}
