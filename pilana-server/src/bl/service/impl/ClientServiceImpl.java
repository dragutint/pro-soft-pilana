/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bl.service.impl;

import bl.dao.ClientDao;
import bl.dao.impl.ClientDaoImpl;
import bl.dao.util.ConnectionFactory;
import bl.service.ClientService;
import domain.Client;
import domain.IGeneralObject;
import java.util.List;

/**
 *
 * @author Dudat
 */
public class ClientServiceImpl implements ClientService{
    private final ClientDao clientDao;
    
    public ClientServiceImpl() {
        clientDao = new ClientDaoImpl();
    }
    
    @Override
    public List<IGeneralObject> find() throws Exception {
        return clientDao.find();
    }

    @Override
    public Client add(Client client) throws Exception {
        Client c =  clientDao.add(client);
        ConnectionFactory.getInstance().getConnection().commit();
        return c;
    }

    @Override
    public void edit(Client client) throws Exception {
        // validations
        
        clientDao.update(client);
        ConnectionFactory.getInstance().getConnection().commit();
    }

    @Override
    public void delete(Client client) throws Exception {
        // validations if needed
        clientDao.delete(client);
        ConnectionFactory.getInstance().getConnection().commit();
    }
    
}
