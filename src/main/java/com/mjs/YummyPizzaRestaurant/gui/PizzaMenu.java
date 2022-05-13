package com.mjs.YummyPizzaRestaurant.gui;

import com.mjs.YummyPizzaRestaurant.model.Menu;
import com.mjs.YummyPizzaRestaurant.repo.MenuRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.AbstractTableModel;
import java.awt.event.*;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class PizzaMenu extends JFrame{

    private JList list1;
    private JPanel listPanel;
    private JPanel tablePanel;
    private JTable pizzaTable;

    JScrollPane scrollPane;

    private ArrayList<Menu> menu;

    private Object[][] data;
    private Object[] columns;

    private MenuRepo menuRepo ;
    private MenuTableModel model ;

    private Menu selectedMenu ;

    private JPanel contentPane;
    private JTable tblMenus;
    private JButton btnEditMenu;
    private JButton btnAddMenu;

    JFrame frame;

    public static void main(String... args) {
        JFrame frame = new JFrame("JTable Test");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);

//        pMenu.createUIComponents();
//        JScrollPane scrollPane = new JScrollPane(table);

    }

//    private void createUIComponents() {
//        // TODO: place custom component creation code here
//
//        columns = new String[]{"id", "productName", "productPrice",
//        "productType", "calories", "pizzaBase", "pizzaSize", "pizzaSauce"};
//        data = new Object[][]{{1, "productName1", "productPric1e",
//                "pro1ductType", "calo1ries", "pizzaBas1e", "piz1zaSize", "pizz1aSauce"}
//        };
//        pizzaTable = new JTable(data, columns);
//        list1 = new JList(data);
//        scrollPane = new JScrollPane();
//        tablePanel = new JPanel();
//        tablePanel.add(pizzaTable);
//        listPanel = new JPanel();
//        listPanel.add(list1);
//        scrollPane.add(listPanel);
//        scrollPane.add(tablePanel);
//        JScrollPane scrollPane2 = new JScrollPane(pizzaTable);
//
//        frame = new JFrame("JTable Test");
//        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
////        JTable table = pMenu.createUIComponents();
////        JScrollPane scrollPane = new JScrollPane(table);
//        frame.getContentPane().add(scrollPane);
////        frame.getContentPane().add(scrollPane2);
//        frame.pack();
//        frame.setVisible(true);
//
//
//    }

//    private void createUIComponents2() {
//        // TODO: place custom component creation code here
//        Iterator<Menu> itr = menuRepo.findAll().iterator();
//        menu = new ArrayList<>();
//        while(itr.hasNext()) {
//            menu.add(itr.next());
//            System.out.println(menu.get(menu.size()-1).getProductName());
//        }
//
//        StringBuilder dataString = new StringBuilder();
//        for(int i = 0; i < menu.size(); i++) {
//            dataString.append(this.convertObjectToString(menu.get(i))).append(",");
//        }
//        System.out.println(dataString);
////        data = new Object[][]{{menu.get(0)}, {menu.get(1)}};
//        data = new Object[][]{{1, "p1 traditional small", 11.2, "pizza", 232.4, "traditional", "small", "tomato" }};
//
////        -----
//
//        System.out.println("ui2-----" + data[0][1]);
//        pizzaTable = new JTable(data, columns);
//        list1 = new JList(data);
//        scrollPane = new JScrollPane();
//        tablePanel = new JPanel();
//        tablePanel.add(pizzaTable);
//        listPanel = new JPanel();
//        listPanel.add(list1);
//        scrollPane.add(listPanel);
//        scrollPane.add(tablePanel);
//
//        frame.setTitle("JTable");
//        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
////        JTable table = pMenu.createUIComponents();
////        JScrollPane scrollPane = new JScrollPane(table);
//        frame.getContentPane().add(scrollPane);
////        frame.getContentPane().add(scrollPane2);
//        frame.pack();
//        frame.setVisible(true);
//    }
//{1, "p1 traditional small", 11.2, "pizza", 232.4, "traditional", "small", "tomato" }


    private String convertObjectToString(Menu m) {
        String rowData = "{" + m.getProductId() + ", \""
                + m.getProductName() + "\", " + m.getProductPrice() + ", \""
                + m.getProductType()+ "\", " + m.getCalories() + ", \""
                + m.getPizzaBase() + "\", \""
                + m.getPizzaSize() + "\", \"" + m.getPizzaSauce() + "\" }";
        System.out.println(rowData);
        return rowData;
    }

    public PizzaMenu(MenuRepo menuRepo) {

        this.menuRepo = menuRepo ;
        this.model = new MenuTableModel() ;


        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 450, 300);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);

        JLabel lblNewLabel = new JLabel("Menu");

        btnAddMenu = new JButton("Add Menu");
        btnAddMenu.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                addMenu();
            }
        });

        JScrollPane scrollPane = new JScrollPane();

        btnEditMenu = new JButton("Edit Menu");
        btnEditMenu.setEnabled(false);
        btnEditMenu.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                editMenu(selectedMenu);
            }
        });

        GroupLayout gl_contentPane = new GroupLayout(contentPane);
        gl_contentPane.setHorizontalGroup(
                gl_contentPane.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(gl_contentPane.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(gl_contentPane.createParallelGroup(GroupLayout.Alignment.LEADING)
                                        .addComponent(scrollPane, GroupLayout.DEFAULT_SIZE, 428, Short.MAX_VALUE)
                                        .addComponent(lblNewLabel)
                                        .addGroup(GroupLayout.Alignment.TRAILING, gl_contentPane.createSequentialGroup()
                                                .addComponent(btnEditMenu)
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
                                        .addComponent(btnEditMenu)))
        );

        tblMenus = new JTable(model);
        tblMenus.getSelectionModel().addListSelectionListener(new ListSelectionListener(){
            public void valueChanged(ListSelectionEvent event) {

                int row = tblMenus.getSelectedRow();

                if (row >= 0)
                    selectedMenu = model.getMenuAtRow(row) ;
                else
                    selectedMenu = null ;

                btnEditMenu.setEnabled(selectedMenu != null);
            }
        });

        scrollPane.setViewportView(tblMenus);
        contentPane.setLayout(gl_contentPane);
    }

    private void addMenu() {
        // TODO (in Step 2)
//        CreateMenu createMenu = new CreateMenu();
//        createMenu.pack();
//        createMenu.setVisible(true);
    }

    private void editMenu(Menu menu) {
        //TODO (in Step 3)
    }

    private void createUIComponents() {
        // TODO: place custom component creation code here
    }

    private class MenuTableModel extends AbstractTableModel {

        private String[] columnNames = {"id", "Name", "productPrice",
                "productType", "calories", "pizzaBase", "pizzaSize", "pizzaSauce"};

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
