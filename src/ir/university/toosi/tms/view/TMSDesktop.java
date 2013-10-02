package ir.university.toosi.tms.view;

import ir.university.toosi.tms.controller.LanguageAction;

import javax.swing.*;
import java.awt.*;

/**
 * @author : Hamed Hatami , Farzad Sedaghatbin, Atefeh Ahmadi
 * @version : 1.0
 */
public class TMSDesktop extends JDesktopPane {

   // Image image = new ImageIcon(TMSDesktop.class.getClassLoader().getResource("bg.png")).getImage();
    Image image = new ImageIcon("./images/bg.png").getImage();//todo

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.drawImage(image, 0, 0, this.getWidth(), this.getHeight(), this);
        setComponentOrientation(ComponentOrientation.getOrientation(LanguageAction.getLocale()));
    }
}
