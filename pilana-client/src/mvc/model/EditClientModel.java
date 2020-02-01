/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mvc.model;

import domain.Client;
import java.io.IOException;
import thread.ThreadController;
import transfer.ResponseObject;
import util.DOperation;

/**
 *
 * @author Dudat
 */
public class NewClientModel {

    public ResponseObject addNewClient(Client newClient) throws IOException, Exception {
        return (ResponseObject) ThreadController.getInstance().request(DOperation.ADD_NEW_CLIENT, newClient);
    }
    
}
