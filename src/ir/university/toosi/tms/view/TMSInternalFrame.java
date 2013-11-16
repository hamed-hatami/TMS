package ir.university.toosi.tms.view;

import ir.university.toosi.tms.util.ComponentUtil;

import javax.swing.*;
import java.awt.*;

/**
 * @author : Hamed Hatami , Farzad Sedaghatbin, Atefeh Ahmadi
 * @version : 1.0
 */
public class TMSInternalFrame extends JInternalFrame  {

    public TMSInternalFrame() {
        super();
        setFrameIcon(ComponentUtil.getImageIcon("logo.png"));
        setIconifiable(false);
        setMaximizable(false);
        setResizable(false);
        setClosable(true);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);

    }


    @Override
    public Component add(Component comp) {
        addImpl(comp, null, -1);
        setSize((int) comp.getSize().getWidth() + 20, (int) comp.getSize().getHeight() + 35);
        return comp;
    }



}
