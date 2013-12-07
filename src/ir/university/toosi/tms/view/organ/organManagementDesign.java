/*
 * Created by JFormDesigner on Sun Nov 24 15:15:21 IRST 2013
 */

package ir.university.toosi.tms.view.organ;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.border.*;
import javax.swing.tree.*;

/**
 * @author a_hadadi
 */
public abstract class OrganManagementDesign extends JPanel {
    public OrganManagementDesign() {
        initComponents();
    }

    protected abstract void buttonCancelActionPerformed();

    protected abstract void buttonEditActionPerformed();

    protected abstract void buttonAddActionPerformed();

    protected abstract void buttonAllocateActionPerformed();

    protected abstract void buttonDeleteActionPerformed();

    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents
        scrollPane = new JScrollPane();
        tree = new JTree();
        panelButton = new JPanel();
        buttonCancel = new JButton();
        buttonEdit = new JButton();
        buttonAdd = new JButton();
        buttonAllocate = new JButton();
        buttonDelete = new JButton();
        panelOrganInfo = new JPanel();
        labelOrganName = new JLabel();
        textFieldOrganName = new JTextField();
        textFieldOrganCode = new JTextField();
        labelOrganCode = new JLabel();
        textFieldOrganTitle = new JTextField();
        labelOrganTitle = new JLabel();
        labelOrganType = new JLabel();
        comboBoxOrganType = new JComboBox();

        //======== this ========
        setLayout(null);

        //======== scrollPane ========
        {

            //---- tree ----
            tree.setComponentOrientation(ComponentOrientation.RIGHT_TO_LEFT);
            scrollPane.setViewportView(tree);
        }
        add(scrollPane);
        scrollPane.setBounds(10, 10, 540, 290);

        //======== panelButton ========
        {
            panelButton.setBorder(new EtchedBorder());
            panelButton.setLayout(null);

            //---- buttonCancel ----
            buttonCancel.setText("Cancel");
            buttonCancel.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    buttonCancelActionPerformed();
                }
            });
            panelButton.add(buttonCancel);
            buttonCancel.setBounds(15, 7, 95, 26);

            //---- buttonEdit ----
            buttonEdit.setText("Edit");
            buttonEdit.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    buttonEditActionPerformed();
                }
            });
            panelButton.add(buttonEdit);
            buttonEdit.setBounds(261, 7, 95, 26);

            //---- buttonAdd ----
            buttonAdd.setText("Add");
            buttonAdd.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    buttonAddActionPerformed();
                }
            });
            panelButton.add(buttonAdd);
            buttonAdd.setBounds(384, 7, 95, 26);

            //---- buttonAllocate ----
            buttonAllocate.setText("Allocate");
            buttonAllocate.setVisible(false);
            buttonAllocate.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    buttonAllocateActionPerformed();
                }
            });
            panelButton.add(buttonAllocate);
            buttonAllocate.setBounds(495, 15, 95, 26);

            //---- buttonDelete ----
            buttonDelete.setText("Delete");
            buttonDelete.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    buttonDeleteActionPerformed();
                }
            });
            panelButton.add(buttonDelete);
            buttonDelete.setBounds(138, 7, 95, 26);

            { // compute preferred size
                Dimension preferredSize = new Dimension();
                for(int i = 0; i < panelButton.getComponentCount(); i++) {
                    Rectangle bounds = panelButton.getComponent(i).getBounds();
                    preferredSize.width = Math.max(bounds.x + bounds.width, preferredSize.width);
                    preferredSize.height = Math.max(bounds.y + bounds.height, preferredSize.height);
                }
                Insets insets = panelButton.getInsets();
                preferredSize.width += insets.right;
                preferredSize.height += insets.bottom;
                panelButton.setMinimumSize(preferredSize);
                panelButton.setPreferredSize(preferredSize);
            }
        }
        add(panelButton);
        panelButton.setBounds(10, 385, 540, 40);

        //======== panelOrganInfo ========
        {
            panelOrganInfo.setBorder(new EtchedBorder());
            panelOrganInfo.setLayout(null);

            //---- labelOrganName ----
            labelOrganName.setText("\u0646\u0627\u0645 \u0633\u0627\u0632\u0645\u0627\u0646");
            labelOrganName.setFont(new Font("Tahoma", Font.PLAIN, 11));
            panelOrganInfo.add(labelOrganName);
            labelOrganName.setBounds(420, 14, 70, 20);

            //---- textFieldOrganName ----
            textFieldOrganName.setFont(new Font("Tahoma", Font.PLAIN, 11));
            textFieldOrganName.setEditable(false);
            textFieldOrganName.setBackground(new Color(204, 204, 204));
            panelOrganInfo.add(textFieldOrganName);
            textFieldOrganName.setBounds(260, 10, 155, 26);

            //---- textFieldOrganCode ----
            textFieldOrganCode.setFont(new Font("Tahoma", Font.PLAIN, 11));
            textFieldOrganCode.setEditable(false);
            textFieldOrganCode.setBackground(new Color(204, 204, 204));
            panelOrganInfo.add(textFieldOrganCode);
            textFieldOrganCode.setBounds(15, 10, 155, 26);

            //---- labelOrganCode ----
            labelOrganCode.setText("\u06a9\u062f \u0633\u0627\u0632\u0645\u0627\u0646");
            labelOrganCode.setFont(new Font("Tahoma", Font.PLAIN, 11));
            panelOrganInfo.add(labelOrganCode);
            labelOrganCode.setBounds(175, 14, 70, 20);

            //---- textFieldOrganTitle ----
            textFieldOrganTitle.setFont(new Font("Tahoma", Font.PLAIN, 11));
            textFieldOrganTitle.setEditable(false);
            textFieldOrganTitle.setBackground(new Color(204, 204, 204));
            panelOrganInfo.add(textFieldOrganTitle);
            textFieldOrganTitle.setBounds(260, 40, 155, 26);

            //---- labelOrganTitle ----
            labelOrganTitle.setText("\u0639\u0646\u0648\u0627\u0646 \u0633\u0627\u0632\u0645\u0627\u0646");
            labelOrganTitle.setFont(new Font("Tahoma", Font.PLAIN, 11));
            panelOrganInfo.add(labelOrganTitle);
            labelOrganTitle.setBounds(420, 44, 70, 20);

            //---- labelOrganType ----
            labelOrganType.setText("\u0646\u0648\u0639 \u0633\u0627\u0632\u0645\u0627\u0646");
            labelOrganType.setFont(new Font("Tahoma", Font.PLAIN, 11));
            panelOrganInfo.add(labelOrganType);
            labelOrganType.setBounds(175, 44, 70, 20);

            //---- comboBoxOrganType ----
            comboBoxOrganType.setBackground(new Color(240, 240, 240));
            comboBoxOrganType.setEnabled(false);
            panelOrganInfo.add(comboBoxOrganType);
            comboBoxOrganType.setBounds(15, 40, 155, 26);

            { // compute preferred size
                Dimension preferredSize = new Dimension();
                for(int i = 0; i < panelOrganInfo.getComponentCount(); i++) {
                    Rectangle bounds = panelOrganInfo.getComponent(i).getBounds();
                    preferredSize.width = Math.max(bounds.x + bounds.width, preferredSize.width);
                    preferredSize.height = Math.max(bounds.y + bounds.height, preferredSize.height);
                }
                Insets insets = panelOrganInfo.getInsets();
                preferredSize.width += insets.right;
                preferredSize.height += insets.bottom;
                panelOrganInfo.setMinimumSize(preferredSize);
                panelOrganInfo.setPreferredSize(preferredSize);
            }
        }
        add(panelOrganInfo);
        panelOrganInfo.setBounds(10, 305, 540, 75);

        { // compute preferred size
            Dimension preferredSize = new Dimension();
            for(int i = 0; i < getComponentCount(); i++) {
                Rectangle bounds = getComponent(i).getBounds();
                preferredSize.width = Math.max(bounds.x + bounds.width, preferredSize.width);
                preferredSize.height = Math.max(bounds.y + bounds.height, preferredSize.height);
            }
            Insets insets = getInsets();
            preferredSize.width += insets.right;
            preferredSize.height += insets.bottom;
            setMinimumSize(preferredSize);
            setPreferredSize(preferredSize);
        }
        // JFormDesigner - End of component initialization  //GEN-END:initComponents
    }

    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables
    protected JScrollPane scrollPane;
    protected JTree tree;
    private JPanel panelButton;
    protected JButton buttonCancel;
    protected JButton buttonEdit;
    protected JButton buttonAdd;
    protected JButton buttonAllocate;
    protected JButton buttonDelete;
    protected JPanel panelOrganInfo;
    protected JLabel labelOrganName;
    protected JTextField textFieldOrganName;
    protected JTextField textFieldOrganCode;
    protected JLabel labelOrganCode;
    protected JTextField textFieldOrganTitle;
    protected JLabel labelOrganTitle;
    protected JLabel labelOrganType;
    protected JComboBox comboBoxOrganType;
    // JFormDesigner - End of variables declaration  //GEN-END:variables
}
