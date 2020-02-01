/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mvc.controller;

import domain.WoodProduct;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import mvc.model.SearchWoodProductModel;
import mvc.view.FSearchWoodProduct;

/**
 *
 * @author Dudat
 */
public class SearchWoodProductController extends AbstractController{
    FSearchWoodProduct view;
    SearchWoodProductModel model;
    final List<WoodProduct> allWoodProducts;
    
    public SearchWoodProductController() throws Exception {
        model = new SearchWoodProductModel();
        allWoodProducts = model.findWoodProducts();
        this.view = new FSearchWoodProduct(allWoodProducts);
        
        view.setShowWoodProductListener(new ShowWoodProductListener());
        view.setOnChangeListener(new OnChangeListener());
        
        view.setVisible(true);
    }
    
    private class OnChangeListener implements DocumentListener {

        @Override
        public void insertUpdate(DocumentEvent e) {
            view.getTableModel().setWoodProducts(model.search(view.getTxtSearchCriteria().getText().trim(), allWoodProducts));
        }

        @Override
        public void removeUpdate(DocumentEvent e) {
            view.getTableModel().setWoodProducts(model.search(view.getTxtSearchCriteria().getText().trim(), allWoodProducts));
        }

        @Override
        public void changedUpdate(DocumentEvent e) {
            view.getTableModel().setWoodProducts(model.search(view.getTxtSearchCriteria().getText().trim(), allWoodProducts));
        }
    }

    private class ShowWoodProductListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            WoodProduct selectedWoodProduct = view.getTableModel().getSelected(view.getSelectedRow());
            new WoodProductViewController(selectedWoodProduct);
            view.dispose();
        }
    }
}
