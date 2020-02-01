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
            throw new Exception("Field " + field + " cannot be empty");
    }
}
