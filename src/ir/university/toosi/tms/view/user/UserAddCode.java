package ir.university.toosi.tms.view.user;


import com.fasterxml.jackson.databind.ObjectMapper;
import ir.university.toosi.tms.model.entity.PC;
import ir.university.toosi.tms.model.entity.User;
import ir.university.toosi.tms.model.entity.WebServiceInfo;
import ir.university.toosi.tms.model.entity.WorkGroup;
import ir.university.toosi.tms.util.ComponentUtil;
import ir.university.toosi.tms.util.DialogUtil;
import ir.university.toosi.tms.util.RESTfulClientUtil;
import ir.university.toosi.tms.util.ThreadPoolManager;
import ir.university.toosi.tms.view.TMSInternalFrame;

import java.awt.*;
import java.io.IOException;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * @author a_hadadi
 */
public class UserAddCode extends TMSInternalFrame {

    private UserAddPanel panel = null;
    private User user;
    private boolean isNewUser = false;
    private WebServiceInfo userService = new WebServiceInfo();

    public UserAddCode(User user) {
        super();
        this.isNewUser = null == user;
        this.user = user;

        panel = new UserAddPanel();
        panel.setLocation(0, 0);
        panel.setSize(panel.getPreferredSize());
        panel.setVisible(true);
        this.add(panel);

        Font tahoma = new Font("Tahoma", Font.PLAIN, 12);
        ComponentUtil.setFont(panel, tahoma, ThreadPoolManager.direction);

        setLayout(null);
        getContentPane().setBackground(Color.getColor("Control"));

        this.setTitle(ThreadPoolManager.getLangValue("TMS_USER"));
        panel.labelUserName.setText(ThreadPoolManager.getLangValue("TMS_USERNAME"));
        panel.labelUserPassword.setText(ThreadPoolManager.getLangValue("TMS_PASSWORD"));
        panel.labelStatus.setText(ThreadPoolManager.getLangValue("role_status"));

        panel.buttonCancel.setText(ThreadPoolManager.getLangValue("TMS_CANCEL"));
        panel.buttonSave.setText(ThreadPoolManager.getLangValue("TMS_OK"));


        if (isNewUser) {
            //this.setTitle(ThreadPoolManager.getLangValue("TMS_WORKGROUP_DEFINE"));
            //panel.buttonOK.setText(ThreadPoolManager.getLangValue("TMS_ADD"));
            this.setTitle("تعریف کاربر جدید");
            panel.buttonSave.setText("ذخیره");
        } else {
            //this.setTitle(ThreadPoolManager.getLangValue("TMS_WORKGROUP_EDIT"));
            //panel.buttonOK.setText(ThreadPoolManager.getLangValue("TMS_EDIT"));
            this.setTitle("ویرایش کاربر");
            panel.buttonSave.setText("ذخیره");

            panel.textFieldUserName.setEditable(false);
            panel.textFieldUserName.setBackground(Color.GRAY);

            panel.textFieldUserName.setText(user.getUsername());
            //panel.textFieldUserPassword.setText(user.getPassword());
            panel.textFieldUserPassword.setText("");
            panel.checkBoxStatus.setSelected(user.getEnable().equalsIgnoreCase("1"));
        }


    }

    private boolean validateForm() {

        if (panel.textFieldUserName.getText().trim().isEmpty()) {
            DialogUtil.showErrorDialog(this
                    , "لطفا نام کاربری مناسب وارد نمائید"
                    , "خطای ورودی"
            );
            panel.textFieldUserName.selectAll();
            panel.textFieldUserName.requestFocus();
            return false;
        }

        if (panel.textFieldUserPassword.getPassword().length == 0) {
            DialogUtil.showErrorDialog(this
                    , "لطفا رمز عبور مناسب وارد نمائید"
                    , "خطای ورودی"
            );
            panel.textFieldUserPassword.selectAll();
            panel.textFieldUserPassword.requestFocus();
            return false;
        }


        if (isNewUser) {
            //check unique username
            userService.setServiceName("/findUserByUserName");
            User testUser = new User();
            testUser.setUsername(panel.textFieldUserName.getText());
            try {
                testUser = new ObjectMapper().readValue(new RESTfulClientUtil().restFullServiceString(userService.getServerUrl()
                        , userService.getServiceName()
                        , panel.textFieldUserName.getText())
                        , User.class);
            } catch (IOException e) {
                e.printStackTrace();
            }

            if (testUser.getUsername() != null) {
                //todo bundle
                DialogUtil.showErrorDialog(this
                        , "این نام کاربری تکراری است."
                        , "خطای ورودی"
                );
                panel.textFieldUserName.selectAll();
                panel.textFieldUserName.requestFocus();
                return false;
            }
        }

        return true;//all checks passed
    }

    private void addUser() {
        if (!validateForm()) {
            return;
        }

        user = new User();
//        newRole.setName(roleName.getText());
//        newRole.setDescription(roleDesc.getText());
        user.setUsername(panel.textFieldUserName.getText());
        user.setEnable(panel.checkBoxStatus.isSelected() ? "1" : "0");
       // user.setPassword(Arrays.toString(panel.textFieldUserPassword.getPassword()));
        user.setPassword(panel.textFieldUserPassword.getText());
        Set<PC> selectedPCs = new HashSet<>();
        user.setPcs(selectedPCs);
        Set<WorkGroup> selectedWorkGroups = new HashSet<>();
        user.setWorkGroups(selectedWorkGroups);

        user.setDeleted("0");
        user.setEffectorUser(ThreadPoolManager.me.getUsername());
        user.setCurrentLang(ThreadPoolManager.currentLanguage);
        userService.setServiceName("/createUser");
        boolean success = false;
        try {
            user = new ObjectMapper().readValue(new RESTfulClientUtil().restFullService(userService.getServerUrl()
                    , userService.getServiceName()
                    , new ObjectMapper().writeValueAsString(user))
                    , User.class);
            success = user != null;
        } catch (IOException e) {
            e.printStackTrace();
        }

        if (success) {
            //todo read from bundle
            //ThreadPoolManager.getLangValue("TMS_WORKGROUP_EDIT")
            DialogUtil.showOKDialog(this
                    , "ایجاد کاربر با موفقیت انجام شد"
                    , "اطلاع رسانی"
            );
            showUserManagementAndExit();
        } else {
            //todo read from bundle
            DialogUtil.showErrorDialog(this
                    , "ایجاد کاربر با خطا مواجه شد"
                    , "خطای سیستمی"
            );
        }

    }

    private void editUser() {

        if (!validateForm()) {
            return;
        }
//        newRole.setName(roleName.getText());
//        newRole.setDescription(roleDesc.getText());
        user.setUsername(panel.textFieldUserName.getText());
        user.setEnable(panel.checkBoxStatus.isSelected() ? "1" : "0");
       // user.setPassword(Arrays.toString(panel.textFieldUserPassword.getPassword()));
        user.setPassword(panel.textFieldUserPassword.getText());

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

    class UserAddPanel extends UserAddDesign {

        @Override
        protected void cancelActionPerformed() {
            showUserManagementAndExit();
        }

        @Override
        protected void saveActionPerformed() {

            if (isNewUser) {
                addUser();

            } else {
                editUser();
            }
        }
    }


}