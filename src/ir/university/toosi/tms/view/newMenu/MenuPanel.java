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

    protected abstract void showDayManagment();

    protected abstract void showRuleManagment();

    protected abstract void showExceptionRuleManagment();

    protected abstract void showCameraManagment();

    protected abstract void showCardManagment();

    protected abstract void showGatewayManagment();

    protected abstract void showZoneManagment();

    protected abstract void showPDPManagment();

    protected abstract void exit();





    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents
        tabbedPane1 = new JTabbedPane();
        managementMenu = new JPanel();
        personManagementItem = new JButton();
        organManagementItem = new JButton();
        userManagementMenu = new JPanel();
        userManagementItem = new JButton();
        workGroupManagementItem = new JButton();
        roleManagementItem = new JButton();
        pcManagementItem = new JButton();
        regionsMenu = new JPanel();
        cameraItem = new JButton();
        cardItem = new JButton();
        gatewayItem = new JButton();
        zoneItem = new JButton();
        pdpItem = new JButton();
        calendarMenu = new JPanel();
        dayItem = new JButton();
        calendarItem = new JButton();
        ruleItem = new JButton();
        exceptionRuleItem = new JButton();
        operationMenu = new JPanel();
        languageDefItem = new JButton();
        eventLogListItem = new JButton();
        importLanguage = new JButton();
        exit = new JButton();

        //======== tabbedPane1 ========
        {
            tabbedPane1.setBorder(null);
            tabbedPane1.setMinimumSize(new Dimension(300, 100));
            tabbedPane1.setPreferredSize(new Dimension(300, 86));
            tabbedPane1.setFont(new Font("Tahoma", Font.PLAIN, 11));
            tabbedPane1.setMaximumSize(new Dimension(2000, 100));

            //======== managementMenu ========
            {
                managementMenu.setBorder(null);
                managementMenu.setFont(new Font("Tahoma", Font.PLAIN, 11));
                managementMenu.setLayout(new BoxLayout(managementMenu, BoxLayout.LINE_AXIS));

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

                //---- organManagementItem ----
                organManagementItem.setIcon(null);
                organManagementItem.setMaximumSize(new Dimension(80, 80));
                organManagementItem.setMinimumSize(new Dimension(80, 80));
                organManagementItem.setVerticalTextPosition(SwingConstants.BOTTOM);
                organManagementItem.setHorizontalTextPosition(SwingConstants.CENTER);
                organManagementItem.setText("\u0633\u0627\u0632\u0645\u0627\u0646");
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
            }
            tabbedPane1.addTab("\u0645\u062f\u06cc\u0631\u06cc\u062a \u0627\u0634\u062e\u0627\u0635", managementMenu);

            //======== userManagementMenu ========
            {
                userManagementMenu.setLayout(new BoxLayout(userManagementMenu, BoxLayout.LINE_AXIS));

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
                userManagementMenu.add(userManagementItem);

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
                userManagementMenu.add(workGroupManagementItem);

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
                userManagementMenu.add(roleManagementItem);

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
                userManagementMenu.add(pcManagementItem);
            }
            tabbedPane1.addTab("\u0645\u062f\u06cc\u0631\u06cc\u062a \u06a9\u0627\u0631\u0628\u0631\u0627\u0646", userManagementMenu);

            //======== regionsMenu ========
            {
                regionsMenu.setLayout(new BoxLayout(regionsMenu, BoxLayout.LINE_AXIS));

                //---- cameraItem ----
                cameraItem.setIcon(null);
                cameraItem.setMaximumSize(new Dimension(80, 80));
                cameraItem.setMinimumSize(new Dimension(80, 80));
                cameraItem.setText("\u062f\u0648\u0631\u0628\u06cc\u0646");
                cameraItem.setAlignmentX(0.5F);
                cameraItem.setVerticalTextPosition(SwingConstants.BOTTOM);
                cameraItem.setHorizontalTextPosition(SwingConstants.CENTER);
                cameraItem.setPreferredSize(new Dimension(80, 80));
                cameraItem.setFont(new Font("Tahoma", Font.PLAIN, 11));
                cameraItem.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        showCameraManagment();
                    }
                });
                regionsMenu.add(cameraItem);

                //---- cardItem ----
                cardItem.setIcon(null);
                cardItem.setMaximumSize(new Dimension(80, 80));
                cardItem.setMinimumSize(new Dimension(80, 80));
                cardItem.setText("\u06a9\u0627\u0631\u062a");
                cardItem.setAlignmentX(0.5F);
                cardItem.setVerticalTextPosition(SwingConstants.BOTTOM);
                cardItem.setHorizontalTextPosition(SwingConstants.CENTER);
                cardItem.setPreferredSize(new Dimension(80, 80));
                cardItem.setFont(new Font("Tahoma", Font.PLAIN, 11));
                cardItem.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        showCardManagment();
                    }
                });
                regionsMenu.add(cardItem);

                //---- gatewayItem ----
                gatewayItem.setIcon(null);
                gatewayItem.setMaximumSize(new Dimension(80, 80));
                gatewayItem.setMinimumSize(new Dimension(80, 80));
                gatewayItem.setText("\u06af\u0630\u0631\u06af\u0627\u0647");
                gatewayItem.setAlignmentX(0.5F);
                gatewayItem.setVerticalTextPosition(SwingConstants.BOTTOM);
                gatewayItem.setHorizontalTextPosition(SwingConstants.CENTER);
                gatewayItem.setPreferredSize(new Dimension(80, 80));
                gatewayItem.setFont(new Font("Tahoma", Font.PLAIN, 11));
                gatewayItem.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        showGatewayManagment();
                    }
                });
                regionsMenu.add(gatewayItem);

                //---- zoneItem ----
                zoneItem.setIcon(null);
                zoneItem.setMaximumSize(new Dimension(80, 80));
                zoneItem.setMinimumSize(new Dimension(80, 80));
                zoneItem.setText("\u0646\u0627\u062d\u06cc\u0647");
                zoneItem.setAlignmentX(0.5F);
                zoneItem.setVerticalTextPosition(SwingConstants.BOTTOM);
                zoneItem.setHorizontalTextPosition(SwingConstants.CENTER);
                zoneItem.setPreferredSize(new Dimension(80, 80));
                zoneItem.setFont(new Font("Tahoma", Font.PLAIN, 11));
                zoneItem.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        showZoneManagment();
                    }
                });
                regionsMenu.add(zoneItem);

                //---- pdpItem ----
                pdpItem.setIcon(null);
                pdpItem.setMaximumSize(new Dimension(80, 80));
                pdpItem.setMinimumSize(new Dimension(80, 80));
                pdpItem.setText("\u067e\u06cc \u062f\u06cc \u067e\u06cc");
                pdpItem.setAlignmentX(0.5F);
                pdpItem.setVerticalTextPosition(SwingConstants.BOTTOM);
                pdpItem.setHorizontalTextPosition(SwingConstants.CENTER);
                pdpItem.setPreferredSize(new Dimension(80, 80));
                pdpItem.setFont(new Font("Tahoma", Font.PLAIN, 9));
                pdpItem.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        showPDPManagment();
                    }
                });
                regionsMenu.add(pdpItem);
            }
            tabbedPane1.addTab("\u0646\u0648\u0627\u062d\u06cc", regionsMenu);

            //======== calendarMenu ========
            {
                calendarMenu.setLayout(new BoxLayout(calendarMenu, BoxLayout.LINE_AXIS));

                //---- dayItem ----
                dayItem.setIcon(null);
                dayItem.setMaximumSize(new Dimension(80, 80));
                dayItem.setMinimumSize(new Dimension(80, 80));
                dayItem.setText("\u0631\u0648\u0632\u06a9\u0627\u0631\u06cc");
                dayItem.setAlignmentX(0.5F);
                dayItem.setVerticalTextPosition(SwingConstants.BOTTOM);
                dayItem.setHorizontalTextPosition(SwingConstants.CENTER);
                dayItem.setPreferredSize(new Dimension(80, 80));
                dayItem.setFont(new Font("Tahoma", Font.PLAIN, 11));
                dayItem.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        showDayManagment();
                    }
                });
                calendarMenu.add(dayItem);

                //---- calendarItem ----
                calendarItem.setIcon(null);
                calendarItem.setMaximumSize(new Dimension(80, 80));
                calendarItem.setMinimumSize(new Dimension(80, 80));
                calendarItem.setText("\u062a\u0642\u0648\u06cc\u0645");
                calendarItem.setAlignmentX(0.5F);
                calendarItem.setVerticalTextPosition(SwingConstants.BOTTOM);
                calendarItem.setHorizontalTextPosition(SwingConstants.CENTER);
                calendarItem.setPreferredSize(new Dimension(80, 80));
                calendarItem.setFont(new Font("Tahoma", Font.PLAIN, 11));
                calendarItem.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        showCalendarManagment();
                    }
                });
                calendarMenu.add(calendarItem);

                //---- ruleItem ----
                ruleItem.setIcon(null);
                ruleItem.setMaximumSize(new Dimension(80, 80));
                ruleItem.setMinimumSize(new Dimension(80, 80));
                ruleItem.setText("\u062b\u0628\u062a \u0642\u0627\u0646\u0648\u0646 \u062c\u062f\u06cc\u062f");
                ruleItem.setAlignmentX(0.5F);
                ruleItem.setVerticalTextPosition(SwingConstants.BOTTOM);
                ruleItem.setHorizontalTextPosition(SwingConstants.CENTER);
                ruleItem.setPreferredSize(new Dimension(80, 80));
                ruleItem.setFont(new Font("Tahoma", Font.PLAIN, 8));
                ruleItem.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        showRuleManagment();
                    }
                });
                calendarMenu.add(ruleItem);

                //---- exceptionRuleItem ----
                exceptionRuleItem.setIcon(null);
                exceptionRuleItem.setMaximumSize(new Dimension(80, 80));
                exceptionRuleItem.setMinimumSize(new Dimension(80, 80));
                exceptionRuleItem.setText("\u062b\u0628\u062a \u0627\u0633\u062a\u062b\u0646\u0627\u0621");
                exceptionRuleItem.setAlignmentX(0.5F);
                exceptionRuleItem.setVerticalTextPosition(SwingConstants.BOTTOM);
                exceptionRuleItem.setHorizontalTextPosition(SwingConstants.CENTER);
                exceptionRuleItem.setPreferredSize(new Dimension(80, 80));
                exceptionRuleItem.setFont(new Font("Tahoma", Font.PLAIN, 8));
                exceptionRuleItem.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        showExceptionRuleManagment();
                    }
                });
                calendarMenu.add(exceptionRuleItem);
            }
            tabbedPane1.addTab("\u062a\u0642\u0648\u06cc\u0645", calendarMenu);

            //======== operationMenu ========
            {
                operationMenu.setBorder(null);
                operationMenu.setFont(new Font("Tahoma", Font.PLAIN, 11));
                operationMenu.setLayout(new BoxLayout(operationMenu, BoxLayout.LINE_AXIS));

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
                operationMenu.add(languageDefItem);

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
                operationMenu.add(eventLogListItem);

                //---- importLanguage ----
                importLanguage.setIcon(null);
                importLanguage.setMaximumSize(new Dimension(80, 80));
                importLanguage.setMinimumSize(new Dimension(80, 80));
                importLanguage.setHorizontalTextPosition(SwingConstants.CENTER);
                importLanguage.setVerticalTextPosition(SwingConstants.BOTTOM);
                importLanguage.setText("\u0648\u06cc\u0631\u0627\u06cc\u0634 \u0632\u0628\u0627\u0646");
                importLanguage.setPreferredSize(new Dimension(80, 80));
                importLanguage.setFont(new Font("Tahoma", Font.PLAIN, 11));
                importLanguage.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        showLanguageForm();
                    }
                });
                operationMenu.add(importLanguage);

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
                operationMenu.add(exit);
            }
            tabbedPane1.addTab("\u0639\u0645\u0644\u06cc\u0627\u062a", operationMenu);
        }
        // JFormDesigner - End of component initialization  //GEN-END:initComponents
        add(tabbedPane1);
    }

    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables
    private JTabbedPane tabbedPane1;
    private JPanel managementMenu;
    protected JButton personManagementItem;
    protected JButton organManagementItem;
    private JPanel userManagementMenu;
    protected JButton userManagementItem;
    protected JButton workGroupManagementItem;
    protected JButton roleManagementItem;
    protected JButton pcManagementItem;
    private JPanel regionsMenu;
    protected JButton cameraItem;
    protected JButton cardItem;
    protected JButton gatewayItem;
    protected JButton zoneItem;
    protected JButton pdpItem;
    private JPanel calendarMenu;
    protected JButton dayItem;
    protected JButton calendarItem;
    protected JButton ruleItem;
    protected JButton exceptionRuleItem;
    private JPanel operationMenu;
    protected JButton languageDefItem;
    protected JButton eventLogListItem;
    protected JButton importLanguage;
    protected JButton exit;
    // JFormDesigner - End of variables declaration  //GEN-END:variables
}

