package ir.university.toosi.tms.view;

//import ir.university.toosi.tms.view.newMenu.MenuPanel;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import ir.university.toosi.tms.model.entity.Languages;
import ir.university.toosi.tms.model.entity.WebServiceInfo;
import ir.university.toosi.tms.util.RESTfulClientUtil;
import ir.university.toosi.tms.util.ThreadPoolManager;
import ir.university.toosi.tms.view.calendar.CalendarManagement;
import ir.university.toosi.tms.view.eventlog.EventLogList;
import ir.university.toosi.tms.view.language.LanguageAddForm;
import ir.university.toosi.tms.view.language.LanguageManagementCode;
import ir.university.toosi.tms.view.newMenu.*;
import ir.university.toosi.tms.view.person.PersonManagement;
import ir.university.toosi.tms.view.role.RoleManagementCode;
import ir.university.toosi.tms.view.user.UserManagement;
import ir.university.toosi.tms.view.user.UserManagementCode;
import ir.university.toosi.tms.view.workgroup.LoginForm;
import ir.university.toosi.tms.view.workgroup.WorkGroupManagementCode;

import javax.swing.*;
import java.awt.*;
import java.beans.PropertyVetoException;
import java.io.IOException;

public class MainForm extends JFrame {

    public MainForm(){

            /*Toolkit toolkit = Toolkit.getDefaultToolkit();
            int xSize = ((int) toolkit.getScreenSize().getWidth());
            int ySize = ((int) toolkit.getScreenSize().getHeight());
            setSize(xSize,  ySize);*/
            super("سامانه مدیریت تردد");//todo from bundle
            setSize();

            setDefaultLookAndFeelDecorated(true);
            setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        try {
            UIManager.setLookAndFeel("javax.swing.plaf.nimbus.NimbusLookAndFeel");
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

    private TMSDesktop desktopPane;
   // private Login loginForm;
    private WebServiceInfo webServiceInfo = new WebServiceInfo();
    private ComponentOrientation direction;


    public void setSize() {
        setMinimumSize(new Dimension(600, 400));
        setPreferredSize(new Dimension(600, 400));
        Toolkit kit = Toolkit.getDefaultToolkit();
        Dimension screenSize = kit.getScreenSize();
        setLocation(20, 20);
        screenSize.setSize( screenSize.getWidth()-40,screenSize.getHeight() - 80);
        setSize(screenSize);
        setMaximumSize(screenSize);

    }

    private void createAndShowGUI() {

        LoginForm loginFormDialog = new LoginForm();
        loginFormDialog.setModal(true);
        loginFormDialog.setVisible(true);

        if(!loginFormDialog.isLogin()){
            System.exit(1);// todo
        }
        direction =loginFormDialog.direction;

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


       /* try {
            Image image ;//= Toolkit.getDefaultToolkit().getImage("/ir/university/toosi/tms/view/images/big-logo.png");
            String s = "/ir/university/toosi/tms/view/images/big-logo.png";
            image =new ImageIcon(getClass().getResource(s)).getImage();
            ImageCanvas imageCanvas = new ImageCanvas(image);
           // imageCanvas.setLayout();
            imageCanvas.setMinimumSize(new Dimension(desktopPane.getWidth(),80));
            imageCanvas.setMaximumSize(new Dimension(desktopPane.getWidth(),80));
            imageCanvas.setPreferredSize(new Dimension(desktopPane.getWidth(),80));
            imageCanvas.setSize(desktopPane.getWidth(),80);
            imageCanvas.setVisible(true);
            contentPane.add(imageCanvas,SwingConstants.BOTTOM);
            imageCanvas.setSize(desktopPane.getWidth(),80);
            desktopPane.add(imageCanvas);

        }catch (Exception e){
            e.printStackTrace();
        }*/


       // changeComonentOrientation(ComponentOrientation.getOrientation(LanguageAction.getLocale()));
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


    //define innerClass to Override its methods for handle events
    class MenuPaneActionAvailable extends MenuPanel {
        MenuPaneActionAvailable() {
            super();
        }

        @Override
        protected void showUserManagement(){
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
        protected void showRoleManagement(){
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
        protected void showWorkGroupManagement(){
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
        protected void showEventLogList(){
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
        protected void showLanguageDef(){
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
        protected void showLanguageForm(){
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
        protected void exit(){
           // int confirm = JOptionPane.showOptionDialog(this,"",);
            int confirm = JOptionPane.showOptionDialog(this, "ExitMassage","Exit Confirmation", JOptionPane.YES_NO_OPTION,
                    JOptionPane.QUESTION_MESSAGE, null, null, null);
            if (confirm == JOptionPane.YES_OPTION) {
               // saveSettings(); //save prop
                System.exit(1);
            }
           // System.exit(1);
        }



    }

}
