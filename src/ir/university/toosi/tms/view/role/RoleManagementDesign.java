/*
 * Created by JFormDesigner on Wed Oct 02 20:01:16 AFT 2013
 */

package ir.university.toosi.tms.view.role;

import ir.university.toosi.tms.view.TMSInternalFrame;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.border.*;
import javax.swing.table.*;

/**
 * @author a_hadadi
 */
public abstract class RoleManagementDesign extends  JPanel {
    public RoleManagementDesign() {
        initComponents();
    }

    protected abstract void button1ActionPerformed();

    protected abstract void button2ActionPerformed();

    protected abstract void button4ActionPerformed();

    protected abstract void button3ActionPerformed();

    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents
        panel1 = new JPanel();
        scrollPane1 = new JScrollPane();
        mainTable = new JTable();
        panel2 = new JPanel();
        add = new JButton();
        delete = new JButton();
        edit = new JButton();

        //======== this ========
        setVisible(true);
        setLayout(null);

        //======== panel1 ========
        {
            panel1.setBorder(new TitledBorder("\u0644\u06cc\u0633\u062a \u0646\u0642\u0634 \u0647\u0627"));
            panel1.setLayout(new BoxLayout(panel1, BoxLayout.X_AXIS));

            //======== scrollPane1 ========
            {

                //---- mainTable ----
                mainTable.setModel(new DefaultTableModel(
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
                    TableColumnModel cm = mainTable.getColumnModel();
                    cm.getColumn(0).setResizable(false);
                    cm.getColumn(0).setMinWidth(100);
                    cm.getColumn(0).setMaxWidth(300);
                    cm.getColumn(0).setPreferredWidth(100);
                    cm.getColumn(1).setResizable(false);
                }
                scrollPane1.setViewportView(mainTable);
            }
            panel1.add(scrollPane1);
        }
        add(panel1);
        panel1.setBounds(5, 5, 530, 245);

        //======== panel2 ========
        {
            panel2.setBorder(new TitledBorder("\u0639\u0645\u0644\u06cc\u0627\u062a"));
            panel2.setLayout(null);

            //---- add ----
            add.setText("\u0627\u0641\u0632\u0648\u062f\u0646");
            add.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    button1ActionPerformed();
                }
            });
            panel2.add(add);
            add.setBounds(105, 25, 76, add.getPreferredSize().height);

            //---- delete ----
            delete.setText("\u062d\u0630\u0641");
            delete.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    button2ActionPerformed();
                }
            });
            panel2.add(delete);
            delete.setBounds(220, 25, 76, delete.getPreferredSize().height);

            //---- edit ----
            edit.setText("\u0648\u06cc\u0631\u0627\u06cc\u0634");
            edit.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    button3ActionPerformed();
                }
            });
            panel2.add(edit);
            edit.setBounds(335, 25, 76, edit.getPreferredSize().height);
        }
        add(panel2);
        panel2.setBounds(5, 250, 530, 75);

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
    private JScrollPane scrollPane1;
    protected JTable mainTable;
    private JPanel panel2;
    private JButton add;
    private JButton delete;
    private JButton edit;
    // JFormDesigner - End of variables declaration  //GEN-END:variables
}
