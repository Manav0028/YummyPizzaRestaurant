package com.mjs.YummyPizzaRestaurant.gui;

import com.mjs.YummyPizzaRestaurant.model.CartItem;
import com.mjs.YummyPizzaRestaurant.model.CustomerOrder;
import com.mjs.YummyPizzaRestaurant.model.Menu;
import com.mjs.YummyPizzaRestaurant.model.OrderItem;
import com.mjs.YummyPizzaRestaurant.repo.MenuRepo;
import com.mjs.YummyPizzaRestaurant.repo.OrderRepo;
import com.mjs.YummyPizzaRestaurant.repo.ToppingRepo;
import com.mjs.YummyPizzaRestaurant.service.OrderServices;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.AbstractTableModel;
import java.awt.event.*;
import java.util.*;

public class PizzaMenu extends JFrame{
    private MenuRepo menuRepo ;
    private OrderRepo orderRepo;
    private ToppingRepo toppingRepo;

    private MenuTableModel model ;
    private Menu selectedMenu ;

    private JPanel contentPane;
    private JTable tblMenus;
    private JButton btnCancel;
    private JButton btnAddMenu;
    private JButton btnSeeOrder;

    private CustomerOrder order;
    private List<OrderItem> items;
    private List<CartItem> cartItems;
    private Map<String, CartItem> cartMap;
    private OrderServices orderServices;



    public static void main(String... args) {
        JFrame frame = new JFrame("JTable Test");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);

    }

    public PizzaMenu(MenuRepo menuRepo, ToppingRepo toppingRepo, OrderRepo orderRepo) {

        this.order = new CustomerOrder();
        this.order.setCustomerId(1);
        this.order.setOrderDate(new Date());

        this.items = new ArrayList<>();
        this.orderServices = new OrderServices();
        this.cartItems = new ArrayList<>();
        this.cartMap = new HashMap<>();

        this.menuRepo = menuRepo ;
        this.model = new MenuTableModel() ;
        this.toppingRepo = toppingRepo;
        this.orderRepo = orderRepo;


        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        this.setBounds(100, 100, 900, 450); //frame bounds
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);

        JLabel lblNewLabel = new JLabel("Menu");

        btnAddMenu = new JButton("Add to Cart");
        btnAddMenu.setEnabled(false);
        btnAddMenu.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                addToCart(selectedMenu);
            }
        });

        btnSeeOrder = new JButton("View Cart");
        btnSeeOrder.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                viewCart();
            }
        });

        btnCancel = new JButton("Cancel");
        btnCancel.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                dispose();
            }
        });

        JScrollPane scrollPane = new JScrollPane();

        GroupLayout gl_contentPane = new GroupLayout(contentPane);
        gl_contentPane.setHorizontalGroup(
                gl_contentPane.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(gl_contentPane.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(gl_contentPane.createParallelGroup(GroupLayout.Alignment.LEADING)
                                        .addComponent(scrollPane, GroupLayout.DEFAULT_SIZE, 428, Short.MAX_VALUE)
                                        .addComponent(lblNewLabel)
                                        .addGroup(GroupLayout.Alignment.TRAILING, gl_contentPane.createSequentialGroup()
                                                .addComponent(btnCancel)
                                                .addComponent(btnSeeOrder)
                                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(btnAddMenu, GroupLayout.PREFERRED_SIZE, 139, GroupLayout.PREFERRED_SIZE)))
                                .addContainerGap())
        );
        gl_contentPane.setVerticalGroup(
                gl_contentPane.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(gl_contentPane.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(lblNewLabel)
                                .addGap(13)
                                .addComponent(scrollPane, GroupLayout.DEFAULT_SIZE, 198, Short.MAX_VALUE)
                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(gl_contentPane.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                        .addComponent(btnAddMenu)
                                        .addComponent(btnCancel)
                                        .addComponent(btnSeeOrder)))
        );

        tblMenus = new JTable(model);
        tblMenus.getSelectionModel().addListSelectionListener(new ListSelectionListener(){
            public void valueChanged(ListSelectionEvent event) {

                int row = tblMenus.getSelectedRow();

                if (row >= 0)
                    selectedMenu = model.getMenuAtRow(row) ;
                else
                    selectedMenu = null ;

                btnAddMenu.setEnabled(selectedMenu != null);
            }
        });

        scrollPane.setViewportView(tblMenus);
        contentPane.setLayout(gl_contentPane);
    }

    private void viewCart() {
        new CartDetails(cartMap, orderRepo);
    }

    private void addToCart(Menu menu) {
        ToppingsUI toppingsUI = new ToppingsUI(toppingRepo, menu);
        toppingsUI.pack();
        toppingsUI.setVisible(true);

        CartItem item = toppingsUI.getCartItem();
        if(cartMap.containsKey(item.getProductToppingId())) {
            cartMap.get(item.getProductToppingId()).setQuantity(cartMap.get(item.getProductToppingId()).getQuantity() + 1);
            cartMap.get(item.getProductToppingId()).setProductPrice(cartMap.get(item.getProductToppingId()).getQuantity() *
                    cartMap.get(item.getProductToppingId()).getProductPrice());
        } else {
            cartMap.put(item.getProductToppingId(), item);
        }
    }


    private class MenuTableModel extends AbstractTableModel {

        private String[] columnNames = {"Number", "Name", "Price",
                "Type", "Calories", "Base", "Size", "Sauce"};

        private List<Menu> rows ;

        public MenuTableModel() {
            refreshData();
        }

        public void refreshData() {
            this.rows = new ArrayList<Menu>();

            for (Menu menu: menuRepo.findAll()) {
                this.rows.add(menu) ;
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

            Menu menu = rows.get(row) ;

            switch (col) {
                case 0: return menu.getProductId();
                case 1: return menu.getProductName();
                case 2: return menu.getProductPrice();
                case 3: return menu.getProductType();
                case 4: return menu.getCalories();
                case 5: return menu.getPizzaBase();
                case 6: return menu.getPizzaSize();
                case 7: return menu.getPizzaSauce();
            }

            return null ;

        }

        public Class getColumnClass(int col) {
            switch (col) {
                case 0: return Integer.class;
                case 1:
                case 3:
                case 5:
                case 6:
                case 7:
                    return String.class;
                case 2:
                case 4:
                    return Double.class;
            }

            return null ;
        }

        public Menu getMenuAtRow(int row) {
            return rows.get(row);
        }
    }
}
