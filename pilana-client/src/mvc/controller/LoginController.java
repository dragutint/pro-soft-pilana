/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mvc.controller;

import domain.Employee;
import mvc.view.FLogin;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import mvc.model.LoginModel;
import mvc.view.util.form_validation.LoginFormValidation;
import transfer.ResponseObject;

/**
 *
 * @author Dudat
 */
public class LoginController extends AbstractController{

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
            if (e.getKeyCode() == KeyEvent.VK_ENTER) 
                view.getBtnLogin().doClick();
        }
        
        @Override
        public void keyReleased(KeyEvent e) {
        }
    }

    private class LoginListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            try {
                String username = view.getUsername().getText().trim();
                String password = view.getPassword().getText().trim();
                LoginFormValidation.validate(new Employee(username, password));
                
                ResponseObject response = model.login(username, password);
                
                new MainScreenController((Employee) response.getData());
                view.dispose();
                
                showMessage(view, response.getMessage());
            } catch (Exception ex) {
                showError(view, ex.getMessage(), LoginController.class.getName(), ex);
            }
        }
    }
}
