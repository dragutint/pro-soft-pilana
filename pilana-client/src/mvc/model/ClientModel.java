/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mvc.model;

import domain.Client;
import domain.ClientType;
import java.io.IOException;
import java.util.ArrayList;
import java.util.EnumSet;
import java.util.List;
import thread.ThreadController;
import transfer.ResponseObject;
import util.DOperation;

/**
 *
 * @author Dudat
 */
public class ClientModel {

    public List<ClientType> getClientTypes() {
        return new ArrayList<>(EnumSet.allOf(ClientType.class));
    }

    public List<Client> getClients() throws IOException, Exception {
        ResponseObject response = (ResponseObject) ThreadController.getInstance().request(DOperation.FIND_CLIENTS, null);
        return (List<Client>) response.getData();
    }
    
}
