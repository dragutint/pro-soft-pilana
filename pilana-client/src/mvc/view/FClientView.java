/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mvc.view;

import domain.Client;
import domain.ClientType;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
import java.util.List;
import javax.swing.JComboBox;
import javax.swing.JTextField;
import mvc.ViewMode;

/**
 *
 * @author Dudat
 */
public class FClientView extends javax.swing.JFrame {

    /**
     * Creates new form FClientPreview
     */
    public FClientView(Client c, ViewMode mode) {
        initComponents();
        
        prepareForm(c, mode);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        txtID = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        txtFirstName = new javax.swing.JTextField();
        txtLastName = new javax.swing.JTextField();
        txtRegistrationDate = new javax.swing.JTextField();
        btnSaveChanges = new javax.swing.JButton();
        cmbClientType = new javax.swing.JComboBox();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setResizable(false);

        jLabel1.setText("ID");

        txtID.setEditable(false);

        jLabel2.setText("First name");

        jLabel3.setText("Last name");

        jLabel4.setText("Registration date");

        jLabel5.setText("Client type");

        txtFirstName.setEditable(false);
        txtFirstName.setText("jTextField1");

        txtLastName.setEditable(false);
        txtLastName.setText("jTextField2");

        txtRegistrationDate.setEditable(false);
        txtRegistrationDate.setText("jTextField3");

        btnSaveChanges.setText("Save changes");
        btnSaveChanges.setToolTipText("");

        cmbClientType.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(64, 64, 64)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(btnSaveChanges, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1)
                            .addComponent(jLabel5)
                            .addComponent(jLabel4)
                            .addComponent(jLabel3)
                            .addComponent(jLabel2))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 32, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(cmbClientType, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(txtID)
                            .addComponent(txtFirstName, javax.swing.GroupLayout.DEFAULT_SIZE, 200, Short.MAX_VALUE)
                            .addComponent(txtLastName)
                            .addComponent(txtRegistrationDate))))
                .addGap(58, 58, 58))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(40, 40, 40)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(txtID, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(txtFirstName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(txtLastName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(txtRegistrationDate, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(cmbClientType, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(btnSaveChanges)
                .addContainerGap(37, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnSaveChanges;
    private javax.swing.JComboBox cmbClientType;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JTextField txtFirstName;
    private javax.swing.JTextField txtID;
    private javax.swing.JTextField txtLastName;
    private javax.swing.JTextField txtRegistrationDate;
    // End of variables declaration//GEN-END:variables

    private void prepareForm(Client c, ViewMode mode) {
        cmbClientType.removeAllItems();
        
        txtID.setText(String.valueOf(c.getId()));
        txtFirstName.setText(c.getFirstName());
        txtLastName.setText(c.getLastName());
        txtRegistrationDate.setText(new SimpleDateFormat("dd.MM.YYYY.").format(c.getRegistrationDate()));        
        cmbClientType.addItem(c.getClientType());
        cmbClientType.setSelectedItem(c.getClientType());
        
        if(mode.equals(ViewMode.EDIT)){
            txtFirstName.setEditable(true);
            txtLastName.setEditable(true);
            cmbClientType.setEditable(true);
        } else {
            btnSaveChanges.setOpaque(false);
            btnSaveChanges.setContentAreaFilled(false);
            btnSaveChanges.setBorderPainted(false);
            btnSaveChanges.setEnabled(false);
            btnSaveChanges.setText("");
        }
    }

    public void setSaveChangesListener(ActionListener listener) {
        btnSaveChanges.addActionListener(listener);
    }
    
    public JTextField getTxtId(){
        return txtID;
    }
    
    public JTextField getTxtFirstName(){
        return txtFirstName;
    }
    
    public JTextField getTxtLastName(){
        return txtLastName;
    }
    
    public JTextField getTxtRegistrationDate(){
        return txtRegistrationDate;
    }
    
    public JComboBox getCmbClientType(){
        return cmbClientType;
    }

    public void addClientTypes(List<ClientType> clientTypes, ClientType selected) {
        cmbClientType.removeAllItems();
        clientTypes.stream().forEach(cmbClientType::addItem);
        cmbClientType.setSelectedItem(selected);
    }
}
