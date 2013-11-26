package ir.university.toosi.tms.view.person;

import com.fasterxml.jackson.databind.ObjectMapper;
import ir.university.toosi.tms.model.entity.WebServiceInfo;
import ir.university.toosi.tms.model.entity.personnel.Person;
import ir.university.toosi.tms.util.*;
import ir.university.toosi.tms.util.ImageUtil.ImageUtils;
import ir.university.toosi.tms.view.TMSInternalFrame;

import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

/**
 * @author a_hadadi
 */
public class PersonCode extends TMSInternalFrame {

    private PersonPanel panel = null;
    private Person person = null;
    private WebServiceInfo personService = new WebServiceInfo();
    private boolean newMode;
    private File sourceFile = null;
    private String prop_openDirectory = "";
    private BufferedImage sourceBufferedImage = null;

    public PersonCode(Person person) {
        super();
        this.person = person;
        newMode = person == null;

        panel = new PersonPanel();
        panel.setLocation(0, 0);
        panel.setSize(panel.getPreferredSize());
        panel.setVisible(true);
        setLayout(null);
        getContentPane().setBackground(Color.getColor("Control"));
        this.add(panel);


        setTitle(ThreadPoolManager.getLangValue("TMS_PERSONNEL_INFO"));


        panel.panelInfo.setBorder(javax.swing.BorderFactory.createTitledBorder(ThreadPoolManager.getLangValue("TMS_PERSONNEL_INFO")));
        panel.labelName.setText(ThreadPoolManager.getLangValue("TMS_NAME"));
        panel.labelLastName.setText(ThreadPoolManager.getLangValue("LAST_NAME"));
        panel.labelPersonelID.setText(ThreadPoolManager.getLangValue("TMS_PERSONNEL_NO"));
        panel.labelNationalCode.setText(ThreadPoolManager.getLangValue("TMS_NATIONAL_CODE"));
        panel.labelCode.setText(ThreadPoolManager.getLangValue("TMS_ID_NUM"));
        panel.labelPin.setText(ThreadPoolManager.getLangValue("TMS_PIN"));
        panel.labelAddress.setText(ThreadPoolManager.getLangValue("TMS_ADDRESS"));
        panel.labelPicAddress.setText(ThreadPoolManager.getLangValue("TMS_PIC"));
        panel.buttonSave.setText(ThreadPoolManager.getLangValue("TMS_ADD"));
        panel.buttonCancel.setText(ThreadPoolManager.getLangValue("TMS_CANCEL"));

        panel.buttonPicBrowse.setText(ThreadPoolManager.getLangValue("TMS_BROWSE"));
        panel.buttonPicBrowse.setEnabled(ThreadPoolManager.hasPermission("BROWS_PERSON"));

       /* jobSetting.setText(ThreadPoolManager.getLangValue("TMS_JOB_SETTING"));
        jobSetting.setVisible(ThreadPoolManager.hasPermission("JOB_SETTING"));*/

        if (newMode) {
            panel.buttonSave.setText(ThreadPoolManager.getLangValue("TMS_ADD"));
            panel.buttonSave.setEnabled(ThreadPoolManager.hasPermission("ADD_PERSON"));
        } else {
            panel.buttonSave.setText(ThreadPoolManager.getLangValue("TMS_EDIT"));
            panel.buttonSave.setEnabled(ThreadPoolManager.hasPermission("EDIT_PERSON"));
            loadPersonToForm();
        }

        Font tahoma = new Font("Tahoma", Font.PLAIN, 12);
        ComponentUtil.setFont(panel, tahoma, ThreadPoolManager.direction);
        prop_openDirectory = Configuration.getProperty("prop_openDirectory");
    }

    private void loadPersonToForm() {
        person.getId();
        panel.textFieldName.setText(person.getName());
        panel.textFieldLastName.setText(person.getLastName());
        panel.textFieldPIN.setText(person.getPin());
        panel.textFieldPersonelID.setText(person.getPersonnelNo());
        panel.textFieldNationalCode.setText(person.getNationalCode());

        panel.labelPicPanel.setIcon(ImageUtils.convertToImageIcon(ImageUtils.convertByteArrayToBufferedImage(person.getPicture())));
        panel.textFieldPicAddress.setText("");
    }

    private void updatePersonFromForm() {
        if (person == null) {
            person = new Person();
        }
        person.setName(panel.textFieldName.getText());
        person.setLastName(panel.textFieldLastName.getText());
        person.setNationalCode(panel.textFieldNationalCode.getText());
        person.setPersonnelNo(panel.textFieldPersonelID.getText());
        person.setPin(panel.textFieldPIN.getText());
        person.setPicture(ImageUtils.imageToByteArray(sourceBufferedImage));

    }

    protected void showPersonManagementAndExit() {
        PersonManagementCode personManagementCode = new PersonManagementCode();
        personManagementCode.setVisible(true);
        ThreadPoolManager.mainForm.getDesktopPane().add(personManagementCode);
        try {
            personManagementCode.setSelected(true);
        } catch (Exception e) {
            e.printStackTrace();
        }
        Configuration.saveSettings("prop_openDirectory", prop_openDirectory);
        dispose();
    }

    public void editPerson() {
        if (!validateForm()) {
            return;
        }


        boolean success;
        personService.setServiceName("/editPerson");
        try {
            updatePersonFromForm();
            new ObjectMapper().readValue(new RESTfulClientUtil().restFullService(personService.getServerUrl()
                    , personService.getServiceName()
                    , new ObjectMapper().writeValueAsString(person))
                    , Boolean.class);
            success = true;
        } catch (IOException e) {
            success = false;
            e.printStackTrace();
        }

        if (success) {
            //todo read from bundle
            //ThreadPoolManager.getLangValue("TMS_WORKGROUP_EDIT")
            DialogUtil.showOKDialog(this
                    , "ویرایش شخص، با موفقیت انجام شد."
                    , "اطلاع رسانی"
            );

            showPersonManagementAndExit();
        } else {
            //todo read from bundle
            DialogUtil.showErrorDialog(this
                    , "ویرایش شخص، با خطا مواجه شد."
                    , "خطای سیستمی"
            );
        }

    }

    private void browsePicture() {
        sourceFile = ImageUtils.OpenImageDialog(prop_openDirectory, this);

        if (null != sourceFile) {
            prop_openDirectory = sourceFile.getParent();
            sourceBufferedImage = ImageUtils.getBufferedImage(sourceFile);
            //panelPreview.setImage(modifiedBufferedImage);
            //panelPreview.repaint();
            //validate();
            //initImageInfo(true);
            //float scaleRatio = ImageUtils.calculateScaleRatio(sourceBufferedImage.getWidth(), panel.labelPicPanel.getWidth());
            float scaleRatio = ImageUtils.calculateBestScaleRatio(sourceBufferedImage.getWidth()
                    , panel.labelPicPanel.getWidth()
                    , sourceBufferedImage.getHeight()
                    , panel.labelPicPanel.getHeight());
            if (scaleRatio > 0 && scaleRatio != 1) {
                try {
                    sourceBufferedImage = ImageUtils.scaleImage(sourceBufferedImage, scaleRatio);
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
           //sourceBufferedImage = ImageUtils.changeImageFormat(sourceBufferedImage);
            panel.labelPicPanel.setIcon(new ImageIcon(sourceBufferedImage));
            panel.textFieldPicAddress.setText(sourceFile.getPath());
        }
    }

    public void addPerson() {

        if (!validateForm()) {
            return;
        }

        boolean success;

        personService.setServiceName("/createPerson");
        try {
            updatePersonFromForm();
            person = new ObjectMapper().readValue(new RESTfulClientUtil().restFullService(personService.getServerUrl()
                    , personService.getServiceName()
                    , new ObjectMapper().writeValueAsString(person))
                    , Person.class);

            success = person != null;
        } catch (IOException e) {
            e.printStackTrace();
            success = false;
        }

        if (success) {
            //todo read from bundle
            //ThreadPoolManager.getLangValue("TMS_WORKGROUP_EDIT")
            JOptionPane.showMessageDialog(this
                    , "افزودن شخص با موفقیت انجام شد."
                    , "پیغام"
                    , JOptionPane.INFORMATION_MESSAGE);

            showPersonManagementAndExit();
        } else {
            //todo read from bundle
            JOptionPane.showMessageDialog(this,
                    "افزودن شخص با خطا مواجه شد.",
                    "خطا",
                    JOptionPane.ERROR_MESSAGE);
        }
    }

    private boolean validateForm() {
        if (panel.textFieldName.getText().trim().isEmpty()) {
            DialogUtil.showErrorDialog(this
                    , "لطفا نام شخص را وارد نمائید."
                    , "خطای ورودی"
            );
            panel.textFieldName.selectAll();
            panel.textFieldName.requestFocus();
            return false;
        }
        return true;
    }

    class PersonPanel extends PersonDesign {

        @Override
        public void buttonPicBrowseActionPerformed() {
            browsePicture();
        }

        @Override
        public void buttonCancelActionPerformed() {
            showPersonManagementAndExit();
        }

        @Override
        public void buttonSaveActionPerformed() {
            if (newMode) {
                addPerson();
            } else {
                editPerson();
            }
        }
    }


}
