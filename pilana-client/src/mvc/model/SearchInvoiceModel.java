/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mvc.model;

import domain.Client;
import domain.Invoice;
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
public class SearchInvoiceModel {

    public List<Invoice> findInvoices() throws IOException, Exception {
        ResponseObject response = (ResponseObject) ThreadController.getInstance().request(DOperation.FIND_INVOICES, null);
        return (List<Invoice>) response.getData();
    }

    public List<Client> findClients() throws IOException, Exception {
        ResponseObject response = (ResponseObject) ThreadController.getInstance().request(DOperation.FIND_CLIENTS, null);
        return (List<Client>) response.getData();
    }

    public List<Invoice> search(Client client, List<Invoice> allInvoices) {
        if(client.getId() == -1) return allInvoices;
        
        List<Invoice> searchResults = new ArrayList<>();
        for(Invoice i : allInvoices){
            if(i.getClient().getId() == client.getId()) searchResults.add(i);
        }
        return searchResults;
    }
    
}
