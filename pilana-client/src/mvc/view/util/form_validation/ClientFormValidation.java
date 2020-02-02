/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mvc.view.util.form_validation;

import domain.Client;
import util.AbstractValidation;

/**
 *
 * @author Dudat
 */
public class ClientFormValidation extends AbstractValidation {

    public static void validate(Client newClient) throws Exception {
        notNull("Client cant be null", newClient);
    }
    
}
