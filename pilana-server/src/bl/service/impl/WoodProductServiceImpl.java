/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bl.service.impl;

import bl.dao.WoodProductDao;
import bl.dao.impl.WoodProductDaoImpl;
import bl.service.WoodProductService;
import domain.IGeneralObject;
import java.util.List;

/**
 *
 * @author Dudat
 */
public class WoodProductServiceImpl implements WoodProductService{
    private final WoodProductDao woodProductDao;
    
    public WoodProductServiceImpl() {
        woodProductDao = new WoodProductDaoImpl();
    }

    @Override
    public List<IGeneralObject> find() throws Exception {
        return woodProductDao.find();
    }
    
}
