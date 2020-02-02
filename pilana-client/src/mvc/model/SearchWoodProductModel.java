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
import java.util.Objects;
import thread.ThreadController;
import transfer.ResponseObject;
import util.DOperation;
import util.NumberParser;

/**
 *
 * @author Dudat
 */
public class SearchWoodProductModel {

    public List<WoodProduct> findWoodProducts() throws IOException, Exception {
        ResponseObject response = (ResponseObject) ThreadController.getInstance().request(DOperation.FIND_WOOD_PRODUCTS, null);
        return (List<WoodProduct>) response.getData();
    }

    public List<WoodProduct> search(String term, List<WoodProduct> list) {
        List<WoodProduct> searchResults = new ArrayList<>();
        
        for(WoodProduct wp : list){
            if(wp.getName().toLowerCase().trim().contains(term.toLowerCase().trim())){
                searchResults.add(wp);
            }
            if(NumberParser.isNumeric(term) && Objects.equals(wp.getId(), Integer.valueOf(term.trim()))){
                searchResults.add(wp);
            }
        }
        
        return searchResults;
    }
    
}
