/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package validation;

import domain.Client;

/**
 *
 * @author Dudat
 */
public class ClientValidation extends AbstractValidation{
    
    public static void validate(Client client) throws Exception{
        notEmpty("First name", client.getFirstName());
        notEmpty("Last name", client.getLastName());
    }
}
