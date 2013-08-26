/*
 * Copyright (c) 2010, Oracle. All rights reserved.
 *
 * Redistribution and use in source and binary forms, with or without
 * modification, are permitted provided that the following conditions are met:
 *
 * * Redistributions of source code must retain the above copyright notice,
 *   this list of conditions and the following disclaimer.
 *
 * * Redistributions in binary form must reproduce the above copyright notice,
 *   this list of conditions and the following disclaimer in the documentation
 *   and/or other materials provided with the distribution.
 *
 * * Neither the name of Oracle nor the names of its contributors
 *   may be used to endorse or promote products derived from this software without
 *   specific prior written permission.
 *
 * THIS SOFTWARE IS PROVIDED BY THE COPYRIGHT HOLDERS AND CONTRIBUTORS "AS IS"
 * AND ANY EXPRESS OR IMPLIED WARRANTIES, INCLUDING, BUT NOT LIMITED TO, THE
 * IMPLIED WARRANTIES OF MERCHANTABILITY AND FITNESS FOR A PARTICULAR PURPOSE
 * ARE DISCLAIMED. IN NO EVENT SHALL THE COPYRIGHT OWNER OR CONTRIBUTORS BE
 * LIABLE FOR ANY DIRECT, INDIRECT, INCIDENTAL, SPECIAL, EXEMPLARY, OR
 * CONSEQUENTIAL DAMAGES (INCLUDING, BUT NOT LIMITED TO, PROCUREMENT OF
 * SUBSTITUTE GOODS OR SERVICES; LOSS OF USE, DATA, OR PROFITS; OR BUSINESS
 * INTERRUPTION) HOWEVER CAUSED AND ON ANY THEORY OF LIABILITY, WHETHER IN
 * CONTRACT, STRICT LIABILITY, OR TORT (INCLUDING NEGLIGENCE OR OTHERWISE)
 * ARISING IN ANY WAY OUT OF THE USE OF THIS SOFTWARE, EVEN IF ADVISED OF
 * THE POSSIBILITY OF SUCH DAMAGE.
 */

package ir.university.toosi.tms.view.user;


import com.fasterxml.jackson.databind.ObjectMapper;
import ir.university.toosi.tms.model.entity.PC;
import ir.university.toosi.tms.model.entity.User;
import ir.university.toosi.tms.model.entity.WebServiceInfo;
import ir.university.toosi.tms.model.entity.WorkGroup;
import ir.university.toosi.tms.util.RESTfulClientUtil;
import ir.university.toosi.tms.util.ThreadPoolManager;
import ir.university.toosi.tms.view.person.PersonList;
import org.jdesktop.beansbinding.BindingGroup;
import org.jdesktop.swingbinding.JTableBinding;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.beans.PropertyVetoException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class UserForm extends JInternalFrame {

    /**
     * Creates new form ContactEditor
     */
    private String[] workGroupsName;
    private UserManagement userManagement;
    private boolean editable = false;

    public UserForm(UserManagement userManagement) {

        this.userManagement = userManagement;
        WebServiceInfo webServiceInfo = new WebServiceInfo();
        webServiceInfo.setServiceName("/getAllWorkGroup");

        workGroupList = new RESTfulClientUtil().callListWorkGroup(webServiceInfo.getServerUrl(), webServiceInfo.getServiceName());
        workGroupsName = new String[workGroupList.size()];
        int i = 0;
        for (WorkGroup workGroup : workGroupList) {
            workGroupsName[i++] = workGroup.getName();
        }

        buttonGroup1 = new ButtonGroup();
        jPanel1 = new JPanel();
        personPanel = new JPanel();
        userNameLabel = new JLabel();
        userName = new JTextField();
        passLabel = new JLabel();
        password = new JTextField();
        jLabel5 = new JLabel();
        workGroups = new JComboBox(workGroupsName);
        nameLabel = new JLabel();
        name = new JTextField();
        lastName = new JTextField();
        lastNameLabel = new JLabel();
        nationalCode = new JTextField();
        nationalCodeLabel = new JLabel();
        cancelButton = new JButton();
        okButton = new JButton();
        assignPC = new JButton();
        assignPerson = new JButton();
        mainPanel = new JPanel();
        tableScroll = new JScrollPane();
        mainTable = new JTable();

        initComponents();
    }

    public UserForm(UserManagement userManagement, User user, JDesktopPane jDesktopPane, boolean editable) {
        List<WorkGroup> workGroupList;
        this.user = user;
        this.userManagement = userManagement;
        this.editable = editable;

        WebServiceInfo webServiceInfo = new WebServiceInfo();
        webServiceInfo.setServiceName("/getAllWorkGroup");

        workGroupList = new RESTfulClientUtil().callListWorkGroup(webServiceInfo.getServerUrl(), webServiceInfo.getServiceName());
        workGroupsName = new String[workGroupList.size()];
        int i = 0;
        for (WorkGroup workGroup : workGroupList) {
            workGroupsName[i++] = workGroup.getName();
        }

        buttonGroup1 = new ButtonGroup();
        jPanel1 = new JPanel();
        personPanel = new JPanel();
        userNameLabel = new JLabel();
        userName = new JTextField();
        passLabel = new JLabel();
        password = new JTextField();
        jLabel5 = new JLabel();
        workGroups = new JComboBox(workGroupsName);
        nameLabel = new JLabel();
        name = new JTextField();
        lastName = new JTextField();
        lastNameLabel = new JLabel();
        nationalCode = new JTextField();
        nationalCodeLabel = new JLabel();
        cancelButton = new JButton();
        okButton = new JButton();
        assignPC = new JButton();
        assignPerson = new JButton();
        mainPanel = new JPanel();
        this.jdpDesktop = jDesktopPane;
        tableScroll = new JScrollPane();
        mainTable = new JTable();

        if (user != null) {
            userName.setText(user.getUsername());
            password.setText(user.getPassword());
            if (user.getPerson() != null) {
                name.setText(user.getPerson().getName());
                lastName.setText(user.getPerson().getLastName());
                nationalCode.setText(user.getPerson().getNationalCode());
            }
        } else {
            userName.setText("");
            password.setText("");
            name.setText("");
            lastName.setText("");
            nationalCode.setText("");
        }

        initComponents();
    }

    /**
     * This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    public void initComponents() {


        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("USERMANAGEMENT");
        setClosable(true);
        this.addInternalFrameListener(ThreadPoolManager.mainForm);


        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder("USER"));
        personPanel.setBorder(javax.swing.BorderFactory.createTitledBorder("PERSON"));

        userNameLabel.setText("USERNAME");

        passLabel.setText("PASSWORD");

        password.setToolTipText("");


        jLabel5.setText("WORKGROUP");

        nameLabel.setText("NAME");
        lastNameLabel.setText("LASTNAME");
        nationalCodeLabel.setText("NATIONALCODE");


        mainPanel.setBorder(BorderFactory.createTitledBorder("PCLIST"));

        mainTable.setAutoCreateRowSorter(true);
        try {
            refresh();
        } catch (IOException e) {
            e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
        }


        mainTable.setColumnSelectionAllowed(true);
        tableScroll.setViewportView(mainTable);
        mainTable.getColumnModel().getSelectionModel().setSelectionMode(ListSelectionModel.MULTIPLE_INTERVAL_SELECTION);

        org.jdesktop.layout.GroupLayout jPanel1Layout = new org.jdesktop.layout.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
                jPanel1Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                        .add(jPanel1Layout.createSequentialGroup()
                                .add(45, 45, 45)
                                .add(jPanel1Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                                        .add(jPanel1Layout.createSequentialGroup()
                                                .add(jLabel5)
                                                .add(18, 18, 18)
                                                .add(workGroups, 0, 155, Short.MAX_VALUE))
                                        .add(jPanel1Layout.createSequentialGroup()
                                                .add(jPanel1Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                                                        .add(passLabel)
                                                        .add(userNameLabel))
                                                .add(18, 18, 18)
                                                .add(jPanel1Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                                                        .add(password, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, 157, Short.MAX_VALUE)
                                                        .add(org.jdesktop.layout.GroupLayout.TRAILING, userName, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, 157, Short.MAX_VALUE)
                                                )))
                                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
                jPanel1Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                        .add(jPanel1Layout.createSequentialGroup()
                                .add(jPanel1Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.BASELINE)
                                        .add(userName, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                                        .add(userNameLabel))
                                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                                .add(jPanel1Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.BASELINE)
                                        .add(password, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                                        .add(passLabel))
                                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)

                                .add(jPanel1Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.BASELINE)
                                        .add(jLabel5)
                                        .add(workGroups, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)))
        );

        org.jdesktop.layout.GroupLayout jPanel2Layout = new org.jdesktop.layout.GroupLayout(personPanel);
        personPanel.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
                jPanel2Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                        .add(jPanel2Layout.createSequentialGroup()
                                .add(45, 45, 45)
                                .add(jPanel2Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                                        .add(jPanel2Layout.createSequentialGroup()
                                                .add(nationalCodeLabel)
                                                .add(18, 18, 18)
                                                .add(nationalCode, 0, 155, Short.MAX_VALUE))
                                        .add(jPanel2Layout.createSequentialGroup()
                                                .add(jPanel2Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                                                        .add(nameLabel)
                                                        .add(lastNameLabel))
                                                .add(18, 18, 18)
                                                .add(jPanel2Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                                                        .add(lastName, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, 157, Short.MAX_VALUE)
                                                        .add(org.jdesktop.layout.GroupLayout.TRAILING, name, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, 157, Short.MAX_VALUE)
                                                )))
                                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
                jPanel2Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                        .add(jPanel2Layout.createSequentialGroup()
                                .add(jPanel2Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.BASELINE)
                                        .add(name, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                                        .add(nameLabel))
                                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                                .add(jPanel2Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.BASELINE)
                                        .add(lastName, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                                        .add(lastNameLabel))
                                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)

                                .add(jPanel2Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.BASELINE)
                                        .add(nationalCodeLabel)
                                        .add(nationalCode, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)))
        );


        cancelButton.setText("Cancel");
        cancelButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent actionEvent) {
                cancel();
            }
        });

        okButton.setText("OK");
        okButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                if (!editable) {
                    saveUser();
                } else {
                    updateUser();
                }
            }
        });

        assignPC.setText("ASSIGNPC");
        assignPC.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                try {
                    assignPCToUser(evt);
                } catch (PropertyVetoException e) {
                    e.printStackTrace();
                }
            }
        });

        assignPC.setEnabled(editable);

        assignPerson.setText("ASSIGNPERSON");
        assignPerson.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                try {
                    assignPersonToUser(evt);
                } catch (PropertyVetoException e) {
                    e.printStackTrace();
                }
            }
        });

        assignPerson.setEnabled(editable);

        org.jdesktop.layout.GroupLayout jPanel1Layout1 = new org.jdesktop.layout.GroupLayout(mainPanel);
        mainPanel.setLayout(jPanel1Layout1);
        jPanel1Layout1.setHorizontalGroup(
                jPanel1Layout1.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                        .add(jPanel1Layout1.createSequentialGroup()
                                .add(36, 36, 36)
                                .add(jPanel1Layout1.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                                        .add(tableScroll, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
                                .addContainerGap(45, Short.MAX_VALUE))
        );
        jPanel1Layout1.setVerticalGroup(
                jPanel1Layout1.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                        .add(jPanel1Layout1.createSequentialGroup()
                                .addContainerGap()
                                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .add(tableScroll, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 136, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                                .add(133, 133, 133))
        );


        org.jdesktop.layout.GroupLayout layout = new org.jdesktop.layout.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                        .add(layout.createSequentialGroup()
                                .add(26, 26, 26)
                                .add(jPanel1, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                                .addContainerGap(28, Short.MAX_VALUE))
                        .add(layout.createSequentialGroup()
                                .add(26, 26, 26)
                                .add(personPanel, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                                .addContainerGap(28, Short.MAX_VALUE))
                        .add(org.jdesktop.layout.GroupLayout.TRAILING, layout.createSequentialGroup()
                                .addContainerGap(84, Short.MAX_VALUE)
                                .add(okButton)
                                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                                .add(assignPC)
                                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                                .add(assignPerson)
                                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                                .add(cancelButton)
                                .add(90, 90, 90))
                        .add(org.jdesktop.layout.GroupLayout.TRAILING, layout.createSequentialGroup()
                                .addContainerGap(org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .add(mainPanel, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                                .addContainerGap())
        );

        layout.linkSize(new java.awt.Component[]{cancelButton, okButton, assignPC}, org.jdesktop.layout.GroupLayout.HORIZONTAL);

        layout.setVerticalGroup(
                layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                        .add(layout.createSequentialGroup()
                                .addContainerGap()
                                .add(jPanel1, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                                .add(personPanel, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                                .add(mainPanel, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 251, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                                .addContainerGap(org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.BASELINE)
                                        .add(cancelButton)
                                        .add(okButton)
                                        .add(assignPC)
                                        .add(assignPerson))
                                .addContainerGap(org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))

        );

        jPanel1.getAccessibleContext().setAccessibleName("UserForm");

        pack();
    }// </editor-fold>//GEN-END:initComponents

    public void saveUser() {
        User newUser = new User();
        WebServiceInfo serviceInfo = new WebServiceInfo();
        newUser.setUsername(userName.getText());
        newUser.setPassword(password.getText());
        serviceInfo.setServiceName("/findWorkGroupByName");
        try {
            WorkGroup workGroup = new ObjectMapper().readValue(new RESTfulClientUtil().restFullServiceString(serviceInfo.getServerUrl(), serviceInfo.getServiceName(), (String) workGroups.getSelectedItem()), WorkGroup.class);
            Set<WorkGroup> workGroups1 = new HashSet<>();
            workGroups1.add(workGroup);
            newUser.setWorkGroups(workGroups1);
//        String workgroupName=workGroups.getSelectedItem();
//        user.setWorkGroups();

            serviceInfo.setServiceName("/createUser");
            user = new ObjectMapper().readValue(new RESTfulClientUtil().restFullService(serviceInfo.getServerUrl(), serviceInfo.getServiceName(), new ObjectMapper().writeValueAsString(newUser)), User.class);
            assignPC.setEnabled(true);
            assignPerson.setEnabled(true);
//            this.setVisible(false);
//            this.dispose();
//            userManagement.refresh();
        } catch (IOException e) {
            e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
        }

    }

    public void updateUser() {
        WebServiceInfo serviceInfo = new WebServiceInfo();
        user.setUsername(userName.getText());
        user.setPassword(password.getText());
        serviceInfo.setServiceName("/findWorkGroupByName");
        try {
            WorkGroup workGroup = new ObjectMapper().readValue(new RESTfulClientUtil().restFullServiceString(serviceInfo.getServerUrl(), serviceInfo.getServiceName(), (String) workGroups.getSelectedItem()), WorkGroup.class);
            Set<WorkGroup> workGroups1 = new HashSet<>();
            workGroups1.add(workGroup);
            user.setWorkGroups(workGroups1);
//        String workgroupName=workGroups.getSelectedItem();
//        user.setWorkGroups();
            serviceInfo.setServiceName("/editUser");
            new RESTfulClientUtil().restFullService(serviceInfo.getServerUrl(), serviceInfo.getServiceName(), new ObjectMapper().writeValueAsString(user));
//            this.setVisible(false);
//            this.dispose();
//            userManagement.refresh();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    private void assignPCToUser(java.awt.event.ActionEvent evt) throws PropertyVetoException {//GEN-FIRST:event_jButton1ActionPerformed
        PCManagement pcManagement = new PCManagement(this, user, jdpDesktop);
        pcManagement.setVisible(true);
        jdpDesktop.add(pcManagement);
        pcManagement.setSelected(true);
    }//GEN-LAST:event_jButton1ActionPerformed

    private void assignPersonToUser(java.awt.event.ActionEvent evt) throws PropertyVetoException {//GEN-FIRST:event_jButton1ActionPerformed
        PersonList personListForm = new PersonList(this, user, jdpDesktop);
        personListForm.setVisible(true);
        jdpDesktop.add(personListForm);
        personListForm.setSelected(true);
    }//GEN-LAST:event_jButton1ActionPerformed

    public void cancel() {
        this.dispose();
        try {
            userManagement.refresh();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void getAll() throws IOException {
        pcList = new ArrayList<>();
        if (user == null)
            return;
        for (PC pc : user.getPcs()) {
            pcList.add(pc);
        }
    }

    public void refresh() throws IOException {
        getAll();
        showData();
    }

    private void showData() {
        JTableBinding jTableBinding = org.jdesktop.swingbinding.SwingBindings.createJTableBinding(org.jdesktop.beansbinding.AutoBinding.UpdateStrategy.READ_WRITE, pcList, mainTable, "");
        JTableBinding.ColumnBinding columnBinding = jTableBinding.addColumnBinding(org.jdesktop.beansbinding.ELProperty.create("${name}"));
        columnBinding.setColumnName("NAME");
        columnBinding.setColumnClass(String.class);
        columnBinding = jTableBinding.addColumnBinding(org.jdesktop.beansbinding.ELProperty.create("${ip}"));
        columnBinding.setColumnName("IP");
        columnBinding.setColumnClass(String.class);
        columnBinding = jTableBinding.addColumnBinding(org.jdesktop.beansbinding.ELProperty.create("${location}"));
        columnBinding.setColumnName("LOCATION");
        columnBinding.setColumnClass(String.class);
        BindingGroup bindingGroup = new BindingGroup();
        bindingGroup.addBinding(jTableBinding);
        jTableBinding.bind();
    }

    /**
     * @param args the command line arguments
     */

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private ButtonGroup buttonGroup1;
    private JButton cancelButton;
    private JPanel mainPanel;
    private JButton okButton;
    private JButton assignPC;
    private JButton assignPerson;
    private JComboBox workGroups;
    private JLabel userNameLabel;
    private JLabel passLabel;
    private JLabel jLabel5;
    private JLabel nameLabel;
    private JLabel lastNameLabel;
    private JLabel nationalCodeLabel;
    private JPanel jPanel1;
    private JPanel personPanel;
    private JTextField userName;
    private JTextField password;
    private JTextField name;
    private JTextField lastName;
    private JTextField nationalCode;
    private JDesktopPane jdpDesktop;
    private User user;
    private JScrollPane tableScroll;
    private JTable mainTable;
    List<WorkGroup> workGroupList = new ArrayList<>();
    List<PC> pcList = new ArrayList<>();
    // End of variables declaration//GEN-END:variables

    public JTable getMainTable() {
        return mainTable;
    }

}
