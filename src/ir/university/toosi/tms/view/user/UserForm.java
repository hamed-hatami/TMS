package ir.university.toosi.tms.view.user;


import com.fasterxml.jackson.databind.ObjectMapper;
import ir.university.toosi.tms.model.entity.PC;
import ir.university.toosi.tms.model.entity.User;
import ir.university.toosi.tms.model.entity.WebServiceInfo;
import ir.university.toosi.tms.model.entity.WorkGroup;
import ir.university.toosi.tms.util.RESTfulClientUtil;
import ir.university.toosi.tms.util.ThreadPoolManager;
import ir.university.toosi.tms.view.TMSInternalFrame;
import ir.university.toosi.tms.view.TMSPanel;
import ir.university.toosi.tms.view.person.PersonList;
import org.jdesktop.beansbinding.BindingGroup;
import org.jdesktop.swingbinding.JTableBinding;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.beans.PropertyVetoException;
import java.io.IOException;
import java.util.*;

public class UserForm extends TMSInternalFrame {

    /**
     * Creates new form ContactEditor
     */
    private UserManagement userManagement;
    private boolean editable = false;

    public UserForm(UserManagement userManagement) {

        this.userManagement = userManagement;

        WebServiceInfo webServiceInfo = new WebServiceInfo();
        webServiceInfo.setServiceName("/getAllWorkGroup");

        allWorkGroupList = new RESTfulClientUtil().callListWorkGroup(webServiceInfo.getServerUrl(), webServiceInfo.getServiceName());
        for (WorkGroup workGroup : allWorkGroupList) {
            workGroupListModel.addElement(workGroup.getDescription());
            workGroupHashtable.put(workGroup.getDescription(), workGroup);
        }

        buttonGroup1 = new ButtonGroup();
        TMSPanel1 = new TMSPanel();
        personPanel = new TMSPanel();
        userNameLabel = new JLabel();
        userName = new JTextField();
        passLabel = new JLabel();
        password = new JTextField();
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
        mainPanel = new TMSPanel();
        tableScroll = new JScrollPane();
        mainTable = new JTable();
        allList = new JList();
        assignList = new JList();
        allList.setModel(workGroupListModel);
        jScrollPane1 = new JScrollPane();
        jScrollPane1.setViewportView(allList);
        jScrollPane2 = new JScrollPane();
        jScrollPane2.setViewportView(assignList);
        add = new JButton();
        remove = new JButton();

        initComponents();
    }

    public UserForm(UserManagement userManagement, User user, JDesktopPane jDesktopPane, boolean editable) {
        List<WorkGroup> workGroupList;
        this.user = user;
        this.userManagement = userManagement;
        this.editable = editable;

        WebServiceInfo webServiceInfo = new WebServiceInfo();
        webServiceInfo.setServiceName("/getAllWorkGroup");

        allWorkGroupList = new RESTfulClientUtil().callListWorkGroup(webServiceInfo.getServerUrl(), webServiceInfo.getServiceName());
        for (WorkGroup workGroup : allWorkGroupList) {
            workGroupListModel.addElement(workGroup.getDescription());
            workGroupHashtable.put(workGroup.getDescription(), workGroup);
        }


        buttonGroup1 = new ButtonGroup();
        TMSPanel1 = new TMSPanel();
        personPanel = new TMSPanel();
        userNameLabel = new JLabel();
        userName = new JTextField();
        passLabel = new JLabel();
        password = new JTextField();
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
        mainPanel = new TMSPanel();
        this.jdpDesktop = jDesktopPane;
        tableScroll = new JScrollPane();
        mainTable = new JTable();
        allList = new JList();
        assignList = new JList();
        allList.setModel(workGroupListModel);
        jScrollPane1 = new JScrollPane();
        jScrollPane1.setViewportView(allList);
        jScrollPane2 = new JScrollPane();
        jScrollPane2.setViewportView(assignList);
        add = new JButton();
        remove = new JButton();


        if (user != null) {
            userName.setText(user.getUsername());
            password.setText(user.getPassword());
            if (user.getPerson() != null) {
                name.setText(user.getPerson().getName());
                lastName.setText(user.getPerson().getLastName());
                nationalCode.setText(user.getPerson().getNationalCode());
            }
            if (user.getWorkGroups() != null) {
                for (WorkGroup workGroup : user.getWorkGroups()) {
                    selectedWorkGroupListModel.addElement(workGroup.getDescription());
                    if (workGroupHashtable.containsKey(workGroup.getDescription())) {
                        workGroupListModel.removeElement(workGroup.getDescription());
                    } else
                        workGroupHashtable.put(workGroup.getDescription(), workGroup);
                }

                assignList.setModel(selectedWorkGroupListModel);
            }
        } else {
            userName.setText("");
            password.setText("");
            name.setText("");
            lastName.setText("");
            nationalCode.setText("");
        }

        name.setEnabled(false);
        lastName.setEnabled(false);
        nationalCode.setEnabled(false);

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
        setResizable(true);
        setAutoscrolls(true);
        setSize(800, 900);
        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle(ThreadPoolManager.getLangValue("TMS_USER_MANAGEMENT"));
        setClosable(true);
        this.addInternalFrameListener(ThreadPoolManager.mainForm);

        if (ThreadPoolManager.currentLanguage.isRtl())
            add.setText("<");
        else
            add.setText(">");
        add.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addActionPerformed(evt);
            }
        });
        if (ThreadPoolManager.currentLanguage.isRtl())
            remove.setText(">");
        else
            remove.setText("<");
        remove.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                removeActionPerformed(evt);
            }
        });


        TMSPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(ThreadPoolManager.getLangValue("TMS_USER")));
        personPanel.setBorder(javax.swing.BorderFactory.createTitledBorder(ThreadPoolManager.getLangValue("TMS_PERSON")));

        userNameLabel.setText(ThreadPoolManager.getLangValue("TMS_USERNAME"));

        passLabel.setText(ThreadPoolManager.getLangValue("TMS_PASSWORD"));

        password.setToolTipText("");


        nameLabel.setText(ThreadPoolManager.getLangValue("TMS_NAME"));
        lastNameLabel.setText(ThreadPoolManager.getLangValue("TMS_LAST_NAME"));
        nationalCodeLabel.setText(ThreadPoolManager.getLangValue("TMS_NATIONAL_CODE"));


        mainPanel.setBorder(BorderFactory.createTitledBorder(ThreadPoolManager.getLangValue("TMS_PC_LIST")));

        mainTable.setAutoCreateRowSorter(true);
        try {
            refresh();
        } catch (IOException e) {
            e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
        }


        mainTable.setColumnSelectionAllowed(true);
        tableScroll.setViewportView(mainTable);
        mainTable.getColumnModel().getSelectionModel().setSelectionMode(ListSelectionModel.MULTIPLE_INTERVAL_SELECTION);

        /* org.jdesktop.layout.GroupLayout TMSPanel1Layout = new org.jdesktop.layout.GroupLayout(TMSPanel1);
       TMSPanel1.setLayout(TMSPanel1Layout);
        TMSPanel1Layout.setHorizontalGroup(
                TMSPanel1Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                        .add(TMSPanel1Layout.createSequentialGroup()
                                .add(45, 45, 45)
                                .add(TMSPanel1Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                                        .add(TMSPanel1Layout.createSequentialGroup()
                                                .add(TMSPanel1Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                                                        .add(passLabel)
                                                        .add(userNameLabel))
                                                .add(18, 18, 18)
                                                .add(TMSPanel1Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                                                        .add(password, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, 157, Short.MAX_VALUE)
                                                        .add(org.jdesktop.layout.GroupLayout.TRAILING, userName, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, 157, Short.MAX_VALUE)
                                                ))
                                )
                                .addContainerGap())
        );
        TMSPanel1Layout.setVerticalGroup(
                TMSPanel1Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                        .add(TMSPanel1Layout.createSequentialGroup()
                                .add(TMSPanel1Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.BASELINE)
                                        .add(userName, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                                        .add(userNameLabel))
                                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                                .add(TMSPanel1Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.BASELINE)
                                        .add(password, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                                        .add(passLabel))
                                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED))
        );*/
        javax.swing.GroupLayout TMSPanel1Layout = new javax.swing.GroupLayout(TMSPanel1);
        TMSPanel1.setLayout(TMSPanel1Layout);
        TMSPanel1Layout.setHorizontalGroup(
                TMSPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(TMSPanel1Layout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(TMSPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(TMSPanel1Layout.createSequentialGroup()
                                                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addGroup(TMSPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                                        .addComponent(remove, javax.swing.GroupLayout.DEFAULT_SIZE, 57, Short.MAX_VALUE)
                                                        .addComponent(add, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGroup(TMSPanel1Layout.createSequentialGroup()
                                                .addComponent(userNameLabel)
                                                .addGap(82, 82, 82)
                                                .addComponent(userName))
                                        .addGroup(TMSPanel1Layout.createSequentialGroup()
                                                .addComponent(passLabel)
                                                .addGap(27, 27, 27)
                                                .addComponent(password)))
                                .addContainerGap(81, Short.MAX_VALUE)));
        TMSPanel1Layout.setVerticalGroup(
                TMSPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, TMSPanel1Layout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(TMSPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(userNameLabel)
                                        .addComponent(userName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(16, 16, 16)
                                .addGroup(TMSPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(passLabel)
                                        .addComponent(password, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(6, 6, 6)
                                .addGroup(TMSPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGroup(TMSPanel1Layout.createSequentialGroup()
                                                .addGap(44, 44, 44)
                                                .addComponent(add)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(remove)))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 18, Short.MAX_VALUE))
        );

        org.jdesktop.layout.GroupLayout TMSPanel2Layout = new org.jdesktop.layout.GroupLayout(personPanel);
        personPanel.setLayout(TMSPanel2Layout);
        TMSPanel2Layout.setHorizontalGroup(
                TMSPanel2Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                        .add(TMSPanel2Layout.createSequentialGroup()
                                .add(45, 45, 45)
                                .add(TMSPanel2Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                                        .add(TMSPanel2Layout.createSequentialGroup()
                                                .add(nationalCodeLabel)
                                                .add(18, 18, 18)
                                                .add(nationalCode, 0, 155, Short.MAX_VALUE))
                                        .add(TMSPanel2Layout.createSequentialGroup()
                                                .add(TMSPanel2Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                                                        .add(nameLabel)
                                                        .add(lastNameLabel))
                                                .add(18, 18, 18)
                                                .add(TMSPanel2Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                                                        .add(lastName, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, 157, Short.MAX_VALUE)
                                                        .add(org.jdesktop.layout.GroupLayout.TRAILING, name, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, 157, Short.MAX_VALUE)
                                                )))
                                .addContainerGap())
        );
        TMSPanel2Layout.setVerticalGroup(
                TMSPanel2Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                        .add(TMSPanel2Layout.createSequentialGroup()
                                .add(TMSPanel2Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.BASELINE)
                                        .add(name, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                                        .add(nameLabel))
                                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                                .add(TMSPanel2Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.BASELINE)
                                        .add(lastName, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                                        .add(lastNameLabel))
                                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)

                                .add(TMSPanel2Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.BASELINE)
                                        .add(nationalCodeLabel)
                                        .add(nationalCode, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)))
        );


        cancelButton.setText(ThreadPoolManager.getLangValue("TMS_CANCEL"));
        cancelButton.setVisible(ThreadPoolManager.hasPermission("CANCLE_PC"));
        cancelButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent actionEvent) {
                cancel();
            }
        });

        okButton.setText(ThreadPoolManager.getLangValue("TMS_OK"));
        okButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                if (!editable) {
                    saveUser();
                } else {
                    updateUser();
                }
            }
        });

        assignPC.setText(ThreadPoolManager.getLangValue("TMS_ASSIGN_PC"));
        assignPC.setVisible(ThreadPoolManager.hasPermission("ASSIGN_PC"));
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

        assignPerson.setText(ThreadPoolManager.getLangValue("TMS_ASSIGN_PERSON"));
        assignPerson.setVisible(ThreadPoolManager.hasPermission("ASSIGN_PERSON"));
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

        org.jdesktop.layout.GroupLayout TMSPanel1Layout1 = new org.jdesktop.layout.GroupLayout(mainPanel);
        mainPanel.setLayout(TMSPanel1Layout1);
        TMSPanel1Layout1.setHorizontalGroup(
                TMSPanel1Layout1.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                        .add(TMSPanel1Layout1.createSequentialGroup()
                                .add(36, 36, 36)
                                .add(TMSPanel1Layout1.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                                        .add(tableScroll, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
                                .addContainerGap(45, Short.MAX_VALUE))
        );
        TMSPanel1Layout1.setVerticalGroup(
                TMSPanel1Layout1.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                        .add(TMSPanel1Layout1.createSequentialGroup()
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
                                .add(TMSPanel1, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
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
                                .add(TMSPanel1, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
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

        TMSPanel1.getAccessibleContext().setAccessibleName("UserForm");


        // pack();
    }

    public void saveUser() {
        User newUser = new User();
        WebServiceInfo serviceInfo = new WebServiceInfo();
        newUser.setUsername(userName.getText());
        newUser.setPassword(password.getText());
        newUser.setDeleted("0");
        newUser.setEnable("1");
        newUser.setEffectorUser(ThreadPoolManager.me.getUsername());
        serviceInfo.setServiceName("/findWorkGroupByName");
        try {
            Set<WorkGroup> workGroupSet = new HashSet<>(selectedWorkGroupList);
            newUser.setWorkGroups(workGroupSet);

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
            Set<WorkGroup> workGroupSet = new HashSet<>(selectedWorkGroupList);
            user.setWorkGroups(workGroupSet);
            serviceInfo.setServiceName("/editUser");
            new RESTfulClientUtil().restFullService(serviceInfo.getServerUrl(), serviceInfo.getServiceName(), new ObjectMapper().writeValueAsString(user));
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    private void assignPCToUser(java.awt.event.ActionEvent evt) throws PropertyVetoException {//GEN-FIRST:event_jButton1ActionPerformed
        PCManagement pcManagement = new PCManagement(this, user, jdpDesktop);
        pcManagement.setVisible(true);
        jdpDesktop.add(pcManagement);
        pcManagement.setSelected(true);
    }

    private void assignPersonToUser(java.awt.event.ActionEvent evt) throws PropertyVetoException {//GEN-FIRST:event_jButton1ActionPerformed
        PersonList personListForm = new PersonList(this, user, jdpDesktop);
        personListForm.setVisible(true);
        jdpDesktop.add(personListForm);
        personListForm.setSelected(true);
    }

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
        if (user != null && user.getPerson() != null) {
            name.setText(user.getPerson().getName());
            lastName.setText(user.getPerson().getLastName());
            nationalCode.setText(user.getPerson().getNationalCode());
        }
        getAll();
        showData();
    }

    private void showData() {
        JTableBinding jTableBinding = org.jdesktop.swingbinding.SwingBindings.createJTableBinding(org.jdesktop.beansbinding.AutoBinding.UpdateStrategy.READ_WRITE, pcList, mainTable, "");
        JTableBinding.ColumnBinding columnBinding = jTableBinding.addColumnBinding(org.jdesktop.beansbinding.ELProperty.create("${name}"));
        columnBinding.setColumnName(ThreadPoolManager.getLangValue("TMS_NAME"));
        columnBinding.setColumnClass(String.class);
        columnBinding = jTableBinding.addColumnBinding(org.jdesktop.beansbinding.ELProperty.create("${ip}"));
        columnBinding.setColumnName(ThreadPoolManager.getLangValue("TMS_IP"));
        columnBinding.setColumnClass(String.class);
        columnBinding = jTableBinding.addColumnBinding(org.jdesktop.beansbinding.ELProperty.create("${location}"));
        columnBinding.setColumnName(ThreadPoolManager.getLangValue("TMS_LOCATION"));
        columnBinding.setColumnClass(String.class);
        BindingGroup bindingGroup = new BindingGroup();
        bindingGroup.addBinding(jTableBinding);
        jTableBinding.bind();
    }


    private void addActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addActionPerformed
        List<String> selectedValuesList = allList.getSelectedValuesList();
        for (String selectedVal : selectedValuesList) {
            WorkGroup workGroup = workGroupHashtable.get(selectedVal);
            if (!selectedValuesList.contains(workGroup)) {
                selectedWorkGroupList.add(workGroup);
                allWorkGroupList.remove(workGroup);
            }
        }
        refreshAllList();
        refreshSelectedList();
    }//GEN-LAST:event_addActionPerformed

    private void removeActionPerformed(java.awt.event.ActionEvent evt) {
        List<String> selectedValuesList = assignList.getSelectedValuesList();
        for (String selectedVal : selectedValuesList) {
            WorkGroup workGroup = workGroupHashtable.get(selectedVal);
            if (!selectedValuesList.contains(workGroup)) {
                selectedWorkGroupList.remove(workGroup);
                allWorkGroupList.add(workGroup);
            }
        }
        refreshAllList();
        refreshSelectedList();
    }

    private void refreshSelectedList() {
        DefaultListModel<String> workGroupListModel = new DefaultListModel<>();
        for (WorkGroup workGroup : selectedWorkGroupList) {
            workGroupListModel.addElement(workGroup.getDescription());
            workGroupHashtable.put(workGroup.getDescription(), workGroup);
        }
        assignList.setModel(workGroupListModel);

    }

    private void refreshAllList() {
        DefaultListModel<String> workGroupListModel = new DefaultListModel<>();
        for (WorkGroup workGroup : allWorkGroupList) {
            workGroupListModel.addElement(workGroup.getDescription());
            workGroupHashtable.put(workGroup.getDescription(), workGroup);
        }
        allList.setModel(workGroupListModel);
    }


    private ButtonGroup buttonGroup1;
    private JButton cancelButton;
    private TMSPanel mainPanel;
    private JButton okButton;
    private JButton assignPC;
    private JButton assignPerson;
    private JLabel userNameLabel;
    private JLabel passLabel;
    private JLabel nameLabel;
    private JLabel lastNameLabel;
    private JLabel nationalCodeLabel;
    private TMSPanel TMSPanel1;
    private TMSPanel personPanel;
    private JTextField userName;
    private JTextField password;
    private JTextField name;
    private JTextField lastName;
    private JTextField nationalCode;
    private JDesktopPane jdpDesktop;
    private JList allList;
    private JList assignList;
    private User user;
    private JScrollPane tableScroll;
    private JTable mainTable;
    private List<WorkGroup> allWorkGroupList = new ArrayList<>();
    private List<WorkGroup> selectedWorkGroupList = new ArrayList<>();
    List<PC> pcList = new ArrayList<>();
    private Hashtable<String, WorkGroup> workGroupHashtable = new Hashtable<>();
    private JButton add;
    private JButton remove;

    private JScrollPane jScrollPane1;
    private JScrollPane jScrollPane2;

    private DefaultListModel<String> workGroupListModel = new DefaultListModel<>();
    private DefaultListModel<String> selectedWorkGroupListModel = new DefaultListModel<>();

    public JTable getMainTable() {
        return mainTable;
    }

}
