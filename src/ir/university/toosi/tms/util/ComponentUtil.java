package ir.university.toosi.tms.util;


import sun.swing.table.DefaultTableCellHeaderRenderer;


import javax.swing.*;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.JTableHeader;
import javax.swing.table.TableColumnModel;
import java.awt.*;

/**
 * @author a_hadadi
 */

public class ComponentUtil {

    public static ImageIcon getImageIcon(String fileName, Class currentClass) {
        String pathPrefix = "/ir/university/toosi/tms/view/images/";
        if (ThreadPoolManager.isDebugMode) {
            //at IDE
            return new ImageIcon(currentClass.getResource(pathPrefix + fileName));
        } else {
            //at jar file
            return new ImageIcon(currentClass.getClassLoader().getResource(fileName));
        }
    }


    public static void SetJTableAlignment(javax.swing.JTable jTable, ComponentOrientation componentOrientation) {
        Font tahoma = new Font("Tahoma", Font.PLAIN, 11);
        int  labelAlighnment = JLabel.RIGHT;
        int  headerAlighnment = JLabel.RIGHT;
        if(componentOrientation == ComponentOrientation.LEFT_TO_RIGHT){
            labelAlighnment = JLabel.LEFT;
            headerAlighnment = JLabel.LEFT;
        }


        DefaultTableCellRenderer defaultTableCellRenderer = new DefaultTableCellRenderer();
        defaultTableCellRenderer.setHorizontalAlignment(labelAlighnment);

        for (int columnIndex = 0; columnIndex < jTable.getColumnCount(); columnIndex++) {
            if(jTable.getModel().getColumnClass(columnIndex).equals(Boolean.class)){
                jTable.getColumnModel().getColumn(columnIndex).setWidth(60);
                jTable.getColumnModel().getColumn(columnIndex).setMaxWidth(90);
                jTable.getColumnModel().getColumn(columnIndex).setMinWidth(10);
                jTable.getColumnModel().getColumn(columnIndex).setPreferredWidth(60);
                continue;
            }
            jTable.getColumnModel().getColumn(columnIndex).setCellRenderer(defaultTableCellRenderer);

        }

       /* JTableHeader header = jTable.getTableHeader();
        DefaultTableCellHeaderRenderer defaultTableCellHeaderRenderer = (DefaultTableCellHeaderRenderer) header.getDefaultRenderer();
        defaultTableCellHeaderRenderer.setHorizontalTextPosition(headerAlighnment);
        defaultTableCellHeaderRenderer.setFont(tahoma);*/

        DefaultTableCellRenderer renderer;
        renderer = (DefaultTableCellRenderer)
                jTable.getTableHeader().getDefaultRenderer();
        renderer.setHorizontalAlignment(headerAlighnment);

       jTable.getTableHeader().setDefaultRenderer(renderer);

    }

    public static void setFont(JComponent component, Font font, ComponentOrientation componentOrientation) {
        component.setFont(font);

        if(component instanceof JTextField){
            component.setComponentOrientation(componentOrientation);
        }


        if(component instanceof JPanel) {
            JPanel panel = (JPanel)component;
            if(panel.getBorder() != null && panel.getBorder() instanceof TitledBorder) {
                ((TitledBorder)panel.getBorder()).setTitleFont(font);
                panel.setComponentOrientation(componentOrientation);
            }
            for(Component cmp : component.getComponents()) {
                setFont((JComponent)cmp, font,componentOrientation);
            }
        }

        if(component instanceof JTabbedPane) {
            JTabbedPane tabbedPane = (JTabbedPane)component;
            int tabCount = tabbedPane.getTabCount();
            for(int i = 0 ; i < tabCount ; i++) {
                setFont((JComponent)tabbedPane.getComponentAt(i), font,componentOrientation);
            }
        }
    }

    private static void changeComonentOrientationRecurcive(Component[] components, ComponentOrientation orientation) {
        for (Component c : components) {
            c.setComponentOrientation(orientation);
            if (c instanceof java.awt.Container)
                changeComonentOrientationRecurcive(((java.awt.Container) c).getComponents(), orientation);
        }
    }

    public static void changeComonentOrientation(JInternalFrame jInternalFrame, ComponentOrientation orientation) {
        changeComonentOrientationRecurcive(jInternalFrame.getComponents(), orientation);
        jInternalFrame.repaint();
        jInternalFrame.revalidate();
    }

}
