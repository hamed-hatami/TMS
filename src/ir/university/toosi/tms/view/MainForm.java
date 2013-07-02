package ir.university.toosi.tms.view;

import ir.university.toosi.tms.controller.LanguageAction;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.security.AccessController;
import java.security.PrivilegedAction;

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


    @Override
    public void init() {

        Frame[] frames = Frame.getFrames();
        for (Frame frame : frames) {
            frame.setMenuBar(null);
            frame.setTitle("Traffic Management System");
            frame.pack();
        }

        jdpDesktop = new JDesktopPane();
        setContentPane(jdpDesktop);
        setJMenuBar(createMenuBar());
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
        menu.setText(LanguageAction.getBundleMessage("frame"));
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
        Login frame = new Login();
        frame.setVisible(true);
        jdpDesktop.add(frame);
        try {
            frame.setSelected(true);
        } catch (java.beans.PropertyVetoException e) {
        }
    }

    private void refreshMainForm() {
        jdpDesktop.setComponentOrientation(ComponentOrientation.getOrientation(LanguageAction.getLocale()));
        menuBar.setComponentOrientation(ComponentOrientation.getOrientation(LanguageAction.getLocale()));
        menu.setText(LanguageAction.getBundleMessage("frame"));
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

}
