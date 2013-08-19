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
import ir.university.toosi.tms.model.entity.User;
import ir.university.toosi.tms.model.entity.WebServiceInfo;
import ir.university.toosi.tms.model.entity.WorkGroup;
import ir.university.toosi.tms.util.RESTfulClientUtil;
import ir.university.toosi.tms.util.ThreadPoolManager;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
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
    private User user;

    public UserForm(UserManagement userManagement) {
        List<WorkGroup> workGroupList;
        this.userManagement = userManagement;
        WebServiceInfo webServiceInfo = new WebServiceInfo();
        webServiceInfo.setServiceName("/getAllWorkGroup");

        workGroupList = new RESTfulClientUtil().callListWorkGroup(webServiceInfo.getServerUrl(), webServiceInfo.getServiceName());
        workGroupsName = new String[workGroupList.size()];
        int i = 0;
        for (WorkGroup workGroup : workGroupList) {
            workGroupsName[i++] = workGroup.getName();
        }

        buttonGroup1 = new javax.swing.ButtonGroup();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        userName = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        password = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        firstName = new javax.swing.JTextField();
        familyName = new javax.swing.JTextField();
        workGroups = new javax.swing.JComboBox(workGroupsName);
        cancelButton = new javax.swing.JButton();
        okButton = new javax.swing.JButton();

        initComponents();
    }

    public UserForm(UserManagement userManagement, User user) {
        List<WorkGroup> workGroupList;
        this.user=user;
        this.userManagement = userManagement;
        editable = true;

        WebServiceInfo webServiceInfo = new WebServiceInfo();
        webServiceInfo.setServiceName("/getAllWorkGroup");

        workGroupList = new RESTfulClientUtil().callListWorkGroup(webServiceInfo.getServerUrl(), webServiceInfo.getServiceName());
        workGroupsName = new String[workGroupList.size()];
        int i = 0;
        for (WorkGroup workGroup : workGroupList) {
            workGroupsName[i++] = workGroup.getName();
        }

        buttonGroup1 = new javax.swing.ButtonGroup();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        userName = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        password = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        firstName = new javax.swing.JTextField();
        familyName = new javax.swing.JTextField();
        workGroups = new javax.swing.JComboBox(workGroupsName);
        cancelButton = new javax.swing.JButton();
        okButton = new javax.swing.JButton();

        userName.setText(user.getUsername());
        firstName.setText(user.getPerson().getName());
        familyName.setText(user.getPerson().getLastName());
        password.setText(user.getPassword());

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

        jLabel1.setText("USERNAME");

        jLabel3.setText("PASSWORD");

        password.setToolTipText("");

        jLabel2.setText("NAME");

        jLabel4.setText("FAMILYNAME");

        jLabel5.setText("WORKGROUP");

        familyName.setToolTipText("");


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
                                                        .add(jLabel2)
                                                        .add(jLabel3)
                                                        .add(jLabel4)
                                                        .add(jLabel1))
                                                .add(18, 18, 18)
                                                .add(jPanel1Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                                                        .add(password, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, 157, Short.MAX_VALUE)
                                                        .add(org.jdesktop.layout.GroupLayout.TRAILING, userName, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, 157, Short.MAX_VALUE)
                                                        .add(firstName, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, 157, Short.MAX_VALUE)
                                                        .add(familyName, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, 157, Short.MAX_VALUE))))
                                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
                jPanel1Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                        .add(jPanel1Layout.createSequentialGroup()
                                .add(jPanel1Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.BASELINE)
                                        .add(userName, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                                        .add(jLabel1))
                                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                                .add(jPanel1Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.BASELINE)
                                        .add(password, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                                        .add(jLabel3))
                                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                                .add(jPanel1Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.BASELINE)
                                        .add(jLabel2)
                                        .add(firstName, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(org.jdesktop.layout.LayoutStyle.UNRELATED)
                                .add(jPanel1Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.BASELINE)
                                        .add(jLabel4)
                                        .add(familyName, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(org.jdesktop.layout.LayoutStyle.UNRELATED)
                                .add(jPanel1Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.BASELINE)
                                        .add(jLabel5)
                                        .add(workGroups, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)))
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


        org.jdesktop.layout.GroupLayout layout = new org.jdesktop.layout.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                        .add(layout.createSequentialGroup()
                                .add(26, 26, 26)
                                .add(jPanel1, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                                .addContainerGap(28, Short.MAX_VALUE))
                        .add(org.jdesktop.layout.GroupLayout.TRAILING, layout.createSequentialGroup()
                                .addContainerGap(114, Short.MAX_VALUE)
                                .add(okButton)
                                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                                .add(cancelButton)
                                .add(110, 110, 110))
        );

        layout.linkSize(new java.awt.Component[]{cancelButton, okButton}, org.jdesktop.layout.GroupLayout.HORIZONTAL);

        layout.setVerticalGroup(
                layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                        .add(layout.createSequentialGroup()
                                .addContainerGap()
                                .add(jPanel1, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                                .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.BASELINE)
                                        .add(cancelButton)
                                        .add(okButton))
                                .addContainerGap(org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel1.getAccessibleContext().setAccessibleName("UserForm");

        pack();
    }// </editor-fold>//GEN-END:initComponents

    public void saveUser() {
        User user = new User();
        WebServiceInfo serviceInfo = new WebServiceInfo();
        user.setUsername(userName.getText());
        user.setPassword(password.getText());
        user.getPerson().setName(firstName.getText());
        serviceInfo.setServiceName("/findWorkGroupByName");
        try {
            WorkGroup workGroup = new ObjectMapper().readValue(new RESTfulClientUtil().restFullService(serviceInfo.getServerUrl(), serviceInfo.getServiceName(), (String) workGroups.getSelectedItem()), WorkGroup.class);
            Set<WorkGroup> workGroups1 = new HashSet<>();
            workGroups1.add(workGroup);
            user.setWorkGroups(workGroups1);
            user.getPerson().setLastName(familyName.getText());
//        String workgroupName=workGroups.getSelectedItem();
//        user.setWorkGroups();

            serviceInfo.setServiceName("/createUser");
            new RESTfulClientUtil().restFullService(serviceInfo.getServerUrl(), serviceInfo.getServiceName(), new ObjectMapper().writeValueAsString(user));
            this.setVisible(false);
            this.dispose();
            userManagement.refresh();
        } catch (IOException e) {
            e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
        }

    }
public void updateUser() {
        WebServiceInfo serviceInfo = new WebServiceInfo();
        user.setUsername(userName.getText());
        user.setPassword(password.getText());
        user.getPerson().setName(firstName.getText());
        serviceInfo.setServiceName("/findWorkGroupByName");
        try {
            WorkGroup workGroup = new ObjectMapper().readValue(new RESTfulClientUtil().restFullService(serviceInfo.getServerUrl(), serviceInfo.getServiceName(), (String) workGroups.getSelectedItem()), WorkGroup.class);
            Set<WorkGroup> workGroups1 = new HashSet<>();
            workGroups1.add(workGroup);
            user.setWorkGroups(workGroups1);
            user.getPerson().setLastName(familyName.getText());
//        String workgroupName=workGroups.getSelectedItem();
//        user.setWorkGroups();
            serviceInfo.setServiceName("/editUser");
            new RESTfulClientUtil().restFullService(serviceInfo.getServerUrl(), serviceInfo.getServiceName(), new ObjectMapper().writeValueAsString(user));
            this.setVisible(false);
            this.dispose();
            userManagement.refresh();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public void cancel() {
        this.dispose();
    }

    /**
     * @param args the command line arguments
     */

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JButton cancelButton;
    private javax.swing.JButton okButton;
    private javax.swing.JComboBox workGroups;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JTextField userName;
    private javax.swing.JTextField firstName;
    private javax.swing.JTextField password;
    private javax.swing.JTextField familyName;
    // End of variables declaration//GEN-END:variables

}
