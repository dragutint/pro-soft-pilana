/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bl.service.so.impl;

import bl.service.validation.EmployeeValidation;
import bl.service.so.AbstractGenericOperation;
import domain.Employee;
import domain.IGeneralObject;

/**
 *
 * @author Dudat
 */
public class SOLogin extends AbstractGenericOperation {

    @Override
    protected void preconditions(Object entity) throws Exception {
        return;
    }

    @Override
    protected Object executeOperation(Object entity) throws Exception {
        Employee expected = (Employee) genericDao.get((IGeneralObject) entity);
        EmployeeValidation.validate(expected, (Employee) entity);
        return expected;
    }
    
}
