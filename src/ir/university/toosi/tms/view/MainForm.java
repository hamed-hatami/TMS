package ir.university.toosi.tms.view;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import ir.university.toosi.tms.model.entity.Languages;
import ir.university.toosi.tms.model.entity.WebServiceInfo;
import ir.university.toosi.tms.util.ComponentUtil;
import ir.university.toosi.tms.util.RESTfulClientUtil;
import ir.university.toosi.tms.util.ThreadPoolManager;
import ir.university.toosi.tms.view.calendar.CalendarManagement;
import ir.university.toosi.tms.view.eventlog.EventLogList;
import ir.university.toosi.tms.view.language.LanguageAddForm;
import ir.university.toosi.tms.view.language.LanguageManagementCode;
import ir.university.toosi.tms.view.newMenu.MenuPanel;
import ir.university.toosi.tms.view.person.PersonManagement;
import ir.university.toosi.tms.view.role.RoleManagementCode;
import ir.university.toosi.tms.view.user.UserManagementCode;
import ir.university.toosi.tms.view.workgroup.LoginForm;
import ir.university.toosi.tms.view.workgroup.WorkGroupManagementCode;

import javax.swing.*;
import java.awt.*;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.beans.PropertyVetoException;
import java.io.IOException;

public class MainForm extends JFrame implements WindowListener {

    private TMSDesktop desktopPane;
    private WebServiceInfo webServiceInfo = new WebServiceInfo();
    private ComponentOrientation direction;

    public MainForm() {
        super("سامانه مدیریت تردد");//todo from bundle
        ThreadPoolManager.isDebugMode = true;//todo change when create jar file
        addWindowListener(this);
        setSize();

        setDefaultLookAndFeelDecorated(true);
        setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
        try {
            UIManager.setLookAndFeel("com.sun.java.swing.plaf.windows.WindowsLookAndFeel");
        } catch (Exception e) {
            e.printStackTrace();
        }

        // ThreadPoolManager.mainForm = this;
        ThreadPoolManager.mainForm = this;

        webServiceInfo.setServiceName("/getAllLanguage");

        try {
            java.util.List<Languages> languageList = new ObjectMapper().readValue(new RESTfulClientUtil().restFullService(webServiceInfo.getServerUrl(), webServiceInfo.getServiceName()), new TypeReference<java.util.List<Languages>>() {
            });
        } catch (IOException e) {
            e.printStackTrace();
        }


    }

    public static void main(String[] args) {
        // LoginF

        MainForm mainForm = new MainForm();
        mainForm.createAndShowGUI();
    }

    public void setSize() {
        setMinimumSize(new Dimension(600, 400));
        setPreferredSize(new Dimension(600, 400));
        Toolkit kit = Toolkit.getDefaultToolkit();
        Dimension screenSize = kit.getScreenSize();
        setLocation(20, 20);
        screenSize.setSize(screenSize.getWidth() - 40, screenSize.getHeight() - 80);
        setSize(screenSize);
        setMaximumSize(screenSize);

    }

    private void createAndShowGUI() {

        LoginForm loginFormDialog = new LoginForm();
        loginFormDialog.setModal(true);
        loginFormDialog.setVisible(true);

        if (!loginFormDialog.isLogin()) {
            System.exit(1);// todo
        }
        direction = loginFormDialog.direction;

        //set Main window Properties
        setVisible(true);


        // setMaximumSize(new Dimension(1024, 800));
        setBackground(new Color(234, 234, 255));
        Container contentPane = getContentPane();
        contentPane.setLayout(new BoxLayout(contentPane, BoxLayout.PAGE_AXIS));

        //add graphical menu panel
        MenuPaneActionAvailable menuPaneActionAvailable = new MenuPaneActionAvailable();
        menuPaneActionAvailable.setMinimumSize(new Dimension((int) menuPaneActionAvailable.getPreferredSize().getWidth(), 100));
        menuPaneActionAvailable.setPreferredSize(new Dimension((int) menuPaneActionAvailable.getPreferredSize().getWidth(), 100));
        contentPane.add(menuPaneActionAvailable);

        //add divider
        JPanel dividerPanel = new JPanel();
        dividerPanel.setBackground(new Color(240, 240, 240));
        dividerPanel.setPreferredSize(new Dimension((int) dividerPanel.getPreferredSize().getWidth(), 2));
        contentPane.add(dividerPanel);


        //add desktopPane for handling JInternalFrames
        //desktopPane = new JDesktopPane();
        desktopPane = new TMSDesktop();
        desktopPane.setBackground(new Color(238, 238, 238));
        contentPane.add(desktopPane);

        changeComonentOrientation(direction);

    }

    public void changeComonentOrientationRecurcive(Component[] components, ComponentOrientation orientation) {
        for (Component c : components) {
            c.setComponentOrientation(orientation);
            if (c instanceof java.awt.Container)
                changeComonentOrientationRecurcive(((java.awt.Container) c).getComponents(), orientation);
        }
    }

    public void changeComonentOrientation(ComponentOrientation orientation) {
        changeComonentOrientationRecurcive(this.getComponents(), orientation);
        repaint();
        revalidate();
    }

    public TMSDesktop getDesktopPane() {
        return desktopPane;
    }

    private void exitOP() {
        String msg = "آیا برای خروج مطمئن هستید ؟" ;
       // msg =  ThreadPoolManager.getLangValue("closeConfirm");//todo load from lang
        int confirm = JOptionPane.showOptionDialog(this,msg , "", JOptionPane.YES_NO_OPTION,
                JOptionPane.QUESTION_MESSAGE, null, null, null);
        if (confirm == JOptionPane.YES_OPTION) {
            // saveSettings(); //save prop
            System.exit(1);
        }
    }

    @Override
    public void windowOpened(WindowEvent e) {
    }

    @Override
    public void windowClosing(WindowEvent e) {
        exitOP();
    }

    @Override
    public void windowClosed(WindowEvent e) {
    }

    @Override
    public void windowIconified(WindowEvent e) {
    }

    @Override
    public void windowDeiconified(WindowEvent e) {
    }

    @Override
    public void windowActivated(WindowEvent e) {
    }

    @Override
    public void windowDeactivated(WindowEvent e) {
    }

    //define innerClass to Override its methods for handle events
    class MenuPaneActionAvailable extends MenuPanel {
        MenuPaneActionAvailable() {
            super();

            languageDefItem.setIcon(ComponentUtil.getImageIcon("lang.png", getClass()));
            importLanguage.setIcon(ComponentUtil.getImageIcon("lang.png", getClass()));
            workGroupManagementItem.setIcon(ComponentUtil.getImageIcon("workgroup-menu.png", getClass()));
            operationManagementItem.setIcon(ComponentUtil.getImageIcon("role-menu.png", getClass()));
            userManagementItem.setIcon(ComponentUtil.getImageIcon("users-menu.png", getClass()));
            eventLogListItem.setIcon(ComponentUtil.getImageIcon("event.png", getClass()));
            personManagementItem.setIcon(ComponentUtil.getImageIcon("account-menu.png", getClass()));
            exit.setIcon(ComponentUtil.getImageIcon("exit.png", getClass()));

        }

        @Override
        protected void showUserManagement() {
            /*UserManagement userManagement = new UserManagement();
            userManagement.setVisible(true);
            desktopPane.add(userManagement);
            try {
                userManagement.setSelected(true);
            } catch (PropertyVetoException e) {
                e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
            }*/

            UserManagementCode userManagement = new UserManagementCode();
            userManagement.setVisible(true);
            desktopPane.add(userManagement);
            try {
                userManagement.setSelected(true);
            } catch (PropertyVetoException e) {
                e.printStackTrace();
            }

        }

        @Override
        protected void showRoleManagement() {
            //done with jform designer
            RoleManagementCode roleManagementCode = new RoleManagementCode();
            roleManagementCode.setVisible(true);
            desktopPane.add(roleManagementCode);
            try {
                roleManagementCode.setSelected(true);
            } catch (PropertyVetoException e) {
                e.printStackTrace();
            }
        }

        @Override
        protected void showWorkGroupManagement() {
            WorkGroupManagementCode workGroupManagement = new WorkGroupManagementCode();
            workGroupManagement.setVisible(true);
            desktopPane.add(workGroupManagement);
            try {
                workGroupManagement.setSelected(true);
            } catch (PropertyVetoException e) {
                e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
            }
        }

        @Override
        protected void showEventLogList() {
            EventLogList eventLogList = new EventLogList();
            eventLogList.setVisible(true);
            desktopPane.add(eventLogList);
            try {
                eventLogList.setSelected(true);
            } catch (PropertyVetoException e) {
                e.printStackTrace();
            }
        }

        @Override
        protected void showCalendarManagment() {
            CalendarManagement calendarManagement = new CalendarManagement(desktopPane);
            calendarManagement.setVisible(true);
            desktopPane.add(calendarManagement);
            try {
                calendarManagement.setSelected(true);
            } catch (PropertyVetoException e) {
                e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
            }
        }

        @Override
        protected void showPersonManagment() {
            PersonManagement personManagement = new PersonManagement();
            personManagement.setVisible(true);
            desktopPane.add(personManagement);
            try {
                personManagement.setSelected(true);
            } catch (PropertyVetoException e) {
                e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
            }
        }

        @Override
        protected void showLanguageDef() {
            //done with jform designer
            LanguageAddForm languageAddForm = new LanguageAddForm();
            languageAddForm.setVisible(true);
            desktopPane.add(languageAddForm);
            try {
                languageAddForm.setSelected(true);
            } catch (PropertyVetoException e) {
                e.printStackTrace();
            }
        }

        @Override
        protected void showLanguageForm() {
            //done with jform designer
            LanguageManagementCode languageManagementCode = new LanguageManagementCode();
            languageManagementCode.setVisible(true);
            desktopPane.add(languageManagementCode);
            try {
                languageManagementCode.setSelected(true);
            } catch (PropertyVetoException e) {
                e.printStackTrace();
            }
        }

        @Override
        protected void exit() {
            exitOP();
        }

    }

}
