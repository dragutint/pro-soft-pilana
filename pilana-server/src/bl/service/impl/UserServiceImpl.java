/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bl.service.impl;

import bl.dao.UserDao;
import bl.dao.impl.UserDaoImpl;
import domain.Employee;
import bl.service.UserService;
import bl.validation.user.UserValidation;

/**
 *
 * @author Dudat
 */
public class UserServiceImpl implements UserService {
    private UserDao userDao;

    public UserServiceImpl() {
        this.userDao = new UserDaoImpl();
    }
    
    @Override
    public Employee login(Employee employee) throws Exception{
        Employee expected = userDao.get(employee.getUsername());
        UserValidation.validateUserLogin(expected, employee);
        return expected;
    }
    
}
