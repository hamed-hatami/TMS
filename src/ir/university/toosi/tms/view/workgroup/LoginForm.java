package ir.university.toosi.tms.view.workgroup;

import javax.swing.*;
import java.awt.*;

public class LoginForm extends JDialog {

    private String formTitle = "login";
    private LoginFormPanel panel = null;
    private boolean login = false;

    public LoginForm(){
        super();

        panel = new LoginFormPanel();
        panel.setLocation(0, 0);
        setSize((int) panel.getSize().getWidth() + 4, panel.getHeight() + 25);
        panel.setVisible(true);
        setLayout(null);
       // getContentPane().setBackground(Color.getColor("Control"));
        this.add(panel);
        Dimension dimension = Toolkit.getDefaultToolkit().getScreenSize();
        int x = (int)(dimension.getWidth()-getSize().getWidth()) / 2;
        int y = (int)(dimension.getHeight()-getSize().getHeight()) / 2;
        this.setLocation(x,y);
        setResizable(false);
       // setModalityType(ModalityType.TOOLKIT_MODAL);
        //setModalityType(ModalityType.MODELESS);

    }

    public boolean isLogin() {
        return login;
    }

    public void setLogin(boolean login) {
        this.login = login;
    }

    class LoginFormPanel extends LoginDesign {

        @Override
        void buttonLoginActionPerformed() {
           setLogin(true);
        }

        @Override
        void buttonCancelActionPerformed() {
            setLogin(false);
        }
    }
}
