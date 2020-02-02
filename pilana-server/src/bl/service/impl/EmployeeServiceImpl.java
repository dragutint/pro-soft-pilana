/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bl.service.impl;

import bl.dao.EmployeeDao;
import bl.dao.impl.EmployeeDaoImpl;
import domain.Employee;
import bl.service.EmployeeService;
import bl.service.util.validation.EmployeeValidation;

/**
 *
 * @author Dudat
 */
public class EmployeeServiceImpl implements EmployeeService {
    private EmployeeDao userDao;

    public EmployeeServiceImpl() {
        this.userDao = new EmployeeDaoImpl();
    }
    
    @Override
    public Employee login(Employee employee) throws Exception{
        Employee expected = userDao.get(employee.getUsername());
        EmployeeValidation.validate(expected, employee);
        return expected;
    }
    
}
