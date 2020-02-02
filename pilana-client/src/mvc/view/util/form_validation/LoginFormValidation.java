/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mvc.view.util.form_validation;

import domain.Employee;
import util.AbstractValidation;

/**
 *
 * @author Dudat
 */
public class LoginFormValidation extends AbstractValidation {
    public static void validate(Employee employee) throws Exception {
        notNull("Employee is null", employee);
        notEmpty("Enter username", employee.getUsername());
        notEmpty("Enter password", employee.getPassword());
    }
}
