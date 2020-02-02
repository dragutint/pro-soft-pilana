/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bl.dao;

import domain.IGeneralObject;
import domain.WoodProduct;
import java.util.List;

/**
 *
 * @author Dudat
 */
public interface WoodProductDao {

    public List<IGeneralObject> find() throws Exception;

    public void updateBalance(WoodProduct woodProduct, Integer amount) throws Exception;

    public WoodProduct get(Integer id) throws Exception;
    
}
