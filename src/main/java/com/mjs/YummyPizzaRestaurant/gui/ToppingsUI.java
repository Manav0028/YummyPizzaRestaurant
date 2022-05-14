package com.mjs.YummyPizzaRestaurant.gui;

import com.mjs.YummyPizzaRestaurant.model.CartItem;
import com.mjs.YummyPizzaRestaurant.model.Menu;
import com.mjs.YummyPizzaRestaurant.model.Topping;
import com.mjs.YummyPizzaRestaurant.repo.ToppingRepo;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.event.*;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ToppingsUI extends JDialog {
    private JPanel contentPane;
    private JButton buttonOK;
    private JButton buttonCancel;
    private JComboBox<String> toppingComboBox;

    private Map<String, Topping> toppingMap;
    private CartItem cartItem;
    private Menu menu;

    public ToppingsUI(ToppingRepo toppingRepo, Menu menu) {

        this.setBounds(100, 100, 400, 150);
        this.contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        setModal(true);
        getRootPane().setDefaultButton(buttonOK);

        this.toppingMap = new HashMap<>();
        this.menu = menu;
        List<Topping> top = toppingRepo.findByProductId(menu.getProductId());
        top.forEach(topping -> {
            System.out.println(topping.toString());
            toppingMap.put(topping.getToppingName(), topping);
        });


        String[] toppings = new String[top.size()];
        final int[] i = {0};
        top.forEach(topping -> {
            toppings[i[0]] = topping.getToppingName();
            i[0]++;
        });

        toppingComboBox.setModel(new DefaultComboBoxModel<>(toppings));
//        top.forEach(topping -> toppingComboBox.addItem(topping.getToppingName()));

        buttonOK.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                onOK();
            }
        });

        buttonCancel.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                onCancel();
            }
        });

        // call onCancel() when cross is clicked
        setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
        addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e) {
                onCancel();
            }
        });

        // call onCancel() on ESCAPE
        contentPane.registerKeyboardAction(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                onCancel();
            }
        }, KeyStroke.getKeyStroke(KeyEvent.VK_ESCAPE, 0), JComponent.WHEN_ANCESTOR_OF_FOCUSED_COMPONENT);
    }

    private void onOK() {
        // add your code here
        String selectedItem = (String) toppingComboBox.getSelectedItem();
        System.out.println(selectedItem);
        dispose();
        cartItem = new CartItem();
        cartItem.setProductId(menu.getProductId());
        cartItem.setProductName(menu.getProductName());
        cartItem.setProductType(menu.getProductType());
        cartItem.setProductPrice(menu.getProductPrice());
        cartItem.setPizzaBase(menu.getPizzaBase());
        cartItem.setPizzaSauce(menu.getPizzaSauce());
        cartItem.setPizzaSize(menu.getPizzaSize());
        cartItem.setQuantity(1);
        cartItem.setTopping(toppingMap.get(selectedItem).getToppingName());
        cartItem.setToppingId(toppingMap.get(selectedItem).getToppingId());
    }

    private void onCancel() {
        // add your code here if necessary
        dispose();
    }

    public CartItem getCartItem() {
        return cartItem;
    }

    public static void main(String[] args) {
//        ToppingsUI dialog = new ToppingsUI();
//        dialog.pack();
//        dialog.setVisible(true);
//        System.exit(0);
    }

}
