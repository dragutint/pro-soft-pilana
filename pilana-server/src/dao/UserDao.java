/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import domain.Employee;
import java.util.List;

/**
 *
 * @author Dudat
 */
public interface UserDao {

    public Employee get(String username) throws Exception;
    
}
