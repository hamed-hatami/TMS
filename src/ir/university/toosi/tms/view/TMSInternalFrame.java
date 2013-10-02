package ir.university.toosi.tms.view;

import ir.university.toosi.tms.controller.LanguageAction;

import javax.swing.*;
import java.awt.*;

/**
 * @author : Hamed Hatami , Farzad Sedaghatbin, Atefeh Ahmadi
 * @version : 1.0
 */
public class TMSInternalFrame extends JInternalFrame {

    public TMSInternalFrame() {
        super();
       // setFrameIcon(new ImageIcon(getClass().getClassLoader().getResource("logo.png")));
        setFrameIcon(new ImageIcon("./images/logo.png")); //todo
        setComponentOrientation(ComponentOrientation.RIGHT_TO_LEFT);
        Dimension dimension = Toolkit.getDefaultToolkit().getScreenSize();
        int x = (int) (dimension.getWidth() / 4);
        int y = (int) (dimension.getHeight() / 4);
        setLocation(x, y);
    }
}
