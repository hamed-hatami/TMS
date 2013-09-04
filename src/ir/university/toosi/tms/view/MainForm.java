package ir.university.toosi.tms.view;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import ir.university.toosi.tms.controller.LanguageAction;
import ir.university.toosi.tms.model.entity.Languages;
import ir.university.toosi.tms.model.entity.Lookup;
import ir.university.toosi.tms.model.entity.WebServiceInfo;
import ir.university.toosi.tms.util.RESTfulClientUtil;
import ir.university.toosi.tms.util.ThreadPoolManager;
import ir.university.toosi.tms.view.basicinfo.BasicInfoManagement;
import ir.university.toosi.tms.view.calendar.CalendarManagement;
import ir.university.toosi.tms.view.eventlog.EventLogList;
import ir.university.toosi.tms.view.language.LanguageForm;
import ir.university.toosi.tms.view.language.LanguageManagementForm;
import ir.university.toosi.tms.view.person.PersonManagement;
import ir.university.toosi.tms.view.role.RoleManagement;
import ir.university.toosi.tms.view.user.UserManagement;
import ir.university.toosi.tms.view.workgroup.WorkGroupManagement;

import javax.swing.*;
import javax.swing.event.InternalFrameEvent;
import javax.swing.event.InternalFrameListener;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.beans.PropertyVetoException;
import java.util.List;

/**
 * @author : Hamed Hatami ,  Farzad Sedaghatbin, Atefeh Ahmadi
 * @version : 1.0
 */

public class MainForm extends JFrame implements InternalFrameListener {

    private TMSDesktop jdpDesktop;
    private Login loginForm;

    public MainForm() {

        try {
            Toolkit toolkit = Toolkit.getDefaultToolkit();
            int xSize = ((int) toolkit.getScreenSize().getWidth());
            int ySize = ((int) toolkit.getScreenSize().getHeight());
            setSize(xSize, ySize);

            setDefaultLookAndFeelDecorated(true);
            setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            UIManager.setLookAndFeel("javax.swing.plaf.nimbus.NimbusLookAndFeel");

            ThreadPoolManager.mainForm = this;
            WebServiceInfo webServiceInfo = new WebServiceInfo();
            webServiceInfo.setServiceName("/getAllLanguage");

            List<Languages> languageList = new ObjectMapper().readValue(new RESTfulClientUtil().restFullService(webServiceInfo.getServerUrl(), webServiceInfo.getServiceName()), new TypeReference<List<Languages>>() {
            });

            loginForm = new Login(this);
            loginForm.setVisible(true);
            jdpDesktop = new TMSDesktop();
            jdpDesktop.add(loginForm);
            loginForm.setSelected(true);
            setContentPane(jdpDesktop);
            jdpDesktop.setComponentOrientation(ComponentOrientation.getOrientation(LanguageAction.getLocale()));

        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public static void main(String[] args) {
        MainForm main = new MainForm();
        main.setVisible(true);
    }

    protected void showPersonEdit() {
        /*Login loginForm = new Login();
        loginForm.setVisible(true);
        jdpDesktop.add(loginForm);*/
   /*     try {
            loginForm.setSelected(true);
        } catch (java.beans.PropertyVetoException e) {
        }*/
    }

    private void showUserManagement() throws PropertyVetoException {
        UserManagement userManagement = new UserManagement(jdpDesktop);
        userManagement.setVisible(true);
        jdpDesktop.add(userManagement);
        userManagement.setSelected(true);

    }

    private void showLanguageForm() throws PropertyVetoException {
        LanguageForm languageForm = new LanguageForm(jdpDesktop);
        languageForm.setVisible(true);
        jdpDesktop.add(languageForm);
        languageForm.setSelected(true);

    }

    private void showWorkGroupManagement() throws PropertyVetoException {
        WorkGroupManagement workGroupManagement = new WorkGroupManagement(jdpDesktop);
        workGroupManagement.setVisible(true);
        jdpDesktop.add(workGroupManagement);
        workGroupManagement.setSelected(true);

    }

    private void showCalendarManagment() throws PropertyVetoException {
        CalendarManagement calendarManagement = new CalendarManagement(jdpDesktop);
        calendarManagement.setVisible(true);
        jdpDesktop.add(calendarManagement);
        calendarManagement.setSelected(true);

    }

    private void showPersonManagment() throws PropertyVetoException {
        PersonManagement personManagement = new PersonManagement(jdpDesktop);
        personManagement.setVisible(true);
        jdpDesktop.add(personManagement);
        personManagement.setSelected(true);

    }

    private void showRoleManagement() throws PropertyVetoException {
        RoleManagement roleManagement = new RoleManagement(jdpDesktop);
        roleManagement.setVisible(true);
        jdpDesktop.add(roleManagement);
        roleManagement.setSelected(true);
    }

    private void showEventLogList() throws PropertyVetoException {
        EventLogList eventLogList = new EventLogList(jdpDesktop);
        eventLogList.setVisible(true);
        jdpDesktop.add(eventLogList);
        eventLogList.setSelected(true);
    }

    private void refreshMainForm() {
        jdpDesktop.setComponentOrientation(ComponentOrientation.getOrientation(LanguageAction.getLocale()));
        //languageMenu.setText(ThreadPoolManager.getLangValue("language"));
        //languageDefItem.setText(ThreadPoolManager.getLangValue("languageDef"));
        jdpDesktop.removeAll();
        jdpDesktop.revalidate();
        jdpDesktop.repaint();
    }

    private void showLookupInfo(Lookup lookup) throws PropertyVetoException {
        BasicInfoManagement basicInfoManagement = new BasicInfoManagement(jdpDesktop, lookup);
        basicInfoManagement.setVisible(true);
        jdpDesktop.add(basicInfoManagement);
        basicInfoManagement.setSelected(true);
    }

    private void showLanguageDef() throws PropertyVetoException {
        LanguageManagementForm languageManagement = new LanguageManagementForm(jdpDesktop);
        languageManagement.setVisible(true);
        jdpDesktop.add(languageManagement);
        languageManagement.setSelected(true);
    }

    public JMenuBar createMenuBar(ComponentOrientation direction) {
        JMenuBar menuBar = null;
        try {
            menuBar = new JMenuBar();
            menuBar.setComponentOrientation(ComponentOrientation.getOrientation(LanguageAction.getLocale()));
            JMenu languageMenu = new JMenu();
            JMenuItem languageDefItem = new JMenuItem(new ImageIcon(MainForm.class.getClassLoader().getResource("lang.png")));
            languageDefItem.setComponentOrientation(direction);
            JMenuItem importLanguage = new JMenuItem(new ImageIcon(MainForm.class.getClassLoader().getResource("keyboard.png")));
            importLanguage.setComponentOrientation(direction);
            languageMenu.setText(ThreadPoolManager.getLangValue("language"));
            languageDefItem.setText(ThreadPoolManager.getLangValue("languageDef"));
            importLanguage.setText(ThreadPoolManager.getLangValue("importLanguage"));
            languageMenu.add(languageDefItem);
            languageMenu.add(importLanguage);
            JMenu managementMenu = new JMenu();
            JMenuItem workGroupManagementItem = new JMenuItem(new ImageIcon(MainForm.class.getClassLoader().getResource("groups.png")));
            workGroupManagementItem.setComponentOrientation(direction);
            JMenuItem calendarManagementItem = new JMenuItem(new ImageIcon(MainForm.class.getClassLoader().getResource("calendar.png")));
            calendarManagementItem.setComponentOrientation(direction);
            calendarManagementItem.setVisible(false);
            JMenuItem personManagementItem = new JMenuItem(new ImageIcon(MainForm.class.getClassLoader().getResource("person-mgnt.png")));
            personManagementItem.setComponentOrientation(direction);
            JMenuItem userManagementItem = new JMenuItem(new ImageIcon(MainForm.class.getClassLoader().getResource("user-mgnt.png")));
            userManagementItem.setComponentOrientation(direction);
            JMenuItem operationManagementItem = new JMenuItem(new ImageIcon(MainForm.class.getClassLoader().getResource("operation.png")));
            operationManagementItem.setComponentOrientation(direction);
            JMenuItem eventLogListItem = new JMenuItem(new ImageIcon(MainForm.class.getClassLoader().getResource("event.png")));
            eventLogListItem.setComponentOrientation(direction);
            workGroupManagementItem.setText(ThreadPoolManager.getLangValue("workgroup_management"));
            calendarManagementItem.setText(ThreadPoolManager.getLangValue("calendar_management"));
            personManagementItem.setText(ThreadPoolManager.getLangValue("person_management"));
            managementMenu.setText(ThreadPoolManager.getLangValue("management"));
            operationManagementItem.setText(ThreadPoolManager.getLangValue("operation_management"));
            userManagementItem.setText(ThreadPoolManager.getLangValue("user_management"));
            eventLogListItem.setText(ThreadPoolManager.getLangValue("eventLog_list"));
            managementMenu.add(workGroupManagementItem);
            managementMenu.add(operationManagementItem);
            managementMenu.add(userManagementItem);
            managementMenu.add(eventLogListItem);
            managementMenu.add(calendarManagementItem);
            managementMenu.add(personManagementItem);

            JMenu basicInfoMenu = new JMenu();
            basicInfoMenu.setVisible(false);
            basicInfoMenu.setText(ThreadPoolManager.getLangValue("BasicInfo"));
            JMenuItem exit = new JMenuItem(new ImageIcon(MainForm.class.getClassLoader().getResource("exit.png")));
            exit.setComponentOrientation(direction);
            JMenu exitMenu = new JMenu();
            exit.setText(ThreadPoolManager.getLangValue("exit"));
            exitMenu.setText(ThreadPoolManager.getLangValue("operation"));
            exitMenu.add(exit);

            userManagementItem.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    try {
                        showUserManagement();
                    } catch (PropertyVetoException e1) {
                        e1.printStackTrace();
                    }
                }
            });
            operationManagementItem.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    try {
                        showRoleManagement();
                    } catch (PropertyVetoException e1) {
                        e1.printStackTrace();
                    }
                }
            });
            workGroupManagementItem.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    try {
                        showWorkGroupManagement();
                    } catch (PropertyVetoException e1) {
                        e1.printStackTrace();
                    }
                }
            });
            eventLogListItem.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    try {
                        showEventLogList();
                    } catch (PropertyVetoException e1) {
                        e1.printStackTrace();
                    }
                }
            });
            calendarManagementItem.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    try {
                        showCalendarManagment();
                    } catch (PropertyVetoException e1) {
                        e1.printStackTrace();
                    }
                }
            });
            personManagementItem.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    try {
                        showPersonManagment();
                    } catch (PropertyVetoException e1) {
                        e1.printStackTrace();
                    }
                }
            });
            languageDefItem.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    try {
                        showLanguageDef();
                    } catch (PropertyVetoException e1) {
                        e1.printStackTrace();
                    }
                }
            });
            importLanguage.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    try {
                        showLanguageForm();
                    } catch (PropertyVetoException e1) {
                        e1.printStackTrace();
                    }
                }
            });
            exit.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    System.exit(0);
                }
            });

            WebServiceInfo loginService = new WebServiceInfo();
            loginService.setServiceName("/getAllDefinableLookup");
            List<Lookup> lookups = new ObjectMapper().readValue(new RESTfulClientUtil().restFullService(loginService.getServerUrl(), loginService.getServiceName()), new TypeReference<List<Lookup>>() {
            });
            JMenuItem[] basicInfoMenus = new JMenuItem[lookups.size()];
            int i = 0;
            for (Lookup lookup : lookups) {
                JMenuItem jMenuItem = new JMenuItem();
                jMenuItem.setVisible(false);
                jMenuItem.setText(ThreadPoolManager.getLangValue(lookup.getName()));
                jMenuItem.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        //To change body of implemented methods use File | Settings | File Templates.
                    }
                });
                basicInfoMenus[i++] = jMenuItem;
                basicInfoMenu.add(jMenuItem);
            }

            menuBar.add(languageMenu);
            menuBar.add(managementMenu);
            menuBar.add(exitMenu);
            menuBar.add(basicInfoMenu);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return menuBar;
    }

    public JDesktopPane getJdpDesktop() {
        return jdpDesktop;
    }

    public void setJdpDesktop(TMSDesktop jdpDesktop) {
        this.jdpDesktop = jdpDesktop;
    }

    public Login getLoginForm() {
        return loginForm;
    }

    public void setLoginForm(Login loginForm) {
        this.loginForm = loginForm;
    }

    @Override
    public void internalFrameOpened(InternalFrameEvent e) {
        //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public void internalFrameClosing(InternalFrameEvent e) {
        //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public void internalFrameClosed(InternalFrameEvent e) {
        //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public void internalFrameIconified(InternalFrameEvent e) {
        //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public void internalFrameDeiconified(InternalFrameEvent e) {
        //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public void internalFrameActivated(InternalFrameEvent e) {
        //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public void internalFrameDeactivated(InternalFrameEvent e) {
        //To change body of implemented methods use File | Settings | File Templates.
    }
}
