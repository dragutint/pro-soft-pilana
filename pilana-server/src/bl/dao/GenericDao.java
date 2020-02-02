/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bl.dao;

import domain.IGeneralObject;
import java.util.List;

/**
 *
 * @author Dudat
 */
public interface GenericDao {
    public IGeneralObject update(IGeneralObject generalObject) throws Exception;
    public IGeneralObject save(IGeneralObject generalObject) throws Exception;
    public List<IGeneralObject> find(IGeneralObject ide) throws Exception;
    public boolean delete(IGeneralObject object) throws Exception;
    public List<IGeneralObject> findBy(IGeneralObject object, String field, String value) throws Exception;
    public IGeneralObject get(IGeneralObject object) throws Exception;
}
