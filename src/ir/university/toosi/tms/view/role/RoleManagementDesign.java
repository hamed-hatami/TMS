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

    protected abstract void buttonAddActionPerformed();

    protected abstract void buttonDeleteActionPerformed();

    protected abstract void buttonCancelActionPerformed();

    protected abstract void buttonEditActionPerformed();

    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents
        panelInfo = new JPanel();
        scrollPane1 = new JScrollPane();
        mainTable = new JTable();
        panelButton = new JPanel();
        add = new JButton();
        delete = new JButton();
        edit = new JButton();
        buttonCancel = new JButton();

        //======== this ========
        setVisible(true);
        setLayout(null);

        //======== panelInfo ========
        {
            panelInfo.setBorder(new TitledBorder(null, "\u0644\u06cc\u0633\u062a \u0646\u0642\u0634 \u0647\u0627", TitledBorder.LEADING, TitledBorder.DEFAULT_POSITION,
                new Font("Tahoma", Font.PLAIN, 11)));
            panelInfo.setFont(new Font("Tahoma", Font.PLAIN, 11));
            panelInfo.setLayout(null);

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
                    cm.getColumn(0).setMinWidth(150);
                    cm.getColumn(0).setMaxWidth(600);
                    cm.getColumn(0).setPreferredWidth(150);
                    cm.getColumn(1).setMinWidth(80);
                    cm.getColumn(1).setMaxWidth(110);
                    cm.getColumn(1).setPreferredWidth(80);
                }
                mainTable.setFont(new Font("Tahoma", Font.PLAIN, 11));
                scrollPane1.setViewportView(mainTable);
            }
            panelInfo.add(scrollPane1);
            scrollPane1.setBounds(5, 15, 520, 240);

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
        panelInfo.setBounds(5, 5, 530, 260);

        //======== panelButton ========
        {
            panelButton.setBorder(new EtchedBorder());
            panelButton.setFont(new Font("Tahoma", Font.PLAIN, 11));
            panelButton.setLayout(null);

            //---- add ----
            add.setText("\u0627\u0641\u0632\u0648\u062f\u0646");
            add.setFont(new Font("Tahoma", Font.PLAIN, 11));
            add.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    buttonAddActionPerformed();
                }
            });
            panelButton.add(add);
            add.setBounds(175, 20, 75, add.getPreferredSize().height);

            //---- delete ----
            delete.setText("\u062d\u0630\u0641");
            delete.setFont(new Font("Tahoma", Font.PLAIN, 11));
            delete.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    buttonDeleteActionPerformed();
                }
            });
            panelButton.add(delete);
            delete.setBounds(285, 20, 75, delete.getPreferredSize().height);

            //---- edit ----
            edit.setText("\u0648\u06cc\u0631\u0627\u06cc\u0634");
            edit.setFont(new Font("Tahoma", Font.PLAIN, 11));
            edit.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    buttonEditActionPerformed();
                }
            });
            panelButton.add(edit);
            edit.setBounds(395, 20, 75, edit.getPreferredSize().height);

            //---- buttonCancel ----
            buttonCancel.setText("\u0627\u0646\u0635\u0631\u0627\u0641");
            buttonCancel.setFont(new Font("Tahoma", Font.PLAIN, 11));
            buttonCancel.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    buttonCancelActionPerformed();
                }
            });
            panelButton.add(buttonCancel);
            buttonCancel.setBounds(65, 20, 75, buttonCancel.getPreferredSize().height);
        }
        add(panelButton);
        panelButton.setBounds(8, 271, 525, 61);

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
    protected JTable mainTable;
    private JPanel panelButton;
    protected JButton add;
    protected JButton delete;
    protected JButton edit;
    protected JButton buttonCancel;
    // JFormDesigner - End of variables declaration  //GEN-END:variables
}
