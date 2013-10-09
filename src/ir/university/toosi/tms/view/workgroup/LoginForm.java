package ir.university.toosi.tms.view.workgroup;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import ir.university.toosi.tms.model.entity.*;
import ir.university.toosi.tms.util.ComponentUtil;
import ir.university.toosi.tms.util.RESTfulClientUtil;
import ir.university.toosi.tms.util.ThreadPoolManager;
import org.jdesktop.swingx.JXImagePanel;
import ir.university.toosi.tms.util.ImageCanvas;

import javax.swing.*;
import java.awt.*;
import java.io.IOException;
import java.net.InetAddress;
import java.net.MalformedURLException;
import java.net.UnknownHostException;
import java.security.AccessController;
import java.security.PrivilegedAction;
import java.util.*;
import java.util.List;

/**
 * @author a_hadadi
 */

public class LoginForm extends JDialog {

    private String formTitle = "login";
    private LoginFormPanel panel = null;
    private boolean blogin = false;
    public ComponentOrientation direction;

    private WebServiceInfo loginService = new WebServiceInfo();
    private User user, result;
    private String[] langItems;
    private String defaultedLang;
    private java.util.List<Languages> languagesList;

    public LoginForm(){
        super();

        panel = new LoginFormPanel();
        panel.setLocation(0, 0);

        setSize((int) panel.getSize().getWidth() , panel.getHeight() );
        panel.setVisible(true);
        setLayout(null);
        this.add(panel);
        Dimension dimension = Toolkit.getDefaultToolkit().getScreenSize();
        int x = (int)(dimension.getWidth()-getSize().getWidth()) / 2;
        int y = (int)(dimension.getHeight()-getSize().getHeight()) / 2;
        this.setLocation(x,y);
        setResizable(false);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        setUndecorated(true);
        fillSearchCombo();
        init1();

        //URI uri = new URI(aURL.toString());
       // panel.panelLogo = new JXImagePanel()
       // panel.panelLogo = new ImagePanel("./resources/images/big-logo.png") ;
       //panel.panelLogo = new ImagePanel("D:\\ARIA\\CVSROOT\\project\\TMS\\resources\\images\\big-logo.png") ;
       // panel.repaint();

    }

    private void init1() {

        loginService.setServiceName("/loadLanguage");
        try {
            ThreadPoolManager.langHash = new ObjectMapper().readValue(new RESTfulClientUtil().restFullServiceString(loginService.getServerUrl(), loginService.getServiceName(), defaultedLang), new TypeReference<Hashtable<String, LanguageManagement>>() {
            });

        } catch (IOException e) {
            e.printStackTrace();
        }
        panel.login.setText(ThreadPoolManager.getLangValue("TMS_LOGIN"));
        panel.cancel.setText(ThreadPoolManager.getLangValue("TMS_CANCEL"));
        panel.userNameLabel.setText(ThreadPoolManager.getLangValue("TMS_USERNAME"));
        panel.passwordLabel.setText(ThreadPoolManager.getLangValue("TMS_PASSWORD"));
        panel.langLabel.setText(ThreadPoolManager.getLangValue("TMS_LANGUAGE"));

        try {
            Image image = ComponentUtil.getImageIcon("big-logo.png",getClass()).getImage();
            ImageCanvas imageCanvas = new ImageCanvas(image);
            imageCanvas.setBounds(0,0,426,272);
            imageCanvas.setVisible(true);
            panel.add(imageCanvas);
          //  panel.panelLogo.repaint();
          //  validate();
        }catch (Exception e){
            e.printStackTrace();
        }

        panel.langLabel.setOpaque(true);
        panel.repaint();
        validate();




    }

    private void fillSearchCombo() {

        loginService.setServiceName("/getAllLanguage");
        try {
            languagesList = new ObjectMapper().readValue(new RESTfulClientUtil().restFullService(loginService.getServerUrl(), loginService.getServiceName()), new TypeReference<List<Languages>>() {
            });
        } catch (IOException e) {
            e.printStackTrace();
        }
        langItems = new String[languagesList.size()];
        int i = 0;
        for (Languages languages : languagesList) {
            if (languages.isDefaulted())
                defaultedLang = languages.getName();
            langItems[i++] = languages.getName();
        }

        panel.language.setModel(new DefaultComboBoxModel(langItems));
       // panel.language.setSelectedItem(defaultedLang);
    }

    public boolean isLogin() {
        return blogin;
    }

    public void setLogin(boolean login) {
        this.blogin = login;
    }

    private void closeDialog(){
        setVisible(false);
    }

    class LoginFormPanel extends LoginDesign {

        @Override
        void buttonLoginActionPerformed() {
            setLogin(false);

            loginService.setServiceName("/authenticate");

            user = new User();
            user.setUsername(userName.getText());
            user.setPassword(password.getText());


            AccessController.doPrivileged(new PrivilegedAction() {
                public Object run() {
                    try {
                        result = new ObjectMapper().readValue(new RESTfulClientUtil().restFullService(loginService.getServerUrl(), loginService.getServiceName(), new ObjectMapper().writeValueAsString(user)), User.class);
                    } catch (IOException e) {
                        e.printStackTrace();
                    }

                    return null;
                }
            });

            if (result == null || result.getUsername().equalsIgnoreCase("null")) {
                JOptionPane.showMessageDialog(new JFrame(), "کاربر? با ا?ن مشخصات ?افت نشد");
                return;
            }

            try {
                String ipAddress = InetAddress.getLocalHost().getHostAddress();
                boolean allowed = true;
                for (PC pc : result.getPcs()) {
                    if (pc.getIp().equals(ipAddress)) {
                        allowed = true;
                        break;
                    }
                }

                if (!allowed) {
                    JOptionPane.showMessageDialog(new JFrame(), "استفاده از ا?ن کامپ?وتر برا? شما مجاز ن?ست" +
                            "");
                    return;
                }
            } catch (UnknownHostException e) {
                e.printStackTrace();
                return;
            }
            ThreadPoolManager.me = result;
            ThreadPoolManager.currentLanguage = languagesList.get(language.getSelectedIndex());
            loginService.setServiceName("/loadLanguage");
            try {
                ThreadPoolManager.langHash = new ObjectMapper().readValue(new RESTfulClientUtil().restFullServiceString(loginService.getServerUrl(), loginService.getServiceName(), ThreadPoolManager.currentLanguage.getName()), new TypeReference<Hashtable<String, LanguageManagement>>() {
                });

            } catch (IOException e) {
                e.printStackTrace();
                return;
            }

            loginService.setServiceName("/getAllOperation");
            try {
                List<Operation> operationList = new ObjectMapper().readValue(new RESTfulClientUtil().restFullService(loginService.getServerUrl(), loginService.getServiceName()), new TypeReference<List<Operation>>() {
                });
                ThreadPoolManager.loadPermissions(operationList);
            } catch (IOException e) {
                e.printStackTrace();
                return;
            }

            //ComponentOrientation direction;
            if (ThreadPoolManager.currentLanguage.isRtl()) {
                direction = ComponentOrientation.RIGHT_TO_LEFT;
            } else {
                direction = ComponentOrientation.LEFT_TO_RIGHT;
            }




           setLogin(true);
            closeDialog();

        }

        @Override
        void buttonCancelActionPerformed() {
            System.exit(0);
        }
    }



}
