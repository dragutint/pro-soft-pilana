/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bl.service.so;

import bl.dao.GenericDao;
import bl.dao.impl.GenericDaoImpl;
import java.sql.SQLException;
import util.ConnectionFactory;

/**
 *
 * @author Dudat
 */
public abstract class AbstractGenericOperation {

    protected GenericDao genericDao;

    public AbstractGenericOperation() {
        genericDao = new GenericDaoImpl();
    }

    public final Object execute(Object entity) throws Exception {
        try {
            preconditions(entity);
            startTransaction();
            Object result = executeOperation(entity);
            commitTransaction();
            return result;
        } catch (Exception ex) {
            ex.printStackTrace();
            rollbackTransaction();
            throw new Exception("Sistem ne moze da izvrsi operaciju");
        }
    }

    protected abstract void preconditions(Object entity) throws Exception;

    private void startTransaction() throws SQLException {
        ConnectionFactory.getInstance().getConnection().setAutoCommit(false);
    }

    protected abstract Object executeOperation(Object entity) throws Exception;

    private void commitTransaction() throws SQLException {
        ConnectionFactory.getInstance().getConnection().commit();
    }

    private void rollbackTransaction() throws SQLException {
        ConnectionFactory.getInstance().getConnection().rollback();
    }

}
