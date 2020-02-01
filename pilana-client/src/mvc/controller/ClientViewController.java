/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mvc.controller;

import domain.Client;
import mvc.ViewMode;
import mvc.view.FClientView;

/**
 *
 * @author Dudat
 */
public class ClientViewController extends AbstractController {
    FClientView view;
    ViewMode mode;
    
    public ClientViewController(Client selectedClient, ViewMode mode) {
        this.mode = mode;
        this.view = new FClientView(selectedClient, mode);
        
        if(mode.equals(ViewMode.EDIT)){
            // set action listener for button
        }
        
        view.setVisible(true);
    }
    
}
