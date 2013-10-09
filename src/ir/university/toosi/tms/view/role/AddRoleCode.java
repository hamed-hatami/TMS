package ir.university.toosi.tms.view.role;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import ir.university.toosi.tms.model.entity.Operation;
import ir.university.toosi.tms.model.entity.Role;
import ir.university.toosi.tms.model.entity.WebServiceInfo;
import ir.university.toosi.tms.util.ComponentUtil;
import ir.university.toosi.tms.util.RESTfulClientUtil;
import ir.university.toosi.tms.util.ThreadPoolManager;
import ir.university.toosi.tms.view.TMSInternalFrame;
import ir.university.toosi.tms.view.TMSPanel;
import org.jdesktop.beansbinding.BindingGroup;
import org.jdesktop.swingbinding.JTableBinding;

import javax.swing.*;
import java.awt.*;
import java.beans.PropertyVetoException;
import java.io.IOException;
import java.util.*;
import java.util.List;


public class AddRoleCode extends TMSInternalFrame {
    private AddRolePanel panel = null;

    private WebServiceInfo roleService = new WebServiceInfo();
    private java.util.List<Operation> operationList;


    public AddRoleCode(){
        super();
        panel = new AddRolePanel();
        panel.setLocation(0, 0);
        panel.setSize(panel.getPreferredSize());
        panel.setVisible(true);
        setLayout(null);
        getContentPane().setBackground(Color.getColor("Control"));
        this.add(panel);


        this.setTitle(ThreadPoolManager.getLangValue("TMS_ROLE_MANAGEMENT"));
        panel.mainTable.setAutoCreateRowSorter(true);
        panel.buttonSave.setText(ThreadPoolManager.getLangValue("TMS_ADD"));
        panel.buttonCancel.setText(ThreadPoolManager.getLangValue("TMS_CANCEL"));


        try {
            refresh();
        } catch (IOException e) {
            e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
        }
    }
    private void getAll() throws IOException {
        roleService.setServiceName("/getAllOperation");
        operationList = new ObjectMapper().readValue(new RESTfulClientUtil().restFullService(roleService.getServerUrl(), roleService.getServiceName()), new TypeReference<List<Operation>>() {
        });
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
        org.jdesktop.swingbinding.JTableBinding jTableBinding = org.jdesktop.swingbinding.SwingBindings.createJTableBinding(org.jdesktop.beansbinding.AutoBinding.UpdateStrategy.READ_WRITE, operationList, panel.mainTable, "");
//         columnBinding = jTableBinding.addColumnBinding(org.jdesktop.beansbinding.ELProperty.create("${name}"));
//        columnBinding.setColumnName(ThreadPoolManager.getLangValue("TMS_NAME"));
//        columnBinding.setColumnClass(String.class);
        JTableBinding.ColumnBinding columnBinding = jTableBinding.addColumnBinding(org.jdesktop.beansbinding.ELProperty.create("${description}"));
        columnBinding.setColumnName(ThreadPoolManager.getLangValue("TMS_DESC"));
        columnBinding.setEditable(false);
        columnBinding.setColumnClass(String.class);
        columnBinding = jTableBinding.addColumnBinding(org.jdesktop.beansbinding.ELProperty.create("${enabled}"));
        columnBinding.setColumnName(ThreadPoolManager.getLangValue("TMS_ENABLED"));
        columnBinding.setColumnClass(Boolean.class);
        BindingGroup bindingGroup = new BindingGroup();
        bindingGroup.addBinding(jTableBinding);
        jTableBinding.bind();
    }





    class AddRolePanel extends AddRoleDesign {

        @Override
        void saveActionPerformed() {
            //todo
        }

        @Override
        void cancelActionPerformed() {
            dispose();
        }
    }
}
