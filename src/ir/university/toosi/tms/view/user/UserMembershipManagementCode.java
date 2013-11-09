package ir.university.toosi.tms.view.user;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import ir.university.toosi.tms.model.entity.*;
import ir.university.toosi.tms.model.entity.person.Person;
import ir.university.toosi.tms.util.ComponentUtil;
import ir.university.toosi.tms.util.DialogUtil;
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
    private WebServiceInfo userService = new WebServiceInfo();
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
            workGroupList = new ObjectMapper().readValue(new RESTfulClientUtil().restFullService(workGroupService.getServerUrl(), workGroupService.getServiceName()), new TypeReference<List<WorkGroup>>() {});

            pcList = getMixUserSelectedPCs();
            workGroupList = getMixUserSelectedWorkGroups();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private List<WorkGroup> getMixUserSelectedWorkGroups() {
        for(WorkGroup userWorkGroup :  user.getWorkGroups()){
            for(WorkGroup tableWorkGroup :  workGroupList){
                if(userWorkGroup.getId() == tableWorkGroup.getId()){
                    tableWorkGroup.setSelected(true);
                    break;
                }
            }
        }
        return workGroupList;
    }

    public Set<WorkGroup> getSelectedWorkGroupList(){
        Set<WorkGroup> selectedWorkGroupList = new HashSet<>();
        for(WorkGroup tableWorkGroup :  workGroupList){
            if(tableWorkGroup.isSelected()){
                selectedWorkGroupList.add(tableWorkGroup);
            }
        }
        return selectedWorkGroupList;
    }

    private List<PC> getMixUserSelectedPCs() {
        for(PC userPC :  user.getPcs()){
            for(PC tablePC :  pcList){
                if(userPC.getId() == tablePC.getId()){
                    tablePC.setSelected(true);
                    break;
                }
            }
        }
        return pcList;
    }

    public Set<PC> getSelectedPCList(){
        Set<PC> selectedPCList = new HashSet<>();
        for(PC tablePC :  pcList){
            if(tablePC.isSelected()){
                selectedPCList.add(tablePC);
            }
        }
        return selectedPCList;
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

        columnBindingPC.setColumnName("انتخاب");//todo lang
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

        columnBindingWG.setColumnName("انتخاب");//todo lang
        columnBindingWG.setColumnClass(Boolean.class);
        columnBindingWG.setEditable(true);
        BindingGroup bindingGroupWG = new BindingGroup();
        bindingGroupWG.addBinding(jTableBindingWG);
        jTableBindingWG.bind();


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

       //  select current person
        if(user.getPerson()!=null){
            for(int i = 0 ; i<panel.tablePerson.getRowCount();i++){
               Person person = personList.get(panel.tablePerson.convertRowIndexToModel(i));
                  if(person.getId() == user.getPerson().getId()){
                      panel.tablePerson.setRowSelectionInterval(i,i);
                      break;
                  }
            }
        }
    }

    private boolean validateForm() {
        if(panel.tablePerson.getSelectedRow() == -1){
            //todo bundle
           if(!DialogUtil.showYesNOQuestionDialog(this
                    ,"شخص مرتبط با این کاربر انتخاب نشده است، آیا ادامه می دهید؟"
            ,"بله"
            ,"خیر"
            ,"اطلاعات ناقص")){
               return false;
           }
        }

        if(getSelectedWorkGroupList().isEmpty()){
            //todo bundle
            if(!DialogUtil.showYesNOQuestionDialog(this
                    ,"گروه کاری مرتبط با این کاربر انتخاب نشده است، آیا ادامه می دهید؟"
                    ,"بله"
                    ,"خیر"
                    ,"اطلاعات ناقص")){
                return false;
            }
        }

        if(getSelectedPCList().isEmpty()){
            //todo bundle
            if(!DialogUtil.showYesNOQuestionDialog(this
                    ,"رایانه مرتبط با این کاربر انتخاب نشده است، آیا ادامه می دهید؟"
                    ,"بله"
                    ,"خیر"
                    ,"اطلاعات ناقص")){
                return false;
            }
        }

        return true;
    }

    private void save(){
        if(!validateForm()){
            return;
        }

       // user.setUsername(panel.textFieldUserName.getText());
       // user.setEnable(panel.checkBoxStatus.isSelected() ? "1" : "0");
       // user.setPassword(Arrays.toString(panel.textFieldUserPassword.getPassword()));
        user.setPcs(getSelectedPCList());
        user.setWorkGroups(getSelectedWorkGroupList());
        user.setPerson(getSelectedPerson());

        user.setDeleted("0");
        user.setEffectorUser(ThreadPoolManager.me.getUsername());
        user.setCurrentLang(ThreadPoolManager.currentLanguage);
        userService.setServiceName("/editUser");
        boolean success = false;

        try {
            success = new ObjectMapper().readValue(new RESTfulClientUtil().restFullService(userService.getServerUrl()
                    , userService.getServiceName()
                    , new ObjectMapper().writeValueAsString(this.user))
                    , Boolean.class);
        } catch (IOException e) {
            e.printStackTrace();
        }

        if (success) {
            //todo read from bundle
            //ThreadPoolManager.getLangValue("TMS_WORKGROUP_EDIT")
            DialogUtil.showOKDialog(this
                    , "ویرایش  کاربر با موفقیت انجام شد"
                    , "اطلاع رسانی"
            );
            showUserManagementAndExit();
        } else {
            //todo read from bundle
            DialogUtil.showErrorDialog(this
                    , "ویرایش کاربر با خطا مواجه شد"
                    , "خطای سیستمی"
            );
        }

    }

    private Person getSelectedPerson() {
        if(panel.tablePerson.getSelectedRow() == -1){
           return null;
        }
        return personList.get(panel.tablePerson.convertRowIndexToModel(panel.tablePerson.getSelectedRow()));
    }

    protected void showUserManagementAndExit() {
        UserManagementCode userManagement = new UserManagementCode();
        userManagement.setVisible(true);
        ThreadPoolManager.mainForm.getDesktopPane().add(userManagement);
        try {
            userManagement.setSelected(true);
        } catch (Exception e) {
            e.printStackTrace();
        }
        dispose();
    }

    private class UserMembershipManagementDesignPanel extends  UserMembershipManagementDesign {

        @Override
        protected void cancelActionPerformed() {
            showUserManagementAndExit();
        }

        @Override
        protected void saveActionPerformed() {
            save();

        }
    }
}
