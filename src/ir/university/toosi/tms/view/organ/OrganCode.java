package ir.university.toosi.tms.view.organ;


import com.fasterxml.jackson.databind.ObjectMapper;
import ir.university.toosi.tms.model.entity.*;
import ir.university.toosi.tms.model.entity.personnel.Organ;
import ir.university.toosi.tms.util.ComponentUtil;
import ir.university.toosi.tms.util.DialogUtil;
import ir.university.toosi.tms.util.RESTfulClientUtil;
import ir.university.toosi.tms.util.ThreadPoolManager;
import ir.university.toosi.tms.view.TMSInternalFrame;
import ir.university.toosi.tms.view.user.UserManagementCode;

import java.awt.*;
import java.io.IOException;
import java.util.HashSet;
import java.util.Set;

/**
 * @author a_hadadi
 */
public class OrganCode extends TMSInternalFrame {

    private UserAddPanel panel = null;
    private Organ organ;
    private boolean isNewOrgan = false;
    private WebServiceInfo organService = new WebServiceInfo();

    public OrganCode(Organ organ) {
        super();
        this.isNewOrgan = null == organ;
        this.organ = organ;

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

        panel.labelOrganName.setText("نام سازمان");//todo ThreadPoolManager.getLangValue("TMS_OrganNAME")
        panel.labelOrganCode.setText("کد سازمان");
        panel.labelOrganTitle.setText("عنوان سازمان");
        panel.labelOrganType.setText("نوع سازمان");

        panel.buttonCancel.setText(ThreadPoolManager.getLangValue("TMS_CANCEL"));
        panel.buttonSave.setText(ThreadPoolManager.getLangValue("TMS_OK"));


        if (isNewOrgan) {
            //this.setTitle(ThreadPoolManager.getLangValue("TMS_WORKGROUP_DEFINE"));
            //panel.buttonOK.setText(ThreadPoolManager.getLangValue("TMS_ADD"));
            this.setTitle("تعریف سازمان جدید");
            panel.buttonSave.setText("ذخیره");
        } else {
            //this.setTitle(ThreadPoolManager.getLangValue("TMS_WORKGROUP_EDIT"));
            //panel.buttonOK.setText(ThreadPoolManager.getLangValue("TMS_EDIT"));
            this.setTitle("ویرایش سازمان");
            panel.buttonSave.setText("ذخیره");

            panel.textFieldOrganName.setEditable(false);
            panel.textFieldOrganName.setBackground(Color.GRAY);

            panel.textFieldOrganName.setText(organ != null ? organ.getName() : "");
            panel.textFieldOrganCode.setText(organ != null ? organ.getCode() : "");
            panel.textFieldOrganTitle.setText(organ != null ? organ.getTitle() : "");
           // panel.comboBoxOrganType.setSelectedItem();//todo
        }


    }

    private boolean validateForm() {

        if (panel.textFieldOrganCode.getText().trim().isEmpty()) {
            DialogUtil.showErrorDialog(this
                    , "لطفا نام سازمان را وارد نمائید."
                    , "خطای ورودی"
            );
            panel.textFieldOrganName.selectAll();
            panel.textFieldOrganName.requestFocus();
            return false;
        }


        if (isNewOrgan) {
            //check unique username
            organService.setServiceName("/findOrganByOrganName");
            Organ testOrgan = new Organ();
            testOrgan.setName(panel.textFieldOrganName.getText().trim());
            try {
                testOrgan = new ObjectMapper().readValue(new RESTfulClientUtil().restFullServiceString(organService.getServerUrl()
                        , organService.getServiceName()
                        , panel.textFieldOrganName.getText().trim())
                        , Organ.class);
            } catch (IOException e) {
                e.printStackTrace();
            }

            if (testOrgan.getName() != null) {
                //todo bundle
                DialogUtil.showErrorDialog(this
                        , "این نام سازمان تکراری است."
                        , "خطای ورودی"
                );
                panel.textFieldOrganName.selectAll();
                panel.textFieldOrganName.requestFocus();
                return false;
            }
        }

        return true;//all checks passed
    }

    private void addOrgan() {
        if (!validateForm()) {
            return;
        }

        organ = new Organ();
//        newRole.setName(roleName.getText());
//        newRole.setDescription(roleDesc.getText());
        organ.setName(panel.textFieldOrganName.getText().trim());
        organ.setCode(panel.textFieldOrganCode.getText().trim());
        organ.setTitle(panel.textFieldOrganTitle.getText().trim());
        organ.setOrganType(selectedOrgan());


        organ.setDeleted("0");
        organ.setEffectorUser(ThreadPoolManager.me.getUsername());
        organ.setCurrentLang(ThreadPoolManager.currentLanguage);
        organService.setServiceName("/createOrgan");
        boolean success = false;
        try {
            organ = new ObjectMapper().readValue(new RESTfulClientUtil().restFullService(organService.getServerUrl()
                    , organService.getServiceName()
                    , new ObjectMapper().writeValueAsString(organ))
                    , Organ.class);
            success = organ != null;
        } catch (IOException e) {
            e.printStackTrace();
        }

        if (success) {
            //todo read from bundle
            //ThreadPoolManager.getLangValue("TMS_WORKGROUP_EDIT")
            DialogUtil.showOKDialog(this
                    , "ایجاد سازمان با موفقیت انجام شد"
                    , "اطلاع رسانی"
            );
            showOrganManagementAndExit();
        } else {
            //todo read from bundle
            DialogUtil.showErrorDialog(this
                    , "ایجاد سازمان با خطا مواجه شد"
                    , "خطای سیستمی"
            );
        }

    }

    private BLookup selectedOrgan() {
        return null;//todo
    }

    private void editOrgan() {
        if (!validateForm()) {
            return;
        }

        organ = new Organ();
//        newRole.setName(roleName.getText());
//        newRole.setDescription(roleDesc.getText());
        organ.setName(panel.textFieldOrganName.getText().trim());
        organ.setCode(panel.textFieldOrganCode.getText().trim());
        organ.setTitle(panel.textFieldOrganTitle.getText().trim());
        organ.setOrganType(selectedOrgan());


        organ.setDeleted("0");
        organ.setEffectorUser(ThreadPoolManager.me.getUsername());
        organ.setCurrentLang(ThreadPoolManager.currentLanguage);
        organService.setServiceName("/editOrgan");
        boolean success = false;
        try {
            organ = new ObjectMapper().readValue(new RESTfulClientUtil().restFullService(organService.getServerUrl()
                    , organService.getServiceName()
                    , new ObjectMapper().writeValueAsString(organ))
                    , Organ.class);
            success = organ != null;
        } catch (IOException e) {
            e.printStackTrace();
        }

        if (success) {
            //todo read from bundle
            //ThreadPoolManager.getLangValue("TMS_WORKGROUP_EDIT")
            DialogUtil.showOKDialog(this
                    , "ویرایش سازمان با موفقیت انجام شد"
                    , "اطلاع رسانی"
            );
            showOrganManagementAndExit();
        } else {
            //todo read from bundle
            DialogUtil.showErrorDialog(this
                    , "ویرایش سازمان با خطا مواجه شد"
                    , "خطای سیستمی"
            );
        }

    }

    protected void showOrganManagementAndExit() {
        OrganManagementCode organManagement = new OrganManagementCode();
        organManagement.setVisible(true);
        ThreadPoolManager.mainForm.getDesktopPane().add(organManagement);
        try {
            organManagement.setSelected(true);
        } catch (Exception e) {
            e.printStackTrace();
        }
        dispose();
    }

    class UserAddPanel extends OrganDesign {

        @Override
        protected void cancelActionPerformed() {
            showOrganManagementAndExit();
        }

        @Override
        protected void saveActionPerformed() {

            if (isNewOrgan) {
                addOrgan();

            } else {
                editOrgan();
            }
        }
    }


}