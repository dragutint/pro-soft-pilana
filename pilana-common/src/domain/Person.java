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
public class Person {
    private String jmbg;
    private String firstName;
    private String lastName;

    public Person() {
    }

    public Person(String jmbg, String firstName, String lastName) {
        this.jmbg = jmbg;
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public String getJmbg() {
        return jmbg;
    }

    public void setJmbg(String jmbg) {
        this.jmbg = jmbg;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    @Override
    public String toString() { 
        return this.getFirstName() + " " + this.getLastName();
    }
}
