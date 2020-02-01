/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mvc.view.util.validation;

import domain.Client;
import domain.ClientType;
import java.util.Date;
import javax.swing.JComboBox;
import javax.swing.JTextField;

/**
 *
 * @author Dudat
 */
public class ClientValidation extends AbstractValidation{
    
    public static void validate(Client client) throws Exception{
        notEmpty("first name", client.getFirstName());
        notEmpty("last name", client.getLastName());
    }
}
