package ir.university.toosi.tms.view.user;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import ir.university.toosi.tms.model.entity.PC;
import ir.university.toosi.tms.model.entity.User;
import ir.university.toosi.tms.model.entity.WebServiceInfo;
import ir.university.toosi.tms.model.entity.WorkGroup;
import ir.university.toosi.tms.model.entity.person.Person;
import ir.university.toosi.tms.util.ComponentUtil;
import ir.university.toosi.tms.util.RESTfulClientUtil;
import ir.university.toosi.tms.util.ThreadPoolManager;
import ir.university.toosi.tms.view.TMSInternalFrame;
import org.jdesktop.beansbinding.AutoBinding;
import org.jdesktop.beansbinding.BindingGroup;
import org.jdesktop.swingbinding.JTableBinding;
import org.jdesktop.swingbinding.SwingBindings;

import java.awt.*;
import java.io.IOException;
import java.util.*;
import java.util.List;

/**
 * @author a_hadadi
 */

public class UserMembershipManagementCode extends TMSInternalFrame {

    private UserMembershipManagementDesignPanel panel = null;
    List<PC> pcList = new ArrayList<>();
    private List<WorkGroup> workGroupList = new ArrayList<>();

    private User user;
    private WebServiceInfo pcService = new WebServiceInfo();
    private WebServiceInfo workGroupService = new WebServiceInfo();

    private WebServiceInfo personService = new WebServiceInfo();
    private List<Person> personList;

    public UserMembershipManagementCode(User user){
        super();

        this.user = user;
        panel = new UserMembershipManagementDesignPanel();
        panel.setLocation(0, 0);
        panel.setSize(panel.getPreferredSize());
        panel.setVisible(true);
        setLayout(null);
        getContentPane().setBackground(Color.getColor("Control"));

        this.setTitle(ThreadPoolManager.getLangValue("TMS_USER_MANAGEMENT"));
       /* panel.panelInfo.setBorder(javax.swing.BorderFactory.createTitledBorder(ThreadPoolManager.getLangValue("TMS_USER_MANAGEMENT")));
        panel.buttonAdd.setText(ThreadPoolManager.getLangValue("TMS_ADD"));
        panel.buttonAdd.setEnabled(ThreadPoolManager.hasPermission("ADD_USER"));

        panel.buttonDelete.setText(ThreadPoolManager.getLangValue("TMS_DELETE"));
        panel.buttonDelete.setEnabled(ThreadPoolManager.hasPermission("DELETE_USER"));

        panel.buttonDelete.setText(ThreadPoolManager.getLangValue("TMS_DELETE"));
        panel.buttonDelete.setEnabled(ThreadPoolManager.hasPermission("DELETE_USER"));

        panel.buttonEdit.setText(ThreadPoolManager.getLangValue("TMS_EDIT"));
        panel.buttonEdit.setEnabled(ThreadPoolManager.hasPermission("EDIT_USER"));*/

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
        ComponentUtil.SetJTableAlignment(panel.tablePC,ThreadPoolManager.direction);
        ComponentUtil.SetJTableAlignment(panel.tablePerson,ThreadPoolManager.direction);
        ComponentUtil.SetJTableAlignment(panel.tableWorkgroup,ThreadPoolManager.direction);
    }

    private void getAll() {
        pcService.setServiceName("/getAllPC");
        workGroupService.setServiceName("/getAllWorkGroup");
        personService.setServiceName("/getAllPerson");

        try {
            pcList = new ObjectMapper().readValue(new RESTfulClientUtil().restFullService(pcService.getServerUrl(), pcService.getServiceName()), new TypeReference<List<PC>>() {});
            personList = new ObjectMapper().readValue(new RESTfulClientUtil().restFullService(personService.getServerUrl(), personService.getServiceName()), new TypeReference<List<Person>>() { });
            workGroupList = new ObjectMapper().readValue(new RESTfulClientUtil().restFullService(workGroupService.getServerUrl(), workGroupService.getServiceName()), new TypeReference<List<WorkGroup>>() {
            });
        } catch (IOException e) {
            e.printStackTrace();
        }
       /* pcList = new ArrayList<>(); //todo previus selected pc list
        if (user == null)
            return;
        for (PC pc : user.getPcs()) {
            pcList.add(pc);
        }*/
    }
    private void showData() {

        //data for PC
        JTableBinding jTableBindingPC = org.jdesktop.swingbinding.SwingBindings.createJTableBinding(org.jdesktop.beansbinding.AutoBinding.UpdateStrategy.READ, pcList, panel.tablePC, "");
        JTableBinding.ColumnBinding columnBindingPC = jTableBindingPC.addColumnBinding(org.jdesktop.beansbinding.ELProperty.create("${name}"));
        columnBindingPC.setColumnName(ThreadPoolManager.getLangValue("TMS_NAME"));
        columnBindingPC.setColumnClass(String.class);
        columnBindingPC.setEditable(false);
        columnBindingPC = jTableBindingPC.addColumnBinding(org.jdesktop.beansbinding.ELProperty.create("${ip}"));
        columnBindingPC.setColumnName(ThreadPoolManager.getLangValue("TMS_IP"));
        columnBindingPC.setColumnClass(String.class);
        columnBindingPC.setEditable(false);
        columnBindingPC = jTableBindingPC.addColumnBinding(org.jdesktop.beansbinding.ELProperty.create("${location}"));
        columnBindingPC.setColumnName(ThreadPoolManager.getLangValue("TMS_LOCATION"));
        columnBindingPC.setColumnClass(String.class);
        columnBindingPC.setEditable(false);

        columnBindingPC = jTableBindingPC.addColumnBinding(org.jdesktop.beansbinding.ELProperty.create("${selected}"));

        columnBindingPC.setColumnName("انتخاب");
        columnBindingPC.setColumnClass(Boolean.class);



        BindingGroup bindingGroupPC = new BindingGroup();
        bindingGroupPC.addBinding(jTableBindingPC);
        jTableBindingPC.bind();

        //data for WG


        JTableBinding jTableBindingWG = SwingBindings.createJTableBinding(AutoBinding.UpdateStrategy.READ_WRITE, workGroupList, panel.tableWorkgroup, "");
//        columnBinding = jTableBinding.addColumnBinding(ELProperty.create("${name}"));
//        columnBinding.setColumnName(ThreadPoolManager.getLangValue("TMS_NAME"));
//        columnBinding.setColumnClass(String.class);
        JTableBinding.ColumnBinding columnBindingWG = jTableBindingWG.addColumnBinding(org.jdesktop.beansbinding.ELProperty.create("${descShow}"));
        columnBindingWG.setColumnName(ThreadPoolManager.getLangValue("TMS_DESC"));
        columnBindingWG.setColumnClass(String.class);
        columnBindingWG = jTableBindingWG.addColumnBinding(org.jdesktop.beansbinding.ELProperty.create("${selected}"));

        columnBindingWG.setColumnName("انتخاب");
        columnBindingWG.setColumnClass(Boolean.class);
        columnBindingWG.setEditable(true);
        BindingGroup bindingGroupWG = new BindingGroup();
        bindingGroupWG.addBinding(jTableBindingWG);
        jTableBindingWG.bind();
        //todo add select column

        //data for person
        org.jdesktop.swingbinding.JTableBinding jTableBindingPerson = org.jdesktop.swingbinding.SwingBindings.createJTableBinding(org.jdesktop.beansbinding.AutoBinding.UpdateStrategy.READ_WRITE, personList, panel.tablePerson, "");
        JTableBinding.ColumnBinding columnBindingPerson = jTableBindingPerson.addColumnBinding(org.jdesktop.beansbinding.ELProperty.create("${name}"));
        columnBindingPerson.setColumnName(ThreadPoolManager.getLangValue("TMS_NAME"));
        columnBindingPerson.setColumnClass(String.class);
        columnBindingPerson = jTableBindingPerson.addColumnBinding(org.jdesktop.beansbinding.ELProperty.create("${lastName}"));
        columnBindingPerson.setColumnName(ThreadPoolManager.getLangValue("TMS_LAST_NAME"));
        columnBindingPerson.setColumnClass(String.class);
        columnBindingPerson = jTableBindingPerson.addColumnBinding(org.jdesktop.beansbinding.ELProperty.create("${personnelNo}"));
        columnBindingPerson.setColumnName(ThreadPoolManager.getLangValue("TMS_PERSONNEL_NO"));
        columnBindingPerson.setColumnClass(String.class);
        columnBindingPerson = jTableBindingPerson.addColumnBinding(org.jdesktop.beansbinding.ELProperty.create("${nationalCode}"));
        columnBindingPerson.setColumnName(ThreadPoolManager.getLangValue("TMS_NATIONAL_CODE"));
        columnBindingPerson.setColumnClass(String.class);
        columnBindingPerson = jTableBindingPerson.addColumnBinding(org.jdesktop.beansbinding.ELProperty.create("${pin}"));
        columnBindingPerson.setColumnName(ThreadPoolManager.getLangValue("TMS_PIN"));
        columnBindingPerson.setColumnClass(String.class);
        BindingGroup bindingGroupPerson = new BindingGroup();
        bindingGroupPerson.addBinding(jTableBindingPerson);
        jTableBindingPerson.bind();





    }

    private class UserMembershipManagementDesignPanel extends  UserMembershipManagementDesign {

        @Override
        protected void cancelActionPerformed() {
            dispose();
        }

        @Override
        protected void saveActionPerformed() {
            //todo save
            dispose();
        }
    }
}
