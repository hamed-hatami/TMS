package ir.university.toosi.tms.view;

import ir.university.toosi.tms.controller.LanguageAction;
import ir.university.toosi.tms.util.ThreadPoolManager;
import ir.university.toosi.tms.view.eventlog.EventLogList;
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
    private JMenuItem menuItem;
    private JMenuItem persianItem;
    private JMenuItem englishItem;
    private JMenuItem userManagementItem;
    private JMenuItem roleManagementItem;
    private JMenuItem workGroupManagementItem;
    private JMenuItem eventLogListItem;

    Login loginForm;

    @Override
    public void init() {
        ThreadPoolManager.mainForm =this;
        Frame[] frames = Frame.getFrames();
        for (Frame frame : frames) {
            frame.setMenuBar(null);
            frame.setTitle("Traffic Management System");
            frame.pack();
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
        menu.setText(LanguageAction.getBundleMessage("loginForm"));
        languageMenu.setText(LanguageAction.getBundleMessage("language"));
        menuItem.setText(LanguageAction.getBundleMessage("salam"));
        persianItem.setText(LanguageAction.getBundleMessage("persian"));
        englishItem.setText(LanguageAction.getBundleMessage("english"));
        menuItem.addActionListener(this);
        persianItem.addActionListener(this);
        englishItem.addActionListener(this);
        menu.add(menuItem);
        languageMenu.add(persianItem);
        languageMenu.add(englishItem);

        managementMenu = new JMenu();
        workGroupManagementItem = new JMenuItem();
        userManagementItem = new JMenuItem();
        roleManagementItem = new JMenuItem();
        eventLogListItem = new JMenuItem();
        workGroupManagementItem.setText(LanguageAction.getBundleMessage("workgroup_management"));
        managementMenu.setText(LanguageAction.getBundleMessage("management"));
        roleManagementItem.setText(LanguageAction.getBundleMessage("role_management"));
        userManagementItem.setText(LanguageAction.getBundleMessage("user_management"));
        eventLogListItem.setText(LanguageAction.getBundleMessage("eventLog_list"));
        userManagementItem.addActionListener(this);
        roleManagementItem.addActionListener(this);
        workGroupManagementItem.addActionListener(this);
        eventLogListItem.addActionListener(this);
        managementMenu.add(workGroupManagementItem);
        managementMenu.add(roleManagementItem);
        managementMenu.add(userManagementItem);
        managementMenu.add(eventLogListItem);

        menuBar.add(menu);
        menuBar.add(languageMenu);
        menuBar.add(managementMenu);
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
    private void showWorkGroupManagement() throws PropertyVetoException {
        WorkGroupManagement workGroupManagement= new WorkGroupManagement(jdpDesktop);
        workGroupManagement.setVisible(true);
        jdpDesktop.add(workGroupManagement);
        workGroupManagement.setSelected(true);

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
        jdpDesktop.removeAll();
        jdpDesktop.revalidate();
        jdpDesktop.repaint();
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
            } else if (e.getSource() == userManagementItem) {
                showUserManagement();
            } else if (e.getSource() == roleManagementItem) {
                showRoleManagement();
            } else if (e.getSource() == eventLogListItem) {
                showEventLogList();
            }else if (e.getSource() == workGroupManagementItem) {
                showWorkGroupManagement();
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
