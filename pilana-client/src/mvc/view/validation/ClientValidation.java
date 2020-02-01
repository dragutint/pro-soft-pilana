/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mvc.view.validation;

import domain.Client;
import domain.ClientType;
import java.util.Date;
import javax.swing.JComboBox;
import javax.swing.JTextField;

/**
 *
 * @author Dudat
 */
public class NewClientValidation extends AbstractValidation{
    
    public static Client getFormClient(JTextField firstName, JTextField lastName, JComboBox clientType) throws Exception{
        notEmpty("first name", firstName.getText().trim());
        notEmpty("last name", lastName.getText().trim());
        
        return new Client(
                null,
                firstName.getText().trim(),
                lastName.getText().trim(),
                new Date(System.currentTimeMillis()),
                (ClientType) clientType.getSelectedItem());
    }
}
