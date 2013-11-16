/*
 * Created by JFormDesigner on Mon Nov 11 17:35:13 IRST 2013
 */

package ir.university.toosi.tms.view.person;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.border.*;

/**
 * @author a_hadadi
 */
public  abstract class PersonDesign extends JPanel {

    public PersonDesign() {
        initComponents();
    }

    public abstract void buttonPicBrowseActionPerformed();

    public abstract void buttonCancelActionPerformed();

    public abstract void buttonSaveActionPerformed();

    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents
        panelInfo = new JPanel();
        textFieldName = new JTextField();
        textFieldLastName = new JTextField();
        labelName = new JLabel();
        labelLastName = new JLabel();
        labelPersonelID = new JLabel();
        textFieldPersonelID = new JTextField();
        labelNationalCode = new JLabel();
        textFieldNationalCode = new JTextField();
        labelCode = new JLabel();
        textFieldCode = new JTextField();
        labelPin = new JLabel();
        textFieldPIN = new JTextField();
        labelAddress = new JLabel();
        textFieldAddress = new JTextField();
        panelButton = new JPanel();
        buttonCancel = new JButton();
        buttonSave = new JButton();
        panel1 = new JPanel();
        buttonPicBrowse = new JButton();
        textFieldPicAddress = new JTextField();
        labelPicAddress = new JLabel();
        labelPicPanel = new JLabel();

        //======== this ========
        setLayout(null);

        //======== panelInfo ========
        {
            panelInfo.setBorder(new TitledBorder("text"));
            panelInfo.setLayout(null);
            panelInfo.add(textFieldName);
            textFieldName.setBounds(270, 25, 130, textFieldName.getPreferredSize().height);
            panelInfo.add(textFieldLastName);
            textFieldLastName.setBounds(15, 25, 135, 20);

            //---- labelName ----
            labelName.setText("text");
            panelInfo.add(labelName);
            labelName.setBounds(402, 26, 95, 16);

            //---- labelLastName ----
            labelLastName.setText("text");
            panelInfo.add(labelLastName);
            labelLastName.setBounds(153, 25, 112, 16);

            //---- labelPersonelID ----
            labelPersonelID.setText("text");
            panelInfo.add(labelPersonelID);
            labelPersonelID.setBounds(402, 51, 95, 16);
            panelInfo.add(textFieldPersonelID);
            textFieldPersonelID.setBounds(270, 50, 130, 20);

            //---- labelNationalCode ----
            labelNationalCode.setText("text");
            panelInfo.add(labelNationalCode);
            labelNationalCode.setBounds(153, 50, 112, 16);
            panelInfo.add(textFieldNationalCode);
            textFieldNationalCode.setBounds(15, 50, 135, 20);

            //---- labelCode ----
            labelCode.setText("text");
            panelInfo.add(labelCode);
            labelCode.setBounds(402, 76, 95, 16);
            panelInfo.add(textFieldCode);
            textFieldCode.setBounds(270, 75, 130, 20);

            //---- labelPin ----
            labelPin.setText("text");
            panelInfo.add(labelPin);
            labelPin.setBounds(153, 75, 112, 16);
            panelInfo.add(textFieldPIN);
            textFieldPIN.setBounds(15, 75, 135, 20);

            //---- labelAddress ----
            labelAddress.setText("text");
            panelInfo.add(labelAddress);
            labelAddress.setBounds(402, 101, 95, 16);
            panelInfo.add(textFieldAddress);
            textFieldAddress.setBounds(15, 100, 385, 20);

            { // compute preferred size
                Dimension preferredSize = new Dimension();
                for(int i = 0; i < panelInfo.getComponentCount(); i++) {
                    Rectangle bounds = panelInfo.getComponent(i).getBounds();
                    preferredSize.width = Math.max(bounds.x + bounds.width, preferredSize.width);
                    preferredSize.height = Math.max(bounds.y + bounds.height, preferredSize.height);
                }
                Insets insets = panelInfo.getInsets();
                preferredSize.width += insets.right;
                preferredSize.height += insets.bottom;
                panelInfo.setMinimumSize(preferredSize);
                panelInfo.setPreferredSize(preferredSize);
            }
        }
        add(panelInfo);
        panelInfo.setBounds(10, 5, 505, 130);

        //======== panelButton ========
        {
            panelButton.setBorder(new EtchedBorder());
            panelButton.setLayout(null);

            //---- buttonCancel ----
            buttonCancel.setText("text");
            buttonCancel.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    buttonCancelActionPerformed();
                }
            });
            panelButton.add(buttonCancel);
            buttonCancel.setBounds(15, 10, 85, buttonCancel.getPreferredSize().height);

            //---- buttonSave ----
            buttonSave.setText("text");
            buttonSave.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    buttonSaveActionPerformed();
                }
            });
            panelButton.add(buttonSave);
            buttonSave.setBounds(115, 10, 85, 26);

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
        panelButton.setBounds(10, 273, 505, 45);

        //======== panel1 ========
        {
            panel1.setBorder(new EtchedBorder());
            panel1.setLayout(null);

            //---- buttonPicBrowse ----
            buttonPicBrowse.setText("text");
            buttonPicBrowse.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    buttonPicBrowseActionPerformed();
                }
            });
            panel1.add(buttonPicBrowse);
            buttonPicBrowse.setBounds(140, 75, 65, 21);

            //---- textFieldPicAddress ----
            textFieldPicAddress.setEditable(false);
            textFieldPicAddress.setBackground(new Color(253, 253, 216));
            panel1.add(textFieldPicAddress);
            textFieldPicAddress.setBounds(210, 75, 195, 20);

            //---- labelPicAddress ----
            labelPicAddress.setText("text");
            panel1.add(labelPicAddress);
            labelPicAddress.setBounds(409, 78, 90, 16);

            //---- labelPicPanel ----
            labelPicPanel.setIcon(null);
            labelPicPanel.setHorizontalAlignment(SwingConstants.CENTER);
            labelPicPanel.setBorder(new BevelBorder(BevelBorder.LOWERED));
            panel1.add(labelPicPanel);
            labelPicPanel.setBounds(15, 5, 115, 125);

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
        panel1.setBounds(10, 135, 505, 135);

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
    protected JPanel panelInfo;
    protected JTextField textFieldName;
    protected JTextField textFieldLastName;
    protected JLabel labelName;
    protected JLabel labelLastName;
    protected JLabel labelPersonelID;
    protected JTextField textFieldPersonelID;
    protected JLabel labelNationalCode;
    protected JTextField textFieldNationalCode;
    protected JLabel labelCode;
    protected JTextField textFieldCode;
    protected JLabel labelPin;
    protected JTextField textFieldPIN;
    protected JLabel labelAddress;
    protected JTextField textFieldAddress;
    protected JPanel panelButton;
    protected JButton buttonCancel;
    protected JButton buttonSave;
    private JPanel panel1;
    protected JButton buttonPicBrowse;
    protected JTextField textFieldPicAddress;
    protected JLabel labelPicAddress;
    protected JLabel labelPicPanel;
    // JFormDesigner - End of variables declaration  //GEN-END:variables
}
