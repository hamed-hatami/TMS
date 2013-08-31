package ir.university.toosi.tms.view.person;

import com.fasterxml.jackson.databind.ObjectMapper;
import ir.university.toosi.tms.controller.LanguageAction;
import ir.university.toosi.tms.model.entity.WebServiceInfo;
import ir.university.toosi.tms.model.entity.person.Person;
import ir.university.toosi.tms.util.RESTfulClientUtil;
import ir.university.toosi.tms.util.ThreadPoolManager;
import ir.university.toosi.tms.view.TMSInternalFrame;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.io.IOException;

public class PersonForm extends TMSInternalFrame {

    public PersonForm() {

        mainPanel = new JPanel();
        mainPanel.setComponentOrientation(ComponentOrientation.getOrientation(LanguageAction.getLocale()));
        nameLabel = new JLabel();
        lastNameLabel = new JLabel();
        name = new JTextField();
        lastName = new JTextField();
        personnelNo = new JTextField();
        personnelNoLabel = new JLabel();
        nationalCode = new JTextField();
        nationalCodeLabel = new JLabel();
        idNum = new JTextField();
        idNumLabel = new JLabel();
        pinLabel = new JLabel();
        pin = new JTextField();
        address = new JTextField();
        addressLabel = new JLabel();
        pictureLabel = new JLabel();
        picture = new JTextField();
        browse = new JButton();
        cancel = new JButton();
        edit = new JButton();
        jobSetting = new JButton();
        initComponents();
    }

    public PersonForm(boolean editMode, Person person, PersonManagement personManagement) {

        mainPanel = new JPanel();
        mainPanel.setComponentOrientation(ComponentOrientation.getOrientation(LanguageAction.getLocale()));
        nameLabel = new JLabel();
        lastNameLabel = new JLabel();
        name = new JTextField();
        lastName = new JTextField();
        personnelNo = new JTextField();
        personnelNoLabel = new JLabel();
        nationalCode = new JTextField();
        nationalCodeLabel = new JLabel();
        idNum = new JTextField();
        idNumLabel = new JLabel();
        pinLabel = new JLabel();
        pin = new JTextField();
        address = new JTextField();
        addressLabel = new JLabel();
        pictureLabel = new JLabel();
        picture = new JTextField();
        browse = new JButton();
        cancel = new JButton();
        edit = new JButton();
        jobSetting = new JButton();
        this.editMode = editMode;
        this.personManagement = personManagement;
        this.person = person;
        added = editMode;
        initComponents();
    }


    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        this.addInternalFrameListener(ThreadPoolManager.mainForm);
        setClosable(true);
        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle(ThreadPoolManager.getLangValue("TMS_PERSONNEL_INFO"));

        mainPanel.setBorder(javax.swing.BorderFactory.createTitledBorder(ThreadPoolManager.getLangValue("TMS_PERSONNEL_INFO")));

        nameLabel.setText(ThreadPoolManager.getLangValue("TMS_NAME"));

        lastNameLabel.setText(ThreadPoolManager.getLangValue("TMS_LAST_NAME"));

        personnelNoLabel.setText(ThreadPoolManager.getLangValue("TMS_PERSONNEL_NO"));

        nationalCodeLabel.setText(ThreadPoolManager.getLangValue("TMS_NATIONAL_CODE"));

        idNumLabel.setText(ThreadPoolManager.getLangValue("TMS_ID_NUM"));

        pinLabel.setText(ThreadPoolManager.getLangValue("TMS_PIN"));

        addressLabel.setText(ThreadPoolManager.getLangValue("TMS_ADDRESS"));

        pictureLabel.setText(ThreadPoolManager.getLangValue("TMS_PIC"));

        if (editMode) {
            name.setText(person.getName());
            lastName.setText(person.getLastName());
            pin.setText(person.getPin());
            personnelNo.setText(person.getPersonnelNo());
            nationalCode.setText(person.getNationalCode());
            picture.setText(person.getPicture());
        } else {
            name.setText("");
            lastName.setText("");
            pin.setText("");
            personnelNo.setText("");
            nationalCode.setText("");
            picture.setText("");
        }


        picture.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                browseFile(evt);
            }
        });

        browse.setText(ThreadPoolManager.getLangValue("TMS_BROWSE"));
        browse.setVisible(ThreadPoolManager.hasPermission("BROWS_PERSON"));

        org.jdesktop.layout.GroupLayout jPanel1Layout = new org.jdesktop.layout.GroupLayout(mainPanel);
        mainPanel.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
                jPanel1Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                        .add(jPanel1Layout.createSequentialGroup()
                                .add(50, 50, 50)
                                .add(jPanel1Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.TRAILING)
                                        .add(jPanel1Layout.createSequentialGroup()
                                                .add(nameLabel)
                                                .add(16, 16, 16))
                                        .add(jPanel1Layout.createSequentialGroup()
                                                .add(personnelNoLabel)
                                                .addPreferredGap(org.jdesktop.layout.LayoutStyle.UNRELATED))
                                        .add(jPanel1Layout.createSequentialGroup()
                                                .add(jPanel1Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.TRAILING)
                                                        .add(addressLabel)
                                                        .add(idNumLabel)
                                                        .add(pictureLabel))
                                                .add(18, 18, 18)))
                                .add(jPanel1Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                                        .add(jPanel1Layout.createSequentialGroup()
                                                .add(jPanel1Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING, false)
                                                        .add(personnelNo)
                                                        .add(name, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, 107, Short.MAX_VALUE)
                                                        .add(idNum))
                                                .add(31, 31, 31)
                                                .add(jPanel1Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.TRAILING)
                                                        .add(lastNameLabel)
                                                        .add(nationalCodeLabel)
                                                        .add(pinLabel))
                                                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                                                .add(jPanel1Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                                                        .add(pin, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, 120, Short.MAX_VALUE)
                                                        .add(nationalCode, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, 120, Short.MAX_VALUE)
                                                        .add(lastName, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 112, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)))
                                        .add(address, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, 341, Short.MAX_VALUE)
                                        .add(org.jdesktop.layout.GroupLayout.TRAILING, jPanel1Layout.createSequentialGroup()
                                                .add(picture, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, 248, Short.MAX_VALUE)
                                                .add(18, 18, 18)
                                                .add(browse)))
                                .add(30, 30, 30))
        );
        jPanel1Layout.setVerticalGroup(
                jPanel1Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                        .add(jPanel1Layout.createSequentialGroup()
                                .add(jPanel1Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.BASELINE)
                                        .add(nameLabel)
                                        .add(name, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                                        .add(lastNameLabel)
                                        .add(lastName, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
                                .add(26, 26, 26)
                                .add(jPanel1Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.BASELINE)
                                        .add(personnelNo, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                                        .add(personnelNoLabel)
                                        .add(nationalCode, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 28, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                                        .add(nationalCodeLabel))
                                .add(18, 18, 18)
                                .add(jPanel1Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.BASELINE)
                                        .add(idNum, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                                        .add(idNumLabel)
                                        .add(pinLabel)
                                        .add(pin, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 29, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
                                .add(18, 18, 18)
                                .add(jPanel1Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.BASELINE)
                                        .add(addressLabel)
                                        .add(address, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED, 13, Short.MAX_VALUE)
                                .add(jPanel1Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.BASELINE)
                                        .add(pictureLabel)
                                        .add(picture, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                                        .add(browse))
                                .add(19, 19, 19))
        );

        cancel.setText(ThreadPoolManager.getLangValue("TMS_CANCEL"));
        cancel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                close(evt);
            }
        });

        if (editMode)  {
            edit.setText(ThreadPoolManager.getLangValue("TMS_EDIT"));
            edit.setVisible(ThreadPoolManager.hasPermission("EDIT_PERSON"));
        }
        else
            edit.setText(ThreadPoolManager.getLangValue("TMS_ADD"));
            edit.setVisible(ThreadPoolManager.hasPermission("ADD_PERSON"));
        edit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                if (editMode)
                    edit(evt);
                else
                    add(evt);
            }
        });

        jobSetting.setText(ThreadPoolManager.getLangValue("TMS_JOB_SETTING"));
        jobSetting.setVisible(ThreadPoolManager.hasPermission("JOB_SETTING"));
        jobSetting.setEnabled(added);
        jobSetting.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                jobSetting(evt);
            }
        });

        org.jdesktop.layout.GroupLayout layout = new org.jdesktop.layout.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                        .add(org.jdesktop.layout.GroupLayout.TRAILING, layout.createSequentialGroup()
                                .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.TRAILING)
                                        .add(layout.createSequentialGroup()
                                                .addContainerGap()
                                                .add(mainPanel, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                        .add(org.jdesktop.layout.GroupLayout.LEADING, layout.createSequentialGroup()
                                                .add(171, 171, 171)
                                                .add(jobSetting)
                                                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                                                .add(edit)
                                                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                                                .add(cancel)))
                                .addContainerGap())
        );

        layout.linkSize(new Component[]{cancel, edit}, org.jdesktop.layout.GroupLayout.HORIZONTAL);

        layout.setVerticalGroup(
                layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                        .add(org.jdesktop.layout.GroupLayout.TRAILING, layout.createSequentialGroup()
                                .addContainerGap()
                                .add(mainPanel, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addPreferredGap(org.jdesktop.layout.LayoutStyle.UNRELATED)
                                .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.BASELINE)
                                        .add(edit)
                                        .add(cancel)
                                        .add(jobSetting))
                                .addContainerGap())
        );

        getAccessibleContext().setAccessibleName("PersonnalInfo");

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void close(ActionEvent evt) {
        this.dispose();
        try {
            personManagement.refresh();
        } catch (IOException e) {
            e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
        }
    }

    private void edit(ActionEvent evt) {

        person.setName(name.getText());
        person.setLastName(lastName.getText());
        person.setNationalCode(nationalCode.getText());
        person.setPersonnelNo(personnelNo.getText());
        person.setPicture(picture.getText());
        person.setPersonnelNo(personnelNo.getText());
        person.setPin(pin.getText());

        personService.setServiceName("/editPerson");

        try {
            new ObjectMapper().readValue(new RESTfulClientUtil().restFullService(personService.getServerUrl(), personService.getServiceName(), new ObjectMapper().writeValueAsString(person)), Boolean.class);
        } catch (IOException e) {
            e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
        }
    }

    private void add(ActionEvent evt) {

        Person newPerson = new Person();
        newPerson.setName(name.getText());
        newPerson.setLastName(lastName.getText());
        newPerson.setNationalCode(nationalCode.getText());
        newPerson.setPersonnelNo(personnelNo.getText());
        newPerson.setPicture(picture.getText());
        newPerson.setPersonnelNo(personnelNo.getText());
        newPerson.setPin(pin.getText());

        personService.setServiceName("/createPerson");

        try {
            person = new ObjectMapper().readValue(new RESTfulClientUtil().restFullService(personService.getServerUrl(), personService.getServiceName(), new ObjectMapper().writeValueAsString(newPerson)), Person.class);
        } catch (IOException e) {
            e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
        }
        added = true;
        jobSetting.setEnabled(added);
    }


    private void browseFile(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField8ActionPerformed
// TODO add your handling code here:
    }//GEN-LAST:event_jTextField8ActionPerformed

    private void jobSetting(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
// TODO add your handling code here:
    }//GEN-LAST:event_jButton2ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private JButton browse;
    private JButton jobSetting;
    private JButton cancel;
    private JButton edit;
    private JLabel nameLabel;
    private JLabel lastNameLabel;
    private JLabel personnelNoLabel;
    private JLabel nationalCodeLabel;
    private JLabel idNumLabel;
    private JLabel pinLabel;
    private JLabel addressLabel;
    private JLabel pictureLabel;
    private JPanel mainPanel;
    private JTextField name;
    private JTextField lastName;
    private JTextField personnelNo;
    private JTextField nationalCode;
    private JTextField idNum;
    private JTextField pin;
    private JTextField address;
    private JTextField picture;

    private boolean editMode;
    private boolean added;
    private Person person;
    private PersonManagement personManagement;
    private WebServiceInfo personService = new WebServiceInfo();
    // End of variables declaration//GEN-END:variables

}
