package ir.university.toosi.tms.view.workgroup;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import ir.university.toosi.tms.model.entity.WebServiceInfo;
import ir.university.toosi.tms.model.entity.WorkGroup;
import ir.university.toosi.tms.model.entity.WorkGroupSearchItems;
import ir.university.toosi.tms.util.RESTfulClientUtil;
import ir.university.toosi.tms.util.ThreadPoolManager;
import ir.university.toosi.tms.view.TMSInternalFrame;
import ir.university.toosi.tms.view.TMSPanel;
import org.jdesktop.beansbinding.AutoBinding;
import org.jdesktop.beansbinding.BindingGroup;
import org.jdesktop.beansbinding.ELProperty;
import org.jdesktop.swingbinding.JTableBinding;
import org.jdesktop.swingbinding.SwingBindings;

import javax.swing.*;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import java.beans.PropertyVetoException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class WorkGroupManagement extends TMSInternalFrame {

    /**
     * Creates new form ContactEditor
     */
    public WorkGroupManagement() {
//        fillSearchCombo();
        mainPanel = new TMSPanel();
        tableScroll = new JScrollPane();
        mainTable = new JTable();
        add = new JButton();
        edit = new JButton();
//        searchPanel = new TMSPanel();
//        searchCombo = new JComboBox(searchItems);
//        searchText = new JTextField();
//        filter = new JLabel();
//        by = new JLabel();
        try {
            initComponents();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public WorkGroupManagement(JDesktopPane jDesktopPane) {
//        fillSearchCombo();
        jdpDesktop = jDesktopPane;
        mainPanel = new TMSPanel();
        tableScroll = new JScrollPane();
        mainTable = new JTable();
        add = new JButton();
        edit = new JButton();
//        searchPanel = new TMSPanel();
//        searchCombo = new JComboBox(searchItems);
//        searchText = new JTextField();
//        filter = new JLabel();
//        by = new JLabel();
        try {
            initComponents();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

//    private void fillSearchCombo() {
//        searchItems = new String[WorkGroupSearchItems.values().length];
//        int i = 0;
//        for (WorkGroupSearchItems workGroupSearchItem : WorkGroupSearchItems.values()) {
//            searchItems[i++] = workGroupSearchItem.getDescription();
//        }
//    }

    public void initComponents() throws IOException {


        //this.addInternalFrameListener(ThreadPoolManager.mainForm);
        setClosable(true);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setTitle(ThreadPoolManager.getLangValue("TMS_WORKGROUP_MANAGEMENT"));

        mainPanel.setBorder(BorderFactory.createTitledBorder(ThreadPoolManager.getLangValue("TMS_WORKGROUP_MANAGEMENT")));

        mainTable.setAutoCreateRowSorter(true);
        refresh();


        mainTable.setRowSelectionAllowed(true);
        tableScroll.setViewportView(mainTable);
        mainTable.getColumnModel().getSelectionModel().setSelectionMode(ListSelectionModel.MULTIPLE_INTERVAL_SELECTION);


        add.setText(ThreadPoolManager.getLangValue("TMS_ADD"));
        add.setVisible(ThreadPoolManager.hasPermission("ADD_WORKGROUP"));
        add.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                try {
                    addActionPerformed(evt);
                } catch (PropertyVetoException e) {
                    e.printStackTrace();
                }
            }
        });

        edit.setText(ThreadPoolManager.getLangValue("TMS_EDIT"));
        edit.setVisible(ThreadPoolManager.hasPermission("EDIT_WORKGROUP"));
        edit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                try {
                    editActionPerformed(evt);
                } catch (PropertyVetoException e) {
                    e.printStackTrace();
                }
            }
        });

        org.jdesktop.layout.GroupLayout TMSPanel1Layout = new org.jdesktop.layout.GroupLayout(mainPanel);
        mainPanel.setLayout(TMSPanel1Layout);
        TMSPanel1Layout.setHorizontalGroup(
                TMSPanel1Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                        .add(TMSPanel1Layout.createSequentialGroup()
                                .add(36, 36, 36)
                                .add(TMSPanel1Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                                        .add(TMSPanel1Layout.createSequentialGroup()
                                                .add(add)
                                                .addPreferredGap(org.jdesktop.layout.LayoutStyle.UNRELATED)
                                                .add(18, 18, 18)
                                                .add(edit))
                                        .add(tableScroll, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
                                .addContainerGap(45, Short.MAX_VALUE))
        );
        TMSPanel1Layout.setVerticalGroup(
                TMSPanel1Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                        .add(TMSPanel1Layout.createSequentialGroup()
                                .addContainerGap()
                                .add(TMSPanel1Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.BASELINE)
                                        .add(add)
                                        .add(edit))
                                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .add(tableScroll, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 136, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                                .add(133, 133, 133))
        );

/*
        searchPanel.setBorder(BorderFactory.createTitledBorder(ThreadPoolManager.getLangValue("TMS_SEARCH_WORKGROUP")));
//        searchCombo.setModel(new DefaultComboBoxModel(new String[]{"Item 1", "Item 2", "Item 3", "Item 4"}));

        searchText.setToolTipText("");
        searchText.getDocument().addDocumentListener(new DocumentListener() {
            @Override
            public void insertUpdate(DocumentEvent e) {
                //To change body of implemented methods use File | Settings | File Templates.
            }

            @Override
            public void removeUpdate(DocumentEvent e) {
                //To change body of implemented methods use File | Settings | File Templates.
            }

            @Override
            public void changedUpdate(DocumentEvent e) {
            }
        });

        filter.setText(ThreadPoolManager.getLangValue("TMS_FILTER"));

        by.setText(ThreadPoolManager.getLangValue("TMS_BY"));

        org.jdesktop.layout.GroupLayout TMSPanel2Layout = new org.jdesktop.layout.GroupLayout(searchPanel);
        searchPanel.setLayout(TMSPanel2Layout);
        TMSPanel2Layout.setHorizontalGroup(
                TMSPanel2Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                        .add(TMSPanel2Layout.createSequentialGroup()
                                .addContainerGap()
                                .add(filter)
                                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                                .add(searchText, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 122, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                                .add(18, 18, 18)
                                .add(by)
                                .add(18, 18, 18)
                                .add(searchCombo, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                                .addContainerGap(194, Short.MAX_VALUE))
        );
        TMSPanel2Layout.setVerticalGroup(
                TMSPanel2Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                        .add(TMSPanel2Layout.createSequentialGroup()
                                .addContainerGap()
                                .add(TMSPanel2Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.BASELINE)
                                        .add(filter)
                                        .add(searchText, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                                        .add(searchCombo, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                                        .add(by))
                                .addContainerGap(org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

*/
        org.jdesktop.layout.GroupLayout layout = new org.jdesktop.layout.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                        .add(layout.createSequentialGroup()
                                .addContainerGap()
//                                .add(searchPanel, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
//                                .addContainerGap(org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        )
                        .add(org.jdesktop.layout.GroupLayout.TRAILING, layout.createSequentialGroup()
                                .addContainerGap(org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .add(mainPanel, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                                .addContainerGap())
        );
        layout.setVerticalGroup(
                layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                        .add(org.jdesktop.layout.GroupLayout.TRAILING, layout.createSequentialGroup()
                                .addContainerGap()
//                                .add(searchPanel, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
//                                .addPreferredGap(org.jdesktop.layout.LayoutStyle.UNRELATED)
                                .add(mainPanel, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 221, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                                .addContainerGap(org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        mainPanel.getAccessibleContext().setAccessibleName("WORKGROUPFORM");

        pack();
    }// </editor-fold>//GEN-END:initComponents

    public void refresh() throws IOException {
        workGroupService.setServiceName("/getAllWorkGroup");
        workGroupList = new ObjectMapper().readValue(new RESTfulClientUtil().restFullService(workGroupService.getServerUrl(), workGroupService.getServiceName()), new TypeReference<List<WorkGroup>>() {
        });

        JTableBinding jTableBinding = SwingBindings.createJTableBinding(AutoBinding.UpdateStrategy.READ_WRITE, workGroupList, mainTable, "");
//        columnBinding = jTableBinding.addColumnBinding(ELProperty.create("${name}"));
//        columnBinding.setColumnName(ThreadPoolManager.getLangValue("TMS_NAME"));
//        columnBinding.setColumnClass(String.class);
        JTableBinding.ColumnBinding columnBinding = jTableBinding.addColumnBinding(org.jdesktop.beansbinding.ELProperty.create("${descShow}"));
        columnBinding.setColumnName(ThreadPoolManager.getLangValue("TMS_DESC"));
        columnBinding.setColumnClass(String.class);
        BindingGroup bindingGroup = new BindingGroup();
        bindingGroup.addBinding(jTableBinding);
        jTableBinding.bind();
    }

    private void deleteActionPerformed(java.awt.event.ActionEvent evt) {
/*
        int[] indexes = new int[mainTable.getSelectedRows().length];
        int j = 0;
        for (int i : mainTable.getSelectedRows()) {
            indexes[j++] = mainTable.convertRowIndexToModel(i);
        }

        List<WorkGroup> deleteWorkGroups = new ArrayList<>();
        for (int index : indexes) {
            deleteWorkGroups.add(workGroupList.get(index));
        }

        roleService.setServiceName("/deleteRoleList");
        try {
            new ObjectMapper().readValue(new RESTfulClientUtil().restFullService(roleService.getServerUrl(), roleService.getServiceName(), new ObjectMapper().writeValueAsString(deletedRoles)), Boolean.class);
            refresh();
        } catch (IOException e) {
            e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
        }*/
    }

    private void addActionPerformed(java.awt.event.ActionEvent evt) throws PropertyVetoException {//GEN-FIRST:event_jButton1ActionPerformed
        WorkGroupForm workGroupForm = new WorkGroupForm(this);
        workGroupForm.setVisible(true);
        jdpDesktop.add(workGroupForm);
        workGroupForm.setSelected(true);
    }//GEN-LAST:event_jButton1ActionPerformed


    private void editActionPerformed(java.awt.event.ActionEvent evt) throws PropertyVetoException {//GEN-FIRST:event_jButton1ActionPerformed
        WorkGroup workGroup = workGroupList.get(mainTable.convertRowIndexToModel(mainTable.getSelectedRow()));
        WorkGroupForm workGroupForm = new WorkGroupForm(this,workGroup);
        workGroupForm.setVisible(true);
        jdpDesktop.add(workGroupForm);
        workGroupForm.setSelected(true);
    }//GEN-LAST:event_jButton1ActionPerformed

    /**
     * @param args the command line arguments
     */

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private JButton add;
//    private JButton delete;
    private JButton edit;
//    private JComboBox searchCombo;
//    private JLabel by;
//    private JLabel filter;
    private TMSPanel mainPanel;
//    private TMSPanel searchPanel;
    private JScrollPane tableScroll;
    private JTable mainTable;
    private JDesktopPane jdpDesktop;
//    private JTextField searchText;
    private WebServiceInfo workGroupService = new WebServiceInfo();
    private List<WorkGroup> workGroupList = new ArrayList<>();
//    private String[] searchItems;

    public JTable getMainTable() {
        return mainTable;
    }
    // End of variables declaration//GEN-END:variables
}
