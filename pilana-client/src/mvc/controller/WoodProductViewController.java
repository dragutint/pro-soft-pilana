/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mvc.controller;

import domain.WoodProduct;
import mvc.view.FWoodProduct;

/**
 *
 * @author Dudat
 */
public class WoodProductViewController {
    FWoodProduct view;
    
    public WoodProductViewController(WoodProduct woodProduct) {
        view = new FWoodProduct(woodProduct);
        
        view.setVisible(true);
    }
    
}
