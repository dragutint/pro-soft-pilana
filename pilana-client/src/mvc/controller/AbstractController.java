/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mvc.controller;

import domain.Employee;
import java.awt.Component;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author Dudat
 */
public abstract class AbstractController {
    public void showMessage(Component comp, String msg){
        JOptionPane.showMessageDialog(comp, msg, "Success", JOptionPane.INFORMATION_MESSAGE);
    }
    
    public void showError(Component comp, String msg, String className, Exception ex){
        JOptionPane.showMessageDialog(comp, msg, "Error", JOptionPane.ERROR_MESSAGE);
    }
}
