package ir.university.toosi.tms.view;

//import ir.university.toosi.tms.view.newMenu.MenuPanel;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import ir.university.toosi.tms.controller.LanguageAction;
import ir.university.toosi.tms.model.entity.Languages;
import ir.university.toosi.tms.model.entity.WebServiceInfo;
import ir.university.toosi.tms.util.RESTfulClientUtil;
import ir.university.toosi.tms.util.ThreadPoolManager;
import ir.university.toosi.tms.view.calendar.CalendarManagement;
import ir.university.toosi.tms.view.eventlog.EventLogList;
import ir.university.toosi.tms.view.language.LanguageForm;
import ir.university.toosi.tms.view.language.LanguageManagementForm;
import ir.university.toosi.tms.view.newMenu.*;
import ir.university.toosi.tms.view.person.PersonManagement;
import ir.university.toosi.tms.view.role.RoleManagement;
import ir.university.toosi.tms.view.user.UserManagement;
import ir.university.toosi.tms.view.workgroup.WorkGroupManagement;

import javax.swing.*;
import javax.swing.event.InternalFrameEvent;
import javax.swing.event.InternalFrameListener;
import java.awt.*;
import java.awt.List;
import java.beans.PropertyVetoException;
import java.util.*;

public class MainForm extends JFrame implements InternalFrameListener {

    public MainForm(){
        try {
            Toolkit toolkit = Toolkit.getDefaultToolkit();
            int xSize = ((int) toolkit.getScreenSize().getWidth());
            int ySize = ((int) toolkit.getScreenSize().getHeight());
            setSize(xSize,  ySize);

            setDefaultLookAndFeelDecorated(true);
            setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            UIManager.setLookAndFeel("javax.swing.plaf.nimbus.NimbusLookAndFeel");

           // ThreadPoolManager.mainForm = this;
            ThreadPoolManager.mainForm = this;

            webServiceInfo.setServiceName("/getAllLanguage");

            java.util.List<Languages> languageList = new ObjectMapper().readValue(new RESTfulClientUtil().restFullService(webServiceInfo.getServerUrl(), webServiceInfo.getServiceName()), new TypeReference<java.util.List<Languages>>() {
            });


        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public static void main(String[] args) {
        MainForm mainForm = new MainForm();
        mainForm.createAndShowGUI();
    }

    private TMSDesktop desktopPane;
    private Login loginForm;
    private WebServiceInfo webServiceInfo = new WebServiceInfo();
    private void createAndShowGUI() {

        //set Main window Properties
        setVisible(true);
        setMinimumSize(new Dimension(800, 600));
        setMaximumSize(new Dimension(1024, 800));
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
        dividerPanel.setBackground(Color.green);
        dividerPanel.setPreferredSize(new Dimension((int) dividerPanel.getPreferredSize().getWidth(), 2));
        contentPane.add(dividerPanel);


        //add desktopPane for handling JInternalFrames
        //desktopPane = new JDesktopPane();
        desktopPane = new TMSDesktop();
        desktopPane.setBackground(new Color(238, 238, 238));
        contentPane.add(desktopPane);

        //add sample internal frame
        JInternalFrame sampleInternalFrame = new JInternalFrame();
        sampleInternalFrame.setVisible(true);
        sampleInternalFrame.setIconifiable(true);
        sampleInternalFrame.setMaximizable(true);
        sampleInternalFrame.setResizable(true);
        Container internalFrame1ContentPane = sampleInternalFrame.getContentPane();
        internalFrame1ContentPane.setLayout(null);

        { // compute preferred size
            Dimension preferredSize = new Dimension();
            for (int i = 0; i < internalFrame1ContentPane.getComponentCount(); i++) {
                Rectangle bounds = internalFrame1ContentPane.getComponent(i).getBounds();
                preferredSize.width = Math.max(bounds.x + bounds.width, preferredSize.width);
                preferredSize.height = Math.max(bounds.y + bounds.height, preferredSize.height);
            }
            Insets insets = internalFrame1ContentPane.getInsets();
            preferredSize.width += insets.right;
            preferredSize.height += insets.bottom;
            internalFrame1ContentPane.setMinimumSize(preferredSize);
            internalFrame1ContentPane.setPreferredSize(preferredSize);
        }
        sampleInternalFrame.setBounds(170, 65, 175, 105);
        desktopPane.add(sampleInternalFrame, JLayeredPane.DEFAULT_LAYER);


        loginForm = new Login(this);
        loginForm.setVisible(true);
        //desktopPane = new TMSDesktop();
        desktopPane.add(loginForm);
        try {
            loginForm.setSelected(true);
        } catch (PropertyVetoException e) {
            e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
        }
       // setContentPane(jdpDesktop);
        //jdpDesktop.setComponentOrientation(ComponentOrientation.getOrientation(LanguageAction.getLocale()));
        changeComonentOrientation(ComponentOrientation.getOrientation(LanguageAction.getLocale()));

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

    @Override
    public void internalFrameOpened(InternalFrameEvent e) {
    }

    @Override
    public void internalFrameClosing(InternalFrameEvent e) {
        e.getInternalFrame().dispose();
    }

    @Override
    public void internalFrameClosed(InternalFrameEvent e) {
    }

    @Override
    public void internalFrameIconified(InternalFrameEvent e) {
    }

    @Override
    public void internalFrameDeiconified(InternalFrameEvent e) {
    }

    @Override
    public void internalFrameActivated(InternalFrameEvent e) {
    }

    @Override
    public void internalFrameDeactivated(InternalFrameEvent e) {
    }

    //define innerClass to Override its methods for handle events
    class MenuPaneActionAvailable extends MenuPanel {
        MenuPaneActionAvailable() {
            super();
        }

        @Override
        protected void showUserManagement(){
            UserManagement userManagement = new UserManagement(desktopPane);
            userManagement.setVisible(true);
            desktopPane.add(userManagement);
            try {
                userManagement.setSelected(true);
            } catch (PropertyVetoException e) {
                e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
            }
        }

        @Override
        protected void showRoleManagement(){
            RoleManagement roleManagement = new RoleManagement(desktopPane);
            roleManagement.setVisible(true);
            desktopPane.add(roleManagement);
            try {
                roleManagement.setSelected(true);
            } catch (PropertyVetoException e) {
                e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
            }
        }

        @Override
        protected void showWorkGroupManagement(){
            WorkGroupManagement workGroupManagement = new WorkGroupManagement(desktopPane);
            workGroupManagement.setVisible(true);
            desktopPane.add(workGroupManagement);
            try {
                workGroupManagement.setSelected(true);
            } catch (PropertyVetoException e) {
                e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
            }
        }

        @Override
        protected void showEventLogList(){
            EventLogList eventLogList = new EventLogList(desktopPane);
            eventLogList.setVisible(true);
            desktopPane.add(eventLogList);
            try {
                eventLogList.setSelected(true);
            } catch (PropertyVetoException e) {
                e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
            }
        }

        @Override
        protected void showCalendarManagment(){
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
        protected void showPersonManagment(){
            PersonManagement personManagement = new PersonManagement(desktopPane);
            personManagement.setVisible(true);
            desktopPane.add(personManagement);
            try {
                personManagement.setSelected(true);
            } catch (PropertyVetoException e) {
                e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
            }
        }

        @Override
        protected void showLanguageDef(){
            LanguageManagementForm languageManagement = new LanguageManagementForm(desktopPane);
            languageManagement.setVisible(true);
            desktopPane.add(languageManagement);
            try {
                languageManagement.setSelected(true);
            } catch (PropertyVetoException e) {
                e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
            }
        }

        @Override
        protected void showLanguageForm(){
            LanguageForm languageForm = new LanguageForm(desktopPane);
            languageForm.setVisible(true);
            desktopPane.add(languageForm);
            try {
                languageForm.setSelected(true);
            } catch (PropertyVetoException e) {
                e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
            }
        }

        @Override
        protected void exit(){
           /* int confirm = JOptionPane.showOptionDialog(this,"",);
            int confirm = JOptionPane.showOptionDialog(this, "ExitMassage),
                    "Exit Confirmation", JOptionPane.YES_NO_OPTION,
                    JOptionPane.QUESTION_MESSAGE, null, null, null);
            if (confirm == JOptionPane.YES_OPTION) {
               // saveSettings(); //save prop
                System.exit(1);
            }*/
            System.exit(1);
        }



    }

}
