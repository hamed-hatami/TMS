package ir.university.toosi.tms.view.pc;

import ir.university.toosi.tms.view.TMSInternalFrame;

import java.awt.*;

/**
 * Created with IntelliJ IDEA.
 * User: a_hadadi
 * Date: 10/2/13
 * Time: 8:24 PM
 * To change this template use File | Settings | File Templates.
 */
public class PCManagementCode extends TMSInternalFrame {
   private String formTitle = "this title";
   private PCManagementPanel panel = null;
   public PCManagementCode(){
       super();

       panel = new PCManagementPanel();
       panel.setLocation(0, 0);
       panel.setSize(panel.getPreferredSize());
       panel.setVisible(true);
       setLayout(null);
       getContentPane().setBackground(Color.getColor("Control"));
       this.add(panel);


   }




    class PCManagementPanel extends PCManagementDesign {
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
