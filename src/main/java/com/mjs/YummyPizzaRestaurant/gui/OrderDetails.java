package com.mjs.YummyPizzaRestaurant.gui;

import com.mjs.YummyPizzaRestaurant.model.*;
import com.mjs.YummyPizzaRestaurant.model.enums.OrderType;
import com.mjs.YummyPizzaRestaurant.repo.MenuRepo;
import com.mjs.YummyPizzaRestaurant.repo.OrderItemRepo;
import com.mjs.YummyPizzaRestaurant.repo.OrderRepo;
import com.mjs.YummyPizzaRestaurant.repo.ToppingRepo;
import com.mjs.YummyPizzaRestaurant.service.OrderServices;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.AbstractTableModel;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.*;

public class OrderDetails extends JFrame {
    private JLabel orderSummaryLabel;
    private JTable orderTable;
    private JTable orderItemsTable;
    private JPanel contentPane;
    private JPanel headingPane;
    private JPanel ordersPane;
    private JPanel orderItemsPane;
    private JScrollPane orderScrollPane;
    private JScrollPane orderItemsScrollPane;

    private OrderRepo orderRepo;
    private MenuRepo menuRepo;
    private ToppingRepo toppingRepo;

    private OrderTableModel orderTableModel;
    private CustomerOrder selectedCustomerOrder;

    private CartTableModel itemModel;

    private OrderServices orderServices;

    public OrderDetails(OrderRepo orderRepo, MenuRepo menuRepo, ToppingRepo toppingRepo) {

        this.orderRepo = orderRepo;
        this.orderTableModel = new OrderTableModel();
        this.menuRepo = menuRepo;
        this.toppingRepo = toppingRepo;
        this.itemModel = new CartTableModel();

        this.orderServices = new OrderServices(orderRepo);

        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        this.setBounds(100, 100, 900, 450); //frame bounds
        this.contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        pack();
        setVisible(true);

        orderTable.setModel(orderTableModel);
        orderTable.getSelectionModel().addListSelectionListener(new ListSelectionListener(){
            public void valueChanged(ListSelectionEvent event) {

                int row = orderTable.getSelectedRow();

                if (row >= 0)
                    selectedCustomerOrder = orderTableModel.getOrderAtRow(row) ;
                else
                    selectedCustomerOrder = null ;

                orderTable.setEnabled(selectedCustomerOrder != null);
            }
        });

        orderItemsTable.setModel(itemModel);
        orderTable.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                itemModel.refreshData();
                orderItemsTable.updateUI();
            }
        });
    }

    public JPanel getRootPanel() {
        return contentPane;
    }

    private class OrderTableModel extends AbstractTableModel {

        private String[] columnNames = {"customer_id", "discount_type",
                "eating_option", "order_date" ,  "order_type", "total_amount"};

        private List<CustomerOrder> rows;

        public OrderTableModel() {
            refreshData();
        }

        public void refreshData() {
            this.rows = new ArrayList<>();

            for (CustomerOrder order: orderRepo.findAll()) {
                this.rows.add(order);
            }
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

            CustomerOrder order = rows.get(row);

            switch (col) {
                case 0: return order.getCustomerId();
                case 1: return order.getDiscountType();
                case 2: return order.getEatingOption();
                case 3: return order.getOrderDate();
                case 4: return order.getOrderType();
                case 5: return order.getTotalAmount();
//                case 5: return menu.getPizzaBase();
//                case 6: return menu.getPizzaSize();
//                case 7: return menu.getPizzaSauce();
            }

            return null ;

        }

        public Class getColumnClass(int col) {
            switch (col) {
                case 0: return Integer.class;
                case 1:
                case 4:
                case 2:
                    return String.class;
                case 3:
                    return Date.class;
                case 5:
                    return Double.class;
            }

            return null ;
        }

        public CustomerOrder getOrderAtRow(int row) {
            return rows.get(row);
        }
    }

    private class CartTableModel extends AbstractTableModel {

        private String[] columnNames = {"Name", "productType", "pizzaBase", "pizzaSize", "pizzaSauce", "Topping", "Quantity", "Price"};

        private List<CartItem> rows;

        public CartTableModel() {
            refreshData();
        }

        public void refreshData() {
            this.rows = new ArrayList<>();

            if (selectedCustomerOrder != null) {
                for (OrderItem item :
                        selectedCustomerOrder.getOrderItems()) {
                    CartItem cartItem = new CartItem();
                    Optional<Menu> menuOptional = menuRepo.findById(item.getProductId());
                    Optional<Topping> toppingOptional = toppingRepo.findById(item.getToppingId());
                    if (menuOptional.isPresent() && toppingOptional.isPresent()) {
                        Menu menu = menuOptional.get();
                        cartItem.setProductId(menu.getProductId());
                        cartItem.setProductName(menu.getProductName());
                        cartItem.setProductType(menu.getProductType());
                        cartItem.setProductPrice(item.getOrderPrice());
                        cartItem.setPizzaBase(menu.getPizzaBase());
                        cartItem.setPizzaSauce(menu.getPizzaSauce());
                        cartItem.setPizzaSize(menu.getPizzaSize());
                        cartItem.setQuantity(item.getOrderQuantity());
                        cartItem.setTopping(toppingOptional.get().getToppingName());
                    }
                    this.rows.add(cartItem);
                }
            }
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
