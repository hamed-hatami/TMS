/*
 * Created by JFormDesigner on Mon Nov 18 12:15:18 IRST 2013
 */

package ir.university.toosi.tms.view.pc;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.border.*;

/**
 * @author a_hadadi
 */
public abstract class PCDesign extends JPanel {
    public PCDesign() {
        initComponents();
    }

    protected abstract void cancelActionPerformed();

    protected abstract void saveActionPerformed();

    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents
        panelMain = new JPanel();
        labelPCName = new JLabel();
        textFieldPCName = new JTextField();
        textFieldIP = new JTextField();
        labelIP = new JLabel();
        textFieldPhisicalPlace = new JTextField();
        labelPhisicalPlace = new JLabel();
        panelButtons = new JPanel();
        buttonCancel = new JButton();
        buttonSave = new JButton();

        //======== this ========
        setLayout(null);

        //======== panelMain ========
        {
            panelMain.setBorder(new EtchedBorder());
            panelMain.setLayout(null);

            //---- labelPCName ----
            labelPCName.setText("\u0646\u0627\u0645");
            labelPCName.setFont(new Font("Tahoma", Font.PLAIN, 11));
            panelMain.add(labelPCName);
            labelPCName.setBounds(265, 22, 93, 20);

            //---- textFieldPCName ----
            textFieldPCName.setFont(new Font("Tahoma", Font.PLAIN, 11));
            panelMain.add(textFieldPCName);
            textFieldPCName.setBounds(66, 19, 195, 26);

            //---- textFieldIP ----
            textFieldIP.setFont(new Font("Tahoma", Font.PLAIN, 11));
            panelMain.add(textFieldIP);
            textFieldIP.setBounds(66, 49, 195, 26);

            //---- labelIP ----
            labelIP.setText("\u0634\u0646\u0627\u0633\u0647 \u0634\u0628\u06a9\u0647");
            labelIP.setFont(new Font("Tahoma", Font.PLAIN, 11));
            panelMain.add(labelIP);
            labelIP.setBounds(265, 52, 93, 20);

            //---- textFieldPhisicalPlace ----
            textFieldPhisicalPlace.setFont(new Font("Tahoma", Font.PLAIN, 11));
            panelMain.add(textFieldPhisicalPlace);
            textFieldPhisicalPlace.setBounds(66, 79, 195, 26);

            //---- labelPhisicalPlace ----
            labelPhisicalPlace.setText("\u0645\u06a9\u0627\u0646 \u0641\u06cc\u0632\u06cc\u06a9\u06cc");
            labelPhisicalPlace.setFont(new Font("Tahoma", Font.PLAIN, 11));
            panelMain.add(labelPhisicalPlace);
            labelPhisicalPlace.setBounds(265, 81, 93, 20);

            { // compute preferred size
                Dimension preferredSize = new Dimension();
                for(int i = 0; i < panelMain.getComponentCount(); i++) {
                    Rectangle bounds = panelMain.getComponent(i).getBounds();
                    preferredSize.width = Math.max(bounds.x + bounds.width, preferredSize.width);
                    preferredSize.height = Math.max(bounds.y + bounds.height, preferredSize.height);
                }
                Insets insets = panelMain.getInsets();
                preferredSize.width += insets.right;
                preferredSize.height += insets.bottom;
                panelMain.setMinimumSize(preferredSize);
                panelMain.setPreferredSize(preferredSize);
            }
        }
        add(panelMain);
        panelMain.setBounds(10, 5, 410, 125);

        //======== panelButtons ========
        {
            panelButtons.setBorder(new EtchedBorder());
            panelButtons.setLayout(null);

            //---- buttonCancel ----
            buttonCancel.setText("cancel");
            buttonCancel.setFont(new Font("Tahoma", Font.PLAIN, 11));
            buttonCancel.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    cancelActionPerformed();
                }
            });
            panelButtons.add(buttonCancel);
            buttonCancel.setBounds(110, 10, 80, 26);

            //---- buttonSave ----
            buttonSave.setText("\u0630\u062e\u06cc\u0631\u0647");
            buttonSave.setFont(new Font("Tahoma", Font.PLAIN, 11));
            buttonSave.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    saveActionPerformed();
                }
            });
            panelButtons.add(buttonSave);
            buttonSave.setBounds(200, 10, 80, 26);

            { // compute preferred size
                Dimension preferredSize = new Dimension();
                for(int i = 0; i < panelButtons.getComponentCount(); i++) {
                    Rectangle bounds = panelButtons.getComponent(i).getBounds();
                    preferredSize.width = Math.max(bounds.x + bounds.width, preferredSize.width);
                    preferredSize.height = Math.max(bounds.y + bounds.height, preferredSize.height);
                }
                Insets insets = panelButtons.getInsets();
                preferredSize.width += insets.right;
                preferredSize.height += insets.bottom;
                panelButtons.setMinimumSize(preferredSize);
                panelButtons.setPreferredSize(preferredSize);
            }
        }
        add(panelButtons);
        panelButtons.setBounds(10, 135, 410, 45);

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
    private JPanel panelMain;
    protected JLabel labelPCName;
    protected JTextField textFieldPCName;
    protected JTextField textFieldIP;
    protected JLabel labelIP;
    protected JTextField textFieldPhisicalPlace;
    protected JLabel labelPhisicalPlace;
    private JPanel panelButtons;
    protected JButton buttonCancel;
    protected JButton buttonSave;
    // JFormDesigner - End of variables declaration  //GEN-END:variables
}
