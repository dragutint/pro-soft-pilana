/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bl.controller;

import domain.Employee;
import bl.service.UserService;
import bl.service.impl.UserServiceImpl;
import domain.Client;

/**
 *
 * @author Dudat
 */
public class Controller {
    private static Controller instance;
    private static UserService userService;
    
    private Controller(){
        userService = new UserServiceImpl();
    }
    
    public static Controller getInstance(){
        if(instance == null)
            instance = new Controller();
        return instance;
    }

    public Employee login(Employee employee) throws Exception {
        return userService.login(employee);
    }

    public Client addNewClient(Client client) {
        client.setId(5);
        return client;
    }
}
