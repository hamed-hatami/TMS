package ir.university.toosi.tms.view.organ;


import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import ir.university.toosi.tms.model.entity.*;
import ir.university.toosi.tms.model.entity.personnel.Organ;
import ir.university.toosi.tms.util.*;
import ir.university.toosi.tms.view.TMSInternalFrame;

import javax.swing.tree.TreePath;
import java.awt.*;
import java.io.IOException;
import java.util.*;
import java.util.List;

/**
 * @author a_hadadi
 */
public class OrganCode extends TMSInternalFrame {

    private UserAddPanel panel = null;
    private Organ currentOrgan;
    private Organ parentOfNewOrgan;
    private boolean isNewOrgan = false;
    private WebServiceInfo organService = new WebServiceInfo();
    private List<Object> comboItems;
    private List<BLookup> bLookups ;
    private TreePath expandedTreePath;

    public OrganCode(Organ organ,boolean isNewOrgan,TreePath expandedTreePath) {
        super();
        this.isNewOrgan = isNewOrgan;
        this.expandedTreePath = expandedTreePath;

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

        fillComboBoxItems();

        if (isNewOrgan) {
            //this.setTitle(ThreadPoolManager.getLangValue("TMS_WORKGROUP_DEFINE"));
            //panel.buttonOK.setText(ThreadPoolManager.getLangValue("TMS_ADD"));
            this.parentOfNewOrgan = organ;
            this.setTitle("تعریف سازمان جدید");
            panel.buttonSave.setText("ذخیره");
        } else {
            //this.setTitle(ThreadPoolManager.getLangValue("TMS_WORKGROUP_EDIT"));
            //panel.buttonOK.setText(ThreadPoolManager.getLangValue("TMS_EDIT"));
            this.currentOrgan = organ;
            this.setTitle("ویرایش سازمان");
            panel.buttonSave.setText("ذخیره");

            panel.textFieldOrganName.setEditable(false);
            panel.textFieldOrganName.setBackground(Color.GRAY);

            panel.textFieldOrganCode.setEditable(false);
            panel.textFieldOrganCode.setBackground(Color.GRAY);

            assert organ != null;
            panel.textFieldOrganName.setText(organ.getName() != null ? organ.getName() : "");
            panel.textFieldOrganCode.setText(organ.getCode() != null ? organ.getCode() : "");
            panel.textFieldOrganTitle.setText(organ.getTitle() != null ? organ.getTitle() : "");
            BLookup bLookup =  organ.getOrganType();
            panel.comboBoxOrganType.setSelectedItem(bLookup);
            for (int i = 0; i < panel.comboBoxOrganType.getModel().getSize(); i++) {
                Object element = panel.comboBoxOrganType.getModel().getElementAt(i);
                if (organ.getOrganType().getId() == ((BLookup)element).getId()) {
                    panel.comboBoxOrganType.setSelectedIndex(i);
                    break;
                }
            }
            //System.out.print(bLookup.toString());
        }



    }

    private void fillComboBoxItems() {
        organService.setServiceName("/getByLookupId");

        try {
            bLookups    = new ObjectMapper().readValue(new RESTfulClientUtil().restFullServiceString(
                    organService.getServerUrl()
                    , organService.getServiceName()
                    , String.valueOf(1l))
                    , new TypeReference<List<BLookup>>() {
            });
        } catch (IOException e) {
            e.printStackTrace();
        }
        comboItems = new ArrayList<>();
        for (BLookup currentBLookup : bLookups) {
            comboItems.add(currentBLookup);
        }
        panel.comboBoxOrganType.setModel(new javax.swing.DefaultComboBoxModel(comboItems.toArray()));
    }

    private boolean validateForm() {

        if (panel.textFieldOrganName.getText().trim().isEmpty()) {
            DialogUtil.showErrorDialog(this
                    , "لطفا نام سازمان را وارد نمائید."
                    , "خطای ورودی"
            );//todo bundle
            panel.textFieldOrganName.selectAll();
            panel.textFieldOrganName.requestFocus();
            return false;
        }

        if (panel.textFieldOrganCode.getText().trim().isEmpty()) {
            DialogUtil.showErrorDialog(this
                    , "لطفا کد سازمان را وارد نمائید."
                    , "خطای ورودی"
            );//todo bundle
            panel.textFieldOrganCode.selectAll();
            panel.textFieldOrganCode.requestFocus();
            return false;
        }

        if (panel.textFieldOrganTitle.getText().trim().isEmpty()) {
            DialogUtil.showErrorDialog(this
                    , "لطفا عنوان سازمان را وارد نمائید."
                    , "خطای ورودی"
            ); //todo bundle
            panel.textFieldOrganTitle.selectAll();
            panel.textFieldOrganTitle.requestFocus();
            return false;
        }

        if (isNewOrgan) {
            //check unique username
            organService.setServiceName("/existOrgan");
            Organ testOrgan = new Organ();
            testOrgan.setName(panel.textFieldOrganName.getText().trim());
            testOrgan.setCode(panel.textFieldOrganCode.getText().trim());
            boolean exists =false;
            try {
                String condition = new ObjectMapper().readValue(new RESTfulClientUtil().restFullService(
                        organService.getServerUrl()
                        , organService.getServiceName()
                        , new ObjectMapper().writeValueAsString(testOrgan))
                        , String.class);
                exists =  condition.equalsIgnoreCase("true");

            } catch (IOException e) {
                e.printStackTrace();
            }

            if (exists) {
                //todo bundle
                DialogUtil.showErrorDialog(this
                        , "نام یا کد سازمان تکراری است."
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

        currentOrgan = new Organ();
//        newRole.setName(roleName.getText());
//        newRole.setDescription(roleDesc.getText());
        currentOrgan.setName(panel.textFieldOrganName.getText().trim());
        currentOrgan.setCode(panel.textFieldOrganCode.getText().trim());
        currentOrgan.setTitle(panel.textFieldOrganTitle.getText().trim());
        currentOrgan.setOrganType(selectedOrganType());
        currentOrgan.setParentOrgan(parentOfNewOrgan);

        currentOrgan.setDeleted("0");
        currentOrgan.setEffectorUser(ThreadPoolManager.me.getUsername());
        currentOrgan.setCurrentLang(ThreadPoolManager.currentLanguage);
        organService.setServiceName("/createOrgan");
        boolean success = false;
        try {
            currentOrgan = new ObjectMapper().readValue(new RESTfulClientUtil().restFullService(organService.getServerUrl()
                    , organService.getServiceName()
                    , new ObjectMapper().writeValueAsString(currentOrgan))
                    , Organ.class);
            success = currentOrgan != null;
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

    private BLookup selectedOrganType() {
        BLookup selectedOrganType = (BLookup) panel.comboBoxOrganType.getSelectedItem();
        //System.out.println(selectedOrganType);
        return selectedOrganType;
    }

    private void editOrgan() {
        if (!validateForm()) {
            return;
        }

       // currentOrgan = new Organ();
//        newRole.setName(roleName.getText());
//        newRole.setDescription(roleDesc.getText());
        currentOrgan.setName(panel.textFieldOrganName.getText().trim());
        currentOrgan.setCode(panel.textFieldOrganCode.getText().trim());
        currentOrgan.setTitle(panel.textFieldOrganTitle.getText().trim());
        currentOrgan.setOrganType(selectedOrganType());


        currentOrgan.setDeleted("0");
        currentOrgan.setEffectorUser(ThreadPoolManager.me.getUsername());
        currentOrgan.setCurrentLang(ThreadPoolManager.currentLanguage);
        organService.setServiceName("/editOrgan");
        boolean success = false;

        try {
            String condition = new ObjectMapper().readValue(new RESTfulClientUtil().restFullService(
                    organService.getServerUrl()
                    , organService.getServiceName()
                    , new ObjectMapper().writeValueAsString(currentOrgan))
                    , String.class);
            success = condition.equalsIgnoreCase("true");
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
        OrganManagementCode organManagement = new OrganManagementCode(expandedTreePath);
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