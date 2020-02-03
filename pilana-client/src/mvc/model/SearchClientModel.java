/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mvc.model;

import domain.Client;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import thread.ThreadController;
import transfer.ResponseObject;
import util.DOperation;

/**
 *
 * @author Dudat
 */
public class SearchClientModel {
    
    public List<Client> findClients() throws IOException, Exception {
        ResponseObject response = (ResponseObject) ThreadController.getInstance().request(DOperation.FIND_CLIENTS, null);
        return (List<Client>) response.getData();
    }

    public List<Client> search(String term, List<Client> allClients) throws Exception {
        List<Client> searchResults = new ArrayList<>();
        
        for(Client c : allClients){
            if(c.getFirstName().toLowerCase().contains(term.toLowerCase()) 
                    || c.getLastName().toLowerCase().contains(term.toLowerCase()) 
                    || term.toLowerCase().contains(c.getFirstName().toLowerCase() + " " + c.getLastName().toLowerCase())){
                searchResults.add(c);
            }
        }
        if(searchResults.size()==0) throw new Exception("System cannot find clients for entered criteria");
        return searchResults;
    }
    
}
