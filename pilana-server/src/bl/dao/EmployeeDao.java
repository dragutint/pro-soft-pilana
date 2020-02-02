/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bl.dao;

import domain.Employee;

/**
 *
 * @author Dudat
 */
public interface EmployeeDao {

    public Employee get(String username) throws Exception;
    
    public Employee get(Integer id) throws Exception;
    
}
