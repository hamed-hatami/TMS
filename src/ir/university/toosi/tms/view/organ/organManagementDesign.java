/*
 * Created by JFormDesigner on Sun Nov 24 15:15:21 IRST 2013
 */

package ir.university.toosi.tms.view.organ;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.border.*;
import javax.swing.tree.*;

/**
 * @author a_hadadi
 */
public abstract class OrganManagementDesign extends JPanel {
    public OrganManagementDesign() {
        initComponents();
    }

    protected abstract void buttonCancelActionPerformed();

    protected abstract void buttonEditActionPerformed();

    protected abstract void buttonAddActionPerformed();

    protected abstract void buttonAllocateActionPerformed();

    protected abstract void buttonDeleteActionPerformed();

    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents
        scrollPane = new JScrollPane();
        tree = new JTree();
        panelButton = new JPanel();
        buttonCancel = new JButton();
        buttonEdit = new JButton();
        buttonAdd = new JButton();
        buttonAllocate = new JButton();
        buttonDelete = new JButton();

        //======== this ========
        setLayout(null);

        //======== scrollPane ========
        {

            //---- tree ----
            tree.setComponentOrientation(ComponentOrientation.RIGHT_TO_LEFT);
            scrollPane.setViewportView(tree);
        }
        add(scrollPane);
        scrollPane.setBounds(10, 10, 520, 325);

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
        panelButton.setBounds(10, 345, 520, 55);

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
    protected JScrollPane scrollPane;
    protected JTree tree;
    private JPanel panelButton;
    protected JButton buttonCancel;
    protected JButton buttonEdit;
    protected JButton buttonAdd;
    protected JButton buttonAllocate;
    protected JButton buttonDelete;
    // JFormDesigner - End of variables declaration  //GEN-END:variables
}
