package ir.university.toosi.tms.view.workgroup;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import ir.university.toosi.tms.model.entity.WebServiceInfo;
import ir.university.toosi.tms.model.entity.WorkGroup;
import ir.university.toosi.tms.util.ComponentUtil;
import ir.university.toosi.tms.util.RESTfulClientUtil;
import ir.university.toosi.tms.util.ThreadPoolManager;
import ir.university.toosi.tms.view.TMSInternalFrame;
import org.jdesktop.beansbinding.AutoBinding;
import org.jdesktop.beansbinding.BindingGroup;
import org.jdesktop.swingbinding.JTableBinding;
import org.jdesktop.swingbinding.SwingBindings;

import javax.swing.*;
import java.awt.*;
import java.beans.PropertyVetoException;
import java.io.IOException;
import java.util.*;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: a_hadadi
 * Date: 10/2/13
 * Time: 8:24 PM
 * To change this template use File | Settings | File Templates.
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
           // this.changeComonentOrientation(ThreadPoolManager.direction);
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
        BindingGroup bindingGroup = new BindingGroup();
        bindingGroup.addBinding(jTableBinding);
        jTableBinding.bind();
    }


    class WorkGroupManagementPanel extends WorkGroupManagementDesign {
       @Override
        protected void buttonAddActionPerformed() {
          /* AddRoleCode addRoleCode = new AddRoleCode();
           addRoleCode.setVisible(true);
           // roleManagementCode.setBounds(170, 65, 175, 105);
           // desktopPane.add(roleManagementCode, JLayeredPane.DEFAULT_LAYER);
           ThreadPoolManager.mainForm.getDesktopPane().add(addRoleCode);
           try {
               addRoleCode.setSelected(true);
           } catch (PropertyVetoException e) {
               e.printStackTrace();
           }*/
        }

        @Override
        protected void buttonEditActionPerformed() {
            //todo
        }

        @Override
        protected void buttonCancelActionPerformed() {
            dispose();
        }

        @Override
        protected void buttonModifyActionPerformed() {
            //todo
        }
    }
}
