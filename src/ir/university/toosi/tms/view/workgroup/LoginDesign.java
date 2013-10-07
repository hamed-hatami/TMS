/*
 * Created by JFormDesigner on Thu Oct 03 13:07:02 AFT 2013
 */

package ir.university.toosi.tms.view.workgroup;


import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.border.*;

/**
 * @author a_hadadi
 */
public abstract class LoginDesign extends JPanel {
    public LoginDesign() {
        initComponents();
        setSize(426, 272);
    }

    abstract void buttonLoginActionPerformed();

    abstract void buttonCancelActionPerformed();

    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents
        login = new JButton();
        cancel = new JButton();
        language = new JComboBox();
        langLabel = new JLabel();
        passwordLabel = new JLabel();
        password = new JPasswordField();
        userNameLabel = new JLabel();
        userName = new JTextField();

        //======== this ========
        setMinimumSize(new Dimension(426, 272));
        setMaximumSize(new Dimension(426, 272));
        setBorder(UIManager.getBorder("InternalFrame.paletteBorder"));
        setPreferredSize(new Dimension(426, 272));
        setAlignmentX(0.0F);
        setAlignmentY(0.0F);
        setForeground(new Color(204, 255, 0));
        setBackground(new Color(7, 96, 153));
        setLayout(null);

        //---- login ----
        login.setText("login");
        login.setFont(new Font("Tahoma", login.getFont().getStyle() & ~Font.BOLD, login.getFont().getSize()));
        login.setBorder(null);
        login.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                buttonLoginActionPerformed();
            }
        });
        add(login);
        login.setBounds(275, 185, 75, 25);

        //---- cancel ----
        cancel.setText("cancel");
        cancel.setFont(new Font("Tahoma", cancel.getFont().getStyle() & ~Font.BOLD, cancel.getFont().getSize()));
        cancel.setBorder(null);
        cancel.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                buttonCancelActionPerformed();
            }
        });
        add(cancel);
        cancel.setBounds(195, 185, 75, 25);

        //---- language ----
        language.setBorder(null);
        language.setFont(new Font("Tahoma", language.getFont().getStyle() & ~Font.BOLD, language.getFont().getSize()));
        language.setComponentOrientation(ComponentOrientation.RIGHT_TO_LEFT);
        add(language);
        language.setBounds(193, 124, 120, 26);

        //---- langLabel ----
        langLabel.setText("langLabel");
        langLabel.setFont(new Font("Tahoma", langLabel.getFont().getStyle() & ~Font.BOLD, langLabel.getFont().getSize()));
        langLabel.setForeground(new Color(205, 225, 245));
        langLabel.setFocusable(false);
        langLabel.setBackground(new Color(7, 96, 153));
        langLabel.setOpaque(true);
        add(langLabel);
        langLabel.setBounds(315, 126, 90, 16);

        //---- passwordLabel ----
        passwordLabel.setText("passwordLabel");
        passwordLabel.setFont(new Font("Tahoma", passwordLabel.getFont().getStyle() & ~Font.BOLD, passwordLabel.getFont().getSize()));
        passwordLabel.setForeground(new Color(205, 225, 245));
        passwordLabel.setFocusable(false);
        passwordLabel.setBackground(new Color(7, 96, 153));
        passwordLabel.setOpaque(true);
        add(passwordLabel);
        passwordLabel.setBounds(315, 89, 90, 16);

        //---- password ----
        password.setBackground(new Color(7, 96, 153));
        password.setForeground(new Color(205, 225, 245));
        password.setBorder(new LineBorder(new Color(205, 225, 245)));
        password.setFont(new Font("Tahoma", password.getFont().getStyle() & ~Font.BOLD, password.getFont().getSize()));
        add(password);
        password.setBounds(195, 87, 115, 21);

        //---- userNameLabel ----
        userNameLabel.setText("userNameLabel");
        userNameLabel.setFont(new Font("Tahoma", userNameLabel.getFont().getStyle() & ~Font.BOLD, userNameLabel.getFont().getSize()));
        userNameLabel.setForeground(new Color(205, 225, 245));
        userNameLabel.setFocusable(false);
        userNameLabel.setBackground(new Color(7, 96, 153));
        userNameLabel.setOpaque(true);
        add(userNameLabel);
        userNameLabel.setBounds(315, 53, 90, 16);

        //---- userName ----
        userName.setBackground(new Color(7, 96, 153));
        userName.setForeground(new Color(205, 225, 245));
        userName.setBorder(new LineBorder(new Color(205, 225, 245)));
        userName.setFont(new Font("Tahoma", userName.getFont().getStyle() & ~Font.BOLD, userName.getFont().getSize()));
        add(userName);
        userName.setBounds(195, 50, 115, 21);

        setPreferredSize(new Dimension(425, 270));
        // JFormDesigner - End of component initialization  //GEN-END:initComponents
    }

    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables
    protected JButton login;
    protected JButton cancel;
    protected JComboBox language;
    protected JLabel langLabel;
    protected JLabel passwordLabel;
    protected JPasswordField password;
    protected JLabel userNameLabel;
    protected JTextField userName;
    // JFormDesigner - End of variables declaration  //GEN-END:variables
}
