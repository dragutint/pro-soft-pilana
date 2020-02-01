/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mvc.model;

import domain.WoodProduct;
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
public class SearchWoodProductModel {

    public List<WoodProduct> getWoodProducts() throws IOException, Exception {
        ResponseObject response = (ResponseObject) ThreadController.getInstance().request(DOperation.FIND_WOOD_PRODUCTS, null);
        return (List<WoodProduct>) response.getData();
    }

    public List<WoodProduct> search(String term, List<WoodProduct> list) {
        List<WoodProduct> searchResults = new ArrayList<>();
        
        for(WoodProduct wp : list){
            if(wp.getName().toLowerCase().trim().contains(term.toLowerCase().trim())){
                searchResults.add(wp);
            }
        }
        
        return searchResults;
    }
    
}
