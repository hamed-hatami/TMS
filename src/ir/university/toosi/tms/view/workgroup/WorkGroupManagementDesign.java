/*
 * Created by JFormDesigner on Wed Oct 02 20:01:16 AFT 2013
 */

package ir.university.toosi.tms.view.workgroup;

import javax.swing.*;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumnModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * @author a_hadadi
 */
public abstract class WorkGroupManagementDesign extends  JPanel {
    public WorkGroupManagementDesign() {
        initComponents();
    }

    protected abstract void button1ActionPerformed();

    protected abstract void button2ActionPerformed();

    protected abstract void button4ActionPerformed();

    protected abstract void button3ActionPerformed();

    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents
        // Generated using JFormDesigner Evaluation license - farzad sedaghatbin
        panel1 = new JPanel();
        scrollPane1 = new JScrollPane();
        table1 = new JTable();
        panel2 = new JPanel();
        button1 = new JButton();
        button2 = new JButton();
        button3 = new JButton();

        //======== this ========
        setVisible(true);

        // JFormDesigner evaluation mark
        setBorder(new javax.swing.border.CompoundBorder(
            new javax.swing.border.TitledBorder(new javax.swing.border.EmptyBorder(0, 0, 0, 0),
                "JFormDesigner Evaluation", javax.swing.border.TitledBorder.CENTER,
                javax.swing.border.TitledBorder.BOTTOM, new java.awt.Font("Dialog", java.awt.Font.BOLD, 12),
                java.awt.Color.red), getBorder())); addPropertyChangeListener(new java.beans.PropertyChangeListener(){public void propertyChange(java.beans.PropertyChangeEvent e){if("border".equals(e.getPropertyName()))throw new RuntimeException();}});

        setLayout(null);

        //======== panel1 ========
        {
            panel1.setBorder(new TitledBorder("defined WorkGroup"));
            panel1.setLayout(new BoxLayout(panel1, BoxLayout.X_AXIS));

            //======== scrollPane1 ========
            {

                //---- table1 ----
                table1.setModel(new DefaultTableModel(
                    new Object[][] {
                        {"\u0645\u062f\u06cc\u0631", true},
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
                    TableColumnModel cm = table1.getColumnModel();
                    cm.getColumn(0).setResizable(false);
                    cm.getColumn(0).setMinWidth(100);
                    cm.getColumn(0).setMaxWidth(300);
                    cm.getColumn(0).setPreferredWidth(100);
                    cm.getColumn(1).setResizable(false);
                }
                scrollPane1.setViewportView(table1);
            }
            panel1.add(scrollPane1);
        }
        add(panel1);
        panel1.setBounds(5, 5, 530, 245);

        //======== panel2 ========
        {
            panel2.setBorder(new TitledBorder("available Operations"));
            panel2.setLayout(null);

            //---- button1 ----
            button1.setText("add");
            button1.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    button1ActionPerformed();
                }
            });
            panel2.add(button1);
            button1.setBounds(105, 25, 76, button1.getPreferredSize().height);

            //---- button2 ----
            button2.setText("delete");
            button2.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    button2ActionPerformed();
                }
            });
            panel2.add(button2);
            button2.setBounds(220, 25, 76, button2.getPreferredSize().height);

            //---- button3 ----
            button3.setText("modify");
            button3.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    button3ActionPerformed();
                }
            });
            panel2.add(button3);
            button3.setBounds(335, 25, 76, button3.getPreferredSize().height);
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
    // Generated using JFormDesigner Evaluation license - farzad sedaghatbin
    private JPanel panel1;
    private JScrollPane scrollPane1;
    private JTable table1;
    private JPanel panel2;
    private JButton button1;
    private JButton button2;
    private JButton button3;
    // JFormDesigner - End of variables declaration  //GEN-END:variables
}
