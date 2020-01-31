/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bl.service;

import domain.Client;
import domain.IGeneralObject;
import java.util.List;

/**
 *
 * @author Dudat
 */
public interface ClientService {

    public List<IGeneralObject> find() throws Exception;

    public Client add(Client client) throws Exception;
    
}
