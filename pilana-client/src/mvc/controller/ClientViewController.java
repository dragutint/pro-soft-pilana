/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mvc.controller;

import domain.Client;
import mvc.view.ViewMode;
import mvc.view.FClientView;

/**
 *
 * @author Dudat
 */
public class ClientViewController extends AbstractController {
    FClientView view;
    
    public ClientViewController(Client selectedClient) {
        this.view = new FClientView(selectedClient, ViewMode.PREVIEW);
        
        view.setVisible(true);
    }
    
}
