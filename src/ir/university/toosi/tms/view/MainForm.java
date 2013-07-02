package ir.university.toosi.tms.view;

import ir.university.toosi.tms.controller.LanguageAction;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.beans.PropertyVetoException;

/**
 * @author : Hamed Hatami , Javad Sarhadi , Farzad Sedaghatbin, Atefeh Ahmadi
 * @version : 1.0
 */

public class MainForm extends JApplet implements ActionListener {

    private JDesktopPane jdpDesktop;
    private JMenuBar menuBar;
    private JMenu menu;
    private JMenu languageMenu;
    private JMenuItem menuItem;
    private JMenuItem persianItem;
    private JMenuItem englishItem;
    Login loginForm;

    @Override
    public void init() {

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
            e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
        }

        setContentPane(jdpDesktop);
        menuBar=createMenuBar();
        setJMenuBar(menuBar);
        menuBar.setVisible(false);

        jdpDesktop.putClientProperty("JDesktopPane.dragMode", "outline");
        jdpDesktop.setComponentOrientation(ComponentOrientation.getOrientation(LanguageAction.getLocale()));
        menuBar.setComponentOrientation(ComponentOrientation.getOrientation(LanguageAction.getLocale()));

    }


    protected JMenuBar createMenuBar() {
        menuBar = new JMenuBar();
        menu = new JMenu();
        languageMenu = new JMenu();
        menuItem = new JMenuItem();
        persianItem = new JMenuItem();
        englishItem = new JMenuItem();
        menuBar.setComponentOrientation(ComponentOrientation.getOrientation(LanguageAction.getLocale()));
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
        menuBar.add(menu);
        menuBar.add(languageMenu);
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
        if (e.getSource() == menuItem) {
            showPersonEdit();
        }
        if (e.getSource() == persianItem) {
            LanguageAction.changeLocale("fa");
            refreshMainForm();
        }
        if (e.getSource() == englishItem) {
            LanguageAction.changeLocale("en");
            refreshMainForm();
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
}
