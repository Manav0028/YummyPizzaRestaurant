package com.mjs.YummyPizzaRestaurant.gui;

import javax.swing.*;
import java.awt.event.*;

public class ApplyJob extends JDialog {
    private JPanel contentPane;
    private JLabel lblInstructions;
    private JTextField txtFirstName;
    private JTextField txtLastName;
    private JTextField txtEmail;
    private JTextField txtPhoneNumber;
    private JLabel lblFirstName;
    private JLabel lblLastName;
    private JLabel lblEmail;
    private JLabel lblPhoneNumber;
    private JButton btnApply;
    private JButton btnCancel;

    /**
     * Launch the application.
     */
    public static void main(String[] args) {
        try {
            ApplyJob dialog = new ApplyJob();
            dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
            dialog.setVisible(true);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * Create the dialog.
     */
    public ApplyJob() {
        setContentPane(contentPane);
        setVisible(true);

        btnApply.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                onOK();
            }
        });

        btnCancel.addActionListener(new ActionListener() {
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
        String firstName = txtFirstName.getText();
        String lastName = txtLastName.getText();
        dispose();
    }

    private void onCancel() {
        // add your code here if necessary
        dispose();
    }

    //
    private void createUIComponents() {
        // TODO: place custom component creation code here
    }


}
