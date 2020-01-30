/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package domain;

/**
 *
 * @author Dudat
 */
public enum ClientType {
    BRONZE(1),
    SILVER(2),
    PLATINUM(3);

    private final int id;
    
    private ClientType(int id) {
        this.id = id;
    }
        
    public int getId(){
        return this.id;
    }
}
