package ir.university.toosi.tms.view.user;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import ir.university.toosi.tms.model.entity.User;
import ir.university.toosi.tms.model.entity.WebServiceInfo;
import ir.university.toosi.tms.util.ComponentUtil;
import ir.university.toosi.tms.util.RESTfulClientUtil;
import ir.university.toosi.tms.util.ThreadPoolManager;
import ir.university.toosi.tms.view.TMSInternalFrame;
import org.jdesktop.beansbinding.BindingGroup;
import org.jdesktop.swingbinding.JTableBinding;
import org.jdesktop.swingbinding.SwingBindings;
import org.primefaces.util.ComponentUtils;

import javax.swing.*;
import javax.swing.event.InternalFrameEvent;
import javax.swing.event.InternalFrameListener;
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
public class UserManagementCode extends TMSInternalFrame implements InternalFrameListener {
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
        Font tahoma = new Font("Tahoma", Font.PLAIN, 12);
        ComponentUtil.setFont(panel, tahoma, ThreadPoolManager.direction);
        // this.changeComonentOrientation(ThreadPoolManager.direction);
        ComponentUtil.SetJTableAlignment(panel.tableInfo,ThreadPoolManager.direction);
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
        columnBinding.setEditable(false);
        BindingGroup bindingGroup = new BindingGroup();
        bindingGroup.addBinding(jTableBinding);
        jTableBinding.bind();
    }

    @Override
    public void internalFrameOpened(InternalFrameEvent e) {
    }

    @Override
    public void internalFrameClosing(InternalFrameEvent e) {
    }

    @Override
    public void internalFrameClosed(InternalFrameEvent e) {
    }

    @Override
    public void internalFrameIconified(InternalFrameEvent e) {
    }

    @Override
    public void internalFrameDeiconified(InternalFrameEvent e) {
    }

    @Override
    public void internalFrameActivated(InternalFrameEvent e) {
        try {
            refresh();
        } catch (IOException e1) {
            e1.printStackTrace();
        }
    }

    @Override
    public void internalFrameDeactivated(InternalFrameEvent e) {
    }


    class UserManagementPanel extends UserManagementDesign {

        @Override
        protected void buttonCancelActionPerformed() {
            dispose();
        }

        @Override
        protected void buttonAddActionPerformed() {
            UserAddCode userAddForm = new UserAddCode();
            userAddForm.setVisible(true);
            ThreadPoolManager.mainForm.getDesktopPane().add(userAddForm);
            try {
                userAddForm.setSelected(true);
            } catch (PropertyVetoException e) {
                e.printStackTrace();
            }

        }

        @Override
        protected void buttonDeleteActionPerformed() {
            if(panel.tableInfo.getSelectedRow()==-1){
                return;//todo show error
            }
            int result = JOptionPane.showConfirmDialog(null, ThreadPoolManager.getLangValue("deleteMessage"), "", JOptionPane.OK_CANCEL_OPTION);
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
        protected void buttonMembershipManagementActionPerformed() {
            if(panel.tableInfo.getSelectedRow()==-1){
                return;//todo show error
            }
            User user = userList.get(panel.tableInfo.convertRowIndexToModel(tableInfo.getSelectedRow()));
            UserMembershipManagementCode userMembershipManagement = new UserMembershipManagementCode(user);
            userMembershipManagement.setVisible(true);
            ThreadPoolManager.mainForm.getDesktopPane().add(userMembershipManagement);
            try {
                userMembershipManagement.setSelected(true);
            } catch (PropertyVetoException e) {
                e.printStackTrace();
            }
        }


        @Override
        protected void buttonEditActionPerformed() {
            if(panel.tableInfo.getSelectedRow()==-1){
               return; //todo show error
            }
            User user = userList.get(panel.tableInfo.convertRowIndexToModel(panel.tableInfo.getSelectedRow()));

            UserAddCode userAddForm = new UserAddCode(user);
            userAddForm.setVisible(true);

            ThreadPoolManager.mainForm.getDesktopPane().add(userAddForm);
            //jdpDesktop.add(userForm);
            try {
                userAddForm.setSelected(true);
            } catch (PropertyVetoException e) {
                e.printStackTrace();
            }
        }
    }
}
