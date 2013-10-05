package ir.university.toosi.tms.view.role;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import ir.university.toosi.tms.model.entity.Role;
import ir.university.toosi.tms.model.entity.WebServiceInfo;
import ir.university.toosi.tms.util.RESTfulClientUtil;
import ir.university.toosi.tms.util.ThreadPoolManager;
import ir.university.toosi.tms.view.TMSInternalFrame;
import org.jdesktop.beansbinding.BindingGroup;
import org.jdesktop.swingbinding.JTableBinding;

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
public class RoleManagementCode extends TMSInternalFrame {
   private String formTitle = "this title";

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

    }


    private void getAll() throws IOException {
        roleService.setServiceName("/getAllRole");
        roleList = new ObjectMapper().readValue(new RESTfulClientUtil().restFullService(roleService.getServerUrl(), roleService.getServiceName()), new TypeReference<List<Role>>() {
        });
    }


    class RoleManagementPanel extends RoleManagementDesign {
        @Override
        protected void button1ActionPerformed() {
            AddRoleCode addRoleCode = new AddRoleCode();
            addRoleCode.setVisible(true);
            // roleManagementCode.setBounds(170, 65, 175, 105);
            // desktopPane.add(roleManagementCode, JLayeredPane.DEFAULT_LAYER);
            ThreadPoolManager.mainForm.getDesktopPane().add(addRoleCode);
            try {
                addRoleCode.setSelected(true);
            } catch (PropertyVetoException e) {
                e.printStackTrace();
            }


        }

        @Override
        protected void button2ActionPerformed() {
            //todo
        }

        @Override
        protected void button4ActionPerformed() {
            //To change body of implemented methods use File | Settings | File Templates.
        }

        @Override
        protected void button3ActionPerformed() {
            //todo
        }
    }
}