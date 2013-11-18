/*
 * Created by JFormDesigner on Wed Oct 09 09:17:11 IRST 2013
 */

package ir.university.toosi.tms.view.user;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.border.*;

/**
 * @author a_hadadi
 */
public abstract class UserAddDesign extends JPanel {
    public UserAddDesign() {
        initComponents();
    }

    protected abstract void cancelActionPerformed();

    protected abstract void saveActionPerformed();

    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents
        panel1 = new JPanel();
        labelStatus = new JLabel();
        checkBoxStatus = new JCheckBox();
        labelUserName = new JLabel();
        textFieldUserName = new JTextField();
        textFieldUserPassword = new JPasswordField();
        labelUserPassword = new JLabel();
        panel3 = new JPanel();
        buttonCancel = new JButton();
        buttonSave = new JButton();

        //======== this ========
        setLayout(null);

        //======== panel1 ========
        {
            panel1.setBorder(new EtchedBorder());
            panel1.setLayout(null);

            //---- labelStatus ----
            labelStatus.setText("\u0648\u0636\u0639\u06cc\u062a");
            labelStatus.setFont(new Font("Tahoma", Font.PLAIN, 11));
            panel1.add(labelStatus);
            labelStatus.setBounds(308, 67, 82, 16);
            panel1.add(checkBoxStatus);
            checkBoxStatus.setBounds(new Rectangle(new Point(285, 65), checkBoxStatus.getPreferredSize()));

            //---- labelUserName ----
            labelUserName.setText("\u0646\u0627\u0645 \u06a9\u0627\u0631\u0628\u0631\u06cc :");
            labelUserName.setFont(new Font("Tahoma", Font.PLAIN, 11));
            panel1.add(labelUserName);
            labelUserName.setBounds(307, 13, 93, 20);

            //---- textFieldUserName ----
            textFieldUserName.setFont(new Font("Tahoma", Font.PLAIN, 11));
            panel1.add(textFieldUserName);
            textFieldUserName.setBounds(130, 10, 175, 26);

            //---- textFieldUserPassword ----
            textFieldUserPassword.setFont(new Font("Tahoma", Font.PLAIN, 11));
            panel1.add(textFieldUserPassword);
            textFieldUserPassword.setBounds(130, 40, 175, 26);

            //---- labelUserPassword ----
            labelUserPassword.setText("\u06af\u0630\u0631 \u0648\u0627\u0698\u0647 :");
            labelUserPassword.setFont(new Font("Tahoma", Font.PLAIN, 11));
            panel1.add(labelUserPassword);
            labelUserPassword.setBounds(307, 42, 93, 20);

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
        panel1.setBounds(15, 10, 410, 95);

        //======== panel3 ========
        {
            panel3.setBorder(new EtchedBorder());
            panel3.setLayout(null);

            //---- buttonCancel ----
            buttonCancel.setText("cancel");
            buttonCancel.setFont(new Font("Tahoma", Font.PLAIN, 11));
            buttonCancel.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    cancelActionPerformed();
                }
            });
            panel3.add(buttonCancel);
            buttonCancel.setBounds(15, 10, 80, 26);

            //---- buttonSave ----
            buttonSave.setText("\u0630\u062e\u06cc\u0631\u0647");
            buttonSave.setFont(new Font("Tahoma", Font.PLAIN, 11));
            buttonSave.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    saveActionPerformed();
                }
            });
            panel3.add(buttonSave);
            buttonSave.setBounds(105, 10, 80, 26);

            { // compute preferred size
                Dimension preferredSize = new Dimension();
                for(int i = 0; i < panel3.getComponentCount(); i++) {
                    Rectangle bounds = panel3.getComponent(i).getBounds();
                    preferredSize.width = Math.max(bounds.x + bounds.width, preferredSize.width);
                    preferredSize.height = Math.max(bounds.y + bounds.height, preferredSize.height);
                }
                Insets insets = panel3.getInsets();
                preferredSize.width += insets.right;
                preferredSize.height += insets.bottom;
                panel3.setMinimumSize(preferredSize);
                panel3.setPreferredSize(preferredSize);
            }
        }
        add(panel3);
        panel3.setBounds(15, 110, 410, 45);

        setPreferredSize(new Dimension(435, 165));
        // JFormDesigner - End of component initialization  //GEN-END:initComponents
    }

    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables
    private JPanel panel1;
    protected JLabel labelStatus;
    protected JCheckBox checkBoxStatus;
    protected JLabel labelUserName;
    protected JTextField textFieldUserName;
    protected JPasswordField textFieldUserPassword;
    protected JLabel labelUserPassword;
    private JPanel panel3;
    protected JButton buttonCancel;
    protected JButton buttonSave;
    // JFormDesigner - End of variables declaration  //GEN-END:variables
}
