/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package transfer;

import java.io.Serializable;
import util.DResponseStatus;

/**
 *
 * @author Dudat
 */
public class ResponseObject implements Serializable{
    private DResponseStatus status;
    private String message;
    private Object data;

    public ResponseObject() {
    }

    public ResponseObject(DResponseStatus status, String message, Object data) {
        this.status = status;
        this.message = message;
        this.data = data;
    }

    public DResponseStatus getStatus() {
        return status;
    }

    public void setStatus(DResponseStatus status) {
        this.status = status;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }
    
    
}
