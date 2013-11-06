package ir.university.toosi.tms.view.role;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import ir.university.toosi.tms.model.entity.LanguageManagement;
import ir.university.toosi.tms.model.entity.Operation;
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
import java.util.HashSet;
import java.util.List;
import java.util.Set;


public class RoleCode extends TMSInternalFrame {
    private RolePanel panel = null;
    private Role role= null;
    private WebServiceInfo roleService = new WebServiceInfo();
    private WebServiceInfo languageService = new WebServiceInfo();
    private WebServiceInfo operationService = new WebServiceInfo();
    private java.util.List<Operation> operationList;
    private boolean newMode;


    public RoleCode(Role role){
        super();
        this.role = role;
        newMode = role == null;

        panel = new RolePanel();
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
            e.printStackTrace();
        }
        //todo correct titles
        if (newMode) {
            //this.setTitle(ThreadPoolManager.getLangValue("TMS_WORKGROUP_DEFINE"));
            //panel.buttonOK.setText(ThreadPoolManager.getLangValue("TMS_ADD"));
            this.setTitle("تعریف نقش جدید");
            panel.buttonSave.setText("ذخیره");
        } else {
            //this.setTitle(ThreadPoolManager.getLangValue("TMS_WORKGROUP_EDIT"));
            //panel.buttonOK.setText(ThreadPoolManager.getLangValue("TMS_EDIT"));
            this.setTitle("ویرایش نقش");
            panel.buttonSave.setText("ذخیره");
        }

        if (!newMode) {
            assert role!= null;
            panel.textFieldDescription.setText(role.getDescShow());
            panel.checkBoxActive.setSelected(role.isEnabled());
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

        if(!newMode){
           operationList = fillSelectedOperations();
        }

        org.jdesktop.swingbinding.JTableBinding jTableBinding = org.jdesktop.swingbinding.SwingBindings.createJTableBinding(org.jdesktop.beansbinding.AutoBinding.UpdateStrategy.READ_WRITE, operationList, panel.mainTable, "");
//         columnBinding = jTableBinding.addColumnBinding(org.jdesktop.beansbinding.ELProperty.create("${name}"));
//        columnBinding.setColumnName(ThreadPoolManager.getLangValue("TMS_NAME"));
//        columnBinding.setColumnClass(String.class);
        JTableBinding.ColumnBinding columnBinding = jTableBinding.addColumnBinding(org.jdesktop.beansbinding.ELProperty.create("${description}"));
        columnBinding.setColumnName(ThreadPoolManager.getLangValue("TMS_DESC"));
        columnBinding.setEditable(false);
        columnBinding.setColumnClass(String.class);
        columnBinding = jTableBinding.addColumnBinding(org.jdesktop.beansbinding.ELProperty.create("${selected}"));
        columnBinding.setColumnName("تخصیص");
        columnBinding.setColumnClass(Boolean.class);
        BindingGroup bindingGroup = new BindingGroup();
        bindingGroup.addBinding(jTableBinding);
        jTableBinding.bind();

        ComponentUtil.SetJTableAlignment(panel.mainTable,ThreadPoolManager.direction);
        panel.mainTable.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        panel.mainTable.getTableHeader().setReorderingAllowed(false);
        panel.mainTable.setColumnSelectionAllowed(false);

    }

    private List<Operation> fillSelectedOperations() {
        for(Operation roleOperation :  role.getOperations()){
            for(Operation tableOperations :  operationList){
                if(roleOperation.getId() == tableOperations.getId()){
                    tableOperations.setSelected(true);
                    break;
                }
            }
        }
        return operationList;
    }

    public Set<Operation> getSelectedOperationList(){
        Set<Operation> selectedOperationList = new HashSet<>();
        for(Operation tableOperation :  operationList){
            if(tableOperation.isSelected()){
                selectedOperationList.add(tableOperation);
            }
        }
        return selectedOperationList;
    }

    private boolean validateForm() {
        if(panel.textFieldDescription.getText().trim().isEmpty()){
            DialogUtil.showErrorDialog(this
                    , "لطفا برای نقش، عنوان مناسب انتخاب نمائید."
                    , "خطای ورودی"
            );
            panel.textFieldDescription.selectAll();
            panel.textFieldDescription.requestFocus();
            return false;
        }
        return true;
    }

    protected void showRoleManagementAndExit() {
        RoleManagementCode roleManagementCode = new RoleManagementCode();
        roleManagementCode.setVisible(true);
        ThreadPoolManager.mainForm.getDesktopPane().add(roleManagementCode);
        try{
            roleManagementCode.setSelected(true);
        }catch(Exception e){
            e.printStackTrace();
        }
        dispose();
    }

    private void reloadLanguageKeys() {
       /* languageService.setServiceName("/loadLanguage");
        try {
            ThreadPoolManager.langHash = new ObjectMapper().readValue(new RESTfulClientUtil().restFullServiceString(languageService.getServerUrl()
                    , languageService.getServiceName()
                    , ThreadPoolManager.currentLanguage.getName())
                    , new TypeReference<Hashtable<String, LanguageManagement>>() {
            });

        } catch (IOException e) {
            e.printStackTrace();
        }*/
        LanguageManagement languageManagement = new LanguageManagement();
        languageManagement.setTitle(panel.textFieldDescription.getText());
        languageManagement.setType(ThreadPoolManager.currentLanguage);
        ThreadPoolManager.langHash.put(role.getDescription(), languageManagement);
    }

    public void addRole() {
        if(!validateForm()){
            return;
        }

        Role newRole = new Role();
//        newRole.setName(roleName.getText());
//        newRole.setDescription(roleDesc.getText());
        newRole.setDescText(panel.textFieldDescription.getText());
        newRole.setEnabled(panel.checkBoxActive.isSelected());
        newRole.setOperations(getSelectedOperationList());

        newRole.setDeleted("0");
        newRole.setEffectorUser(ThreadPoolManager.me.getUsername());
        newRole.setCurrentLang(ThreadPoolManager.currentLanguage);
        roleService.setServiceName("/createRole");
        boolean success = false;
        try {
            role = new ObjectMapper().readValue(new RESTfulClientUtil().restFullService(roleService.getServerUrl()
                    , roleService.getServiceName()
                    , new ObjectMapper().writeValueAsString(newRole))
                    , Role.class);
            success = role != null;
        } catch (IOException e) {
            e.printStackTrace();
        }

        if(success){
            reloadLanguageKeys();
            //todo read from bundle
            //ThreadPoolManager.getLangValue("TMS_WORKGROUP_EDIT")
            DialogUtil.showOKDialog(this
                    ,"ثبت نقش جدید با موفقیت انجام شد."
                    , "اطلاع رسانی"
            );
            showRoleManagementAndExit();
        }else{
            //todo read from bundle
            DialogUtil.showErrorDialog(this
                    ,"ایجاد نقش جدید با خطا مواجه شد."
                    , "خطای سیستمی"
            );
        }

    }

    public void editRole() {
        if(!validateForm()){
            return;
        }

        role.setDescText(panel.textFieldDescription.getText());
        role.setEnabled(panel.checkBoxActive.isSelected());
        role.setOperations(getSelectedOperationList());

        role.setDeleted("0");
        role.setEffectorUser(ThreadPoolManager.me.getUsername());
        role.setCurrentLang(ThreadPoolManager.currentLanguage);
        roleService.setServiceName("/editRole");

        boolean success = false;

        try {
            success = new ObjectMapper().readValue(new RESTfulClientUtil().restFullService(roleService.getServerUrl()
                    , roleService.getServiceName()
                    , new ObjectMapper().writeValueAsString(role))
                    , Boolean.class);
        } catch (IOException e) {
            e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
        }


        /*try {
            String result= new ObjectMapper().readValue(new RESTfulClientUtil().restFullService(roleService.getServerUrl()
                    , roleService.getServiceName()
                    , new ObjectMapper().writeValueAsString(role))
                    , String.class);
            success = result.equalsIgnoreCase("true");

        } catch (IOException e) {
            e.printStackTrace();
        }*/
        if(success){
            reloadLanguageKeys();
            //todo read from bundle
            //ThreadPoolManager.getLangValue("TMS_WORKGROUP_EDIT")
            JOptionPane.showMessageDialog(this
                    , "ویرایش نقش با موفقیت انجام شد."
                    , "پیغام"
                    ,JOptionPane.INFORMATION_MESSAGE);
            showRoleManagementAndExit();
        }else{
            //todo read from bundle
            JOptionPane.showMessageDialog(this,
                    "ویرایش نقش با خطا مواجه شد.",
                    "خطا",
                    JOptionPane.ERROR_MESSAGE);
        }

    }



    class RolePanel extends RoleDesign {

        @Override
        void saveActionPerformed() {
            if(newMode){
                addRole();
            }else{
                editRole();
            }
        }

        @Override
        void cancelActionPerformed() {
            showRoleManagementAndExit();
        }
    }
}
