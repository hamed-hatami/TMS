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
        setComponentOrientation(ComponentOrientation.getOrientation(LanguageAction.getLocale()));
        Toolkit toolkit = Toolkit.getDefaultToolkit();
        int xSize = ((int) toolkit.getScreenSize().getWidth() / 2);
        int ySize = ((int) toolkit.getScreenSize().getHeight() / 2);

        setLocation(xSize, ySize);
    }
}
