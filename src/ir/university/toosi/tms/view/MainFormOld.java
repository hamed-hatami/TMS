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
import ir.university.toosi.tms.view.language.LanguageAddForm;
import ir.university.toosi.tms.view.language.LanguageManagementCode;
import ir.university.toosi.tms.view.pc.PCForm;
import ir.university.toosi.tms.view.pc.PCManagement;
import ir.university.toosi.tms.view.pc.PCManagementCode;
import ir.university.toosi.tms.view.person.PersonForm;
import ir.university.toosi.tms.view.person.PersonList;
import ir.university.toosi.tms.view.person.PersonManagement;
import ir.university.toosi.tms.view.role.AddRoleCode;
import ir.university.toosi.tms.view.role.RoleForm;
import ir.university.toosi.tms.view.role.RoleManagement;
import ir.university.toosi.tms.view.role.RoleManagementCode;
import ir.university.toosi.tms.view.user.UserAddCode;
import ir.university.toosi.tms.view.user.UserForm;
import ir.university.toosi.tms.view.user.UserManagement;
import ir.university.toosi.tms.view.workgroup.WorkGroupForm;
import ir.university.toosi.tms.view.workgroup.WorkGroupManagement;
import ir.university.toosi.tms.view.workgroup.WorkGroupManagementCode;

import javax.swing.*;
import javax.swing.event.InternalFrameEvent;
import javax.swing.event.InternalFrameListener;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

 


public class MainFormOld extends JFrame implements InternalFrameListener {

    private TMSDesktop jdpDesktop;
    private Login loginForm;
    private WebServiceInfo webServiceInfo = new WebServiceInfo();

    public MainFormOld() {
        ThreadPoolManager.isDebugMode = true;
        try {
            Toolkit toolkit = Toolkit.getDefaultToolkit();
            int xSize = ((int) toolkit.getScreenSize().getWidth());
            int ySize = ((int) toolkit.getScreenSize().getHeight());
            setSize(xSize,  ySize);

            setDefaultLookAndFeelDecorated(true);
            setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            UIManager.setLookAndFeel("javax.swing.plaf.nimbus.NimbusLookAndFeel");

           // todo ThreadPoolManager.mainForm = this;

            webServiceInfo.setServiceName("/getAllLanguage");

            List<Languages> languageList = new ObjectMapper().readValue(new RESTfulClientUtil().restFullService(webServiceInfo.getServerUrl(), webServiceInfo.getServiceName()), new TypeReference<List<Languages>>() {
            });

           //todo

            TMSInternalFrame internalFrame ;

            internalFrame = new AddRoleCode();//WorkGroupManagement();
            internalFrame.setVisible(true);
            jdpDesktop = new TMSDesktop();
            jdpDesktop.add(internalFrame);
            internalFrame.setSelected(true);
            internalFrame.setLocation(200,200);
            setContentPane(jdpDesktop);

            jdpDesktop.setComponentOrientation(ComponentOrientation.getOrientation(LanguageAction.getLocale()));

        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public static void main(String[] args) {
        MainFormOld main = new MainFormOld();
        main.setVisible(true);
    }

    protected void showPersonEdit() {
/*
Login loginForm = new Login();
        loginForm.setVisible(true);
        jdpDesktop.add(loginForm);

     try {
            loginForm.setSelected(true);
        } catch (java.beans.Exception e) {
        }
*/

    }

    private void showUserManagement() throws Exception {
/* UserManagement userManagement = new UserManagement(jdpDesktop);
        userManagement.setVisible(true);
        jdpDesktop.add(userManagement);
        userManagement.setSelected(true);*/


    }

    private void showLanguageForm() throws Exception {
        LanguageAddForm languageForm = new LanguageAddForm();
        languageForm.setVisible(true);
        jdpDesktop.add(languageForm);
        languageForm.setSelected(true);


    }

    private void showWorkGroupManagement() throws Exception {
/*        WorkGroupManagement workGroupManagement = new WorkGroupManagement(jdpDesktop);
        workGroupManagement.setVisible(true);
        jdpDesktop.add(workGroupManagement);
        workGroupManagement.setSelected(true);*/

    }

    private void showCalendarManagment() throws Exception {
        CalendarManagement calendarManagement = new CalendarManagement(jdpDesktop);
        calendarManagement.setVisible(true);
        jdpDesktop.add(calendarManagement);
        calendarManagement.setSelected(true);

    }

    private void showPersonManagment() throws Exception {
/*PersonManagement personManagement = new PersonManagement(jdpDesktop);
        personManagement.setVisible(true);
        jdpDesktop.add(personManagement);
        personManagement.setSelected(true);*/


    }

    private void showRoleManagement() throws Exception {
/*        RoleManagement roleManagement = new RoleManagement(jdpDesktop);
        roleManagement.setVisible(true);
        jdpDesktop.add(roleManagement);
        roleManagement.setSelected(true);*/
    }

    private void showEventLogList() throws Exception {
/* EventLogList eventLogList = new EventLogList(jdpDesktop);
        eventLogList.setVisible(true);
        jdpDesktop.add(eventLogList);
        eventLogList.setSelected(true);*/

    }

 private void refreshMainForm() {
        jdpDesktop.setComponentOrientation(ComponentOrientation.getOrientation(LanguageAction.getLocale()));
        //languageMenu.setText(ThreadPoolManager.getLangValue("language"));
        //languageDefItem.setText(ThreadPoolManager.getLangValue("languageDef"));
        jdpDesktop.removeAll();
        jdpDesktop.revalidate();
        jdpDesktop.repaint();
    }


    private void showLookupInfo(Lookup lookup) throws Exception {
        BasicInfoManagement basicInfoManagement = new BasicInfoManagement(jdpDesktop, lookup);
        basicInfoManagement.setVisible(true);
        jdpDesktop.add(basicInfoManagement);
        basicInfoManagement.setSelected(true);
    }

    private void showLanguageDef() throws Exception {
/* LanguageAddForm languageManagement = new LanguageAddForm(jdpDesktop);
        languageManagement.setVisible(true);
        jdpDesktop.add(languageManagement);
        languageManagement.setSelected(true);*/

    }

    public JMenuBar createMenuBar(ComponentOrientation direction) {
        JMenuBar menuBar = null;
        try {
            menuBar = new JMenuBar();
            menuBar.setComponentOrientation(ComponentOrientation.getOrientation(LanguageAction.getLocale()));
            JMenu languageMenu = new JMenu();
            //JMenuItem languageDefItem = new JMenuItem(new ImageIcon(MainForm.class.getClassLoader().getResource("lang.png")));
            JMenuItem languageDefItem = new JMenuItem(new ImageIcon("./images/lang.png"));//todo
            languageDefItem.setComponentOrientation(direction);
            //JMenuItem importLanguage = new JMenuItem(new ImageIcon(MainForm.class.getClassLoader().getResource("keyboard.png")));
            JMenuItem importLanguage = new JMenuItem(new ImageIcon("./images/keyboard.png"));//todo
            importLanguage.setComponentOrientation(direction);
            languageMenu.setText(ThreadPoolManager.getLangValue("language"));
            languageDefItem.setText(ThreadPoolManager.getLangValue("languageDef"));
            importLanguage.setText(ThreadPoolManager.getLangValue("importLanguage"));
            languageMenu.add(languageDefItem);
            languageMenu.addSeparator();
            languageMenu.add(importLanguage);
            JMenu managementMenu = new JMenu();
//            JMenuItem workGroupManagementItem = new JMenuItem(new ImageIcon(MainForm.class.getClassLoader().getResource("groups.png")));
            JMenuItem workGroupManagementItem = new JMenuItem(new ImageIcon("./images/groups.png"));//todo
            workGroupManagementItem.setComponentOrientation(direction);
//            JMenuItem calendarManagementItem = new JMenuItem(new ImageIcon(MainForm.class.getClassLoader().getResource("calendar.png")));
            JMenuItem calendarManagementItem = new JMenuItem(new ImageIcon("./images/calendar.png"));//todo
            calendarManagementItem.setComponentOrientation(direction);
            calendarManagementItem.setVisible(false);
//            JMenuItem personManagementItem = new JMenuItem(new ImageIcon(MainForm.class.getClassLoader().getResource("person-mgnt.png")));
            JMenuItem personManagementItem = new JMenuItem(new ImageIcon("./images/person-mgnt.png"));//todo
            personManagementItem.setComponentOrientation(direction);
//            JMenuItem userManagementItem = new JMenuItem(new ImageIcon(MainForm.class.getClassLoader().getResource("user-mgnt.png")));
            JMenuItem userManagementItem = new JMenuItem(new ImageIcon("./images/user-mgnt.png"));//todo
            userManagementItem.setComponentOrientation(direction);
//            JMenuItem operationManagementItem = new JMenuItem(new ImageIcon(MainForm.class.getClassLoader().getResource("operation.png")));
            JMenuItem operationManagementItem = new JMenuItem(new ImageIcon("./images/operation.png"));//todo
            operationManagementItem.setComponentOrientation(direction);
           // JMenuItem eventLogListItem = new JMenuItem(new ImageIcon(MainForm.class.getClassLoader().getResource("event.png")));
            JMenuItem eventLogListItem = new JMenuItem(new ImageIcon("./images/event.png"));//todo
            eventLogListItem.setComponentOrientation(direction);
            workGroupManagementItem.setText(ThreadPoolManager.getLangValue("workgroup_management"));
            calendarManagementItem.setText(ThreadPoolManager.getLangValue("calendar_management"));
            personManagementItem.setText(ThreadPoolManager.getLangValue("person_management"));
            managementMenu.setText(ThreadPoolManager.getLangValue("management"));
            operationManagementItem.setText(ThreadPoolManager.getLangValue("operation_management"));
            userManagementItem.setText(ThreadPoolManager.getLangValue("user_management"));
            eventLogListItem.setText(ThreadPoolManager.getLangValue("eventLog_list"));
            managementMenu.add(workGroupManagementItem);
            managementMenu.addSeparator();
            managementMenu.add(operationManagementItem);
            managementMenu.addSeparator();
            managementMenu.add(userManagementItem);
            managementMenu.addSeparator();
            managementMenu.add(eventLogListItem);
            //managementMenu.addSeparator();
            managementMenu.add(calendarManagementItem);
            managementMenu.addSeparator();
            managementMenu.add(personManagementItem);
            JMenu basicInfoMenu = new JMenu();
            basicInfoMenu.setVisible(false);
            basicInfoMenu.setText(ThreadPoolManager.getLangValue("BasicInfo"));
            //JMenuItem exit = new JMenuItem(new ImageIcon(MainForm.class.getClassLoader().getResource("exit.png")));
            //JMenuItem exit = new JMenuItem(new ImageIcon("./images/exit.png"));//todo
            JMenuItem exit = new JMenuItem(new ImageIcon("D:\\ARIA\\CVSROOT\\project\\TMS\\resources\\images\\exit.png"));//todo
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
                    } catch (Exception e1) {
                        e1.printStackTrace();
                    }
                }
            });
            operationManagementItem.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    try {
                        showRoleManagement();
                    } catch (Exception e1) {
                        e1.printStackTrace();
                    }
                }
            });
            workGroupManagementItem.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    try {
                        showWorkGroupManagement();
                    } catch (Exception e1) {
                        e1.printStackTrace();
                    }
                }
            });
            eventLogListItem.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    try {
                        showEventLogList();
                    } catch (Exception e1) {
                        e1.printStackTrace();
                    }
                }
            });
            calendarManagementItem.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    try {
                        showCalendarManagment();
                    } catch (Exception e1) {
                        e1.printStackTrace();
                    }
                }
            });
            personManagementItem.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    try {
                        showPersonManagment();
                    } catch (Exception e1) {
                        e1.printStackTrace();
                    }
                }
            });
            languageDefItem.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    try {
                        showLanguageDef();
                    } catch (Exception e1) {
                        e1.printStackTrace();
                    }
                }
            });
            importLanguage.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    try {
                        showLanguageForm();
                    } catch (Exception e1) {
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

            webServiceInfo.setServiceName("/getAllDefinableLookup");
            final List<Lookup> lookups = new ObjectMapper().readValue(new RESTfulClientUtil().restFullService(webServiceInfo.getServerUrl(), webServiceInfo.getServiceName()), new TypeReference<List<Lookup>>() {
            });
            JMenuItem[] basicInfoMenus = new JMenuItem[lookups.size()];
            int i = 0;
            for (final Lookup lookup : lookups) {
                JMenuItem jMenuItem = new JMenuItem();
                jMenuItem.setVisible(false);
                jMenuItem.setText(ThreadPoolManager.getLangValue(lookup.getName()));
                jMenuItem.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        try {
                            showLookupInfo(lookup);
                        } catch (Exception e1) {
                            e1.printStackTrace();
                        }
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
