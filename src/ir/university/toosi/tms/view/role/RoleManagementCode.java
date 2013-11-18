package ir.university.toosi.tms.view.role;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import ir.university.toosi.tms.model.entity.Role;
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
import java.io.IOException;
import java.util.*;
import java.util.List;

/**
 * @author a_hadadi
 */
public class RoleManagementCode extends TMSInternalFrame {

    private RoleManagementPanel panel = null;
    private WebServiceInfo roleService = new WebServiceInfo();
    private java.util.List<Role> roleList = new ArrayList<>();

    public RoleManagementCode(){
       super();

       panel = new RoleManagementPanel();
       panel.setLocation(0, 0);
       panel.setSize(panel.getPreferredSize());
       panel.setVisible(true);
       setLayout(null);
       getContentPane().setBackground(Color.getColor("Control"));
       this.add(panel);


        setTitle(ThreadPoolManager.getLangValue("TMS_ROLE_MANAGEMENT"));
        panel.panelInfo.setBorder(BorderFactory.createTitledBorder(ThreadPoolManager.getLangValue("TMS_ROLE_MANAGEMENT")));
        panel.add.setText(ThreadPoolManager.getLangValue("TMS_ADD"));
        panel.add.setEnabled(ThreadPoolManager.hasPermission("ADD_ROLE"));
        panel.delete.setText(ThreadPoolManager.getLangValue("TMS_DELETE"));
        panel.delete.setEnabled(ThreadPoolManager.hasPermission("DELETE_ROLE"));
        panel.edit.setText(ThreadPoolManager.getLangValue("TMS_EDIT"));
        panel.edit.setEnabled(ThreadPoolManager.hasPermission("EDIT_ROLE"));
        panel.buttonCancel.setText(ThreadPoolManager.getLangValue("TMS_CANCEL"));
        panel.mainTable.setAutoCreateRowSorter(true);


        try {
            refresh();
        } catch (IOException e) {
            e.printStackTrace();
        }


    }

    public void refresh() throws IOException {
        getAll();
        showData();
        Font tahoma = new Font("Tahoma", Font.PLAIN, 12);
        ComponentUtil.setFont(panel, tahoma, ThreadPoolManager.direction);
       // this.changeComonentOrientation(ThreadPoolManager.direction);
        ComponentUtil.SetJTableAlignment(panel.mainTable,ThreadPoolManager.direction);
    }

    private void showData() {
        org.jdesktop.swingbinding.JTableBinding jTableBinding = org.jdesktop.swingbinding.SwingBindings.createJTableBinding(org.jdesktop.beansbinding.AutoBinding.UpdateStrategy.READ_WRITE, roleList, panel.mainTable, "");
//        columnBinding = jTableBinding.addColumnBinding(org.jdesktop.beansbinding.ELProperty.create("${name}"));
//        columnBinding.setColumnName(ThreadPoolManager.getLangValue("TMS_NAME"));
//        columnBinding.setColumnClass(String.class);
        JTableBinding.ColumnBinding columnBinding = jTableBinding.addColumnBinding(org.jdesktop.beansbinding.ELProperty.create("${descShow}"));
        columnBinding.setColumnName(ThreadPoolManager.getLangValue("TMS_DESC"));
        columnBinding.setColumnClass(String.class);
        columnBinding.setEditable(false);
        columnBinding = jTableBinding.addColumnBinding(org.jdesktop.beansbinding.ELProperty.create("${enabled}"));
        columnBinding.setColumnName(ThreadPoolManager.getLangValue("TMS_ENABLED"));
        columnBinding.setColumnClass(Boolean.class);
        columnBinding.setEditable(false);
        BindingGroup bindingGroup = new BindingGroup();
        bindingGroup.addBinding(jTableBinding);
        jTableBinding.bind();

        ComponentUtil.SetJTableAlignment(panel.mainTable,ThreadPoolManager.direction);
        panel.mainTable.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        panel.mainTable.getTableHeader().setReorderingAllowed(false);
        panel.mainTable.setColumnSelectionAllowed(false);
    }

    private void getAll() throws IOException {
        roleService.setServiceName("/getAllRole");
        roleList = new ObjectMapper().readValue(new RESTfulClientUtil().restFullService(roleService.getServerUrl(), roleService.getServiceName()), new TypeReference<List<Role>>() {
        });
    }


    class RoleManagementPanel extends RoleManagementDesign {

        @Override
        protected void buttonAddActionPerformed() {
            RoleCode roleCode = new RoleCode(null);
            roleCode.setVisible(true);
            ThreadPoolManager.mainForm.getDesktopPane().add(roleCode);
            try {
                roleCode.setSelected(true);
            } catch (Exception e) {
                e.printStackTrace();
            }
            dispose();
        }


        @Override
        protected void buttonDeleteActionPerformed() {
            if(panel.mainTable.getSelectedRow()==-1){
                //todo read from bundle
                DialogUtil.showErrorDialog(this
                        , "نقش مورد نظر را جهت ویرایش انتخاب فرمائید."
                        , "خطای ورودی"
                );
                return;
            }

            if (!DialogUtil.showDeleteQuestionDialog(this)) {
                return;
            }

            try {
                Role role = roleList.get(panel.mainTable.convertRowIndexToModel(panel.mainTable.getSelectedRow()));
                WebServiceInfo serviceInfo = new WebServiceInfo();
                serviceInfo.setServiceName("/deleteRole");
                new RESTfulClientUtil().restFullService(serviceInfo.getServerUrl(), serviceInfo.getServiceName(), new ObjectMapper().writeValueAsString(role));
                //todo read from bundle
                DialogUtil.showOKDialog(this
                        ,"نقش مورد نظر حذف شد."
                        ,"اطلاع رسانی"
                );
                refresh();
            } catch (IOException e) {
                //todo read from bundle
                DialogUtil.showErrorDialog(this
                        ,"در حذف نقش خطا رخ داده است"
                        ,"خطای سیستمی"
                );
                e.printStackTrace();
            }
        }

        @Override
        protected void buttonCancelActionPerformed() {
            dispose();
        }

        @Override
        protected void buttonEditActionPerformed() {
            if(panel.mainTable.getSelectedRow()==-1){
                //todo read from bundle
                DialogUtil.showErrorDialog(this
                        , "نقش مورد نظر را جهت ویرایش انتخاب فرمائید."
                        , "خطای ورودی"
                );
                return;
            }
            Role role = roleList.get(panel.mainTable.convertRowIndexToModel(panel.mainTable.getSelectedRow()));
            RoleCode roleCode = new RoleCode(role);
            roleCode.setVisible(true);
            ThreadPoolManager.mainForm.getDesktopPane().add(roleCode);
            try {
                dispose();
                roleCode.setSelected(true);
            } catch (Exception e) {
                e.printStackTrace();
            }

            dispose();
        }
    }
}
