/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package transfer;

import java.io.Serializable;
import util.DOperation;

/**
 *
 * @author Dudat
 */
public class RequestObject implements Serializable{
    private DOperation operation;
    private Object data;

    public RequestObject() {
    }

    public RequestObject(DOperation operation, Object data) {
        this.operation = operation;
        this.data = data;
    }

    public DOperation getOperation() {
        return operation;
    }

    public void setOperation(DOperation operation) {
        this.operation = operation;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }
    
}
