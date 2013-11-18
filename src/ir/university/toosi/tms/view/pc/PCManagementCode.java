package ir.university.toosi.tms.view.pc;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import ir.university.toosi.tms.model.entity.PC;
import ir.university.toosi.tms.model.entity.PCSearchItems;
import ir.university.toosi.tms.model.entity.WebServiceInfo;
import ir.university.toosi.tms.util.ComponentUtil;
import ir.university.toosi.tms.util.DialogUtil;
import ir.university.toosi.tms.util.RESTfulClientUtil;
import ir.university.toosi.tms.util.ThreadPoolManager;
import ir.university.toosi.tms.view.TMSInternalFrame;
import org.jdesktop.beansbinding.BindingGroup;
import org.jdesktop.swingbinding.JTableBinding;

import javax.swing.*;
import java.awt.*;
import java.beans.PropertyVetoException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * @author a_hadadi
 */
public class PCManagementCode extends TMSInternalFrame {

    private WebServiceInfo pcService = new WebServiceInfo();
    private List<PC> pcList = new ArrayList<>();
    private PCManagementPanel panel = null;
    private String[] filterItems;

    public PCManagementCode() {
        super();

        panel = new PCManagementPanel();
        panel.setLocation(0, 0);
        panel.setSize(panel.getPreferredSize());
        panel.setVisible(true);
        setLayout(null);

        // setTitle(ThreadPoolManager.getLangValue("TMS_PC_MANAGEMENT"));//todo
        setTitle("مدیریت رایانه");//todo
        // panel.panelPCList.setBorder(BorderFactory.createTitledBorder(ThreadPoolManager.getLangValue("TMS_PC_MANAGEMENT")));//todo
        panel.panelPCList.setBorder(BorderFactory.createTitledBorder("فهرست رایانه ها"));//todo
        panel.panelSearch.setBorder(javax.swing.BorderFactory.createTitledBorder(ThreadPoolManager.getLangValue("TMS_SEARCH")));

        panel.buttonAdd.setText(ThreadPoolManager.getLangValue("TMS_ADD"));
        panel.buttonAdd.setEnabled(ThreadPoolManager.hasPermission("ADD_PC"));

        panel.buttonDelete.setText(ThreadPoolManager.getLangValue("TMS_DELETE"));
        panel.buttonDelete.setEnabled(ThreadPoolManager.hasPermission("DELETE_PC"));

        panel.buttonEdit.setText(ThreadPoolManager.getLangValue("TMS_EDIT"));
        panel.buttonEdit.setVisible(ThreadPoolManager.hasPermission("EDIT_PC"));

        panel.labelFilter.setText(ThreadPoolManager.getLangValue("TMS_FILTER"));
        panel.labelFilterBy.setText(ThreadPoolManager.getLangValue("TMS_BY"));


        panel.buttonCancel.setText(ThreadPoolManager.getLangValue("TMS_CANCEL"));

        // searchPC.setEffectorUser(ThreadPoolManager.me.getUsername());
        // pc.setEffectorUser(ThreadPoolManager.me.getUsername());

        getContentPane().setBackground(Color.getColor("Control"));

        this.add(panel);

        fillSearchCombo();
        refresh();

    }

    private void fillSearchCombo() {
        filterItems = new String[PCSearchItems.values().length];
        int i = 0;
        for (PCSearchItems pcSearchItems : PCSearchItems.values()) {
            filterItems[i++] = pcSearchItems.getDescription();
        }
        panel.comboBoxFilterBy.setModel(new DefaultComboBoxModel(filterItems));
    }

    private void refresh() {
        Font tahoma = new Font("Tahoma", Font.PLAIN, 12);
        ComponentUtil.setFont(panel, tahoma, ThreadPoolManager.direction);
        ComponentUtil.SetJTableAlignment(panel.tablePC, ThreadPoolManager.direction);
        try {
            getAll();
            showData();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void getAll() throws IOException {

        pcService.setServiceName("/getAllPC");
        pcList = new ObjectMapper().readValue(new RESTfulClientUtil().restFullService(pcService.getServerUrl(), pcService.getServiceName()), new TypeReference<List<PC>>() {
        });
    }

    private void showData() {
        JTableBinding jTableBinding = org.jdesktop.swingbinding.SwingBindings.createJTableBinding(org.jdesktop.beansbinding.AutoBinding.UpdateStrategy.READ_WRITE, pcList, panel.tablePC, "");
        JTableBinding.ColumnBinding columnBinding = jTableBinding.addColumnBinding(org.jdesktop.beansbinding.ELProperty.create("${name}"));
        columnBinding.setColumnName(ThreadPoolManager.getLangValue("TMS_NAME"));
        columnBinding.setColumnClass(String.class);
        columnBinding.setEditable(false);
        columnBinding = jTableBinding.addColumnBinding(org.jdesktop.beansbinding.ELProperty.create("${ip}"));
        columnBinding.setColumnName(ThreadPoolManager.getLangValue("TMS_IP"));
        columnBinding.setColumnClass(String.class);
        columnBinding.setEditable(false);
        columnBinding = jTableBinding.addColumnBinding(org.jdesktop.beansbinding.ELProperty.create("${location}"));
        columnBinding.setColumnName(ThreadPoolManager.getLangValue("TMS_LOCATION"));
        columnBinding.setColumnClass(String.class);
        columnBinding.setEditable(false);
        BindingGroup bindingGroup = new BindingGroup();
        bindingGroup.addBinding(jTableBinding);
        jTableBinding.bind();
    }

    private void applyFilter() {

        PC searchPC = new PC();
        if (PCSearchItems.values()[panel.comboBoxFilterBy.getSelectedIndex()].equals(PCSearchItems.NAME)) {
            pcService.setServiceName("/findPCByName");
            searchPC.setName(panel.textFieldFilter.getText());
        } else if (PCSearchItems.values()[panel.comboBoxFilterBy.getSelectedIndex()].equals(PCSearchItems.IP)) {
            pcService.setServiceName("/findPCByIP");
            searchPC.setIp(panel.textFieldFilter.getText());
        }
        searchPC.setEffectorUser(ThreadPoolManager.me.getUsername());
        try {
            pcList = new ObjectMapper().readValue(new RESTfulClientUtil().restFullService(pcService.getServerUrl(), pcService.getServiceName(), new ObjectMapper().writeValueAsString(searchPC)), new TypeReference<List<PC>>() {
            });
        } catch (IOException e) {
            e.printStackTrace();
        }

        showData();

    }

    private void deletePC() {

        pcService.setServiceName("/deletePC");
        try {
            PC pc = pcList.get(panel.tablePC.convertRowIndexToModel(panel.tablePC.getSelectedRow()));
            pc.setEffectorUser(ThreadPoolManager.me.getUsername());
            WebServiceInfo serviceInfo = new WebServiceInfo();
            serviceInfo.setServiceName("/deletePC");
            String result = new ObjectMapper().readValue(
                    new RESTfulClientUtil().restFullService(serviceInfo.getServerUrl(), serviceInfo.getServiceName(), new ObjectMapper().writeValueAsString(pc))
                    , String.class);
            if (result.equalsIgnoreCase("true")) {
                DialogUtil.showOKDialog(this
                        , "رایانه مورد نظر حذف شد."
                        , "اطلاع رسانی"
                );
                refresh();
            } else {
                DialogUtil.showOKDialog(this
                        , "در حذف رایانه مورد نظر، خطا رخ داده است."
                        , "خطای سیستمی"
                );

            }
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    class PCManagementPanel extends PCManagementDesign {

        @Override
        protected void buttonCancelActionPerformed() {
            dispose();
        }

        @Override
        protected void buttonEditActionPerformed() {

            if (panel.tablePC.getSelectedRow() == -1) {
                //todo read from bundle
                DialogUtil.showErrorDialog(this
                        , "رایانه مورد نظر را جهت ویرایش انتخاب نمائید."
                        , "خطای ورودی"
                );
                return;
            }

            PC pc = pcList.get(panel.tablePC.convertRowIndexToModel(panel.tablePC.getSelectedRow()));
            PCCode pcForm = new PCCode(pc);
            pcForm.setVisible(true);
            ThreadPoolManager.mainForm.getDesktopPane().add(pcForm);
            try {
                pcForm.setSelected(true);
            } catch (PropertyVetoException e) {
                e.printStackTrace();
            }
             dispose();
        }

        @Override
        protected void buttonAddActionPerformed() {
            PCCode pcForm= new PCCode(null);
            pcForm.setVisible(true);
            ThreadPoolManager.mainForm.getDesktopPane().add(pcForm);
            try {
                pcForm.setSelected(true);
            } catch (PropertyVetoException e) {
                e.printStackTrace();
            }
             dispose();
        }

        @Override
        protected void buttonDeleteActionPerformed() {

            if (panel.tablePC.getSelectedRow() == -1) {
                //todo read from bundle
                DialogUtil.showErrorDialog(this
                        , "رایانه مورد نظر را جهت حذف انتخاب کنید"
                        , "خطای ورودی"
                );
                return;
            }

            if (!DialogUtil.showDeleteQuestionDialog(this)) {
                // int result = JOptionPane.showConfirmDialog(null, "DELETE_PC", "DELETE", JOptionPane.OK_CANCEL_OPTION);
                return;
            }

            deletePC();

        }

        @Override
        protected void filterEvent() {
            applyFilter();
        }

    }
}

