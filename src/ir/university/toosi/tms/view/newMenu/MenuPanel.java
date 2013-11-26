package ir.university.toosi.tms.view.newMenu;

import java.awt.event.*;
import javax.swing.*;
import java.awt.*;
import org.jdesktop.swingx.*;


/*
 * Created by JFormDesigner on Sat Sep 28 18:18:38 AFT 2013
 */


/**
 * @author a_hadadi
 */
public abstract class MenuPanel extends JPanel {


    public MenuPanel() {
       // super("InternalFrameDemo");
        //setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        setLayout(new BoxLayout(this, BoxLayout.PAGE_AXIS));
        initComponents();
        setVisible(true);
        //  setComponentOrientation(ComponentOrientation.RIGHT_TO_LEFT);
    }



    protected abstract void showUserManagement();

    protected abstract void showRoleManagement();

    protected abstract void showWorkGroupManagement();

    protected abstract void showEventLogList();

    protected abstract void showCalendarManagment();

    protected abstract void showPCManagment();

    protected abstract void showLanguageDef();

    protected abstract void showLanguageForm();

    protected abstract void showOrganManagment();

    protected abstract void showPersonManagment();



    protected abstract void exit();





    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents
        tabbedPane1 = new JTabbedPane();
        languageMenu = new JPanel();
        languageDefItem = new JButton();
        importLanguage = new JButton();
        managementMenu = new JPanel();
        workGroupManagementItem = new JButton();
        roleManagementItem = new JButton();
        userManagementItem = new JButton();
        personManagementItem = new JButton();
        pcManagementItem = new JButton();
        organManagementItem = new JButton();
        eventLogListItem = new JButton();
        exitMenu = new JPanel();
        exit = new JButton();

        //======== tabbedPane1 ========
        {
            tabbedPane1.setBorder(null);
            tabbedPane1.setMinimumSize(new Dimension(300, 100));
            tabbedPane1.setPreferredSize(new Dimension(300, 86));
            tabbedPane1.setFont(new Font("Tahoma", Font.PLAIN, 11));
            tabbedPane1.setMaximumSize(new Dimension(2000, 100));

            //======== languageMenu ========
            {
                languageMenu.setBorder(null);
                languageMenu.setComponentOrientation(ComponentOrientation.LEFT_TO_RIGHT);
                languageMenu.setFont(new Font("Tahoma", Font.PLAIN, 11));
                languageMenu.setLayout(new BoxLayout(languageMenu, BoxLayout.LINE_AXIS));

                //---- languageDefItem ----
                languageDefItem.setIcon(null);
                languageDefItem.setMaximumSize(new Dimension(80, 80));
                languageDefItem.setMinimumSize(new Dimension(80, 80));
                languageDefItem.setText("\u0627\u06cc\u062c\u0627\u062f");
                languageDefItem.setAlignmentX(0.5F);
                languageDefItem.setVerticalTextPosition(SwingConstants.BOTTOM);
                languageDefItem.setHorizontalTextPosition(SwingConstants.CENTER);
                languageDefItem.setPreferredSize(new Dimension(80, 80));
                languageDefItem.setFont(new Font("Tahoma", Font.PLAIN, 11));
                languageDefItem.setVisible(false);
                languageDefItem.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        showLanguageDef();
                    }
                });
                languageMenu.add(languageDefItem);

                //---- importLanguage ----
                importLanguage.setIcon(null);
                importLanguage.setMaximumSize(new Dimension(80, 80));
                importLanguage.setMinimumSize(new Dimension(80, 80));
                importLanguage.setHorizontalTextPosition(SwingConstants.CENTER);
                importLanguage.setVerticalTextPosition(SwingConstants.BOTTOM);
                importLanguage.setText("\u0648\u06cc\u0631\u0627\u06cc\u0634");
                importLanguage.setPreferredSize(new Dimension(80, 80));
                importLanguage.setFont(new Font("Tahoma", Font.PLAIN, 11));
                importLanguage.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        showLanguageForm();
                    }
                });
                languageMenu.add(importLanguage);
            }
            tabbedPane1.addTab("\u0632\u0628\u0627\u0646", languageMenu);

            //======== managementMenu ========
            {
                managementMenu.setBorder(null);
                managementMenu.setFont(new Font("Tahoma", Font.PLAIN, 11));
                managementMenu.setLayout(new BoxLayout(managementMenu, BoxLayout.LINE_AXIS));

                //---- workGroupManagementItem ----
                workGroupManagementItem.setIcon(null);
                workGroupManagementItem.setMaximumSize(new Dimension(80, 80));
                workGroupManagementItem.setMinimumSize(new Dimension(80, 80));
                workGroupManagementItem.setText("\u06af\u0631\u0648\u0647 \u06a9\u0627\u0631\u06cc");
                workGroupManagementItem.setVerticalTextPosition(SwingConstants.BOTTOM);
                workGroupManagementItem.setHorizontalTextPosition(SwingConstants.CENTER);
                workGroupManagementItem.setAlignmentX(0.5F);
                workGroupManagementItem.setPreferredSize(new Dimension(80, 80));
                workGroupManagementItem.setFont(new Font("Tahoma", Font.PLAIN, 11));
                workGroupManagementItem.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        showWorkGroupManagement();
                    }
                });
                managementMenu.add(workGroupManagementItem);

                //---- roleManagementItem ----
                roleManagementItem.setIcon(null);
                roleManagementItem.setMinimumSize(new Dimension(80, 80));
                roleManagementItem.setMaximumSize(new Dimension(80, 80));
                roleManagementItem.setHorizontalTextPosition(SwingConstants.CENTER);
                roleManagementItem.setVerticalTextPosition(SwingConstants.BOTTOM);
                roleManagementItem.setText("\u0646\u0642\u0634");
                roleManagementItem.setAlignmentX(0.5F);
                roleManagementItem.setPreferredSize(new Dimension(80, 80));
                roleManagementItem.setFont(new Font("Tahoma", Font.PLAIN, 11));
                roleManagementItem.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        showRoleManagement();
                    }
                });
                managementMenu.add(roleManagementItem);

                //---- userManagementItem ----
                userManagementItem.setIcon(null);
                userManagementItem.setMaximumSize(new Dimension(80, 80));
                userManagementItem.setMinimumSize(new Dimension(80, 80));
                userManagementItem.setVerticalTextPosition(SwingConstants.BOTTOM);
                userManagementItem.setHorizontalTextPosition(SwingConstants.CENTER);
                userManagementItem.setText("\u06a9\u0627\u0631\u0628\u0631\u0627\u0646");
                userManagementItem.setAlignmentX(0.5F);
                userManagementItem.setPreferredSize(new Dimension(80, 80));
                userManagementItem.setFont(new Font("Tahoma", Font.PLAIN, 11));
                userManagementItem.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        showUserManagement();
                    }
                });
                managementMenu.add(userManagementItem);

                //---- personManagementItem ----
                personManagementItem.setIcon(null);
                personManagementItem.setMaximumSize(new Dimension(80, 80));
                personManagementItem.setMinimumSize(new Dimension(80, 80));
                personManagementItem.setVerticalTextPosition(SwingConstants.BOTTOM);
                personManagementItem.setHorizontalTextPosition(SwingConstants.CENTER);
                personManagementItem.setText("\u0627\u0634\u062e\u0627\u0635");
                personManagementItem.setAlignmentX(0.5F);
                personManagementItem.setPreferredSize(new Dimension(80, 80));
                personManagementItem.setFont(new Font("Tahoma", Font.PLAIN, 11));
                personManagementItem.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        showPersonManagment();
                    }
                });
                managementMenu.add(personManagementItem);

                //---- pcManagementItem ----
                pcManagementItem.setIcon(null);
                pcManagementItem.setMaximumSize(new Dimension(80, 80));
                pcManagementItem.setMinimumSize(new Dimension(80, 80));
                pcManagementItem.setVerticalTextPosition(SwingConstants.BOTTOM);
                pcManagementItem.setHorizontalTextPosition(SwingConstants.CENTER);
                pcManagementItem.setText("\u0631\u0627\u06cc\u0627\u0646\u0647");
                pcManagementItem.setAlignmentX(0.5F);
                pcManagementItem.setPreferredSize(new Dimension(80, 80));
                pcManagementItem.setFont(new Font("Tahoma", Font.PLAIN, 11));
                pcManagementItem.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        showPCManagment();
                    }
                });
                managementMenu.add(pcManagementItem);

                //---- organManagementItem ----
                organManagementItem.setIcon(null);
                organManagementItem.setMaximumSize(new Dimension(80, 80));
                organManagementItem.setMinimumSize(new Dimension(80, 80));
                organManagementItem.setVerticalTextPosition(SwingConstants.BOTTOM);
                organManagementItem.setHorizontalTextPosition(SwingConstants.CENTER);
                organManagementItem.setText("\u0627\u0631\u06af\u0627\u0646");
                organManagementItem.setAlignmentX(0.5F);
                organManagementItem.setPreferredSize(new Dimension(80, 80));
                organManagementItem.setFont(new Font("Tahoma", Font.PLAIN, 11));
                organManagementItem.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        showOrganManagment();
                    }
                });
                managementMenu.add(organManagementItem);

                //---- eventLogListItem ----
                eventLogListItem.setIcon(null);
                eventLogListItem.setMaximumSize(new Dimension(80, 80));
                eventLogListItem.setMinimumSize(new Dimension(80, 80));
                eventLogListItem.setVerticalTextPosition(SwingConstants.BOTTOM);
                eventLogListItem.setHorizontalTextPosition(SwingConstants.CENTER);
                eventLogListItem.setText("\u0631\u0648\u06cc\u062f\u0627\u062f");
                eventLogListItem.setAlignmentX(0.5F);
                eventLogListItem.setPreferredSize(new Dimension(80, 80));
                eventLogListItem.setFont(new Font("Tahoma", Font.PLAIN, 11));
                eventLogListItem.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        showEventLogList();
                    }
                });
                managementMenu.add(eventLogListItem);
            }
            tabbedPane1.addTab("\u0645\u062f\u06cc\u0631\u06cc\u062a", managementMenu);

            //======== exitMenu ========
            {
                exitMenu.setBorder(null);
                exitMenu.setFont(new Font("Tahoma", Font.PLAIN, 11));
                exitMenu.setLayout(new BoxLayout(exitMenu, BoxLayout.LINE_AXIS));

                //---- exit ----
                exit.setIcon(null);
                exit.setMaximumSize(new Dimension(80, 80));
                exit.setMinimumSize(new Dimension(80, 80));
                exit.setText("\u062e\u0631\u0648\u062c");
                exit.setAlignmentX(0.5F);
                exit.setVerticalTextPosition(SwingConstants.BOTTOM);
                exit.setHorizontalTextPosition(SwingConstants.CENTER);
                exit.setPreferredSize(new Dimension(80, 80));
                exit.setFont(new Font("Tahoma", Font.PLAIN, 11));
                exit.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        exit();
                    }
                });
                exitMenu.add(exit);
            }
            tabbedPane1.addTab("\u0639\u0645\u0644\u06cc\u0627\u062a", exitMenu);
        }
        // JFormDesigner - End of component initialization  //GEN-END:initComponents
        add(tabbedPane1);
    }

    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables
    private JTabbedPane tabbedPane1;
    private JPanel languageMenu;
    protected JButton languageDefItem;
    protected JButton importLanguage;
    private JPanel managementMenu;
    protected JButton workGroupManagementItem;
    protected JButton roleManagementItem;
    protected JButton userManagementItem;
    protected JButton personManagementItem;
    protected JButton pcManagementItem;
    protected JButton organManagementItem;
    protected JButton eventLogListItem;
    private JPanel exitMenu;
    protected JButton exit;
    // JFormDesigner - End of variables declaration  //GEN-END:variables
}

