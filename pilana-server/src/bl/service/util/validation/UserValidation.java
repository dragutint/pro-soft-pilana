/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bl.service.util.validation;

import util.AbstractValidation;
import domain.Employee;

/**
 *
 * @author Dudat
 */
public class UserValidation extends AbstractValidation {
    public static void validate(Employee expected, Employee actual) throws Exception {
        notNull("User doesnt exists", expected);
        notEquals("Wrong password", expected.getPassword().trim(), actual.getPassword().trim());
    }
}
