/*
 * Created by JFormDesigner on Sat Oct 05 18:14:04 IRST 2013
 */

package ir.university.toosi.tms.view.role;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.border.*;
import javax.swing.table.*;

/**
 * @author a_hadadi
 */
public abstract class AddRoleDesign extends JPanel {
    public AddRoleDesign() {
        initComponents();
    }

    abstract void saveActionPerformed();

    abstract void cancelActionPerformed();

    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents
        panel1 = new JPanel();
        label2 = new JLabel();
        checkBox1 = new JCheckBox();
        label1 = new JLabel();
        textField1 = new JTextField();
        panel2 = new JPanel();
        scrollPane1 = new JScrollPane();
        mainTable = new JTable();
        panel3 = new JPanel();
        cancel = new JButton();
        ok = new JButton();

        //======== this ========
        setLayout(null);

        //======== panel1 ========
        {
            panel1.setBorder(new EtchedBorder());
            panel1.setLayout(null);

            //---- label2 ----
            label2.setText("\u0648\u0636\u0639\u06cc\u062a");
            panel1.add(label2);
            label2.setBounds(469, 37, 82, 16);
            panel1.add(checkBox1);
            checkBox1.setBounds(new Rectangle(new Point(440, 35), checkBox1.getPreferredSize()));

            //---- label1 ----
            label1.setText("\u062a\u0648\u0636\u06cc\u062d");
            panel1.add(label1);
            label1.setBounds(470, 13, 82, label1.getPreferredSize().height);
            panel1.add(textField1);
            textField1.setBounds(285, 10, 175, textField1.getPreferredSize().height);

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
        panel1.setBounds(8, 9, 565, 60);

        //======== panel2 ========
        {
            panel2.setBorder(new EtchedBorder());
            panel2.setLayout(null);

            //======== scrollPane1 ========
            {

                //---- mainTable ----
                mainTable.setModel(new DefaultTableModel(
                    new Object[][] {
                    },
                    new String[] {
                        "\u062a\u0648\u0636\u06cc\u062d", "\u0627\u0646\u062a\u062e\u0627\u0628"
                    }
                ) {
                    Class<?>[] columnTypes = new Class<?>[] {
                        Object.class, Boolean.class
                    };
                    boolean[] columnEditable = new boolean[] {
                        false, true
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
                    TableColumnModel cm = mainTable.getColumnModel();
                    cm.getColumn(0).setResizable(false);
                    cm.getColumn(1).setMinWidth(80);
                    cm.getColumn(1).setMaxWidth(120);
                    cm.getColumn(1).setPreferredWidth(80);
                }
                scrollPane1.setViewportView(mainTable);
            }
            panel2.add(scrollPane1);
            scrollPane1.setBounds(5, 10, 553, 224);

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
        panel2.setBounds(8, 74, 565, 245);

        //======== panel3 ========
        {
            panel3.setBorder(new EtchedBorder());
            panel3.setLayout(null);

            //---- cancel ----
            cancel.setText("\u0628\u0627\u0632\u06af\u0634\u062a");
            cancel.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    cancelActionPerformed();
                }
            });
            panel3.add(cancel);
            cancel.setBounds(15, 10, 80, cancel.getPreferredSize().height);

            //---- ok ----
            ok.setText("\u0630\u062e\u06cc\u0631\u0647");
            ok.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    saveActionPerformed();
                }
            });
            panel3.add(ok);
            ok.setBounds(105, 10, 80, ok.getPreferredSize().height);

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
        panel3.setBounds(8, 324, 565, 45);

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
    protected JLabel label2;
    protected JCheckBox checkBox1;
    protected JLabel label1;
    protected JTextField textField1;
    private JPanel panel2;
    private JScrollPane scrollPane1;
    protected JTable mainTable;
    private JPanel panel3;
    protected JButton cancel;
    protected JButton ok;
    // JFormDesigner - End of variables declaration  //GEN-END:variables
}
