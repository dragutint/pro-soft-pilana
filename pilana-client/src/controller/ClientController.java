/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import domain.Employee;
import form.FClient;
import model.ClientModel;

/**
 *
 * @author Dudat
 */
public class ClientController {
    FClient view; 
    ClientModel model;
   
    public ClientController(Employee emp) {
        view = new FClient(emp);
        model = new ClientModel();
        
        view.setVisible(true);
    }
}
