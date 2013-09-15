package ir.university.toosi.tms.view.workgroup;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import ir.university.toosi.tms.model.entity.*;
import ir.university.toosi.tms.util.RESTfulClientUtil;
import ir.university.toosi.tms.util.ThreadPoolManager;
import ir.university.toosi.tms.view.TMSInternalFrame;
import ir.university.toosi.tms.view.TMSPanel;

import javax.swing.*;
import java.io.IOException;
import java.util.*;

/**
 * @author root
 */
public class WorkGroupForm extends TMSInternalFrame {

    /**
     * Creates new form WorkGroupForm
     */
    private WorkGroupManagement workGroupManagement;
    private WorkGroup workGroup;
    private Hashtable<String, Role> roles = new Hashtable<>();
    private boolean editable = false;
    private DefaultListModel<String> roleListModel = new DefaultListModel<>();

    public WorkGroupForm(WorkGroupManagement workGroupManagement) {
        roles = new Hashtable<>();
        try {
            this.workGroupManagement = workGroupManagement;
            workGroupService.setServiceName("/getAllRole");
            allRoleList = new ObjectMapper().readValue(new RESTfulClientUtil().restFullService(workGroupService.getServerUrl(), workGroupService.getServiceName()), new TypeReference<List<Role>>() {
            });

            for (Role role : allRoleList) {
                roleListModel.addElement(role.getDescShow());
                roles.put(role.getDescription(), role);
            }

            initComponents();
        } catch (IOException e) {
            e.printStackTrace();
        }
        refreshSelectedList();
        refreshAllList();
    }

    public WorkGroupForm(WorkGroupManagement workGroupManagement, WorkGroup workGroup) {
        roles = new Hashtable<>();
        try {
            initComponents();
        } catch (IOException e) {
            e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
        }

        this.workGroupManagement = workGroupManagement;
        this.workGroup = workGroup;
//        nameText.setText(workGroup.getName());
        descriptionText.setText(ThreadPoolManager.getLangValue(workGroup.getDescription()));
        selectedRoleList = new ArrayList<>(workGroup.getRoles());
        workGroupService.setServiceName("/getAllRole");

        try {
            allRoleList = new ObjectMapper().readValue(new RESTfulClientUtil().restFullService(workGroupService.getServerUrl(), workGroupService.getServiceName()), new TypeReference<List<Role>>() {
            });
        } catch (IOException e) {
            e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
        }
        for (Role role : allRoleList) {
            roleListModel.addElement(role.getDescShow());
            roles.put(role.getDescription(), role);
        }

        List<Role> allRoles = new ArrayList<>(allRoleList);
        for (Role allRole : allRoles) {
            for (Role role : selectedRoleList) {
                if (role.getDescription() != null && role.getDescription().equalsIgnoreCase(allRole.getDescription())) {
                    allRoleList.remove(allRole);
                }
            }

        }

        editable = true;

        refreshSelectedList();
        refreshAllList();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() throws IOException {


        setClosable(true);
        this.addInternalFrameListener(ThreadPoolManager.mainForm);
        TMSPanel1 = new TMSPanel();
//        nameLable = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
//        nameText = new javax.swing.JTextField();
        descriptionText = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        allList = new javax.swing.JList();
        jScrollPane2 = new javax.swing.JScrollPane();
        assignList = new javax.swing.JList();
        add = new javax.swing.JButton();
        remove = new javax.swing.JButton();
        okButton = new javax.swing.JButton();
        cancelButton = new javax.swing.JButton();
        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle(ThreadPoolManager.getLangValue("TMS_WORKGROUP"));

        allList.setModel(roleListModel);
        TMSPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(ThreadPoolManager.getLangValue("TMS_WORKGROUP")));
        TMSPanel1.setName(ThreadPoolManager.getLangValue("TMS_WORKGROUP")); // NOI18N

//        nameLable.setText(ThreadPoolManager.getLangValue("TMS_NAME"));

        jLabel2.setText(ThreadPoolManager.getLangValue("TMS_DESC"));


        jScrollPane1.setViewportView(allList);


        jScrollPane2.setViewportView(assignList);

        add.setText(">");
        add.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addActionPerformed(evt);
            }
        });

        remove.setText("<");
        remove.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                removeActionPerformed(evt);
            }
        });
        okButton.setText(ThreadPoolManager.getLangValue("TMS_OK"));
        okButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                okButtonActionPerformed(evt);
            }
        });

        cancelButton.setText(ThreadPoolManager.getLangValue("TMS_CANCEL"));
        cancelButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cancelButtonActionPerformed(evt);
            }
        });


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
//                                        .addGroup(TMSPanel1Layout.createSequentialGroup()
//                                                .addComponent(nameLable)
//                                                .addGap(82, 82, 82)
//                                                .addComponent(nameText))
                                        .addGroup(TMSPanel1Layout.createSequentialGroup()
                                                .addComponent(jLabel2)
                                                .addGap(27, 27, 27)
                                                .addComponent(descriptionText)))
                                .addContainerGap(81, Short.MAX_VALUE))
                        .addGroup(TMSPanel1Layout.createSequentialGroup()
                                .addGap(85, 85, 85)
                                .addComponent(okButton, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(cancelButton)
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        TMSPanel1Layout.setVerticalGroup(
                TMSPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, TMSPanel1Layout.createSequentialGroup()
                                .addContainerGap()
//                                .addGroup(TMSPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
//                                        .addComponent(nameLable)
//                                        .addComponent(nameText, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
//                                .addGap(16, 16, 16)
                                .addGroup(TMSPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(jLabel2)
                                        .addComponent(descriptionText, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(6, 6, 6)
                                .addGroup(TMSPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGroup(TMSPanel1Layout.createSequentialGroup()
                                                .addGap(44, 44, 44)
                                                .addComponent(add)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(remove)))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 18, Short.MAX_VALUE)
                                .addGroup(TMSPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(cancelButton)
                                        .addComponent(okButton)))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addGap(23, 23, 23)
                                .addComponent(TMSPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(TMSPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        TMSPanel1.getAccessibleContext().setAccessibleName("WORKGROUP");

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void addActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addActionPerformed
        List<String> selectedRoles = allList.getSelectedValuesList();
        for (String selectedRole : selectedRoles) {
            Role role = roles.get(selectedRole);
            if (!selectedRoleList.contains(role)) {
                selectedRoleList.add(role);
                allRoleList.remove(role);
            }
        }
        refreshAllList();
        refreshSelectedList();
    }//GEN-LAST:event_addActionPerformed

    private void removeActionPerformed(java.awt.event.ActionEvent evt) {
        List<String> selectedRoles = assignList.getSelectedValuesList();
        for (String selectedRole : selectedRoles) {
            Role role = roles.get(selectedRole);
            if (!selectedRoleList.contains(role)) {
                selectedRoleList.remove(role);
                allRoleList.add(role);
            }
        }
        refreshAllList();
        refreshSelectedList();
    }//GEN-LAST:event_removeActionPerformed

    private void okButtonActionPerformed(java.awt.event.ActionEvent evt) {
        Set<Role> roleSet = new HashSet<>(selectedRoleList);
        try {
            if (!editable) {
                if(descriptionText.getText() == null || roleSet.size() == 0 )
                    JOptionPane.showInternalMessageDialog(this, ThreadPoolManager.getLangValue("FILL_MANDATORY"));
                WorkGroup newWorkGroup = new WorkGroup();
                newWorkGroup.setDeleted("0");
//                newWorkGroup.setName(nameText.getText());
                newWorkGroup.setDescText(descriptionText.getText());
                newWorkGroup.setCurrentLang(ThreadPoolManager.currentLanguage);
                newWorkGroup.setRoles(roleSet);
                workGroupService.setServiceName("/createWorkGroup");
                newWorkGroup = new ObjectMapper().readValue(new RESTfulClientUtil().restFullService(workGroupService.getServerUrl(), workGroupService.getServiceName(), new ObjectMapper().writeValueAsString(newWorkGroup)), WorkGroup.class);
                LanguageManagement languageManagement = new LanguageManagement();
                languageManagement.setTitle(descriptionText.getText());
                languageManagement.setType(ThreadPoolManager.currentLanguage);
                ThreadPoolManager.langHash.put(newWorkGroup.getDescription(), languageManagement);
               /* if (newWorkGroup != null)
                    workGroupService.setServiceName("/createLanguageManagement");
                LanguageManagement languageManagement = new LanguageManagement();
                languageManagement.setTitle(newWorkGroup.getDescription());
                languageManagement.setType(ThreadPoolManager.currentLanguage);
                try {
                    languageManagement = new ObjectMapper().readValue(new RESTfulClientUtil().restFullService(workGroupService.getServerUrl(), workGroupService.getServiceName(), new ObjectMapper().writeValueAsString(languageManagement)), LanguageManagement.class);

                    workGroupService.setServiceName("/createLanguageKeyManagement");
                    LanguageKeyManagement languageKeyManagement = new LanguageKeyManagement();
                    languageKeyManagement.setDescriptionKey(newWorkGroup.getName());
                    Set list = new HashSet();
                    list.add(languageManagement);
                    languageKeyManagement.setLanguageManagements(list);

                    languageKeyManagement = new ObjectMapper().readValue(new RESTfulClientUtil().restFullService(workGroupService.getServerUrl(), workGroupService.getServiceName(), new ObjectMapper().writeValueAsString(languageKeyManagement)), LanguageKeyManagement.class);
                } catch (IOException e) {
                    e.printStackTrace();
                }*/
                this.dispose();
            } else {
//                workGroup.setName(nameText.getText());
                workGroup.setDescText(descriptionText.getText());
                workGroup.setRoles(roleSet);
                workGroup.setCurrentLang(ThreadPoolManager.currentLanguage);
                workGroupService.setServiceName("/editWorkGroup");
                workGroup = new ObjectMapper().readValue(new RESTfulClientUtil().restFullService(workGroupService.getServerUrl(), workGroupService.getServiceName(), new ObjectMapper().writeValueAsString(workGroup)), WorkGroup.class);
                LanguageManagement languageManagement = new LanguageManagement();
                languageManagement.setTitle(descriptionText.getText());
                languageManagement.setType(ThreadPoolManager.currentLanguage);
                ThreadPoolManager.langHash.put(workGroup.getDescription(), languageManagement);
                this.dispose();
            }
            workGroupManagement.refresh();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void cancelButtonActionPerformed(java.awt.event.ActionEvent evt) {
        this.dispose();

    }

    private void refreshSelectedList() {
        DefaultListModel<String> roleListModel = new DefaultListModel<>();
        for (Role role : selectedRoleList) {
            roleListModel.addElement(role.getDescShow());
            roles.put(role.getDescription(), role);
        }
        assignList.setModel(roleListModel);

    }

    private void refreshAllList() {
        DefaultListModel<String> roleListModel = new DefaultListModel<>();
        for (Role role : allRoleList) {
            roleListModel.addElement(role.getDescShow());
            roles.put(role.getDescription(), role);
        }
        allList.setModel(roleListModel);
    }


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private WebServiceInfo workGroupService = new WebServiceInfo();
    private List<Role> allRoleList = new ArrayList<>();
    private List<Role> selectedRoleList = new ArrayList<>();
    private javax.swing.JButton add;
    private javax.swing.JList allList;
    private javax.swing.JList assignList;
    private javax.swing.JTextField descriptionText;
    private javax.swing.JLabel jLabel2;
    private TMSPanel TMSPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
//    private javax.swing.JLabel nameLable;
//    private javax.swing.JTextField nameText;
    private javax.swing.JButton remove;
    private javax.swing.JButton okButton;
    private javax.swing.JButton cancelButton;
    // End of variables declaration//GEN-END:variables
}
