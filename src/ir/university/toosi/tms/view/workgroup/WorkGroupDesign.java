/*
 * Created by JFormDesigner on Mon Nov 04 12:26:21 IRST 2013
 */

package ir.university.toosi.tms.view.workgroup;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.border.*;
import javax.swing.table.*;

/**
 * @author a_hadadi
 */
public abstract class WorkGroupDesign extends JPanel {
    public WorkGroupDesign() {
        initComponents();
    }

    protected abstract void buttonOKActionPerformed();

    protected abstract void buttonCancelActionPerformed();

    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents
        panel1 = new JPanel();
        textFieldDescription = new JTextField();
        labelDescription = new JLabel();
        checkBoxActive = new JCheckBox();
        panel2 = new JPanel();
        buttonCancel = new JButton();
        buttonOK = new JButton();
        panelRole = new JPanel();
        scrollPane1 = new JScrollPane();
        tableRole = new JTable();

        //======== this ========
        setLayout(null);

        //======== panel1 ========
        {
            panel1.setBorder(new EtchedBorder());
            panel1.setLayout(null);
            panel1.add(textFieldDescription);
            textFieldDescription.setBounds(178, 6, 169, textFieldDescription.getPreferredSize().height);

            //---- labelDescription ----
            labelDescription.setText("labelDescription");
            panel1.add(labelDescription);
            labelDescription.setBounds(353, 8, 107, labelDescription.getPreferredSize().height);

            //---- checkBoxActive ----
            checkBoxActive.setText("checkBoxActiveTitle");
            panel1.add(checkBoxActive);
            checkBoxActive.setBounds(330, 27, 135, checkBoxActive.getPreferredSize().height);

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
        panel1.setBounds(5, 10, 475, 55);

        //======== panel2 ========
        {
            panel2.setBorder(new EtchedBorder());
            panel2.setLayout(null);

            //---- buttonCancel ----
            buttonCancel.setText("buttonCancel");
            buttonCancel.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    buttonCancelActionPerformed();
                }
            });
            panel2.add(buttonCancel);
            buttonCancel.setBounds(15, 10, 80, buttonCancel.getPreferredSize().height);

            //---- buttonOK ----
            buttonOK.setText("buttonOK");
            buttonOK.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    buttonOKActionPerformed();
                }
            });
            panel2.add(buttonOK);
            buttonOK.setBounds(105, 10, 80, buttonOK.getPreferredSize().height);

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
        panel2.setBounds(5, 290, 475, 45);

        //======== panelRole ========
        {
            panelRole.setBorder(new TitledBorder("relative roles"));
            panelRole.setLayout(null);

            //======== scrollPane1 ========
            {

                //---- tableRole ----
                tableRole.setModel(new DefaultTableModel(
                    new Object[][] {
                    },
                    new String[] {
                        "title", "active status"
                    }
                ) {
                    Class<?>[] columnTypes = new Class<?>[] {
                        String.class, Boolean.class
                    };
                    boolean[] columnEditable = new boolean[] {
                        false, false
                    };
                    @Override
                    public Class<?> getColumnClass(int columnIndex) {
                        return columnTypes[columnIndex];
                    }
                    @Override
                    public boolean isCellEditable(int rowIndex, int columnIndex) {
                        return columnEditable[columnIndex];
                    }
                });
                {
                    TableColumnModel cm = tableRole.getColumnModel();
                    cm.getColumn(0).setResizable(false);
                    cm.getColumn(0).setMinWidth(150);
                    cm.getColumn(0).setMaxWidth(500);
                    cm.getColumn(0).setPreferredWidth(150);
                    cm.getColumn(1).setResizable(false);
                    cm.getColumn(1).setMinWidth(120);
                    cm.getColumn(1).setMaxWidth(120);
                    cm.getColumn(1).setPreferredWidth(120);
                }
                tableRole.setFont(new Font("Tahoma", Font.PLAIN, 11));
                scrollPane1.setViewportView(tableRole);
            }
            panelRole.add(scrollPane1);
            scrollPane1.setBounds(5, 15, 465, 195);

            { // compute preferred size
                Dimension preferredSize = new Dimension();
                for(int i = 0; i < panelRole.getComponentCount(); i++) {
                    Rectangle bounds = panelRole.getComponent(i).getBounds();
                    preferredSize.width = Math.max(bounds.x + bounds.width, preferredSize.width);
                    preferredSize.height = Math.max(bounds.y + bounds.height, preferredSize.height);
                }
                Insets insets = panelRole.getInsets();
                preferredSize.width += insets.right;
                preferredSize.height += insets.bottom;
                panelRole.setMinimumSize(preferredSize);
                panelRole.setPreferredSize(preferredSize);
            }
        }
        add(panelRole);
        panelRole.setBounds(5, 70, 475, 215);

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
    private JPanel panel1;
    protected JTextField textFieldDescription;
    protected JLabel labelDescription;
    protected JCheckBox checkBoxActive;
    private JPanel panel2;
    protected JButton buttonCancel;
    protected JButton buttonOK;
    protected JPanel panelRole;
    private JScrollPane scrollPane1;
    protected JTable tableRole;
    // JFormDesigner - End of variables declaration  //GEN-END:variables
}
