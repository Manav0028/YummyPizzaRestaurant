package com.mjs.YummyPizzaRestaurant.gui;

import com.mjs.YummyPizzaRestaurant.model.JobApplication;

import javax.swing.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class ApplyJob extends JDialog {
    private JPanel contentPane;
    public JobApplication application;

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
    private JLabel lblVacancyId;
    private JTextField txtVacancyId;

    /**
     * Create the dialog.
     */
    public ApplyJob(JobApplication application) {

        this.setContentPane(contentPane);
        this.application = application;

        this.setModal(true);
        setTitle("Apply Job");
        setBounds(100, 100, 450, 300);

        btnCancel.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                close();
            }
        });
        btnApply.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                applyForJob();
            }
        });
    }

    private void applyForJob() {
        String vacancyId = txtVacancyId.getText();
        String firstName = txtFirstName.getText();
        String lastName = txtLastName.getText();
        String email = txtEmail.getText();
        String phoneNumber = txtPhoneNumber.getText();

        if (vacancyId.isEmpty() || firstName.isEmpty() || lastName.isEmpty() || email.isEmpty() || phoneNumber.isEmpty()) {
            JOptionPane.showMessageDialog(this,
                    "Please enter all fields",
                    "Try Again",
                    JOptionPane.ERROR_MESSAGE);
            return;
        }
    }

    private boolean inputComplete() {

        if (txtVacancyId.getText().isEmpty() || !txtVacancyId.isValid())
            return false;

        if (txtFirstName.getText().isEmpty())
            return false;

        if (txtLastName.getText().isEmpty())
            return false;

        if (txtEmail.getText().isEmpty())
            return false;

        if (txtPhoneNumber.getText().isEmpty())
            return false;

        return true;
    }

    public JobApplication showDialog() {
        setVisible(true);
        return application;
    }

    private void close() {
        this.setVisible(false);
        this.dispose();
    }

}
