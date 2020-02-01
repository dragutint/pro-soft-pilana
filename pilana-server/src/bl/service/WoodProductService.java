/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bl.service;

import domain.IGeneralObject;
import java.util.List;

/**
 *
 * @author Dudat
 */
public interface WoodProductService {

    public List<IGeneralObject> find() throws Exception;
    
}
