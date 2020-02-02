/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bl.dao;

import domain.Client;
import domain.IGeneralObject;
import java.util.List;

/**
 *
 * @author Dudat
 */
public interface ClientDao {

    public List<IGeneralObject> find() throws Exception;

    public Client add(Client client) throws Exception;

    public void update(Client client) throws Exception;

    public void delete(Client client) throws Exception;

    public Client get(int id) throws Exception;
    
}
