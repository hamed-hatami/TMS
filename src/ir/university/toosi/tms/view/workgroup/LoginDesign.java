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
        setSize(480, 230);
    }

    abstract void buttonLoginActionPerformed();

    abstract void buttonCancelActionPerformed();

    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents
        panel1 = new JPanel();
        userNameLabel = new JLabel();
        passwordLabel = new JLabel();
        userName = new JTextField();
        password = new JPasswordField();
        label3 = new JLabel();
        panel2 = new JPanel();
        login = new JButton();
        cancel = new JButton();
        language = new JComboBox();
        langLabel = new JLabel();
        panelLogo = new JPanel();
        button1 = new JButton();

        //======== this ========
        setMaximumSize(new Dimension(480, 230));
        setMinimumSize(new Dimension(480, 230));
        setPreferredSize(new Dimension(480, 230));
        setLayout(null);

        //======== panel1 ========
        {
            panel1.setBorder(new EtchedBorder());
            panel1.setLayout(null);

            //---- userNameLabel ----
            userNameLabel.setText("userNameLabel");
            panel1.add(userNameLabel);
            userNameLabel.setBounds(160, 20, 92, 20);

            //---- passwordLabel ----
            passwordLabel.setText("passwordLabel");
            panel1.add(passwordLabel);
            passwordLabel.setBounds(160, 45, 75, passwordLabel.getPreferredSize().height);
            panel1.add(userName);
            userName.setBounds(25, 20, 130, userName.getPreferredSize().height);
            panel1.add(password);
            password.setBounds(25, 45, 130, password.getPreferredSize().height);

            //---- label3 ----
            label3.setText("text");
            panel1.add(label3);
            label3.setBounds(190, 95, 37, label3.getPreferredSize().height);

            { // compute preferred size
                Dimension preferredSize = new Dimension();
                for(int i = 0; i < panel1.getComponentCount(); i++) {
                    Rectangle bounds = panel1.getComponent(i).getBounds();
                    preferredSize.width = Math.max(bounds.x + bounds.width, preferredSize.width);
                    preferredSize.height = Math.max(bounds.y + bounds.height, preferredSize.height);
                }
                Insets insets = panel1.getInsets();
                preferredSize.width += insets.right;
                preferredSize.height += insets.bottom;
                panel1.setMinimumSize(preferredSize);
                panel1.setPreferredSize(preferredSize);
            }
        }
        add(panel1);
        panel1.setBounds(220, 20, 245, 85);

        //======== panel2 ========
        {
            panel2.setMinimumSize(new Dimension(100, 100));
            panel2.setPreferredSize(new Dimension(100, 100));
            panel2.setBorder(new EtchedBorder());
            panel2.setLayout(null);

            //---- login ----
            login.setText("login");
            login.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    buttonLoginActionPerformed();
                }
            });
            panel2.add(login);
            login.setBounds(110, 55, 75, login.getPreferredSize().height);

            //---- cancel ----
            cancel.setText("cancel");
            cancel.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    buttonCancelActionPerformed();
                }
            });
            panel2.add(cancel);
            cancel.setBounds(25, 55, 75, cancel.getPreferredSize().height);
            panel2.add(language);
            language.setBounds(25, 20, 130, language.getPreferredSize().height);

            //---- langLabel ----
            langLabel.setText("langLabel");
            panel2.add(langLabel);
            langLabel.setBounds(160, 25, 75, 16);

            { // compute preferred size
                Dimension preferredSize = new Dimension();
                for(int i = 0; i < panel2.getComponentCount(); i++) {
                    Rectangle bounds = panel2.getComponent(i).getBounds();
                    preferredSize.width = Math.max(bounds.x + bounds.width, preferredSize.width);
                    preferredSize.height = Math.max(bounds.y + bounds.height, preferredSize.height);
                }
                Insets insets = panel2.getInsets();
                preferredSize.width += insets.right;
                preferredSize.height += insets.bottom;
                panel2.setMinimumSize(preferredSize);
                panel2.setPreferredSize(preferredSize);
            }
        }
        add(panel2);
        panel2.setBounds(220, 110, 245, 105);

        //======== panelLogo ========
        {
            panelLogo.setBorder(new EtchedBorder());
            panelLogo.setLayout(null);

            //---- button1 ----
            button1.setIcon(new ImageIcon("D:\\ARIA\\CVSROOT\\project\\TMS\\resources\\images\\big-logo.png"));
            panelLogo.add(button1);
            button1.setBounds(0, 0, 205, 195);
        }
        add(panelLogo);
        panelLogo.setBounds(10, 20, 205, 195);

        setPreferredSize(new Dimension(480, 230));
        // JFormDesigner - End of component initialization  //GEN-END:initComponents
    }

    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables
    private JPanel panel1;
    protected JLabel userNameLabel;
    protected JLabel passwordLabel;
    protected JTextField userName;
    protected JPasswordField password;
    private JLabel label3;
    private JPanel panel2;
    protected JButton login;
    protected JButton cancel;
    protected JComboBox language;
    protected JLabel langLabel;
    protected JPanel panelLogo;
    private JButton button1;
    // JFormDesigner - End of variables declaration  //GEN-END:variables
}
