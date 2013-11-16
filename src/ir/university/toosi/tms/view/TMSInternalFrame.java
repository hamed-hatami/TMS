package ir.university.toosi.tms.view;

import javax.swing.*;
import java.awt.*;

/**
 * @author : Hamed Hatami , Farzad Sedaghatbin, Atefeh Ahmadi
 * @version : 1.0
 */
public class TMSInternalFrame extends JInternalFrame  {

    public TMSInternalFrame() {
        super();
      // setFrameIcon(new ImageIcon(getClass().getClassLoader().getResource("logo.png"))); //todo enable for jar deploy
        setFrameIcon(new ImageIcon(getClass().getResource("/resources/images/logo.png")));  //todo enable for idea

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
