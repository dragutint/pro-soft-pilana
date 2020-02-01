/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bl.service.util.validation.user;

import domain.Employee;

/**
 *
 * @author Dudat
 */
public class UserValidation {
    public static void validateUserLogin(Employee expected, Employee actual) throws Exception{
        if(expected == null)
            throw new Exception("User doesnt exists");
        
        if(!expected.getPassword().trim().equals(actual.getPassword().trim()))
            throw new Exception("Wrong password");
    }
}
