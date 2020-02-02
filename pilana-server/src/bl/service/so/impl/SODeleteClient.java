/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bl.service.so.impl;

import bl.service.so.AbstractGenericOperation;
import domain.IGeneralObject;

/**
 *
 * @author Dudat
 */
public class SODeleteClient extends AbstractGenericOperation {

    @Override
    protected void preconditions(Object entity) throws Exception {
        return;
    }

    @Override
    protected Object executeOperation(Object entity) throws Exception {
        return genericDao.delete((IGeneralObject) entity);
    }
    
}
