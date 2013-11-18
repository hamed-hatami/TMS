/*
 * Created by JFormDesigner on Wed Oct 02 20:01:16 AFT 2013
 */

package ir.university.toosi.tms.view.user;

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
public abstract class UserManagementDesign extends  JPanel {
    public UserManagementDesign() {
        initComponents();
    }



    protected abstract void buttonCancelActionPerformed();

    protected abstract void buttonAddActionPerformed();

    protected abstract void buttonDeleteActionPerformed();

    protected abstract void buttonMembershipManagementActionPerformed();

    protected abstract void buttonEditActionPerformed();



    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents
        panelInfo = new JPanel();
        scrollPane1 = new JScrollPane();
        tableInfo = new JTable();
        panelButton = new JPanel();
        buttonCancel = new JButton();
        buttonAdd = new JButton();
        buttonDelete = new JButton();
        buttonEdit = new JButton();
        buttonMembershipManagement = new JButton();

        //======== this ========
        setVisible(true);
        setLayout(null);

        //======== panelInfo ========
        {
            panelInfo.setBorder(new TitledBorder("defined Users"));
            panelInfo.setFont(new Font("Tahoma", Font.PLAIN, 11));
            panelInfo.setLayout(new BoxLayout(panelInfo, BoxLayout.X_AXIS));

            //======== scrollPane1 ========
            {

                //---- tableInfo ----
                tableInfo.setModel(new DefaultTableModel(
                    new Object[][] {
                    },
                    new String[] {
                        "userName"
                    }
                ) {
                    Class<?>[] columnTypes = new Class<?>[] {
                        String.class
                    };
                    boolean[] columnEditable = new boolean[] {
                        false
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
                }
                tableInfo.setFont(new Font("Tahoma", Font.PLAIN, 11));
                scrollPane1.setViewportView(tableInfo);
            }
            panelInfo.add(scrollPane1);
        }
        add(panelInfo);
        panelInfo.setBounds(5, 5, 530, 255);

        //======== panelButton ========
        {
            panelButton.setBorder(new EtchedBorder());
            panelButton.setLayout(null);

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
            buttonCancel.setBounds(20, 15, 85, 26);

            //---- buttonAdd ----
            buttonAdd.setText("\u0627\u0641\u0632\u0648\u062f\u0646");
            buttonAdd.setFont(new Font("Tahoma", Font.PLAIN, 11));
            buttonAdd.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    buttonAddActionPerformed();
                }
            });
            panelButton.add(buttonAdd);
            buttonAdd.setBounds(424, 15, 85, 26);

            //---- buttonDelete ----
            buttonDelete.setText("\u062d\u0630\u0641");
            buttonDelete.setFont(new Font("Tahoma", Font.PLAIN, 11));
            buttonDelete.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    buttonDeleteActionPerformed();
                }
            });
            panelButton.add(buttonDelete);
            buttonDelete.setBounds(121, 15, 85, 26);

            //---- buttonEdit ----
            buttonEdit.setText("\u0648\u06cc\u0631\u0627\u06cc\u0634");
            buttonEdit.setFont(new Font("Tahoma", Font.PLAIN, 11));
            buttonEdit.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    buttonEditActionPerformed();
                }
            });
            panelButton.add(buttonEdit);
            buttonEdit.setBounds(323, 15, 85, 26);

            //---- buttonMembershipManagement ----
            buttonMembershipManagement.setText("\u062a\u062e\u0635\u06cc\u0635");
            buttonMembershipManagement.setFont(new Font("Tahoma", Font.PLAIN, 11));
            buttonMembershipManagement.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    buttonMembershipManagementActionPerformed();
                }
            });
            panelButton.add(buttonMembershipManagement);
            buttonMembershipManagement.setBounds(222, 15, 85, 26);
        }
        add(panelButton);
        panelButton.setBounds(5, 262, 530, 55);

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
    private JPanel panelButton;
    protected JButton buttonCancel;
    protected JButton buttonAdd;
    protected JButton buttonDelete;
    protected JButton buttonEdit;
    protected JButton buttonMembershipManagement;
    // JFormDesigner - End of variables declaration  //GEN-END:variables
}
