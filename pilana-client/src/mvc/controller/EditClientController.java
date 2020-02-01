/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mvc.controller;

import domain.Client;
import mvc.view.FClientPreview;

/**
 *
 * @author Dudat
 */
public class ClientPreviewController extends AbstractController {
    FClientPreview view;
    
    public ClientPreviewController(Client selectedClient) {
        view = new FClientPreview(selectedClient);
        
        view.setVisible(true);
    }
    
}
