/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bl.service.so.impl;

import bl.service.so.AbstractGenericOperation;
import bl.service.validation.ClientValidation;
import domain.Client;
import domain.IGeneralObject;

/**
 *
 * @author Dudat
 */
public class SOUpdateClient extends AbstractGenericOperation {

    @Override
    protected void preconditions(Object entity) throws Exception {
        ClientValidation.validate((Client) entity);
    }

    @Override
    protected Object executeOperation(Object entity) throws Exception {
        return genericDao.update((IGeneralObject) entity);
    }
    
}
