/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import domain.Employee;
import bl.service.so.impl.SOFindInvoices;
import bl.service.so.impl.SODeleteClient;
import bl.service.so.impl.SOSimpleFind;
import bl.service.so.impl.SOUpdateClient;
import bl.service.so.impl.SOLogin;
import bl.service.so.impl.SOSaveClient;
import bl.service.so.impl.SOSaveInvoice;
import domain.Client;
import domain.IGeneralObject;
import domain.Invoice;
import domain.WoodProduct;
import java.util.List;

/**
 *
 * @author Dudat
 */
public class Controller {
    private static Controller instance;
    
    private Controller(){
    }
    
    public static Controller getInstance(){
        if(instance == null)
            instance = new Controller();
        return instance;
    }

    public Employee login(Employee employee) throws Exception {
        return (Employee) new SOLogin().execute(employee);
    }

    public Client addNewClient(Client client) throws Exception{
        return (Client) new SOSaveClient().execute(client);
    }

    public List<IGeneralObject> findClients() throws Exception {
        return (List<IGeneralObject>) new SOSimpleFind().execute(new Client());
    }

    public void editClient(Client client) throws Exception{
        new SOUpdateClient().execute(client);
    }

    public void deleteClient(Client client) throws Exception{
        new SODeleteClient().execute(client);
    }

    public List<IGeneralObject> findWoodProducts() throws Exception{
        return (List<IGeneralObject>) new SOSimpleFind().execute(new WoodProduct());
    }
    
    public Invoice newInvoice(Invoice invoice) throws Exception{
        return (Invoice) new SOSaveInvoice().execute(invoice);
    }

    public List<Invoice> findInvoices() throws Exception{
        return (List<Invoice>) new SOFindInvoices().execute(new Invoice());
    }
}
