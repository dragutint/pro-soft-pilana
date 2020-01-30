/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import domain.Employee;

/**
 *
 * @author Dudat
 */
public class ClientController {
    
    public ClientController(Employee emp) {
        System.out.println("EMPLOEEE " + emp.getId());
    }
}
