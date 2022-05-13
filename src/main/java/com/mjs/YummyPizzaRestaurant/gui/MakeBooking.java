package com.mjs.YummyPizzaRestaurant.gui;

import javax.swing.*;

public class MakeBooking extends JFrame {

    private JLabel lblEnterNumPeople;
    private JTextField txtEnterNumPeople;
    private JButton btnNext;

    public MakeBooking(){
        setTitle("Make Group Booking");
        setSize(300,200);
        setLocation(150, 250);
        setVisible(true);
        setDefaultCloseOperation(EXIT_ON_CLOSE);

    }

    private void createUIComponents() {
        // TODO: place custom component creation code here
    }
}
