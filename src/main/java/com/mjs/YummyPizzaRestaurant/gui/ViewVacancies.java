package com.mjs.YummyPizzaRestaurant.gui;

import com.mjs.YummyPizzaRestaurant.model.JobApplication;
import com.mjs.YummyPizzaRestaurant.model.JobVacancy;
import com.mjs.YummyPizzaRestaurant.repo.JobVacancyRepo;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.AbstractTableModel;
import java.awt.event.ComponentAdapter;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class ViewVacancies extends JFrame {

    private JobVacancyRepo vacancies;
    private VacancyTableModel model;

    private JobVacancy selectedVacancy;
    private JobApplication application;

    private JPanel contentPane;
    private JPanel ctpMain;
    private JLabel lblAllVacancies;
    private JTable tblVacancies;
    private JScrollPane scpVacancies;
    private JPanel ctpButtons;
    private JButton btnStartApplication;
    private JButton btnCancel;

    /**
     * Create the frame.
     */
    public ViewVacancies(JobVacancyRepo vacancies) {

        this.vacancies = vacancies;
        this.model = new VacancyTableModel();

        setTitle("View Job Vacancies");
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setBounds(100, 100, 900, 450);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);

        btnCancel.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                close();
            }
        });

        lblAllVacancies = new JLabel("All Vacancies");

        scpVacancies = new JScrollPane();

        GroupLayout gl_contentPane = new GroupLayout(contentPane);
        gl_contentPane.setHorizontalGroup(
                gl_contentPane.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(gl_contentPane.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(gl_contentPane.createParallelGroup(GroupLayout.Alignment.LEADING)
                                        .addComponent(lblAllVacancies)
                                        .addComponent(scpVacancies, GroupLayout.DEFAULT_SIZE, 428, Short.MAX_VALUE)
                                        .addGroup(GroupLayout.Alignment.TRAILING, gl_contentPane.createSequentialGroup()
                                                .addComponent(btnCancel)
                                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(btnStartApplication, GroupLayout.PREFERRED_SIZE, 139, GroupLayout.PREFERRED_SIZE)))
                                .addContainerGap())
        );

        gl_contentPane.setVerticalGroup(
                gl_contentPane.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(gl_contentPane.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(lblAllVacancies)
                                .addGap(13)
                                .addComponent(scpVacancies, GroupLayout.DEFAULT_SIZE, 198, Short.MAX_VALUE)
                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(gl_contentPane.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                        .addComponent(btnCancel)
                                        .addComponent(btnStartApplication)))
        );

        tblVacancies = new JTable(model);
        tblVacancies.getSelectionModel().addListSelectionListener(new ListSelectionListener(){
            public void valueChanged(ListSelectionEvent event) {

                int row = tblVacancies.getSelectedRow();

                if (row >= 0)
                    selectedVacancy = model.getVacancyAtRow(row);
                else
                    selectedVacancy = null;
            }
        });
        scpVacancies.setViewportView(tblVacancies);
        scpVacancies.addComponentListener(new ComponentAdapter() {
        });
        btnStartApplication.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent e) {
                applyJob(application);
            }
        });
    }

    private void applyJob(JobApplication application) {
        ApplyJob dlg = new ApplyJob(application);
        JobApplication addedApplication = dlg.showDialog();
    }

    private class VacancyTableModel extends AbstractTableModel {

        private String[] columnNames = {"ID", "positionName", "jobDescription", "numberOfPositions", "lastDateToApply"};

        private List<JobVacancy> rows;

        public VacancyTableModel() {
            refreshData();
        }

        public void refreshData() {
            this.rows = new ArrayList<JobVacancy>();

            for (JobVacancy vacancy: vacancies.findAll()) {
                this.rows.add(vacancy);
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

            JobVacancy vacancy = rows.get(row);

            switch (col) {
                case 0: return vacancy.getId();
                case 1: return vacancy.getPositionName();
                case 2: return vacancy.getJobDescription();
                case 3: return vacancy.getNumberOfPositions();
                case 4: return vacancy.getLastDateToApply();
            }
            return null;
        }

        public Class getColumnClass(int col) {
            switch (col) {
                case 0: return Integer.class;
                case 1: return String.class;
                case 2: return String.class;
                case 3: return Integer.class;
                case 4: return Date.class;
            }
            return null;
        }

        public JobVacancy getVacancyAtRow(int row) {
            return rows.get(row);
        }

    }

    private void close() {
        this.setVisible(false);
        this.dispose();
    }

}
