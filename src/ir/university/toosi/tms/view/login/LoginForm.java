package ir.university.toosi.tms.view.login;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import ir.university.toosi.tms.model.entity.*;
import ir.university.toosi.tms.util.*;

import javax.swing.*;
import java.awt.*;
import java.io.IOException;
import java.net.InetAddress;
import java.net.NetworkInterface;
import java.net.SocketException;
import java.net.UnknownHostException;
import java.security.AccessController;
import java.security.PrivilegedAction;
import java.util.Enumeration;
import java.util.Hashtable;
import java.util.List;
import java.util.Properties;

/**
 * @author a_hadadi
 */
public class LoginForm extends JDialog {

    public ComponentOrientation direction;
    public String lookAndFeel;
    private LoginFormPanel panel = null;
    private boolean blogin = false;
    private WebServiceInfo loginService = new WebServiceInfo();
    private User user, result;
    private String[] langItems;
    private String defaultedLang;
    private java.util.List<Languages> languagesList;
    private int prop_favoritLAF = 0;
    private String prop_userName = "";

    public LoginForm() {
        super();

        setDefaultLookAndFeelDecorated(true);

        panel = new LoginFormPanel();
        panel.setLocation(0, 0);

        setSize((int) panel.getSize().getWidth(), panel.getHeight());
        panel.setVisible(true);
        setLayout(null);
        this.add(panel);
        Dimension dimension = Toolkit.getDefaultToolkit().getScreenSize();
        int x = (int) (dimension.getWidth() - getSize().getWidth()) / 2;
        int y = (int) (dimension.getHeight() - getSize().getHeight()) / 2;
        this.setLocation(x, y);
        setResizable(false);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        setUndecorated(true);
        fillSearchCombo();
        fillLookAndFeelCombo();
        init1();

        initAppSettings();

    }

    private void fillLookAndFeelCombo() {


        ComboSelectItem selectItems[] = new ComboSelectItem[9];
        selectItems[0] = new ComboSelectItem("black and orange", "com.jtattoo.plaf.graphite.GraphiteLookAndFeel");//black and orange
        selectItems[1] = new ComboSelectItem("black and blue", "com.jtattoo.plaf.acryl.AcrylLookAndFeel"); //black and blue
        selectItems[2] = new ComboSelectItem("black and silver", "com.jtattoo.plaf.noire.NoireLookAndFeel");//black and silver
        selectItems[3] = new ComboSelectItem("black", "com.jtattoo.plaf.hifi.HiFiLookAndFeel");//full black
        selectItems[4] = new ComboSelectItem("aero", "com.jtattoo.plaf.aero.AeroLookAndFeel");
        selectItems[5] = new ComboSelectItem("Windows", "com.sun.java.swing.plaf.windows.WindowsLookAndFeel");
        selectItems[6] = new ComboSelectItem("mcwin", "com.jtattoo.plaf.mcwin.McWinLookAndFeel");
        selectItems[7] = new ComboSelectItem("texture", "com.jtattoo.plaf.texture.TextureLookAndFeel");
        selectItems[8] = new ComboSelectItem("aluminium", "com.jtattoo.plaf.aluminium.AluminiumLookAndFeel");

        //selectItems[13]= new ComboSelectItem("bernstein","com.jtattoo.plaf.bernstein.BernsteinLookAndFeel");//yellow
        //selectItems[12]= new ComboSelectItem("luna","com.jtattoo.plaf.luna.LunaLookAndFeel");
        //selectItems[11]= new ComboSelectItem("Nimbus","javax.swing.plaf.nimbus.NimbusLookAndFeel");
        //selectItems[10]= new ComboSelectItem("Motif","com.sun.java.swing.plaf.motif.MotifLookAndFeel");
        //selectItems[6]= new ComboSelectItem("mint","com.jtattoo.plaf.mint.MintLookAndFeel");//round like aluminium
        //selectItems[14]= new ComboSelectItem("fast","com.jtattoo.plaf.fast.FastLookAndFeel");
        //selectItems[15]= new ComboSelectItem("Smart","com.jtattoo.plaf.smart.SmartLookAndFeel");//del
        //selectItems[16]= new ComboSelectItem("metal","java.swing.plaf.metal");
        //selectItems[17]= new ComboSelectItem("GTK","com.sun.java.swing.plaf.gtk.GTKLookAndFeel");
        panel.comboBoxLookAndFeel.setModel(new DefaultComboBoxModel(selectItems));
        // panel.language.setSelectedItem(defaultedLang);
    }

    private void initAppSettings() {

        try {
            prop_favoritLAF = Integer.parseInt(Configuration.getProperty("prop_favoritLAF"));
            prop_userName = Configuration.getProperty("prop_userName");

            panel.comboBoxLookAndFeel.setSelectedIndex(prop_favoritLAF);
            panel.comboBoxLookAndFeelItemStateChanged();
            panel.userName.setText(prop_userName);
            panel.userName.selectAll();
            panel.userName.requestFocus();
        } catch (NumberFormatException e) {
            e.printStackTrace();
        }

    }

    private void saveSettings() {

        prop_favoritLAF = panel.comboBoxLookAndFeel.getSelectedIndex();
        prop_userName = panel.userName.getText();

        Configuration.saveSettings("prop_favoritLAF", String.valueOf(prop_favoritLAF));
        Configuration.saveSettings("prop_userName", prop_userName);

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
            Image image = ComponentUtil.getImageIcon("big-logo.png").getImage();
            ImageCanvas imageCanvas = new ImageCanvas(image);
            imageCanvas.setBounds(0, 0, 426, 272);
            imageCanvas.setVisible(true);
            panel.add(imageCanvas);
        } catch (Exception e) {
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

    private void closeDialog() {
        setVisible(false);
    }

    class LoginFormPanel extends LoginDesign {

        Color colorBK1 = new Color(7, 96, 153);
        Color colorFG1 = new Color(205, 225, 245);
        Color colorBK2 = new Color(238, 238, 238);
        Color colorFG2 = new Color(51, 51, 51);

        @Override
        void buttonLoginActionPerformed() {
            setLogin(false);

            loginService.setServiceName("/authenticate");

            user = new User();
            user.setUsername(userName.getText());
            user.setPassword(password.getText());//todo Encryption ?


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
                //todo read from bundle
                DialogUtil.showErrorDialog(this
                        , "کاربری با این مشخصات یافت نشد."
                        , "احراز هویت");
                return;
            }

            try {
                String ipAddress = "";
                if (System.getProperty("os.name").equalsIgnoreCase("Linux")) {
                    NetworkInterface ni = NetworkInterface.getByName(Configuration.getProperty("linux.network.interface"));
                    Enumeration<InetAddress> inetAddresses = ni.getInetAddresses();
                    while (inetAddresses.hasMoreElements()) {
                        InetAddress ia = inetAddresses.nextElement();
                        if (!ia.isLinkLocalAddress()) {
                            ipAddress = ia.getHostAddress();
                        }
                    }
                } else {
                    ipAddress = InetAddress.getLocalHost().getHostAddress();
                }
                boolean allowed = false;
                for (PC pc : result.getPcs()) {
                    if (pc.getIp().equals(ipAddress)) {
                        allowed = true;
                        break;
                    }
                }

                if (!allowed) {
                    DialogUtil.showErrorDialog(this
                            , "استفاده از این کامپیوتر برای شما مجاز نیست."
                            , "احراز هویت"
                    );
                    return;
                }

            } catch (UnknownHostException e) {
                e.printStackTrace();
                return;
            } catch (SocketException e) {
                e.printStackTrace();
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

            comboBoxLookAndFeelItemStateChanged();

            setLogin(true);
            saveSettings();
            closeDialog();

        }

        @Override
        void comboBoxLookAndFeelItemStateChanged() {
            lookAndFeel = ((ComboSelectItem) comboBoxLookAndFeel.getSelectedItem()).getValue().toString();
            try {
                UIManager.setLookAndFeel(lookAndFeel);
                revalidate();
                repaint();
            } catch (Exception e) {
                System.out.println("could not apply '" + comboBoxLookAndFeel.getSelectedItem() + "' lookAndFeel");
            }
        }

        @Override
        void userNameFocusGained() {
            userName.setBackground(colorBK2);
            userName.setForeground(colorFG2);
        }

        @Override
        void userNameFocusLost() {
            userName.setBackground(colorBK1);
            userName.setForeground(colorFG1);
        }

        @Override
        void passwordFocusGained() {
            password.setBackground(colorBK2);
            password.setForeground(colorFG2);
        }

        @Override
        void passwordFocusLost() {
            password.setBackground(colorBK1);
            password.setForeground(colorFG1);
        }

        @Override
        void passwordActionPerformed() {
            buttonLoginActionPerformed();
        }

        @Override
        void userNameActionPerformed() {
            password.selectAll();
            password.requestFocus();
        }

        @Override
        void buttonCancelActionPerformed() {
            System.exit(0);
        }
    }


}
