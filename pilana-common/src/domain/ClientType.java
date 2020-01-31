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
    GOLD(3);

    private final int id;
    
    private ClientType(int id) {
        this.id = id;
    }
        
    public int getId(){
        return this.id;
    }

    public static ClientType getById(int id) {
        for (ClientType e : values()) {
            if (e.getId() == id) {
                return e;
            }
        }
        return null;
    }
}
