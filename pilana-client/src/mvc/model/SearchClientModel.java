/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mvc.model;

import domain.Client;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Dudat
 */
public class SearchClientModel {

    public List<Client> search(String term, List<Client> allClients) {
        List<Client> list = new ArrayList<>();
        
        for(Client c : allClients){
            if(c.getFirstName().toLowerCase().contains(term.toLowerCase()) 
                    || c.getLastName().toLowerCase().contains(term.toLowerCase()) 
                    || term.toLowerCase().contains(c.getFirstName().toLowerCase() + " " + c.getLastName().toLowerCase())){
                list.add(c);
            }
        }
        
        return list;
    }
    
}
