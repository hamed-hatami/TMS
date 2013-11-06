package ir.university.toosi.tms.view.workgroup;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import ir.university.toosi.tms.model.entity.User;
import ir.university.toosi.tms.model.entity.WebServiceInfo;
import ir.university.toosi.tms.model.entity.WorkGroup;
import ir.university.toosi.tms.util.ComponentUtil;
import ir.university.toosi.tms.util.DialogUtil;
import ir.university.toosi.tms.util.RESTfulClientUtil;
import ir.university.toosi.tms.util.ThreadPoolManager;
import ir.university.toosi.tms.view.TMSInternalFrame;
import org.jdesktop.beansbinding.AutoBinding;
import org.jdesktop.beansbinding.BindingGroup;
import org.jdesktop.swingbinding.JTableBinding;
import org.jdesktop.swingbinding.SwingBindings;

import javax.swing.*;
import java.awt.*;
import java.io.IOException;
import java.util.*;
import java.util.List;

/**
 * User: a_hadadi
 */
public class WorkGroupManagementCode extends TMSInternalFrame {

    private WorkGroupManagementPanel panel = null;
    private WebServiceInfo workGroupService = new WebServiceInfo();
    private List<WorkGroup> workGroupList = new ArrayList<>();

   public WorkGroupManagementCode(){
       super();

       panel = new WorkGroupManagementPanel();
       panel.setLocation(0, 0);
       panel.setSize(panel.getPreferredSize());
       panel.setVisible(true);
       setLayout(null);
       getContentPane().setBackground(Color.getColor("Control"));
       this.add(panel);


       this.setTitle(ThreadPoolManager.getLangValue("TMS_WORKGROUP_MANAGEMENT"));
       panel.panelInfo.setBorder(BorderFactory.createTitledBorder(ThreadPoolManager.getLangValue("TMS_WORKGROUP_MANAGEMENT")));
       panel.tableInfo.setAutoCreateRowSorter(true);
       panel.buttonAdd.setText(ThreadPoolManager.getLangValue("TMS_ADD"));
       panel.buttonAdd.setEnabled(ThreadPoolManager.hasPermission("ADD_WORKGROUP"));

       panel.buttonCancel.setText(ThreadPoolManager.getLangValue("TMS_CANCEL"));
       //panel.buttonCancel.setEnabled(ThreadPoolManager.getLangValue("TMS_CANCEL"));

       panel.buttonModify.setText(ThreadPoolManager.getLangValue("TMS_EDIT"));
       panel.buttonModify.setEnabled(ThreadPoolManager.hasPermission("EDIT_WORKGROUP"));

       panel.buttonDelete.setText(ThreadPoolManager.getLangValue("TMS_DELETE"));
       panel.buttonDelete.setEnabled(ThreadPoolManager.hasPermission("DELETE_WORKGROUP"));

       try {
           loadInfo();
           Font tahoma = new Font("Tahoma", Font.PLAIN, 12);
           ComponentUtil.setFont(panel, tahoma, ThreadPoolManager.direction);
           ComponentUtil.SetJTableAlignment(panel.tableInfo,ThreadPoolManager.direction);

       } catch (IOException e) {
           e.printStackTrace();
       }

   }


    public void loadInfo() throws IOException {
        workGroupService.setServiceName("/getAllWorkGroup");
        workGroupList = new ObjectMapper().readValue(new RESTfulClientUtil().restFullService(workGroupService.getServerUrl(), workGroupService.getServiceName()), new TypeReference<List<WorkGroup>>() {
        });

        JTableBinding jTableBinding = SwingBindings.createJTableBinding(AutoBinding.UpdateStrategy.READ_WRITE, workGroupList, panel.tableInfo, "");
//        columnBinding = jTableBinding.addColumnBinding(ELProperty.create("${name}"));
//        columnBinding.setColumnName(ThreadPoolManager.getLangValue("TMS_NAME"));
//        columnBinding.setColumnClass(String.class);
        JTableBinding.ColumnBinding columnBinding = jTableBinding.addColumnBinding(org.jdesktop.beansbinding.ELProperty.create("${descShow}"));
        columnBinding.setColumnName(ThreadPoolManager.getLangValue("TMS_DESC"));
        columnBinding.setColumnClass(String.class);
        columnBinding.setEditable(false);

        columnBinding = jTableBinding.addColumnBinding(org.jdesktop.beansbinding.ELProperty.create("${enabled==1}"));
        columnBinding.setColumnName("فعال");
        columnBinding.setColumnClass(Boolean.class);
        columnBinding.setEditable(false);

        BindingGroup bindingGroup = new BindingGroup();
        bindingGroup.addBinding(jTableBinding);
        jTableBinding.bind();

        ComponentUtil.SetJTableAlignment(panel.tableInfo,ThreadPoolManager.direction);
        panel.tableInfo.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        panel.tableInfo.getTableHeader().setReorderingAllowed(false);
        panel.tableInfo.setColumnSelectionAllowed(false);
        /*panel.tableInfo.setRowSelectionAllowed(true);
        panel.tableInfo.setCellSelectionEnabled(false);*/
       // panel.tableInfo.setColumnSelectionAllowed(false);
    }


    class WorkGroupManagementPanel extends WorkGroupManagementDesign {

       @Override
        protected void buttonAddActionPerformed() {
           WorkGroupCode wg = new WorkGroupCode(null);
           wg.setVisible(true);
           ThreadPoolManager.mainForm.getDesktopPane().add(wg);
           try {
               wg.setSelected(true);
           } catch (Exception e) {
               e.printStackTrace();
           }
           dispose();
        }

        @Override
        protected void buttonDeleteActionPerformed() {

            if(panel.tableInfo.getSelectedRow()==-1){
                //todo read from bundle
                DialogUtil.showErrorDialog(this
                        ,"لطفا یک گروه کاری را انتخاب فرمائید"
                        ,"خطای ورودی"
                );
                return;
            }

            if (!DialogUtil.showDeleteQuestionDialog(this)) {
                return;
            }

            try {
                WorkGroup workGroup = workGroupList.get(panel.tableInfo.convertRowIndexToModel(panel.tableInfo.getSelectedRow()));
                WebServiceInfo serviceInfo = new WebServiceInfo();
                serviceInfo.setServiceName("/deleteWorkGroup");
                new RESTfulClientUtil().restFullService(serviceInfo.getServerUrl(), serviceInfo.getServiceName(), new ObjectMapper().writeValueAsString(workGroup));
                //todo read from bundle
                DialogUtil.showOKDialog(this
                        ,"گروه کاری مورد نظر حذف شد"
                        ,"اطلاع رسانی"
                );
                loadInfo();
            } catch (IOException e) {
                //todo read from bundle
                DialogUtil.showErrorDialog(this
                        ,"در حذف گروه کاری خطا رخ داده است"
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
        protected void buttonModifyActionPerformed() {
            if(panel.tableInfo.getSelectedRow()==-1){
                //todo read from bundle
                DialogUtil.showErrorDialog(this
                        ,"لطفا یک گروه کاری را انتخاب فرمائید"
                        ,"خطای ورودی"
                );
                return;

            }
            WorkGroup workGroup = workGroupList.get(panel.tableInfo.convertRowIndexToModel(panel.tableInfo.getSelectedRow()));
            WorkGroupCode wg = new WorkGroupCode(workGroup);
            wg.setVisible(true);
            ThreadPoolManager.mainForm.getDesktopPane().add(wg);
            try {
                wg.setSelected(true);
            } catch (Exception e) {
                e.printStackTrace();
            }
            dispose();
        }
    }
}
