package ir.university.toosi.tms.view.user;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import ir.university.toosi.tms.model.entity.PC;
import ir.university.toosi.tms.model.entity.PCSearchItems;
import ir.university.toosi.tms.model.entity.User;
import ir.university.toosi.tms.model.entity.WebServiceInfo;
import ir.university.toosi.tms.util.RESTfulClientUtil;
import ir.university.toosi.tms.util.ThreadPoolManager;
import org.jdesktop.beansbinding.BindingGroup;
import org.jdesktop.swingbinding.JTableBinding;

import javax.swing.*;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import java.beans.PropertyVetoException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class PCManagement extends JInternalFrame {

    /**
     * Creates new form ContactEditor
     */
    public PCManagement() {
        fillSearchCombo();
        mainPanel = new JPanel();
        tableScroll = new JScrollPane();
        mainTable = new JTable();
        add = new JButton();
        delete = new JButton();
        edit = new JButton();
        assign = new JButton();
        searchPanel = new JPanel();
        searchCombo = new JComboBox(searchItems);
        searchText = new JTextField();
        filter = new JLabel();
        by = new JLabel();
        try {
            initComponents();
        } catch (IOException e) {
            e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
        }
    }

    public PCManagement(UserForm userForm, User user, JDesktopPane jdpDesktop) {
        fillSearchCombo();
        this.userForm = userForm;
        mainPanel = new JPanel();
        tableScroll = new JScrollPane();
        mainTable = new JTable();
        add = new JButton();
        delete = new JButton();
        edit = new JButton();
        assign = new JButton();
        searchPanel = new JPanel();
        searchCombo = new JComboBox(searchItems);
        searchText = new JTextField();
        filter = new JLabel();
        by = new JLabel();
        this.user = user;
        this.jdpDesktop = jdpDesktop;
        try {
            initComponents();
        } catch (IOException e) {
            e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
        }
    }

    private void fillSearchCombo() {
        searchItems = new String[PCSearchItems.values().length];
        int i = 0;
        for (PCSearchItems pcSearchItems : PCSearchItems.values()) {
            searchItems[i++] = pcSearchItems.getDescription();
        }
    }

    /**
     * This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    public void initComponents() throws IOException {


        this.addInternalFrameListener(ThreadPoolManager.mainForm);
        setClosable(true);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setTitle(ThreadPoolManager.getLangValue("TMS_PC_MANAGEMENT"));

        mainPanel.setBorder(BorderFactory.createTitledBorder(ThreadPoolManager.getLangValue("TMS_PC_MANAGEMENT")));

        mainTable.setAutoCreateRowSorter(true);
        refresh();


        mainTable.setColumnSelectionAllowed(true);
        tableScroll.setViewportView(mainTable);
        mainTable.getColumnModel().getSelectionModel().setSelectionMode(ListSelectionModel.MULTIPLE_INTERVAL_SELECTION);


        add.setText(ThreadPoolManager.getLangValue("TMS_ADD"));
        add.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                try {
                    addActionPerformed(evt);
                } catch (PropertyVetoException e) {
                    e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
                }
            }
        });

        delete.setText(ThreadPoolManager.getLangValue("TMS_DELETE"));
        delete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                int result = JOptionPane.showConfirmDialog(null, "DELETE_PC", "DELETE", JOptionPane.OK_CANCEL_OPTION);
                if (result == JOptionPane.OK_OPTION) {
                    deleteActionPerformed(evt);
                }
            }
        });

        edit.setText(ThreadPoolManager.getLangValue("TMS_EDIT"));
        edit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                try {
                    editActionPerformed(evt);
                } catch (PropertyVetoException e) {
                    e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
                }
            }
        });

        assign.setText(ThreadPoolManager.getLangValue("TMS_ASSIGN"));
        assign.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                int result = JOptionPane.showConfirmDialog(null, "ASSIGN_PC", "ASSIGN", JOptionPane.OK_CANCEL_OPTION);
                if (result == JOptionPane.OK_OPTION) {
                    assignPCActionPerformed(evt);
                }
            }
        });


        org.jdesktop.layout.GroupLayout jPanel1Layout = new org.jdesktop.layout.GroupLayout(mainPanel);
        mainPanel.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
                jPanel1Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                        .add(jPanel1Layout.createSequentialGroup()
                                .add(36, 36, 36)
                                .add(jPanel1Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                                        .add(jPanel1Layout.createSequentialGroup()
                                                .add(add)
                                                .addPreferredGap(org.jdesktop.layout.LayoutStyle.UNRELATED)
                                                .add(delete)
                                                .add(18, 18, 18)
                                                .add(edit)
                                                .add(18, 18, 18)
                                                .add(assign))
                                        .add(tableScroll, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
                                .addContainerGap(45, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
                jPanel1Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                        .add(jPanel1Layout.createSequentialGroup()
                                .addContainerGap()
                                .add(jPanel1Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.BASELINE)
                                        .add(add)
                                        .add(delete)
                                        .add(edit)
                                        .add(assign))
                                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .add(tableScroll, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 136, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                                .add(133, 133, 133))
        );

        searchPanel.setBorder(BorderFactory.createTitledBorder(ThreadPoolManager.getLangValue("TMS_SEARCH_PC")));
//        searchCombo.setModel(new DefaultComboBoxModel(new String[]{"Item 1", "Item 2", "Item 3", "Item 4"}));

        searchText.setToolTipText("");
        searchText.getDocument().addDocumentListener(new DocumentListener() {
            @Override
            public void insertUpdate(DocumentEvent e) {
                //To change body of implemented methods use File | Settings | File Templates.
                try {
                    search(e);
                } catch (IOException e1) {
                    e1.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
                }
            }

            @Override
            public void removeUpdate(DocumentEvent e) {
                //To change body of implemented methods use File | Settings | File Templates.
                try {
                    search(e);
                } catch (IOException e1) {
                    e1.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
                }
            }

            @Override
            public void changedUpdate(DocumentEvent e) {
                try {
                    search(e);
                } catch (IOException e1) {
                    e1.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
                }
            }
        });

        filter.setText(ThreadPoolManager.getLangValue("TMS_FILTER"));

        by.setText(ThreadPoolManager.getLangValue("TMS_BY"));

        org.jdesktop.layout.GroupLayout jPanel2Layout = new org.jdesktop.layout.GroupLayout(searchPanel);
        searchPanel.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
                jPanel2Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                        .add(jPanel2Layout.createSequentialGroup()
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
        jPanel2Layout.setVerticalGroup(
                jPanel2Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                        .add(jPanel2Layout.createSequentialGroup()
                                .addContainerGap()
                                .add(jPanel2Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.BASELINE)
                                        .add(filter)
                                        .add(searchText, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                                        .add(searchCombo, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                                        .add(by))
                                .addContainerGap(org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        org.jdesktop.layout.GroupLayout layout = new org.jdesktop.layout.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                        .add(layout.createSequentialGroup()
                                .addContainerGap()
                                .add(searchPanel, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                                .addContainerGap(org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .add(org.jdesktop.layout.GroupLayout.TRAILING, layout.createSequentialGroup()
                                .addContainerGap(org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .add(mainPanel, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                                .addContainerGap())
        );
        layout.setVerticalGroup(
                layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                        .add(org.jdesktop.layout.GroupLayout.TRAILING, layout.createSequentialGroup()
                                .addContainerGap()
                                .add(searchPanel, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(org.jdesktop.layout.LayoutStyle.UNRELATED)
                                .add(mainPanel, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 221, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                                .addContainerGap(org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        mainPanel.getAccessibleContext().setAccessibleName("OperationForm");

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void getAll() throws IOException {
        pcService.setServiceName("/getAllPC");
        pcList = new ObjectMapper().readValue(new RESTfulClientUtil().restFullService(pcService.getServerUrl(), pcService.getServiceName()), new TypeReference<List<PC>>() {
        });
    }

    public void refresh() throws IOException {
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

    private void search(DocumentEvent documentEvent) throws IOException {

        PC searchPC = new PC();
        if (PCSearchItems.values()[searchCombo.getSelectedIndex()].equals(PCSearchItems.NAME)) {
            pcService.setServiceName("/findPCByName");
            searchPC.setName(searchText.getText());
        }else if (PCSearchItems.values()[searchCombo.getSelectedIndex()].equals(PCSearchItems.IP)) {
            pcService.setServiceName("/findPCByIP");
            searchPC.setIp(searchText.getText());
        }
        searchPC.setEffectorUser(ThreadPoolManager.me.getUsername());
        pcList = new ObjectMapper().readValue(new RESTfulClientUtil().restFullService(pcService.getServerUrl(), pcService.getServiceName(), new ObjectMapper().writeValueAsString(searchPC)), new TypeReference<List<PC>>() {
        });

        showData();
    }

    private void deleteActionPerformed(java.awt.event.ActionEvent evt) {
        int[] indexes = new int[mainTable.getSelectedRows().length];
        int j = 0;
        for (int i : mainTable.getSelectedRows()) {
            indexes[j++] = mainTable.convertRowIndexToModel(i);
        }

        List<PC> deletedPCs = new ArrayList<>();
        for (int index : indexes) {
            PC pc = pcList.get(index);
            pc.setEffectorUser(ThreadPoolManager.me.getUsername());
            deletedPCs.add(pc);
        }

        pcService.setServiceName("/deletePCs");
        try {
            new ObjectMapper().readValue(new RESTfulClientUtil().restFullService(pcService.getServerUrl(), pcService.getServiceName(), new ObjectMapper().writeValueAsString(deletedPCs)), Boolean.class);
            refresh();
        } catch (IOException e) {
            e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
        }
    }

    private void addActionPerformed(java.awt.event.ActionEvent evt) throws PropertyVetoException {//GEN-FIRST:event_jButton1ActionPerformed
        PCForm pcForm = new PCForm(false, null, this);
        pcForm.setVisible(true);
        jdpDesktop.add(pcForm);
        pcForm.setSelected(true);
    }//GEN-LAST:event_jButton1ActionPerformed


    private void editActionPerformed(java.awt.event.ActionEvent evt) throws PropertyVetoException {//GEN-FIRST:event_jButton1ActionPerformed
        PC pc = pcList.get(mainTable.convertRowIndexToModel(mainTable.getSelectedRow()));
        PCForm pcForm = new PCForm(true, pc, this);
        pcForm.setVisible(true);
        jdpDesktop.add(pcForm);
        pcForm.setSelected(true);
    }//GEN-LAST:event_jButton1ActionPerformed

    private void assignPCActionPerformed(java.awt.event.ActionEvent evt) {
        int[] indexes = new int[mainTable.getSelectedRows().length];
        int j = 0;
        for (int i : mainTable.getSelectedRows()) {
            indexes[j++] = mainTable.convertRowIndexToModel(i);
        }

        Set<PC> assignPCs = new HashSet<>();
        for (int index : indexes) {
            PC pc = pcList.get(index);
            boolean hasPc = false;
            for (PC pc1 : user.getPcs()) {
                if (pc.getId() == pc1.getId()) {
                    hasPc = true;
                    break;
                }
            }

            if (!hasPc) {
                assignPCs.add(pc);
            }
        }

        if (assignPCs.size() == 0) {
            this.dispose();
            return;
        }

        user.getPcs().addAll(assignPCs);
        pcService.setServiceName("/editUser");
        try {
            new ObjectMapper().readValue(new RESTfulClientUtil().restFullService(pcService.getServerUrl(), pcService.getServiceName(), new ObjectMapper().writeValueAsString(user)), Boolean.class);
            this.dispose();
            userForm.refresh();
        } catch (IOException e) {
            e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
        }
    }


    /**
     * @param args the command line arguments
     */

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private JButton add;
    private JButton delete;
    private JButton edit;
    private JButton assign;
    private JComboBox searchCombo;
    private JLabel by;
    private JLabel filter;
    private JPanel mainPanel;
    private JPanel searchPanel;
    private JScrollPane tableScroll;
    private JTable mainTable;
    private UserForm userForm;
    private JTextField searchText;
    private WebServiceInfo pcService = new WebServiceInfo();
    private WebServiceInfo userService = new WebServiceInfo();
    private List<PC> pcList = new ArrayList<>();
    private String[] searchItems;
    private User user;
    private JDesktopPane jdpDesktop;

    public JTable getMainTable() {
        return mainTable;
    }
    // End of variables declaration//GEN-END:variables
}
