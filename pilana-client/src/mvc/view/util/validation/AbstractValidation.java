/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mvc.view.util.validation;

/**
 *
 * @author Dudat
 */
public abstract class AbstractValidation {
    protected static void notEmpty(String field, String txt) throws Exception{
        if(txt.isEmpty())
            throw new Exception(field + " cannot be empty");
    }
    
    protected static void notNull(String field, Object obj) throws Exception{
        if(obj == null){
            throw new Exception(field + " cannot be null");
        }
    }
    
    protected static void notGreaterThan(String field, Double num, Double min) throws Exception{
        if(num > min){
            throw new Exception(field + " cannot be less than " + min);
        }
    }
    
    protected static void notLessThan(String field, Double num, Double max) throws Exception {
        if (num < max) {
            throw new Exception(field + " cannot be greater than " + max);
        }
    }
}
