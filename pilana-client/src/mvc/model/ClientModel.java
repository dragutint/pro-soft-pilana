/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mvc.model;

import domain.ClientType;
import java.util.ArrayList;
import java.util.EnumSet;
import java.util.List;

/**
 *
 * @author Dudat
 */
public class ClientModel {

    public List<ClientType> getClientTypes() {
        return new ArrayList<>(EnumSet.allOf(ClientType.class));
    }
    
}
