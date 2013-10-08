package ir.university.toosi.tms.view;

import ir.university.toosi.tms.controller.LanguageAction;

import javax.swing.*;
import javax.swing.border.TitledBorder;
import javax.swing.event.InternalFrameEvent;
import javax.swing.event.InternalFrameListener;
import java.awt.*;

/**
 * @author : Hamed Hatami , Farzad Sedaghatbin, Atefeh Ahmadi
 * @version : 1.0
 */
public class TMSInternalFrame extends JInternalFrame  {

    public TMSInternalFrame() {
        super();
      // setFrameIcon(new ImageIcon(getClass().getClassLoader().getResource("logo.png"))); //todo enable for jar deploy
        setFrameIcon(new ImageIcon(getClass().getResource("/ir/university/toosi/tms/view/images/logo.png")));  //todo enable for idea

        setIconifiable(false);
        setMaximizable(false);
        setResizable(false);
        setClosable(true);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        setComponentOrientation(ComponentOrientation.RIGHT_TO_LEFT);

    }


    @Override
    public Component add(Component comp) {
        addImpl(comp, null, -1);
        setSize((int) comp.getSize().getWidth() + 20, (int) comp.getSize().getHeight() + 35);
        return comp;
    }

    public static void setFont(JComponent component, Font font) {
        component.setFont(font);
        if(component instanceof JPanel) {
            JPanel panel = (JPanel)component;
            if(panel.getBorder() != null && panel.getBorder() instanceof TitledBorder) {
                ((TitledBorder)panel.getBorder()).setTitleFont(font);
            }
            for(Component cmp : component.getComponents()) {
                setFont((JComponent)cmp, font);
            }
        }

        if(component instanceof JTabbedPane) {
            JTabbedPane tabbedPane = (JTabbedPane)component;
            int tabCount = tabbedPane.getTabCount();
            for(int i = 0 ; i < tabCount ; i++) {
                setFont((JComponent)tabbedPane.getComponentAt(i), font);
            }
        }
    }
}
