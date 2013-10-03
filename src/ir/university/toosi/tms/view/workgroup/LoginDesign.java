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
        label1 = new JLabel();
        label2 = new JLabel();
        textField1 = new JTextField();
        textField2 = new JTextField();
        label3 = new JLabel();
        panel2 = new JPanel();
        buttonLogin = new JButton();
        buttonCancel = new JButton();
        comboBox1 = new JComboBox();
        label4 = new JLabel();
        panel3 = new JPanel();

        //======== this ========
        setMaximumSize(new Dimension(480, 230));
        setMinimumSize(new Dimension(480, 230));
        setPreferredSize(new Dimension(480, 230));
        setLayout(null);

        //======== panel1 ========
        {
            panel1.setBorder(new EtchedBorder());
            panel1.setLayout(null);

            //---- label1 ----
            label1.setText("text");
            panel1.add(label1);
            label1.setBounds(160, 20, 92, 20);

            //---- label2 ----
            label2.setText("text");
            panel1.add(label2);
            label2.setBounds(160, 45, 75, label2.getPreferredSize().height);
            panel1.add(textField1);
            textField1.setBounds(25, 20, 130, textField1.getPreferredSize().height);
            panel1.add(textField2);
            textField2.setBounds(25, 45, 130, textField2.getPreferredSize().height);

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

            //---- buttonLogin ----
            buttonLogin.setText("buttonLogin");
            buttonLogin.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    buttonLoginActionPerformed();
                }
            });
            panel2.add(buttonLogin);
            buttonLogin.setBounds(110, 55, 75, buttonLogin.getPreferredSize().height);

            //---- buttonCancel ----
            buttonCancel.setText("buttonCancel");
            buttonCancel.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    buttonCancelActionPerformed();
                }
            });
            panel2.add(buttonCancel);
            buttonCancel.setBounds(25, 55, 75, buttonCancel.getPreferredSize().height);
            panel2.add(comboBox1);
            comboBox1.setBounds(25, 20, 130, comboBox1.getPreferredSize().height);

            //---- label4 ----
            label4.setText("text");
            panel2.add(label4);
            label4.setBounds(160, 25, 75, 16);

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

        //======== panel3 ========
        {
            panel3.setBorder(new EtchedBorder());
            panel3.setLayout(null);
        }
        add(panel3);
        panel3.setBounds(10, 20, 205, 195);

        setPreferredSize(new Dimension(480, 230));
        // JFormDesigner - End of component initialization  //GEN-END:initComponents
    }

    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables
    private JPanel panel1;
    private JLabel label1;
    private JLabel label2;
    private JTextField textField1;
    private JTextField textField2;
    private JLabel label3;
    private JPanel panel2;
    private JButton buttonLogin;
    private JButton buttonCancel;
    private JComboBox comboBox1;
    private JLabel label4;
    private JPanel panel3;
    // JFormDesigner - End of variables declaration  //GEN-END:variables
}
