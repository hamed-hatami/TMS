package ir.university.toosi.tms.view.pc;


import com.fasterxml.jackson.databind.ObjectMapper;
import ir.university.toosi.tms.model.entity.PC;
import ir.university.toosi.tms.model.entity.WebServiceInfo;
import ir.university.toosi.tms.util.ComponentUtil;
import ir.university.toosi.tms.util.DialogUtil;
import ir.university.toosi.tms.util.RESTfulClientUtil;
import ir.university.toosi.tms.util.ThreadPoolManager;
import ir.university.toosi.tms.view.TMSInternalFrame;
import java.awt.*;
import java.io.IOException;

/**
 * @author a_hadadi
 */
public class PCCode extends TMSInternalFrame {

    private PCPanel panel = null;
    private PC pc;
    private boolean isNewPC = false;
    private WebServiceInfo pcService = new WebServiceInfo();

    public PCCode(PC pc) {
        super();
        this.isNewPC = null == pc;
        this.pc = pc;

        panel = new PCPanel();
        panel.setLocation(0, 0);
        panel.setSize(panel.getPreferredSize());
        panel.setVisible(true);
        this.add(panel);

        Font tahoma = new Font("Tahoma", Font.PLAIN, 12);
        ComponentUtil.setFont(panel, tahoma, ThreadPoolManager.direction);

        setLayout(null);
        getContentPane().setBackground(Color.getColor("Control"));


        //this.addInternalFrameListener(ThreadPoolManager.mainForm);
        setTitle(ThreadPoolManager.getLangValue("TMS_PC"));
        panel.labelPCName.setText(ThreadPoolManager.getLangValue("TMS_NAME"));
        panel.labelIP.setText(ThreadPoolManager.getLangValue("TMS_IP"));
        panel.labelPhisicalPlace.setText(ThreadPoolManager.getLangValue("TMS_LOCATION"));
        panel.buttonCancel.setText(ThreadPoolManager.getLangValue("TMS_CANCEL"));
        panel.buttonSave.setText(ThreadPoolManager.getLangValue("TMS_OK"));
       // panel.buttonSave.setEnabled(ThreadPoolManager.hasPermission("OK_PC"));todo

        if (isNewPC) {
            //this.setTitle(ThreadPoolManager.getLangValue("TMS_WORKGROUP_DEFINE"));
            //panel.buttonOK.setText(ThreadPoolManager.getLangValue("TMS_ADD"));
            this.setTitle("تعریف رایانه جدید");
            panel.buttonSave.setText("ذخیره");
        } else {
            //this.setTitle(ThreadPoolManager.getLangValue("TMS_WORKGROUP_EDIT"));
            //panel.buttonOK.setText(ThreadPoolManager.getLangValue("TMS_EDIT"));
            this.setTitle("ویرایش رایانه");
            panel.buttonSave.setText("ذخیره");

            panel.textFieldIP.setText(pc.getIp());
            panel.textFieldPhisicalPlace.setText(pc.getLocation());
            panel.textFieldPCName.setText(pc.getName());

           /* panel.textFieldIP.setEditable(false);
            panel.textFieldIP.setBackground(Color.GRAY);
*/

        }


    }

    private boolean validateForm() {

        if (panel.textFieldPCName.getText().trim().isEmpty()) {
            DialogUtil.showErrorDialog(this
                    , "لطفا نام رایانه را انتخاب نمائید"
                    , "خطای ورودی"
            );
            panel.textFieldPCName.selectAll();
            panel.textFieldPCName.requestFocus();
            return false;
        }

        if (panel.textFieldIP.getText().trim().isEmpty()) {
            DialogUtil.showErrorDialog(this
                    , "لطفا شناسه شبکه رایانه را وارد نمائید."
                    , "خطای ورودی"
            );
            panel.textFieldIP.selectAll();
            panel.textFieldIP.requestFocus();
            return false;
        }

        if (panel.textFieldPhisicalPlace.getText().trim().isEmpty()) {
            DialogUtil.showErrorDialog(this
                    , "لطفا مکان فیزیکی رایانه را وارد نمائید."
                    , "خطای ورودی"
            );
            panel.textFieldPhisicalPlace.selectAll();
            panel.textFieldPhisicalPlace.requestFocus();
            return false;
        }


       /* if (isNewPC) {
            //check unique username
            pcService.setServiceName("/findUserByUserName");
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
        }*/

        return true;//all checks passed
    }

    private void addPC() {
        if (!validateForm()) {
            return;
        }

        PC newPC = new PC();
        newPC.setName(panel.textFieldPCName.getText());
        newPC.setIp(panel.textFieldIP.getText());
        newPC.setLocation(panel.textFieldPhisicalPlace.getText());
        newPC.setDeleted("0");
        newPC.setEffectorUser(ThreadPoolManager.me.getUsername());

        pcService.setServiceName("/createPC");
        boolean success = false;
        try {
           pc = new ObjectMapper().readValue(new RESTfulClientUtil().restFullService(pcService.getServerUrl()
                    , pcService.getServiceName()
                    , new ObjectMapper().writeValueAsString(newPC))
                    , PC.class);
            success = pc != null;
        } catch (IOException e) {
            e.printStackTrace();
        }



        if (success) {
            //todo read from bundle
            //ThreadPoolManager.getLangValue("TMS_WORKGROUP_EDIT")
            DialogUtil.showOKDialog(this
                    , "ایجاد رایانه با موفقیت انجام شد"
                    , "اطلاع رسانی"
            );
            showPCManagementAndExit();
        } else {
            //todo read from bundle
            DialogUtil.showErrorDialog(this
                    , "ایجاد رایانه با خطا مواجه شد"
                    , "خطای سیستمی"
            );
        }

    }

    private void editPC() {

        if (!validateForm()) {
            return;
        }
        pc.setName(panel.textFieldPCName.getText());
        pc.setIp(panel.textFieldIP.getText());
        pc.setLocation(panel.textFieldPhisicalPlace.getText());
        pc.setDeleted("0");
        pc.setEffectorUser(ThreadPoolManager.me.getUsername());

        pcService.setServiceName("/editPC");

        try {
            new ObjectMapper().readValue(new RESTfulClientUtil().restFullService(pcService.getServerUrl(), pcService.getServiceName(), new ObjectMapper().writeValueAsString(pc)), Boolean.class);
        } catch (IOException e) {
            e.printStackTrace();
        }


        boolean success = false;

        try {
            success = new ObjectMapper().readValue(new RESTfulClientUtil().restFullService(pcService.getServerUrl()
                    , pcService.getServiceName()
                    , new ObjectMapper().writeValueAsString(this.pc))
                    , Boolean.class);
        } catch (IOException e) {
            e.printStackTrace();
        }

        if (success) {
            //todo read from bundle
            //ThreadPoolManager.getLangValue("TMS_WORKGROUP_EDIT")
            DialogUtil.showOKDialog(this
                    , "ویرایش  رایانه با موفقیت انجام شد"
                    , "اطلاع رسانی"
            );
            showPCManagementAndExit();
        } else {
            //todo read from bundle
            DialogUtil.showErrorDialog(this
                    , "ویرایش رایانه با خطا مواجه شد"
                    , "خطای سیستمی"
            );
        }
    }

    protected void showPCManagementAndExit() {
        PCManagementCode pcManagement = new PCManagementCode();
        pcManagement.setVisible(true);
        ThreadPoolManager.mainForm.getDesktopPane().add(pcManagement);
        try {
            pcManagement.setSelected(true);
        } catch (Exception e) {
            e.printStackTrace();
        }
        dispose();
    }

    class PCPanel extends PCDesign {

        @Override
        protected void cancelActionPerformed() {
            showPCManagementAndExit();
        }

        @Override
        protected void saveActionPerformed() {
            if (isNewPC) {
                addPC();

            } else {
                editPC();
            }
        }
    }


}