/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import domain.Employee;
import form.FLogin;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import javax.swing.JOptionPane;
import model.LoginModel;

/**
 *
 * @author Dudat
 */
public class LoginController {

    FLogin view;
    LoginModel model;

    public LoginController() {
        view = new FLogin();
        model = new LoginModel();

        view.setVisible(true);
        view.addLoginListener(new LoginListener());
        view.addKeyListener(new EnterListener());
    }
    
    private class EnterListener implements KeyListener {
        @Override
        public void keyTyped(KeyEvent e) {
        }

        @Override
        public void keyPressed(KeyEvent e) {
            if (e.getKeyCode() == KeyEvent.VK_ENTER) {
                view.getBtnLogin().doClick();
            }
        }
        
        @Override
        public void keyReleased(KeyEvent e) {
        }
    }

    private class LoginListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            String username = view.getUsername().getText().trim();
            String password = view.getPassword().getText().trim();
            try {
                Employee emp = model.login(username, password);
                System.out.println("Da li dodjem ovde jbt");
                new ClientController(emp);
                view.dispose();
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(null, ex.getMessage());
            }

        }
    }
}
