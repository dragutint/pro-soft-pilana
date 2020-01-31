/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bl.service.impl;

import bl.dao.ClientDao;
import bl.dao.impl.ClientDaoImpl;
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
        return clientDao.add(client);
    }
    
}
