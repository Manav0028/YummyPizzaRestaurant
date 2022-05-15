package com.mjs.YummyPizzaRestaurant.gui;

import com.mjs.YummyPizzaRestaurant.model.CartItem;
import com.mjs.YummyPizzaRestaurant.model.CustomerOrder;
import com.mjs.YummyPizzaRestaurant.model.Menu;
import com.mjs.YummyPizzaRestaurant.model.OrderItem;
import com.mjs.YummyPizzaRestaurant.repo.OrderRepo;
import com.mjs.YummyPizzaRestaurant.service.OrderServices;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.table.AbstractTableModel;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class CartDetails {
    private JPanel contentPane;
    private JPanel headerPane;
    private JLabel cartLabel;
    private JButton confirmButton;
    private JButton cancelButton;
    private JButton clearButton;
    private JTable cartTable;
    private JPanel buttonsPane;
    private JPanel tablePanel;

    private List<CartItem> cartItems;
    private CartTableModel model;

    public static boolean cartStatus;

    public JPanel getRootPanel() {
        return contentPane;
    }

    public CartDetails(Map<String, CartItem> cartItems, OrderRepo orderRepo) {

        JFrame frame = new JFrame();
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.setContentPane(contentPane);
        frame.pack();
        frame.setVisible(true);

        frame.setBounds(100, 100, 900, 450);
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

        this.cartItems = new ArrayList<>();
        this.cartItems.addAll(cartItems.values());
        this.model = new CartTableModel();
        cartStatus = true;

        cartTable.setModel(model);

        cancelButton.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                frame.dispose();
            }
        });

        clearButton.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                frame.dispose();
                cartItems.clear();
            }
        });

        confirmButton.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                OrderServices services = new OrderServices();
                if (services.saveOrder(cartItems, orderRepo) != null) {
                   frame.dispose();
                   cartItems.clear();
                }

            }
        });
    }

        private class CartTableModel extends AbstractTableModel {

            private String[] columnNames = {"Name", "productType", "pizzaBase", "pizzaSize", "pizzaSauce", "Topping", "Quantity", "Price"};

            private List<CartItem> rows;

            public CartTableModel() {
                refreshData();
            }

            public void refreshData() {
                this.rows = new ArrayList<>();
                this.rows.addAll(cartItems);
            }

            public int getColumnCount() {
                return columnNames.length;
            }

            public int getRowCount() {
                return rows.size();
            }

            public String getColumnName(int col) {
                return columnNames[col];
            }

            public Object getValueAt(int row, int col) {

                CartItem item = rows.get(row) ;

                switch (col) {
                    case 0: return item.getProductName();
                    case 1: return item.getProductType();
                    case 2: return item.getPizzaBase();
                    case 3: return item.getPizzaSize();
                    case 4: return item.getPizzaSauce();
                    case 5: return item.getTopping();
                    case 6: return item.getQuantity();
                    case 7: return item.getProductPrice();
                }

                return null ;

            }

            public Class getColumnClass(int col) {
                switch (col) {
                    case 0:
                    case 1:
                    case 2:
                    case 3:
                    case 4:
                    case 5:
                        return String.class;
                    case 6: return Integer.class;
                    case 7: return Double.class;
                }

                return null ;
            }

            public CartItem getMenuAtRow(int row) {
                return rows.get(row);
            }
        }
}
