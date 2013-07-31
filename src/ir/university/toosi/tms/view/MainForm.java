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
import ir.university.toosi.tms.view.language.FileChooser;
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
import java.io.IOException;
import java.util.List;

/**
 * @author : Hamed Hatami ,  Farzad Sedaghatbin, Atefeh Ahmadi
 * @version : 1.0
 */

public class MainForm extends JApplet implements ActionListener, InternalFrameListener {

    private JDesktopPane jdpDesktop;
    private JMenuBar menuBar;
    private JMenu menu;
    private JMenu languageMenu;
    private JMenu managementMenu;
    private JMenu basicInfoMenu;
    private JMenuItem[] basicInfoMenus;
    private JMenuItem menuItem;
    private JMenuItem persianItem;
    private JMenuItem englishItem;
    private JMenuItem otherItem;
    private JMenuItem importLanguage;
    private JMenuItem userManagementItem;
    private JMenuItem roleManagementItem;
    private JMenuItem workGroupManagementItem;
    private JMenuItem calendarManagementItem;
    private JMenuItem eventLogListItem;
    private List<Languages> languageList;

    private WebServiceInfo lookupService;
    private List<Lookup> lookups;

    Login loginForm;

    @Override
    public void init() {
        ThreadPoolManager.mainForm = this;
        Frame[] frames = Frame.getFrames();
        for (Frame frame : frames) {
            frame.setMenuBar(null);
            frame.setTitle("Traffic Management System");
            frame.pack();
        }
        WebServiceInfo webServiceInfo = new WebServiceInfo();
        webServiceInfo.setServiceName("/getAllLanguage");
        try {
            languageList = new ObjectMapper().readValue(new RESTfulClientUtil().restFullService(webServiceInfo.getServerUrl(), webServiceInfo.getServiceName()), new TypeReference<List<Languages>>() {
            });
        } catch (IOException e) {
            e.printStackTrace();
        }

        loginForm = new Login(this);
        loginForm.setVisible(true);

        jdpDesktop = new JDesktopPane();
        jdpDesktop.add(loginForm);
        try {
            loginForm.setSelected(true);
        } catch (PropertyVetoException e) {
            e.printStackTrace();
        }

        setContentPane(jdpDesktop);
        menuBar = createMenuBar();
        setJMenuBar(menuBar);
        menuBar.setVisible(false);

        jdpDesktop.putClientProperty("JDesktopPane.dragMode", "outline");
        jdpDesktop.setComponentOrientation(ComponentOrientation.getOrientation(LanguageAction.getLocale()));
        menuBar.setComponentOrientation(ComponentOrientation.getOrientation(LanguageAction.getLocale()));

    }


    protected JMenuBar createMenuBar() {
        menuBar = new JMenuBar();
        menuBar.setComponentOrientation(ComponentOrientation.getOrientation(LanguageAction.getLocale()));
        menu = new JMenu();

        languageMenu = new JMenu();
        menuItem = new JMenuItem();
        persianItem = new JMenuItem();
        englishItem = new JMenuItem();
        otherItem = new JMenuItem();
        importLanguage = new JMenuItem();
        menu.setText(LanguageAction.getBundleMessage("loginForm"));
        languageMenu.setText(LanguageAction.getBundleMessage("language"));
        menuItem.setText(LanguageAction.getBundleMessage("salam"));
        persianItem.setText(LanguageAction.getBundleMessage("persian"));
        englishItem.setText(LanguageAction.getBundleMessage("english"));
        otherItem.setText(LanguageAction.getBundleMessage("thirdLanguage"));
        importLanguage.setText(LanguageAction.getBundleMessage("importLanguage"));
        menuItem.addActionListener(this);
        persianItem.addActionListener(this);
        englishItem.addActionListener(this);
        otherItem.addActionListener(this);
        importLanguage.addActionListener(this);
        menu.add(menuItem);
        languageMenu.add(persianItem);
        languageMenu.add(englishItem);
        if (languageList != null && !languageList.isEmpty()) {
            try {
                LanguageAction.initProperty(languageList.get(0).getContent());
            } catch (IOException e) {
                e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
            }
            languageMenu.add(otherItem);
        }
        languageMenu.add(importLanguage);

        managementMenu = new JMenu();
        workGroupManagementItem = new JMenuItem();
        calendarManagementItem = new JMenuItem();
        userManagementItem = new JMenuItem();
        roleManagementItem = new JMenuItem();
        eventLogListItem = new JMenuItem();
        workGroupManagementItem.setText(LanguageAction.getBundleMessage("workgroup_management"));
        calendarManagementItem.setText(LanguageAction.getBundleMessage("calendar_management"));
        managementMenu.setText(LanguageAction.getBundleMessage("management"));
        roleManagementItem.setText(LanguageAction.getBundleMessage("role_management"));
        userManagementItem.setText(LanguageAction.getBundleMessage("user_management"));
        eventLogListItem.setText(LanguageAction.getBundleMessage("eventLog_list"));
        userManagementItem.addActionListener(this);
        roleManagementItem.addActionListener(this);
        workGroupManagementItem.addActionListener(this);
        eventLogListItem.addActionListener(this);
        calendarManagementItem.addActionListener(this);
        managementMenu.add(workGroupManagementItem);
        managementMenu.add(roleManagementItem);
        managementMenu.add(userManagementItem);
        managementMenu.add(eventLogListItem);
        managementMenu.add(calendarManagementItem);

        basicInfoMenu = new JMenu();
        basicInfoMenu.setText(LanguageAction.getBundleMessage("BasicInfo"));
        lookupService = new WebServiceInfo();
        lookupService.setServiceName("/getAllDefinableLookup");
        try {
            lookups = new ObjectMapper().readValue(new RESTfulClientUtil().restFullService(lookupService.getServerUrl(), lookupService.getServiceName()), new TypeReference<List<Lookup>>() {
            });
            basicInfoMenus = new JMenuItem[lookups.size()];
            int i = 0;
            for (Lookup lookup : lookups) {
                JMenuItem jMenuItem = new JMenuItem();
                jMenuItem.setText(LanguageAction.getBundleMessage(lookup.getName()));
                jMenuItem.addActionListener(this);
                basicInfoMenus[i++] = jMenuItem;
                basicInfoMenu.add(jMenuItem);
            }
        } catch (IOException e) {
            e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
        }

        menuBar.add(menu);
        menuBar.add(languageMenu);
        menuBar.add(managementMenu);
        menuBar.add(basicInfoMenu);
        return menuBar;
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

    private void showFileChooser() throws PropertyVetoException {
        FileChooser fileChooser = new FileChooser(jdpDesktop);
        fileChooser.setVisible(true);
        jdpDesktop.add(fileChooser);
        fileChooser.setSelected(true);

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
        menuBar.setComponentOrientation(ComponentOrientation.getOrientation(LanguageAction.getLocale()));
        menu.setText(LanguageAction.getBundleMessage("loginForm"));
        languageMenu.setText(LanguageAction.getBundleMessage("language"));
        menuItem.setText(LanguageAction.getBundleMessage("salam"));
        persianItem.setText(LanguageAction.getBundleMessage("persian"));
        englishItem.setText(LanguageAction.getBundleMessage("english"));
        otherItem.setText(LanguageAction.getBundleMessage("other"));
        jdpDesktop.removeAll();
        jdpDesktop.revalidate();
        jdpDesktop.repaint();
    }

    private void showLookupInfo(Lookup lookup) throws PropertyVetoException {
        System.out.println("LOOKUP : " + lookup.getName());
        BasicInfoManagement basicInfoManagement = new BasicInfoManagement(jdpDesktop, lookup);
        basicInfoManagement.setVisible(true);
        jdpDesktop.add(basicInfoManagement);
        basicInfoManagement.setSelected(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        try {

            if (e.getSource() == menuItem) {
                showPersonEdit();
            } else if (e.getSource() == persianItem) {
                LanguageAction.changeLocale("fa");
                refreshMainForm();
            } else if (e.getSource() == englishItem) {
                LanguageAction.changeLocale("en");
                refreshMainForm();
            } else if (e.getSource() == englishItem) {
                LanguageAction.changeLocale("other");
                refreshMainForm();
            } else if (e.getSource() == userManagementItem) {
                showUserManagement();
            } else if (e.getSource() == importLanguage) {
                showFileChooser();
            } else if (e.getSource() == roleManagementItem) {
                showRoleManagement();
            } else if (e.getSource() == eventLogListItem) {
                showEventLogList();
            } else if (e.getSource() == workGroupManagementItem) {
                showWorkGroupManagement();
            } else if (e.getSource() == calendarManagementItem) {
                showCalendarManagment();
            } else {
                for (int i = 0; i < basicInfoMenus.length; i++) {
                    JMenuItem infoMenu = basicInfoMenus[i];
                    if (e.getSource() == infoMenu) {
                        showLookupInfo(lookups.get(i));
                        break;
                    }
                }
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    public JDesktopPane getJdpDesktop() {
        return jdpDesktop;
    }

    public void setJdpDesktop(JDesktopPane jdpDesktop) {
        this.jdpDesktop = jdpDesktop;
    }

    public JMenuBar getMenuBar() {
        return menuBar;
    }

    public void setMenuBar(JMenuBar menuBar) {
        this.menuBar = menuBar;
    }

    public JMenu getMenu() {
        return menu;
    }

    public void setMenu(JMenu menu) {
        this.menu = menu;
    }

    public JMenu getLanguageMenu() {
        return languageMenu;
    }

    public void setLanguageMenu(JMenu languageMenu) {
        this.languageMenu = languageMenu;
    }

    public JMenuItem getMenuItem() {
        return menuItem;
    }

    public void setMenuItem(JMenuItem menuItem) {
        this.menuItem = menuItem;
    }

    public JMenuItem getPersianItem() {
        return persianItem;
    }

    public void setPersianItem(JMenuItem persianItem) {
        this.persianItem = persianItem;
    }

    public JMenuItem getEnglishItem() {
        return englishItem;
    }

    public void setEnglishItem(JMenuItem englishItem) {
        this.englishItem = englishItem;
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
        e.getInternalFrame().dispose();
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
