/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import domain.Employee;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import thread.ThreadSingleton;
import transfer.RequestObject;
import transfer.ResponseObject;
import util.DOperation;
import util.DResponseStatus;

/**
 *
 * @author Dudat
 */
public class LoginModel {

    public Employee login(String username, String password) throws Exception {
        Employee emp = new Employee(username, password);
        
        return checkEmployee(emp);
    }

    private Employee checkEmployee(Employee emp) throws Exception {
        try {
            Employee employee = (Employee) ThreadSingleton.getInstance().request(DOperation.LOGIN, emp);     
            System.out.println(employee);
            return employee;
        } catch (IOException | ClassNotFoundException ex) {
            throw new Exception(ex.getMessage());
        }
    }
    
}
