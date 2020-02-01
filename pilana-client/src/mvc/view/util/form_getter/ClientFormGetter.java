/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mvc.view.util.form_getter;

import domain.Client;
import domain.ClientType;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import javax.swing.JComboBox;
import javax.swing.JTextField;
import util.DConstants;

/**
 *
 * @author Dudat
 */
public class ClientFormGetter {
    public static Client get(JTextField txtId, JTextField txtFirstName, JTextField txtLastName, JTextField txtRegistrationDate, JComboBox cmbClientType) throws ParseException {
        return new Client(
                txtId != null ? Integer.valueOf(txtId.getText().trim()) : null,
                txtFirstName.getText().trim(),
                txtLastName.getText().trim(),
                txtRegistrationDate != null ? new SimpleDateFormat(DConstants.DATE_FORMAT).parse(txtRegistrationDate.getText().trim()) : null,
                (ClientType) cmbClientType.getSelectedItem());
    }
}
