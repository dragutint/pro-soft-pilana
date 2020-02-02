/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package util;

/**
 *
 * @author Dudat
 */
public abstract class AbstractValidation {
    protected static void notEmpty(String msg, String txt) throws Exception{
        if(txt.isEmpty())
            throw new Exception(msg);
    }
    
    protected static void notNull(String msg, Object obj) throws Exception{
        if(obj == null)
            throw new Exception(msg);
    }
    
    protected static void notGreaterThan(String msg, Double num, Double min) throws Exception{
        if(num > min)
            throw new Exception(msg);
    }
    
    protected static void notLessThan(String msg, Double num, Double max) throws Exception {
        if (num < max) 
            throw new Exception(msg);
    }
    
    protected static void notEquals(String msg, String expected, String actual) throws Exception {
        if(!expected.equals(actual))
            throw new Exception(msg);
    }
}
