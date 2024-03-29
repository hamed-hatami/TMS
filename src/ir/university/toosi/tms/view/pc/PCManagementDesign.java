/*
 * Created by JFormDesigner on Wed Oct 02 20:01:16 AFT 2013
 */

package ir.university.toosi.tms.view.pc;

import javax.swing.*;
import javax.swing.border.EtchedBorder;
import javax.swing.border.TitledBorder;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * @author a_hadadi
 */
public abstract class PCManagementDesign extends JPanel {
    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables
    protected JPanel panelSearch;
    protected JLabel labelFilter;
    protected JLabel labelFilterBy;
    protected JTextField textFieldFilter;
    protected JComboBox comboBoxFilterBy;
    protected JPanel panelPCList;
    protected JScrollPane scrollPane1;
    protected JTable tablePC;
    protected JButton buttonCancel;
    protected JButton buttonEdit;
    protected JButton buttonAdd;
    protected JButton buttonDelete;
    private JPanel panelButton;

    public PCManagementDesign() {
        initComponents();
    }

    protected abstract void buttonCancelActionPerformed();

    protected abstract void buttonEditActionPerformed();

    protected abstract void buttonAddActionPerformed();

    protected abstract void buttonDeleteActionPerformed();

    protected abstract void filterEvent();

    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents
        panelSearch = new JPanel();
        labelFilter = new JLabel();
        labelFilterBy = new JLabel();
        textFieldFilter = new JTextField();
        comboBoxFilterBy = new JComboBox();
        panelPCList = new JPanel();
        scrollPane1 = new JScrollPane();
        tablePC = new JTable();
        panelButton = new JPanel();
        buttonCancel = new JButton();
        buttonEdit = new JButton();
        buttonAdd = new JButton();
        buttonDelete = new JButton();

        //======== this ========
        setVisible(true);
        setLayout(null);

        //======== panelSearch ========
        {
            panelSearch.setBorder(new TitledBorder("TMS_PC_SEARCH"));
            panelSearch.setLayout(null);

            //---- labelFilter ----
            labelFilter.setText("Filter text");
            panelSearch.add(labelFilter);
            labelFilter.setBounds(465, 20, 80, 25);

            //---- labelFilterBy ----
            labelFilterBy.setText("filter by");
            panelSearch.add(labelFilterBy);
            labelFilterBy.setBounds(200, 20, 80, 25);

            //---- textFieldFilter ----

            //filter text typing event
            textFieldFilter.getDocument().addDocumentListener(new DocumentListener() {
                @Override
                public void insertUpdate(DocumentEvent e) {
                    filterEvent();
                }

                @Override
                public void removeUpdate(DocumentEvent e) {
                    filterEvent();
                }

                @Override
                public void changedUpdate(DocumentEvent e) {
                    filterEvent();
                }
            });
            panelSearch.add(textFieldFilter);
            textFieldFilter.setBounds(330, 20, 130, textFieldFilter.getPreferredSize().height);
            panelSearch.add(comboBoxFilterBy);
            comboBoxFilterBy.setBounds(25, 20, 165, comboBoxFilterBy.getPreferredSize().height);

            { // compute preferred size
                Dimension preferredSize = new Dimension();
                for (int i = 0; i < panelSearch.getComponentCount(); i++) {
                    Rectangle bounds = panelSearch.getComponent(i).getBounds();
                    preferredSize.width = Math.max(bounds.x + bounds.width, preferredSize.width);
                    preferredSize.height = Math.max(bounds.y + bounds.height, preferredSize.height);
                }
                Insets insets = panelSearch.getInsets();
                preferredSize.width += insets.right;
                preferredSize.height += insets.bottom;
                panelSearch.setMinimumSize(preferredSize);
                panelSearch.setPreferredSize(preferredSize);
            }
        }
        add(panelSearch);
        panelSearch.setBounds(7, 5, 610, 55);

        //======== panelPCList ========
        {
            panelPCList.setBorder(new TitledBorder("TMS_PC_LIST"));
            panelPCList.setLayout(null);

            //======== scrollPane1 ========
            {
                scrollPane1.setViewportView(tablePC);
            }
            panelPCList.add(scrollPane1);
            scrollPane1.setBounds(10, 20, 590, 275);

            { // compute preferred size
                Dimension preferredSize = new Dimension();
                for (int i = 0; i < panelPCList.getComponentCount(); i++) {
                    Rectangle bounds = panelPCList.getComponent(i).getBounds();
                    preferredSize.width = Math.max(bounds.x + bounds.width, preferredSize.width);
                    preferredSize.height = Math.max(bounds.y + bounds.height, preferredSize.height);
                }
                Insets insets = panelPCList.getInsets();
                preferredSize.width += insets.right;
                preferredSize.height += insets.bottom;
                panelPCList.setMinimumSize(preferredSize);
                panelPCList.setPreferredSize(preferredSize);
            }
        }
        add(panelPCList);
        panelPCList.setBounds(7, 65, 610, 305);

        //======== panelButton ========
        {
            panelButton.setBorder(new EtchedBorder());
            panelButton.setLayout(null);

            //---- buttonCancel ----
            buttonCancel.setText("Cancel");
            buttonCancel.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    buttonCancelActionPerformed();
                }
            });
            panelButton.add(buttonCancel);
            buttonCancel.setBounds(15, 15, 80, 26);

            //---- buttonEdit ----
            buttonEdit.setText("Edit");
            buttonEdit.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    buttonEditActionPerformed();
                }
            });
            panelButton.add(buttonEdit);
            buttonEdit.setBounds(211, 15, 80, 26);

            //---- buttonAdd ----
            buttonAdd.setText("Add");
            buttonAdd.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    buttonAddActionPerformed();
                }
            });
            panelButton.add(buttonAdd);
            buttonAdd.setBounds(309, 15, 80, 26);

            //---- buttonDelete ----
            buttonDelete.setText("Delete");
            buttonDelete.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    buttonDeleteActionPerformed();
                }
            });
            panelButton.add(buttonDelete);
            buttonDelete.setBounds(113, 15, 80, 26);

            { // compute preferred size
                Dimension preferredSize = new Dimension();
                for (int i = 0; i < panelButton.getComponentCount(); i++) {
                    Rectangle bounds = panelButton.getComponent(i).getBounds();
                    preferredSize.width = Math.max(bounds.x + bounds.width, preferredSize.width);
                    preferredSize.height = Math.max(bounds.y + bounds.height, preferredSize.height);
                }
                Insets insets = panelButton.getInsets();
                preferredSize.width += insets.right;
                preferredSize.height += insets.bottom;
                panelButton.setMinimumSize(preferredSize);
                panelButton.setPreferredSize(preferredSize);
            }
        }
        add(panelButton);
        panelButton.setBounds(9, 375, 608, 55);

        { // compute preferred size
            Dimension preferredSize = new Dimension();
            for (int i = 0; i < getComponentCount(); i++) {
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
    // JFormDesigner - End of variables declaration  //GEN-END:variables
}
