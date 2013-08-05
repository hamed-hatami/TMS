package ir.university.toosi.tms.view;

import javax.swing.*;
import java.awt.*;

/**
 * @author : Hamed Hatami , Javad Sarhadi , Farzad Sedaghatbin, Atefeh Ahmadi
 * @version : 1.0
 */
public class TMSJDesktop extends JDesktopPane {

    Image image = new ImageIcon("/home/hatami/Layering.png").getImage().getScaledInstance(1500, 1000, Image.SCALE_SMOOTH);

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.drawImage(image, 0, 0, this);
    }
}
