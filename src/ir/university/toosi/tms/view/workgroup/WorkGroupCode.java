package ir.university.toosi.tms.view.workgroup;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import ir.university.toosi.tms.model.entity.LanguageManagement;
import ir.university.toosi.tms.model.entity.Role;
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
import javax.swing.table.TableColumnModel;
import java.awt.*;
import java.io.IOException;
import java.util.*;
import java.util.List;

/**
 * User: a_hadadi
 */
public class WorkGroupCode extends TMSInternalFrame {

    private boolean newMode;
    private WorkGroupPanel panel = null;
    private WebServiceInfo roleService = new WebServiceInfo();
    private WebServiceInfo workGroupService = new WebServiceInfo();
    private WebServiceInfo languageService = new WebServiceInfo();
    private List<Role> roleList = new ArrayList<>();
    private WorkGroup workGroup = new WorkGroup();

    WorkGroupCode(WorkGroup workGroup) {
        super();
        newMode = workGroup == null;
        this.workGroup  = workGroup;

        panel = new WorkGroupPanel();
        panel.setLocation(0, 0);
        panel.setSize(panel.getPreferredSize());
        panel.setVisible(true);
        setLayout(null);
        getContentPane().setBackground(Color.getColor("Control"));
        this.add(panel);


        //todo correct titles
        if (newMode) {
            //this.setTitle(ThreadPoolManager.getLangValue("TMS_WORKGROUP_DEFINE"));
            //panel.buttonOK.setText(ThreadPoolManager.getLangValue("TMS_ADD"));
            this.setTitle("تعریف گروه کاری جدید");
            panel.buttonOK.setText("ذخیره");
        } else {
            //this.setTitle(ThreadPoolManager.getLangValue("TMS_WORKGROUP_EDIT"));
            //panel.buttonOK.setText(ThreadPoolManager.getLangValue("TMS_EDIT"));
            this.setTitle("ویرایش گروه کاری");
            panel.buttonOK.setText("ذخیره");
        }
        //panel.panelRole.setBorder(BorderFactory.createTitledBorder(ThreadPoolManager.getLangValue("TMS_ROLE_LIST")));
        panel.panelRole.setBorder(BorderFactory.createTitledBorder("لیست نقش ها"));
        panel.tableRole.setAutoCreateRowSorter(true);
        panel.buttonCancel.setText(ThreadPoolManager.getLangValue("TMS_CANCEL"));
       // panel.labelDescription.setText(ThreadPoolManager.getLangValue("TMS_Description"));
        panel.labelDescription.setText("عنوان گروه کاری");
       // panel.checkBoxActive.setText(ThreadPoolManager.getLangValue("TMS_ACTIVE"));
        panel.checkBoxActive.setText("فعال");

        if (!newMode) {
            assert workGroup != null;
            panel.textFieldDescription.setText(workGroup.getDescShow());
            panel.checkBoxActive.setSelected(workGroup.getEnabled().equalsIgnoreCase("1"));
        }

        try {
            loadInfo();
            Font tahoma = new Font("Tahoma", Font.PLAIN, 12);
            ComponentUtil.setFont(panel, tahoma, ThreadPoolManager.direction);
            // this.changeComonentOrientation(ThreadPoolManager.direction);
            ComponentUtil.SetJTableAlignment(panel.tableRole, ThreadPoolManager.direction);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void loadInfo() throws IOException {
        roleService.setServiceName("/getAllRole");
        roleList = new ObjectMapper().readValue(new RESTfulClientUtil().restFullService(roleService.getServerUrl(), roleService.getServiceName()), new TypeReference<List<Role>>() {
        });

        if(!newMode){
           roleList = fillSelectedRole();
        }
        JTableBinding jTableBinding = SwingBindings.createJTableBinding(AutoBinding.UpdateStrategy.READ_WRITE, roleList, panel.tableRole, "");

        JTableBinding.ColumnBinding columnBinding = jTableBinding.addColumnBinding(org.jdesktop.beansbinding.ELProperty.create("${descShow}"));
        columnBinding.setColumnName(ThreadPoolManager.getLangValue("TMS_DESC"));
        columnBinding.setColumnClass(String.class);
        columnBinding.setEditable(false);

        columnBinding = jTableBinding.addColumnBinding(org.jdesktop.beansbinding.ELProperty.create("${selected}"));
        //columnBinding.setColumnName(ThreadPoolManager.getLangValue("TMS_SELECTED"));
        columnBinding.setColumnName("تخصیص");
        columnBinding.setColumnClass(Boolean.class);
        columnBinding.setEditable(true);

        BindingGroup bindingGroup = new BindingGroup();
        bindingGroup.addBinding(jTableBinding);
        jTableBinding.bind();

        ComponentUtil.SetJTableAlignment(panel.tableRole,ThreadPoolManager.direction);
        panel.tableRole.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        panel.tableRole.getTableHeader().setReorderingAllowed(false);
        panel.tableRole.setColumnSelectionAllowed(false);
       /* panel.tableRole.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
        panel.tableRole.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
        panel.tableRole.getColumnModel().getColumn(0).setPreferredWidth(150);
        panel.tableRole.getColumnModel().getColumn(0).setMinWidth(150);
        panel.tableRole.getColumnModel().getColumn(0).setWidth(150);
        panel.tableRole.getColumnModel().getColumn(1).setPreferredWidth(150);
        panel.tableRole.getColumnModel().getColumn(1).setMinWidth(150);
        panel.tableRole.getColumnModel().getColumn(1).setWidth(150);*/
    }

    private List<Role> fillSelectedRole() {
        for(Role wgRole :  workGroup.getRoles()){
            for(Role tableRole :  roleList){
                if(wgRole.getId() == tableRole.getId()){
                    tableRole.setSelected(true);
                    break;
                }
            }
        }
        return roleList;
    }

    public void addWorkGroup() {
        if(!validateForm()){
            return;
        }
        WorkGroup newWorkGroup;
        newWorkGroup = new WorkGroup();
        newWorkGroup.setEnabled(panel.checkBoxActive.isSelected() ? "1" : "0");
        newWorkGroup.setDescText(panel.textFieldDescription.getText());
        newWorkGroup.setRoles(getSelectedRoleList());
        newWorkGroup.setCurrentLang(ThreadPoolManager.currentLanguage);
        newWorkGroup.setDeleted("0");
        newWorkGroup.setEffectorUser(ThreadPoolManager.me.getUsername());


        workGroupService.setServiceName("/createWorkGroup");
        boolean success = false;
        try {
            workGroup=  new ObjectMapper().readValue(new RESTfulClientUtil().restFullService(workGroupService.getServerUrl()
                    , workGroupService.getServiceName()
                    , new ObjectMapper().writeValueAsString(newWorkGroup))
                    , WorkGroup.class);
            success = workGroup != null;
        } catch (IOException e) {
            e.printStackTrace();
        }
        if(success){
            reloadLanguageKeys();
            //todo read from bundle
            //ThreadPoolManager.getLangValue("TMS_WORKGROUP_EDIT")
            DialogUtil.showOKDialog(this
                    ,"ثبت گروه کاری جدید با موفقیت انجام شد"
                    , "اطلاع رسانی"
            );
            showWorkGroupManagementAndExit();
        }else{
            //todo read from bundle
            DialogUtil.showErrorDialog(this
                    ,"ایجاد گروه کاری جدید با خطا مواجه شد"
                    , "خطای سیستمی"
            );
        }

    }

    private boolean validateForm() {
        if(panel.textFieldDescription.getText().trim().isEmpty()){
            DialogUtil.showErrorDialog(this
                    ,"لطفا برای گروه کاری، عنوان مناسب انتخاب نمائید"
                    , "خطای ورودی"
            );
            panel.textFieldDescription.selectAll();
            panel.textFieldDescription.requestFocus();
            return false;
        }
        return true;
    }

    protected void showWorkGroupManagementAndExit() {
        WorkGroupManagementCode workGroupManagement = new WorkGroupManagementCode();
        workGroupManagement.setVisible(true);
        ThreadPoolManager.mainForm.getDesktopPane().add(workGroupManagement);
        try{
            workGroupManagement.setSelected(true);
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
        ThreadPoolManager.langHash.put(workGroup.getDescription(), languageManagement);

    }

    public void editWorkGroup() {
       if(!validateForm()){
          return;
       }

        workGroup.setEnabled(panel.checkBoxActive.isSelected() ? "1" : "0");
        //workGroup.setDescription(panel.textFieldDescription.getText());
        //workGroup.setDescShow(panel.textFieldDescription.getText());
        workGroup.setDescText(panel.textFieldDescription.getText());
        workGroup.setRoles(getSelectedRoleList());
        workGroup.setEffectorUser(ThreadPoolManager.me.getUsername());
        workGroup.setEffectorUser(ThreadPoolManager.me.getUsername());
        workGroup.setCurrentLang(ThreadPoolManager.currentLanguage);

        workGroupService.setServiceName("/editWorkGroup");
        boolean success = false;
        try {
           String result= new ObjectMapper().readValue(new RESTfulClientUtil().restFullService(workGroupService.getServerUrl()
                    , workGroupService.getServiceName()
                    , new ObjectMapper().writeValueAsString(workGroup))
                    , String.class);
            success = result.equalsIgnoreCase("true");

        } catch (IOException e) {
            e.printStackTrace();
        }
        if(success){
            reloadLanguageKeys();
            //todo read from bundle
            //ThreadPoolManager.getLangValue("TMS_WORKGROUP_EDIT")
            JOptionPane.showMessageDialog(this
                    , "ویرایش گروه کاری با موفقیت انجام شد"
                    , "پیغام"
                    ,JOptionPane.INFORMATION_MESSAGE);
            showWorkGroupManagementAndExit();
        }else{
            //todo read from bundle
            JOptionPane.showMessageDialog(this,
                    "ویرایش گروه کاری با خطا مواجه شد",
                    "خطا",
                    JOptionPane.ERROR_MESSAGE);
        }

    }

    public Set<Role> getSelectedRoleList(){
        Set<Role> selectedRoleList = new HashSet<>();
            for(Role tableRole :  roleList){
                if(tableRole.isSelected()){
                    selectedRoleList.add(tableRole);
                }
            }
        return selectedRoleList;
    }

    class WorkGroupPanel extends WorkGroupDesign {
        @Override
        protected void buttonOKActionPerformed() {
            if(newMode){
                addWorkGroup();
            }else{
                editWorkGroup();
            }

        }

        @Override
        protected void buttonCancelActionPerformed() {
            showWorkGroupManagementAndExit();
        }
    }

}
