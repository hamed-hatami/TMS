/*
 * Created by JFormDesigner on Wed Oct 09 10:37:48 IRST 2013
 */

package ir.university.toosi.tms.view.user;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.border.*;
import javax.swing.table.*;

/**
 * @author a_hadadi
 */
public abstract class UserMembershipManagementDesign extends JPanel {
    public UserMembershipManagementDesign() {
        initComponents();
    }

    protected abstract  void cancelActionPerformed();

    protected abstract void checkBoxPersonItemStateChanged();

    protected abstract  void saveActionPerformed();

    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents
        panelPerson = new JPanel();
        scrollPane1 = new JScrollPane();
        tablePerson = new JTable();
        checkBoxPerson = new JCheckBox();
        panelWorkgroup = new JPanel();
        scrollPane2 = new JScrollPane();
        tableWorkgroup = new JTable();
        panelPC = new JPanel();
        scrollPane3 = new JScrollPane();
        tablePC = new JTable();
        panel3 = new JPanel();
        buttonCancel = new JButton();
        buttonSave = new JButton();

        //======== this ========
        setLayout(null);

        //======== panelPerson ========
        {
            panelPerson.setBorder(new TitledBorder(null, "\u062a\u062e\u0635\u06cc\u0635 \u0634\u062e\u0635", TitledBorder.LEADING, TitledBorder.DEFAULT_POSITION,
                new Font("Tahoma", Font.PLAIN, 12)));
            panelPerson.setComponentOrientation(ComponentOrientation.RIGHT_TO_LEFT);
            panelPerson.setLayout(null);

            //======== scrollPane1 ========
            {

                //---- tablePerson ----
                tablePerson.setModel(new DefaultTableModel(
                    new Object[][] {
                    },
                    new String[] {
                        "\u0646\u0627\u0645 \u062e\u0627\u0646\u0648\u0627\u062f\u06af\u06cc", "\u0646\u0627\u0645"
                    }
                ) {
                    boolean[] columnEditable = new boolean[] {
                        false, false
                    };
                    @Override
                    public boolean isCellEditable(int rowIndex, int columnIndex) {
                        return columnEditable[columnIndex];
                    }
                });
                tablePerson.setFont(new Font("Tahoma", Font.PLAIN, 11));
                scrollPane1.setViewportView(tablePerson);
            }
            panelPerson.add(scrollPane1);
            scrollPane1.setBounds(10, 20, 630, 115);

            //---- checkBoxPerson ----
            checkBoxPerson.setText("\u0639\u062f\u0645 \u0627\u0646\u062a\u062e\u0627\u0628 \u0634\u062e\u0635");
            checkBoxPerson.setComponentOrientation(ComponentOrientation.RIGHT_TO_LEFT);
            checkBoxPerson.setFont(new Font("Tahoma", Font.PLAIN, 11));
            checkBoxPerson.addItemListener(new ItemListener() {
                @Override
                public void itemStateChanged(ItemEvent e) {
                    checkBoxPersonItemStateChanged();
                }
            });
            panelPerson.add(checkBoxPerson);
            checkBoxPerson.setBounds(420, 135, 220, 18);

            { // compute preferred size
                Dimension preferredSize = new Dimension();
                for(int i = 0; i < panelPerson.getComponentCount(); i++) {
                    Rectangle bounds = panelPerson.getComponent(i).getBounds();
                    preferredSize.width = Math.max(bounds.x + bounds.width, preferredSize.width);
                    preferredSize.height = Math.max(bounds.y + bounds.height, preferredSize.height);
                }
                Insets insets = panelPerson.getInsets();
                preferredSize.width += insets.right;
                preferredSize.height += insets.bottom;
                panelPerson.setMinimumSize(preferredSize);
                panelPerson.setPreferredSize(preferredSize);
            }
        }
        add(panelPerson);
        panelPerson.setBounds(15, 10, 650, 160);

        //======== panelWorkgroup ========
        {
            panelWorkgroup.setBorder(new TitledBorder(null, "\u062a\u062e\u0635\u06cc\u0635 \u06af\u0631\u0648\u0647 \u06a9\u0627\u0631\u06cc", TitledBorder.LEADING, TitledBorder.DEFAULT_POSITION,
                new Font("Tahoma", Font.PLAIN, 12)));
            panelWorkgroup.setComponentOrientation(ComponentOrientation.RIGHT_TO_LEFT);
            panelWorkgroup.setLayout(null);

            //======== scrollPane2 ========
            {

                //---- tableWorkgroup ----
                tableWorkgroup.setSelectionMode(ListSelectionModel.SINGLE_INTERVAL_SELECTION);
                tableWorkgroup.setModel(new DefaultTableModel(
                    new Object[][] {
                    },
                    new String[] {
                        "\u0639\u0646\u0648\u0627\u0646", "\u0627\u0646\u062a\u062e\u0627\u0628"
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
                    TableColumnModel cm = tableWorkgroup.getColumnModel();
                    cm.getColumn(0).setResizable(false);
                    cm.getColumn(1).setResizable(false);
                    cm.getColumn(1).setMinWidth(60);
                    cm.getColumn(1).setPreferredWidth(60);
                }
                tableWorkgroup.setFont(new Font("Tahoma", Font.PLAIN, 11));
                scrollPane2.setViewportView(tableWorkgroup);
            }
            panelWorkgroup.add(scrollPane2);
            scrollPane2.setBounds(10, 17, 630, 105);

            { // compute preferred size
                Dimension preferredSize = new Dimension();
                for(int i = 0; i < panelWorkgroup.getComponentCount(); i++) {
                    Rectangle bounds = panelWorkgroup.getComponent(i).getBounds();
                    preferredSize.width = Math.max(bounds.x + bounds.width, preferredSize.width);
                    preferredSize.height = Math.max(bounds.y + bounds.height, preferredSize.height);
                }
                Insets insets = panelWorkgroup.getInsets();
                preferredSize.width += insets.right;
                preferredSize.height += insets.bottom;
                panelWorkgroup.setMinimumSize(preferredSize);
                panelWorkgroup.setPreferredSize(preferredSize);
            }
        }
        add(panelWorkgroup);
        panelWorkgroup.setBounds(16, 170, 649, 129);

        //======== panelPC ========
        {
            panelPC.setBorder(new TitledBorder(null, "\u062a\u062e\u0635\u06cc\u0635 \u0631\u0627\u06cc\u0627\u0646\u0647", TitledBorder.LEADING, TitledBorder.DEFAULT_POSITION,
                new Font("Tahoma", Font.PLAIN, 12)));
            panelPC.setComponentOrientation(ComponentOrientation.RIGHT_TO_LEFT);
            panelPC.setLayout(null);

            //======== scrollPane3 ========
            {

                //---- tablePC ----
                tablePC.setModel(new DefaultTableModel(
                    new Object[][] {
                    },
                    new String[] {
                        "\u0645\u062d\u0644", "\u0622\u06cc \u067e\u06cc", "\u0639\u0646\u0648\u0627\u0646", "\u0627\u0646\u062a\u062e\u0627\u0628"
                    }
                ) {
                    Class<?>[] columnTypes = new Class<?>[] {
                        Object.class, Object.class, Object.class, Boolean.class
                    };
                    boolean[] columnEditable = new boolean[] {
                        false, false, false, true
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
                    TableColumnModel cm = tablePC.getColumnModel();
                    cm.getColumn(0).setResizable(false);
                    cm.getColumn(0).setMinWidth(150);
                    cm.getColumn(1).setResizable(false);
                    cm.getColumn(1).setMinWidth(120);
                    cm.getColumn(1).setMaxWidth(120);
                    cm.getColumn(1).setPreferredWidth(120);
                    cm.getColumn(2).setResizable(false);
                    cm.getColumn(2).setMinWidth(150);
                    cm.getColumn(3).setResizable(false);
                    cm.getColumn(3).setMinWidth(60);
                    cm.getColumn(3).setMaxWidth(60);
                    cm.getColumn(3).setPreferredWidth(60);
                }
                tablePC.setSelectionMode(ListSelectionModel.SINGLE_INTERVAL_SELECTION);
                tablePC.setFont(new Font("Tahoma", Font.PLAIN, 11));
                scrollPane3.setViewportView(tablePC);
            }
            panelPC.add(scrollPane3);
            scrollPane3.setBounds(10, 18, 630, 120);

            { // compute preferred size
                Dimension preferredSize = new Dimension();
                for(int i = 0; i < panelPC.getComponentCount(); i++) {
                    Rectangle bounds = panelPC.getComponent(i).getBounds();
                    preferredSize.width = Math.max(bounds.x + bounds.width, preferredSize.width);
                    preferredSize.height = Math.max(bounds.y + bounds.height, preferredSize.height);
                }
                Insets insets = panelPC.getInsets();
                preferredSize.width += insets.right;
                preferredSize.height += insets.bottom;
                panelPC.setMinimumSize(preferredSize);
                panelPC.setPreferredSize(preferredSize);
            }
        }
        add(panelPC);
        panelPC.setBounds(15, 295, 650, 145);

        //======== panel3 ========
        {
            panel3.setBorder(new EtchedBorder());
            panel3.setLayout(null);

            //---- buttonCancel ----
            buttonCancel.setText("cancel");
            buttonCancel.setFont(new Font("Tahoma", Font.PLAIN, 11));
            buttonCancel.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    cancelActionPerformed();
                }
            });
            panel3.add(buttonCancel);
            buttonCancel.setBounds(35, 10, 95, 24);

            //---- buttonSave ----
            buttonSave.setText("\u0630\u062e\u06cc\u0631\u0647");
            buttonSave.setFont(new Font("Tahoma", Font.PLAIN, 11));
            buttonSave.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    saveActionPerformed();
                }
            });
            panel3.add(buttonSave);
            buttonSave.setBounds(145, 10, 95, 24);

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
        panel3.setBounds(17, 445, 648, 45);

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
    protected JPanel panelPerson;
    private JScrollPane scrollPane1;
    protected JTable tablePerson;
    protected JCheckBox checkBoxPerson;
    protected JPanel panelWorkgroup;
    private JScrollPane scrollPane2;
    protected JTable tableWorkgroup;
    protected JPanel panelPC;
    private JScrollPane scrollPane3;
    protected JTable tablePC;
    private JPanel panel3;
    protected JButton buttonCancel;
    protected JButton buttonSave;
    // JFormDesigner - End of variables declaration  //GEN-END:variables
}
