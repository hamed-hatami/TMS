package ir.university.toosi.tms.view.user;


import ir.university.toosi.tms.model.entity.User;
import ir.university.toosi.tms.util.ThreadPoolManager;
import ir.university.toosi.tms.view.TMSInternalFrame;

import java.awt.*;

public class UserAddCode extends TMSInternalFrame {

    private UserAddPanel panel = null;
    private User user;
    private boolean isNewUser = false;

    public UserAddCode(User user){
       this();
        this.isNewUser = false;
       this.user = user;
        if(null == user){
            System.out.println("user is null");
            dispose();

        }
        panel.textFieldUserName.setEditable(false);
        panel.textFieldUserName.setBackground(Color.GRAY);

        panel.textFieldUserName.setText(user.getUsername());
        //panel.textFieldUserPassword.setText(user.getPassword());
        panel.textFieldUserPassword.setText("");
        panel.checkBoxStatus.setSelected(user.getEnable().equalsIgnoreCase("true"));

    }

    public UserAddCode(){
       super();
        this.isNewUser = true;
        panel = new UserAddPanel();
        panel.setLocation(0, 0);
        panel.setSize(panel.getPreferredSize());
        panel.setVisible(true);
        setLayout(null);
        getContentPane().setBackground(Color.getColor("Control"));

        this.setTitle(ThreadPoolManager.getLangValue("TMS_USER"));
        panel.labelUserName.setText(ThreadPoolManager.getLangValue("TMS_USERNAME"));
        panel.labelUserPassword.setText(ThreadPoolManager.getLangValue("TMS_PASSWORD"));
        panel.labelStatus.setText(ThreadPoolManager.getLangValue("role_status"));

        panel.buttonCancel.setText(ThreadPoolManager.getLangValue("TMS_CANCEL"));
        panel.buttonSave.setText(ThreadPoolManager.getLangValue("TMS_OK"));

        this.add(panel);

    }


    class UserAddPanel extends UserAddDesign {

        @Override
        protected void cancelActionPerformed() {
           dispose();
        }

        @Override
        protected void saveActionPerformed() {

            if(isNewUser){
                //todo add user
            }else{
                //todo edit user
            }
            dispose();
        }
    }
}