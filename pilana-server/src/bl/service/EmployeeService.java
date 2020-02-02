/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bl.service;

import domain.Employee;

/**
 *
 * @author Dudat
 */
public interface EmployeeService {

    public Employee login(Employee employee) throws Exception;
    
}
