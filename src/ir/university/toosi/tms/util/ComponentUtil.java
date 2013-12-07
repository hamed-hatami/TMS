package ir.university.toosi.tms.util;


import javax.imageio.ImageIO;
import javax.swing.*;
import javax.swing.border.TitledBorder;
import javax.swing.plaf.basic.BasicComboBoxRenderer;
import javax.swing.table.DefaultTableCellRenderer;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.net.URL;

/**
 * @author a_hadadi
 */

public class ComponentUtil {


    public static ImageIcon getImageIcon(String fileName) {

        if (ThreadPoolManager.isDebugMode) {
            BufferedImage bufferedImage = null;
            try {
                String pathPrefix = "D:\\TMS\\TMS\\resources\\images\\";//todo change it to your pc address
                bufferedImage = ImageIO.read(new File(pathPrefix + fileName));
            } catch (IOException e) {
                e.printStackTrace();
                System.out.println("desire image not fund : " + fileName);
            }
            ImageIcon imageIcon = new ImageIcon(bufferedImage);
            return imageIcon;

        } else {
            //at jar file
            return new ImageIcon(ComponentUtil.class.getClassLoader().getResource(fileName));
        }
    }


    public static void SetJTableAlignment(javax.swing.JTable jTable, ComponentOrientation componentOrientation) {
        Font tahoma = new Font("Tahoma", Font.PLAIN, 11);
        int labelAlighnment = JLabel.RIGHT;
        int headerAlighnment = JLabel.RIGHT;
        if (componentOrientation == ComponentOrientation.LEFT_TO_RIGHT) {
            labelAlighnment = JLabel.LEFT;
            headerAlighnment = JLabel.LEFT;
        }


        DefaultTableCellRenderer defaultTableCellRenderer = new DefaultTableCellRenderer();
        defaultTableCellRenderer.setHorizontalAlignment(labelAlighnment);
       // defaultTableCellRenderer.setFont(tahoma);

        for (int columnIndex = 0; columnIndex < jTable.getColumnCount(); columnIndex++) {
            if (jTable.getModel().getColumnClass(columnIndex).equals(Boolean.class)) {
                jTable.getColumnModel().getColumn(columnIndex).setWidth(60);
                jTable.getColumnModel().getColumn(columnIndex).setMaxWidth(90);
                jTable.getColumnModel().getColumn(columnIndex).setMinWidth(10);
                jTable.getColumnModel().getColumn(columnIndex).setPreferredWidth(60);
                continue;
            }
            if (jTable.getModel().getColumnClass(columnIndex).equals(ImageIcon.class)) {
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

        if (component instanceof JTextField) {
            component.setComponentOrientation(componentOrientation);
        }

        if (component instanceof JTextArea) {
            component.setComponentOrientation(componentOrientation);
        }

        if (component instanceof JTextPane) {
            component.setComponentOrientation(componentOrientation);
        }

        if (component instanceof JScrollPane) {
            for (Component cmp : component.getComponents()) {
                setFont((JComponent) cmp, font, componentOrientation);
            }
        }

        if (component instanceof JTree) {
            component.setComponentOrientation(componentOrientation);
        }

        if (component instanceof JComboBox) {
            component.setComponentOrientation(componentOrientation);
            JComboBox comboBox = (JComboBox) component;
            ((BasicComboBoxRenderer) comboBox.getRenderer()).setHorizontalAlignment(SwingConstants.RIGHT);
            ((BasicComboBoxRenderer) comboBox.getRenderer()).setAutoscrolls(true);
            comboBox.setMaximumRowCount(20);
        }

       /* if(component instanceof JLabel) {
            ((JLabel)component).setHorizontalTextPosition(SwingConstants.RIGHT);
        }*/

        if (component instanceof JPanel) {
            JPanel panel = (JPanel) component;
            if (panel.getBorder() != null && panel.getBorder() instanceof TitledBorder) {
                ((TitledBorder) panel.getBorder()).setTitleFont(font);
                panel.setComponentOrientation(componentOrientation);
            }
            for (Component cmp : component.getComponents()) {
                setFont((JComponent) cmp, font, componentOrientation);
            }
        }

        if (component instanceof JTabbedPane) {
            JTabbedPane tabbedPane = (JTabbedPane) component;
            int tabCount = tabbedPane.getTabCount();
            for (int i = 0; i < tabCount; i++) {
                setFont((JComponent) tabbedPane.getComponentAt(i), font, componentOrientation);
            }
        }
    }

    public static void changeComonentOrientation(Component[] components, ComponentOrientation orientation) {
        for (Component c : components) {
            c.setComponentOrientation(orientation);
            if (c instanceof java.awt.Container)
                changeComonentOrientation(((java.awt.Container) c).getComponents(), orientation);
        }
    }



}
