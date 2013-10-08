package ir.university.toosi.tms.view.user;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import ir.university.toosi.tms.model.entity.User;
import ir.university.toosi.tms.model.entity.WebServiceInfo;
import ir.university.toosi.tms.util.RESTfulClientUtil;
import ir.university.toosi.tms.util.ThreadPoolManager;
import ir.university.toosi.tms.view.TMSInternalFrame;
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
public class UserManagementCode extends TMSInternalFrame {
   private UserManagementPanel panel = null;
    private WebServiceInfo userService = new WebServiceInfo();
    private List<User> userList;

   public UserManagementCode(){
       super();

       panel = new UserManagementPanel();
       panel.setLocation(0, 0);
       panel.setSize(panel.getPreferredSize());
       panel.setVisible(true);
       setLayout(null);
       getContentPane().setBackground(Color.getColor("Control"));

       this.setTitle(ThreadPoolManager.getLangValue("TMS_USER_MANAGEMENT"));
       panel.panelInfo.setBorder(javax.swing.BorderFactory.createTitledBorder(ThreadPoolManager.getLangValue("TMS_USER_MANAGEMENT")));
       panel.buttonAdd.setText(ThreadPoolManager.getLangValue("TMS_ADD"));
       panel.buttonAdd.setEnabled(ThreadPoolManager.hasPermission("ADD_USER"));

       panel.buttonDelete.setText(ThreadPoolManager.getLangValue("TMS_DELETE"));
       panel.buttonDelete.setEnabled(ThreadPoolManager.hasPermission("DELETE_USER"));

       panel.buttonDelete.setText(ThreadPoolManager.getLangValue("TMS_DELETE"));
       panel.buttonDelete.setEnabled(ThreadPoolManager.hasPermission("DELETE_USER"));

       panel.buttonEdit.setText(ThreadPoolManager.getLangValue("TMS_EDIT"));
       panel.buttonEdit.setEnabled(ThreadPoolManager.hasPermission("EDIT_USER"));

       this.add(panel);



       try {
           refresh();
       } catch (IOException e) {
           e.printStackTrace();
       }
   }



    public void refresh() throws IOException {
        getAll();
        showData();
    }

    private void getAll() {
        userService.setServiceName("/getAllUser");
        try {
            userList = new ObjectMapper().readValue(new RESTfulClientUtil().restFullService(userService.getServerUrl(), userService.getServiceName()), new TypeReference<List<User>>() {
            });
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    private void showData() {
        JTableBinding jTableBinding = SwingBindings.createJTableBinding(org.jdesktop.beansbinding.AutoBinding.UpdateStrategy.READ_WRITE, userList, panel.tableInfo, "");
        //JTableBinding jTableBinding = SwingBindings.createJTableBinding(org.jdesktop.beansbinding.AutoBinding.UpdateStrategy.READ, userList, panel.tableInfo, "");
        JTableBinding.ColumnBinding columnBinding = jTableBinding.addColumnBinding(org.jdesktop.beansbinding.ELProperty.create("${username}"));
        columnBinding.setColumnName(ThreadPoolManager.getLangValue("TMS_USERNAME"));
        columnBinding.setColumnClass(String.class);
        BindingGroup bindingGroup = new BindingGroup();
        bindingGroup.addBinding(jTableBinding);
        jTableBinding.bind();
    }


    class UserManagementPanel extends UserManagementDesign {

        @Override
        protected void buttonCancelActionPerformed() {
            dispose();
        }

        @Override
        protected void buttonAddActionPerformed() {
            UserForm userForm = new UserForm();
            userForm.setVisible(true);
            ThreadPoolManager.mainForm.getDesktopPane().add(userForm);
            //jdpDesktop.add(user);
            try {
                userForm.setSelected(true);
            } catch (PropertyVetoException e) {
                e.printStackTrace();
            }

        }

        @Override
        protected void buttonDeleteActionPerformed() {
            if(panel.tableInfo.getSelectedRow()==-1){
                return;//todo show error
            }
            int result = JOptionPane.showConfirmDialog(null, "DELETE_USER", "DELETE", JOptionPane.OK_CANCEL_OPTION);
            if (result == JOptionPane.OK_OPTION) {
                try {
                    User user = userList.get(panel.tableInfo.convertRowIndexToModel(tableInfo.getSelectedRow()));
                    WebServiceInfo serviceInfo = new WebServiceInfo();
                    serviceInfo.setServiceName("/deleteUser");
                    new RESTfulClientUtil().restFullService(serviceInfo.getServerUrl(), serviceInfo.getServiceName(), new ObjectMapper().writeValueAsString(user));
                    refresh();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }


        @Override
        protected void buttonEditActionPerformed() {
            if(panel.tableInfo.getSelectedRow()==-1){
               return; //todo show error
            }
            User user = userList.get(panel.tableInfo.convertRowIndexToModel(panel.tableInfo.getSelectedRow()));
            UserForm userForm = new UserForm(user,true);
            userForm.setVisible(true);
            ThreadPoolManager.mainForm.getDesktopPane().add(userForm);
            //jdpDesktop.add(userForm);
            try {
                userForm.setSelected(true);
            } catch (PropertyVetoException e) {
                e.printStackTrace();
            }
        }
    }
}
