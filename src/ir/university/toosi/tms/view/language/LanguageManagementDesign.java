/*
 * Created by JFormDesigner on Tue Oct 08 10:12:33 IRST 2013
 */

package ir.university.toosi.tms.view.language;

import javax.swing.*;
import javax.swing.border.EtchedBorder;
import javax.swing.border.TitledBorder;
import javax.swing.event.CellEditorListener;
import javax.swing.event.ChangeEvent;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumnModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * @author a_hadadi
 */
public abstract class LanguageManagementDesign extends JPanel {


    public LanguageManagementDesign() {
        initComponents();
    }

    protected abstract void buttonSaveActionPerformed();

    protected abstract void buttonCancelActionPerformed();

    protected abstract void cellEditingStopped();

    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents
        panel2 = new JPanel();
        buttonCancel = new JButton();
        buttonSave = new JButton();
        panel1 = new JPanel();
        scrollPane1 = new JScrollPane();
        tableLanguageData = new JTable();

        //======== this ========
        setLayout(null);

        //======== panel2 ========
        {
            panel2.setBorder(new EtchedBorder());
            panel2.setLayout(null);

            //---- buttonCancel ----
            buttonCancel.setText("\u0627\u0646\u0635\u0631\u0627\u0641");
            buttonCancel.setFont(new Font("Tahoma", Font.PLAIN, 11));
            buttonCancel.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    buttonCancelActionPerformed();
                }
            });
            panel2.add(buttonCancel);
            buttonCancel.setBounds(10, 15, 81, 25);

            //---- buttonSave ----
            buttonSave.setText("\u0630\u062e\u06cc\u0631\u0647");
            buttonSave.setFont(new Font("Tahoma", Font.PLAIN, 11));
            buttonSave.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    buttonSaveActionPerformed();
                }
            });
            panel2.add(buttonSave);
            buttonSave.setBounds(105, 15, 81, 25);

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
        panel2.setBounds(5, 235, 448, 55);

        //======== panel1 ========
        {
            panel1.setBorder(new TitledBorder(null, "\u0645\u062f\u06cc\u0631\u06cc\u062a \u0632\u0628\u0627\u0646", TitledBorder.LEADING, TitledBorder.DEFAULT_POSITION,
                new Font("Tahoma", Font.PLAIN, 11)));
            panel1.setComponentOrientation(ComponentOrientation.RIGHT_TO_LEFT);
            panel1.setLayout(null);

            //======== scrollPane1 ========
            {

                //---- tableLanguageData ----
                tableLanguageData.setModel(new DefaultTableModel(
                    new Object[][] {
                    },
                    new String[] {
                        "\u06a9\u0644\u06cc\u062f", "\u0645\u0642\u062f\u0627\u0631"
                    }
                ) {
                    boolean[] columnEditable = new boolean[] {
                        false, true
                    };
                    @Override
                    public boolean isCellEditable(int rowIndex, int columnIndex) {
                        return columnEditable[columnIndex];
                    }
                });
                {
                    TableColumnModel cm = tableLanguageData.getColumnModel();
                    cm.getColumn(0).setMinWidth(150);
                    cm.getColumn(0).setMaxWidth(200);
                    cm.getColumn(0).setPreferredWidth(150);
                    cm.getColumn(1).setMinWidth(150);
                    cm.getColumn(1).setMaxWidth(300);
                    cm.getColumn(1).setPreferredWidth(200);
                }
                tableLanguageData.setSelectionMode(ListSelectionModel.SINGLE_INTERVAL_SELECTION);
                tableLanguageData.setFont(new Font("Tahoma", Font.PLAIN, 11));
                 tableLanguageData.getDefaultEditor(String.class).addCellEditorListener(new CellEditorListener() {
                            @Override
                            public void editingStopped(ChangeEvent e) {
                               cellEditingStopped();
                            }

                            @Override
                            public void editingCanceled(ChangeEvent e) {

                            }
                        });
                scrollPane1.setViewportView(tableLanguageData);
            }
            panel1.add(scrollPane1);
            scrollPane1.setBounds(5, 25, 440, 195);
        }
        add(panel1);
        panel1.setBounds(5, 10, 450, 225);

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
    private JPanel panel2;
    protected JButton buttonCancel;
    protected JButton buttonSave;
    protected JPanel panel1;
    private JScrollPane scrollPane1;
    protected JTable tableLanguageData;
    // JFormDesigner - End of variables declaration  //GEN-END:variables
}
