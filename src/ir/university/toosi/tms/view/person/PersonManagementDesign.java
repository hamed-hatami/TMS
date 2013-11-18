/*
 * Created by JFormDesigner on Sun Nov 10 18:08:20 IRST 2013
 */

package ir.university.toosi.tms.view.person;

import java.awt.*;
import java.awt.event.*;
import java.io.IOException;
import javax.swing.*;
import javax.swing.border.*;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;

/**
 * @author a_hadadi
 */
public abstract class PersonManagementDesign extends JPanel {
    public PersonManagementDesign() {
        initComponents();
    }

    protected  abstract void buttonCancelActionPerformed();

    protected  abstract void buttonEditActionPerformed();

    protected  abstract void buttonAddActionPerformed();

    protected  abstract void buttonDeleteActionPerformed();

    protected  abstract void buttonAllocateActionPerformed();

    protected  abstract void filterEvent();

    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents
        panelPersonList = new JPanel();
        scrollPane1 = new JScrollPane();
        tablePerson = new JTable();
        panelSearch = new JPanel();
        labelFilter = new JLabel();
        labelFilterBy = new JLabel();
        textFieldFilter = new JTextField();
        comboBoxFilterBy = new JComboBox();
        panelButton = new JPanel();
        buttonCancel = new JButton();
        buttonEdit = new JButton();
        buttonAdd = new JButton();
        buttonAllocate = new JButton();
        buttonDelete = new JButton();

        //======== this ========
        setMaximumSize(new Dimension(610, 345));
        setLayout(null);

        //======== panelPersonList ========
        {
            panelPersonList.setBorder(new TitledBorder("TMS_PERSON_LIST"));
            panelPersonList.setLayout(null);

            //======== scrollPane1 ========
            {
                scrollPane1.setViewportView(tablePerson);
            }
            panelPersonList.add(scrollPane1);
            scrollPane1.setBounds(10, 20, 590, 275);

            { // compute preferred size
                Dimension preferredSize = new Dimension();
                for(int i = 0; i < panelPersonList.getComponentCount(); i++) {
                    Rectangle bounds = panelPersonList.getComponent(i).getBounds();
                    preferredSize.width = Math.max(bounds.x + bounds.width, preferredSize.width);
                    preferredSize.height = Math.max(bounds.y + bounds.height, preferredSize.height);
                }
                Insets insets = panelPersonList.getInsets();
                preferredSize.width += insets.right;
                preferredSize.height += insets.bottom;
                panelPersonList.setMinimumSize(preferredSize);
                panelPersonList.setPreferredSize(preferredSize);
            }
        }
        add(panelPersonList);
        panelPersonList.setBounds(15, 68, 610, 305);

        //======== panelSearch ========
        {
            panelSearch.setBorder(new TitledBorder("TMS_PERSON_SEARCH"));
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
                for(int i = 0; i < panelSearch.getComponentCount(); i++) {
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
        panelSearch.setBounds(15, 10, 610, 55);

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
            buttonCancel.setBounds(25, 15, 95, 26);

            //---- buttonEdit ----
            buttonEdit.setText("Edit");
            buttonEdit.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    buttonEditActionPerformed();
                }
            });
            panelButton.add(buttonEdit);
            buttonEdit.setBounds(261, 15, 95, 26);

            //---- buttonAdd ----
            buttonAdd.setText("Add");
            buttonAdd.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    buttonAddActionPerformed();
                }
            });
            panelButton.add(buttonAdd);
            buttonAdd.setBounds(379, 15, 95, 26);

            //---- buttonAllocate ----
            buttonAllocate.setText("Allocate");
            buttonAllocate.setVisible(false);
            buttonAllocate.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    buttonAllocateActionPerformed();
                }
            });
            panelButton.add(buttonAllocate);
            buttonAllocate.setBounds(495, 15, 95, 26);

            //---- buttonDelete ----
            buttonDelete.setText("Delete");
            buttonDelete.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    buttonDeleteActionPerformed();
                }
            });
            panelButton.add(buttonDelete);
            buttonDelete.setBounds(143, 15, 95, 26);

            { // compute preferred size
                Dimension preferredSize = new Dimension();
                for(int i = 0; i < panelButton.getComponentCount(); i++) {
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
        panelButton.setBounds(15, 380, 610, 55);

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
    protected JPanel panelPersonList;
    protected JScrollPane scrollPane1;
    protected JTable tablePerson;
    protected JPanel panelSearch;
    protected JLabel labelFilter;
    protected JLabel labelFilterBy;
    protected JTextField textFieldFilter;
    protected JComboBox comboBoxFilterBy;
    private JPanel panelButton;
    protected JButton buttonCancel;
    protected JButton buttonEdit;
    protected JButton buttonAdd;
    protected JButton buttonAllocate;
    protected JButton buttonDelete;
    // JFormDesigner - End of variables declaration  //GEN-END:variables
}
