package ir.university.toosi.tms.view.user;

import ir.university.toosi.tms.view.TMSInternalFrame;

import java.awt.*;

/**
 * Created with IntelliJ IDEA.
 * User: a_hadadi
 * Date: 10/2/13
 * Time: 8:24 PM
 * To change this template use File | Settings | File Templates.
 */
public class UserManagementCode extends TMSInternalFrame {
   private String formTitle = "this title";
   private UserManagementPanel panel = null;
   public UserManagementCode(){
       super();

       panel = new UserManagementPanel();
       panel.setLocation(0, 0);
       panel.setSize(panel.getPreferredSize());
       panel.setVisible(true);
       setLayout(null);
       getContentPane().setBackground(Color.getColor("Control"));
       this.add(panel);


   }




    class UserManagementPanel extends UserManagementDesign {
        @Override
        protected void button1ActionPerformed() {
            //todo
        }

        @Override
        protected void button2ActionPerformed() {
            //todo
        }

        @Override
        protected void button4ActionPerformed() {
            //To change body of implemented methods use File | Settings | File Templates.
        }

        @Override
        protected void button3ActionPerformed() {
            //todo
        }
    }
}
