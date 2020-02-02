/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bl.service.util.validation;

import util.AbstractValidation;
import domain.Client;

/**
 *
 * @author Dudat
 */
public class ClientValidation extends AbstractValidation{
    
    public static void validate(Client client) throws Exception{
        notEmpty("You have not entered first name", client.getFirstName());
        notEmpty("You have not entered last name", client.getLastName());
    }
}
