package com.mjs.YummyPizzaRestaurant.gui;

import com.mjs.YummyPizzaRestaurant.repo.MenuRepo;
import com.mjs.YummyPizzaRestaurant.repo.OrderRepo;
import com.mjs.YummyPizzaRestaurant.repo.ToppingRepo;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class HomeUI extends JFrame{
    private JButton menuButton;
    private JButton allOrdersButton;
    private JButton vacancyButton;
    private JLabel titleLabel;
    private JPanel rootPanel;
    private JPanel menuPanel;
    private JPanel allOrderPanel;
    private JPanel jobsPanel;

    public HomeUI(MenuRepo menuRepo, ToppingRepo toppingRepo, OrderRepo orderRepo) {

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setBounds(100, 100, 150, 100); //frame bounds
        this.rootPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(rootPanel);
        pack();
        setVisible(true);

        menuButton.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);
                PizzaMenu menuGui = new PizzaMenu(menuRepo, toppingRepo, orderRepo);
                menuGui.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
                menuGui.pack();
                menuGui.setVisible(true);
            }
        });

        allOrdersButton.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);
                OrderDetails ordersGui = new OrderDetails(orderRepo, menuRepo, toppingRepo);
            }
        });

        makeGroupButton.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);
                MakeGroupBooking menuGui = new MakeGroupBooking();
                menuGui.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
                menuGui.pack();
                menuGui.setVisible(true);
            }
        });

        vacancyButton.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);
                ViewVacancies vacancyGui = new ViewVacancies(jobVacancyRepo);
                vacancyGui.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
                vacancyGui.pack();
                vacancyGui.setVisible(true);
            }
        });
    }

    public JPanel getRootPanel() {
        return rootPanel;
    }
}
