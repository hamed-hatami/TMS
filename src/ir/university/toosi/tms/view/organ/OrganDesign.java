/*
 * Created by JFormDesigner on Wed Oct 09 09:17:11 IRST 2013
 */

package ir.university.toosi.tms.view.organ;

import javax.swing.*;
import javax.swing.border.EtchedBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * @author a_hadadi
 */
public abstract class OrganDesign extends JPanel {
    public OrganDesign() {
        initComponents();
    }

    protected abstract void cancelActionPerformed();

    protected abstract void saveActionPerformed();

    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents
        panel1 = new JPanel();
        labelOrganName = new JLabel();
        textFieldOrganName = new JTextField();
        textFieldOrganCode = new JTextField();
        labelOrganCode = new JLabel();
        textFieldOrganTitle = new JTextField();
        labelOrganTitle = new JLabel();
        labelOrganType = new JLabel();
        comboBoxOrganType = new JComboBox();
        panel3 = new JPanel();
        buttonCancel = new JButton();
        buttonSave = new JButton();

        //======== this ========
        setLayout(null);

        //======== panel1 ========
        {
            panel1.setBorder(new EtchedBorder());
            panel1.setLayout(null);

            //---- labelOrganName ----
            labelOrganName.setText("\u0646\u0627\u0645 \u0633\u0627\u0632\u0645\u0627\u0646");
            labelOrganName.setFont(new Font("Tahoma", Font.PLAIN, 11));
            panel1.add(labelOrganName);
            labelOrganName.setBounds(288, 13, 93, 20);

            //---- textFieldOrganName ----
            textFieldOrganName.setFont(new Font("Tahoma", Font.PLAIN, 11));
            panel1.add(textFieldOrganName);
            textFieldOrganName.setBounds(110, 10, 175, 26);

            //---- textFieldOrganCode ----
            textFieldOrganCode.setFont(new Font("Tahoma", Font.PLAIN, 11));
            panel1.add(textFieldOrganCode);
            textFieldOrganCode.setBounds(110, 40, 175, 26);

            //---- labelOrganCode ----
            labelOrganCode.setText("\u06a9\u062f \u0633\u0627\u0632\u0645\u0627\u0646");
            labelOrganCode.setFont(new Font("Tahoma", Font.PLAIN, 11));
            panel1.add(labelOrganCode);
            labelOrganCode.setBounds(288, 43, 93, 20);

            //---- textFieldOrganTitle ----
            textFieldOrganTitle.setFont(new Font("Tahoma", Font.PLAIN, 11));
            panel1.add(textFieldOrganTitle);
            textFieldOrganTitle.setBounds(110, 70, 175, 26);

            //---- labelOrganTitle ----
            labelOrganTitle.setText("\u0639\u0646\u0648\u0627\u0646 \u0633\u0627\u0632\u0645\u0627\u0646");
            labelOrganTitle.setFont(new Font("Tahoma", Font.PLAIN, 11));
            panel1.add(labelOrganTitle);
            labelOrganTitle.setBounds(287, 73, 93, 20);

            //---- labelOrganType ----
            labelOrganType.setText("\u0646\u0648\u0639 \u0633\u0627\u0632\u0645\u0627\u0646");
            labelOrganType.setFont(new Font("Tahoma", Font.PLAIN, 11));
            panel1.add(labelOrganType);
            labelOrganType.setBounds(287, 102, 93, 20);
            panel1.add(comboBoxOrganType);
            comboBoxOrganType.setBounds(110, 100, 175, 26);

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
        panel1.setBounds(15, 10, 410, 145);

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
            buttonCancel.setBounds(125, 10, 80, 26);

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
            buttonSave.setBounds(215, 10, 80, 26);

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
        panel3.setBounds(15, 160, 410, 45);

        setPreferredSize(new Dimension(435, 215));
        // JFormDesigner - End of component initialization  //GEN-END:initComponents
    }

    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables
    private JPanel panel1;
    protected JLabel labelOrganName;
    protected JTextField textFieldOrganName;
    protected JTextField textFieldOrganCode;
    protected JLabel labelOrganCode;
    protected JTextField textFieldOrganTitle;
    protected JLabel labelOrganTitle;
    protected JLabel labelOrganType;
    protected JComboBox comboBoxOrganType;
    private JPanel panel3;
    protected JButton buttonCancel;
    protected JButton buttonSave;
    // JFormDesigner - End of variables declaration  //GEN-END:variables
}
