/*
 * Created by JFormDesigner on Wed Oct 02 20:01:16 AFT 2013
 */

package ir.university.toosi.tms.view.workgroup;

import javax.swing.*;
import javax.swing.border.*;
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

    protected abstract void buttonAddActionPerformed();

    protected abstract void buttonDeleteActionPerformed();

    protected abstract void buttonCancelActionPerformed();

    protected abstract void buttonModifyActionPerformed();



    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents
        panelInfo = new JPanel();
        scrollPane1 = new JScrollPane();
        tableInfo = new JTable();
        panelButtons = new JPanel();
        buttonAdd = new JButton();
        buttonDelete = new JButton();
        buttonModify = new JButton();
        buttonCancel = new JButton();

        //======== this ========
        setVisible(true);
        setLayout(null);

        //======== panelInfo ========
        {
            panelInfo.setBorder(new TitledBorder(null, "defined WorkGroup", TitledBorder.LEADING, TitledBorder.DEFAULT_POSITION,
                new Font("Tahoma", Font.PLAIN, 11)));
            panelInfo.setFont(new Font("Tahoma", Font.PLAIN, 11));
            panelInfo.setLayout(null);

            //======== scrollPane1 ========
            {

                //---- tableInfo ----
                tableInfo.setModel(new DefaultTableModel(
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
                    TableColumnModel cm = tableInfo.getColumnModel();
                    cm.getColumn(0).setResizable(false);
                    cm.getColumn(0).setMinWidth(100);
                    cm.getColumn(0).setMaxWidth(500);
                    cm.getColumn(0).setPreferredWidth(100);
                    cm.getColumn(1).setResizable(false);
                    cm.getColumn(1).setMinWidth(50);
                    cm.getColumn(1).setMaxWidth(100);
                    cm.getColumn(1).setPreferredWidth(80);
                }
                tableInfo.setFont(new Font("Tahoma", Font.PLAIN, 11));
                scrollPane1.setViewportView(tableInfo);
            }
            panelInfo.add(scrollPane1);
            scrollPane1.setBounds(7, 17, 518, 233);

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
        panelInfo.setBounds(5, 5, 530, 255);

        //======== panelButtons ========
        {
            panelButtons.setBorder(new EtchedBorder());
            panelButtons.setFont(new Font("Tahoma", Font.PLAIN, 11));
            panelButtons.setLayout(null);

            //---- buttonAdd ----
            buttonAdd.setText("add");
            buttonAdd.setFont(new Font("Tahoma", Font.PLAIN, 11));
            buttonAdd.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    buttonAddActionPerformed();
                }
            });
            panelButtons.add(buttonAdd);
            buttonAdd.setBounds(315, 15, 81, 26);

            //---- buttonDelete ----
            buttonDelete.setText("delete");
            buttonDelete.setFont(new Font("Tahoma", Font.PLAIN, 11));
            buttonDelete.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    buttonDeleteActionPerformed();
                }
            });
            panelButtons.add(buttonDelete);
            buttonDelete.setBounds(125, 15, 81, 26);

            //---- buttonModify ----
            buttonModify.setText("modify");
            buttonModify.setFont(new Font("Tahoma", Font.PLAIN, 11));
            buttonModify.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    buttonModifyActionPerformed();
                }
            });
            panelButtons.add(buttonModify);
            buttonModify.setBounds(220, 15, 81, 26);

            //---- buttonCancel ----
            buttonCancel.setText("Cancel");
            buttonCancel.setFont(new Font("Tahoma", Font.PLAIN, 11));
            buttonCancel.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    buttonCancelActionPerformed();
                }
            });
            panelButtons.add(buttonCancel);
            buttonCancel.setBounds(30, 15, 81, 26);
        }
        add(panelButtons);
        panelButtons.setBounds(8, 265, 527, 55);

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
    private JScrollPane scrollPane1;
    protected JTable tableInfo;
    protected JPanel panelButtons;
    protected JButton buttonAdd;
    protected JButton buttonDelete;
    protected JButton buttonModify;
    protected JButton buttonCancel;
    // JFormDesigner - End of variables declaration  //GEN-END:variables
}
