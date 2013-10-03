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

    @Override
    public Component add(Component comp) {
        //Dimension dimension = Toolkit.getDefaultToolkit().getScreenSize();
        Dimension dimension = getSize();
        int x = (int)(dimension.getWidth()-comp.getSize().getWidth()) / 2;
        int y = (int)(dimension.getHeight()-comp.getSize().getHeight()) / 2;
        comp.setLocation(x, y);
        addImpl(comp, null, -1);
        return comp;
    }




}
