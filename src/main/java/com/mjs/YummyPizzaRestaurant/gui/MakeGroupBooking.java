/*
 * Created by JFormDesigner on Fri May 13 22:29:29 AEST 2022
 */

package com.mjs.YummyPizzaRestaurant.gui;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.GroupLayout;
import javax.swing.border.*;

import com.mjs.YummyPizzaRestaurant.model.Booking;
import com.mjs.YummyPizzaRestaurant.repo.BookingRepo;


public class MakeGroupBooking extends JFrame {
    public MakeGroupBooking() {
        initComponents();
    }

    private Booking booking;
    private BookingRepo bookingRepo;

    private void cancelButtonMouseClicked(MouseEvent e) {
        close();
    }

    private void okButtonMouseClicked(MouseEvent e) {

        checkNumOfPeople();
        
    }
    
    private void txtNumOfPeopleKeyPressed(KeyEvent e) {
        okButton.setEnabled(inputComplete());
    }

    private void txtDateKeyPressed(KeyEvent e) {
        okButton.setEnabled(inputComplete());
    }
    
    private void txtNameKeyPressed(KeyEvent e) {
        okButton.setEnabled(inputComplete());
    }


    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents
        // Generated using JFormDesigner Evaluation license - Sean Lo
        dialogPane = new JPanel();
        contentPanel = new JPanel();
        label1 = new JLabel();
        txtNumOfPeople = new JTextField();
        label2 = new JLabel();
        txtDate = new JTextField();
        label3 = new JLabel();
        label4 = new JLabel();
        txtName = new JTextField();
        buttonBar = new JPanel();
        okButton = new JButton();
        cancelButton = new JButton();

        //======== this ========
        setTitle("New Group Booking");
        Container contentPane = getContentPane();
        contentPane.setLayout(new BorderLayout());

        //======== dialogPane ========
        {
            dialogPane.setBorder(new EmptyBorder(12, 12, 12, 12));
            dialogPane.setBorder(new javax.swing.border.CompoundBorder(new javax.swing.border.TitledBorder(new
            javax.swing.border.EmptyBorder(0,0,0,0), "JF\u006frmDes\u0069gner \u0045valua\u0074ion",javax
            .swing.border.TitledBorder.CENTER,javax.swing.border.TitledBorder.BOTTOM,new java
            .awt.Font("D\u0069alog",java.awt.Font.BOLD,12),java.awt
            .Color.red),dialogPane. getBorder()));dialogPane. addPropertyChangeListener(new java.beans.
            PropertyChangeListener(){@Override public void propertyChange(java.beans.PropertyChangeEvent e){if("\u0062order".
            equals(e.getPropertyName()))throw new RuntimeException();}});
            dialogPane.setLayout(new BorderLayout());

            //======== contentPanel ========
            {

                //---- label1 ----
                label1.setText("Please enter booking details:");

                //---- txtNumOfPeople ----
                txtNumOfPeople.addKeyListener(new KeyAdapter() {
                    @Override
                    public void keyPressed(KeyEvent e) {
                        txtNumOfPeopleKeyPressed(e);
                    }
                });

                //---- label2 ----
                label2.setText("Date:");

                //---- txtDate ----
                txtDate.addKeyListener(new KeyAdapter() {
                    @Override
                    public void keyPressed(KeyEvent e) {
                        txtDateKeyPressed(e);
                    }
                });

                //---- label3 ----
                label3.setText("Number of people:");

                //---- label4 ----
                label4.setText("Your name:");

                //---- txtName ----
                txtName.addKeyListener(new KeyAdapter() {
                    @Override
                    public void keyPressed(KeyEvent e) {
                        txtNameKeyPressed(e);
                    }
                });

                GroupLayout contentPanelLayout = new GroupLayout(contentPanel);
                contentPanel.setLayout(contentPanelLayout);
                contentPanelLayout.setHorizontalGroup(
                    contentPanelLayout.createParallelGroup()
                        .addGroup(contentPanelLayout.createSequentialGroup()
                            .addContainerGap()
                            .addGroup(contentPanelLayout.createParallelGroup()
                                .addGroup(contentPanelLayout.createSequentialGroup()
                                    .addGroup(contentPanelLayout.createParallelGroup()
                                        .addComponent(label4)
                                        .addComponent(label3)
                                        .addComponent(label2))
                                    .addGap(24, 24, 24)
                                    .addGroup(contentPanelLayout.createParallelGroup()
                                        .addGroup(contentPanelLayout.createSequentialGroup()
                                            .addComponent(txtNumOfPeople, GroupLayout.PREFERRED_SIZE, 146, GroupLayout.PREFERRED_SIZE)
                                            .addGap(0, 0, Short.MAX_VALUE))
                                        .addComponent(txtName)
                                        .addComponent(txtDate))
                                    .addGap(82, 82, 82))
                                .addGroup(contentPanelLayout.createSequentialGroup()
                                    .addComponent(label1)
                                    .addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                );
                contentPanelLayout.setVerticalGroup(
                    contentPanelLayout.createParallelGroup()
                        .addGroup(contentPanelLayout.createSequentialGroup()
                            .addContainerGap()
                            .addComponent(label1)
                            .addGap(18, 18, 18)
                            .addGroup(contentPanelLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                .addComponent(txtNumOfPeople, GroupLayout.PREFERRED_SIZE, 43, GroupLayout.PREFERRED_SIZE)
                                .addComponent(label3))
                            .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                            .addGroup(contentPanelLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                .addComponent(txtDate, GroupLayout.PREFERRED_SIZE, 42, GroupLayout.PREFERRED_SIZE)
                                .addComponent(label2))
                            .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, 12, Short.MAX_VALUE)
                            .addGroup(contentPanelLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                .addComponent(label4)
                                .addComponent(txtName, GroupLayout.PREFERRED_SIZE, 39, GroupLayout.PREFERRED_SIZE))
                            .addGap(27, 27, 27))
                );
            }
            dialogPane.add(contentPanel, BorderLayout.CENTER);

            //======== buttonBar ========
            {
                buttonBar.setBorder(new EmptyBorder(12, 0, 0, 0));
                buttonBar.setLayout(new GridBagLayout());
                ((GridBagLayout)buttonBar.getLayout()).columnWidths = new int[] {0, 85, 80};
                ((GridBagLayout)buttonBar.getLayout()).columnWeights = new double[] {1.0, 0.0, 0.0};

                //---- okButton ----
                okButton.setText("OK");
                okButton.addMouseListener(new MouseAdapter() {
                    @Override
                    public void mouseClicked(MouseEvent e) {
                        okButtonMouseClicked(e);
                    }
                });
                buttonBar.add(okButton, new GridBagConstraints(1, 0, 1, 1, 0.0, 0.0,
                    GridBagConstraints.CENTER, GridBagConstraints.BOTH,
                    new Insets(0, 0, 0, 5), 0, 0));

                //---- cancelButton ----
                cancelButton.setText("Cancel");
                cancelButton.addMouseListener(new MouseAdapter() {
                    @Override
                    public void mouseClicked(MouseEvent e) {
                        cancelButtonMouseClicked(e);
                    }
                });
                buttonBar.add(cancelButton, new GridBagConstraints(2, 0, 1, 1, 0.0, 0.0,
                    GridBagConstraints.CENTER, GridBagConstraints.BOTH,
                    new Insets(0, 0, 0, 0), 0, 0));
            }
            dialogPane.add(buttonBar, BorderLayout.SOUTH);
        }
        contentPane.add(dialogPane, BorderLayout.CENTER);
        pack();
        setLocationRelativeTo(getOwner());
        // JFormDesigner - End of component initialization  //GEN-END:initComponents
    }

    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables
    // Generated using JFormDesigner Evaluation license - Sean Lo
    private JPanel dialogPane;
    private JPanel contentPanel;
    private JLabel label1;
    private JTextField txtNumOfPeople;
    private JLabel label2;
    private JTextField txtDate;
    private JLabel label3;
    private JLabel label4;
    private JTextField txtName;
    private JPanel buttonBar;
    private JButton okButton;
    private JButton cancelButton;
    // JFormDesigner - End of variables declaration  //GEN-END:variables


    public static void main(String[] args) {
        try {
            MakeGroupBooking frame = new MakeGroupBooking();
            frame.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
            frame.setVisible(true);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void close() {
        this.setVisible(false);
        this.dispose();
    }

    private void checkNumOfPeople() {
        int ValueNumOfPeople = Integer.parseInt(txtNumOfPeople.getText());
        if (ValueNumOfPeople > 20 || ValueNumOfPeople < 6) {
            JOptionPane.showMessageDialog(null, "Sorry, group booking only accepts a party size of 6-20. Please adjust the number of people.");
        } else {
            JOptionPane.showMessageDialog(null, "Your group booking is confirmed.");
            //booking.setNumberOfPerson(ValueNumOfPeople);
            //bookingRepo.save(booking);
        }
    }

    
    private boolean inputComplete() {

        if (txtNumOfPeople.getText().isEmpty())
            return false;

        if (txtDate.getText().isEmpty())
            return false ;

        if (txtName.getText().isEmpty())
            return false ;

        return true ;
    }

}
