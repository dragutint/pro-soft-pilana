/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bl.controller;

import bl.service.ClientService;
import domain.Employee;
import bl.service.UserService;
import bl.service.impl.ClientServiceImpl;
import bl.service.impl.UserServiceImpl;
import domain.Client;
import domain.IGeneralObject;
import java.util.List;

/**
 *
 * @author Dudat
 */
public class Controller {
    private static Controller instance;
    private final UserService userService;
    private final ClientService clientService;
    
    private Controller(){
        userService = new UserServiceImpl();
        clientService = new ClientServiceImpl();
    }
    
    public static Controller getInstance(){
        if(instance == null)
            instance = new Controller();
        return instance;
    }

    public Employee login(Employee employee) throws Exception {
        return userService.login(employee);
    }

    public Client addNewClient(Client client) throws Exception{
        return clientService.add(client);
    }

    public List<IGeneralObject> findClients() throws Exception {
        return clientService.find();
    }
}
