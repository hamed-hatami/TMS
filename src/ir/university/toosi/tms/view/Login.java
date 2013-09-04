package ir.university.toosi.tms.view;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import ir.university.toosi.tms.model.entity.*;
import ir.university.toosi.tms.util.RESTfulClientUtil;
import ir.university.toosi.tms.util.ThreadPoolManager;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.security.AccessController;
import java.security.PrivilegedAction;
import java.util.Hashtable;
import java.util.List;

/**
 * @author a_ahmady
 */
public class Login extends TMSInternalFrame {

    private MainForm mainForm;
    private JButton login;
    private JButton cancel;
    private JLabel userNameLabel;
    private JLabel passwordLabel;
    private JLabel langLabel;
    private TMSPanel TMSPanel1;
    private JTextField userName;
    private JPasswordField password;
    private JComboBox language;
    private WebServiceInfo loginService = new WebServiceInfo();
    private User user, result;
    private String[] langItems;
    private String defaultedLang;
    private List<Languages> languagesList;
    ;

    public Login(MainForm mainForm) {

        fillSearchCombo();
        this.mainForm = mainForm;
        TMSPanel1 = new TMSPanel();
        login = new JButton();
        cancel = new JButton();
        userName = new JTextField();
        password = new JPasswordField();
        userNameLabel = new JLabel();
        passwordLabel = new JLabel();
        langLabel = new JLabel();
        language = new JComboBox(langItems);
        language.setSelectedItem(defaultedLang);
        initComponents();
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
    }

    private void initComponents() {


        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        loginService.setServiceName("/loadLanguage");
        try {
            ThreadPoolManager.langHash = new ObjectMapper().readValue(new RESTfulClientUtil().restFullServiceString(loginService.getServerUrl(), loginService.getServiceName(), defaultedLang), new TypeReference<Hashtable<String, LanguageManagement>>() {
            });

        } catch (IOException e) {
            e.printStackTrace();
        }
        TMSPanel1.setBorder(javax.swing.BorderFactory.createEtchedBorder(javax.swing.border.EtchedBorder.RAISED));

        login.setText(ThreadPoolManager.getLangValue("TMS_LOGIN"));

        cancel.setText(ThreadPoolManager.getLangValue("TMS_CANCEL"));
        cancel.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });
        login.addActionListener(new java.awt.event.ActionListener() {
            @Override
            public void actionPerformed(java.awt.event.ActionEvent evt) {

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

                if (result == null) {
                    JOptionPane.showMessageDialog(new JFrame(), "کاربری با این مشخصات یافت نشد");
                } else if (result.getUsername().equalsIgnoreCase("null")) {
                    JOptionPane.showMessageDialog(new JFrame(), "کاربری با این مشخصات یافت نشد");
                } else {
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
                            JOptionPane.showMessageDialog(new JFrame(), "استفاده از این کامپیوتر برای شما مجاز نیست" +
                                    "");
                            return;
                        }
                    } catch (UnknownHostException e) {
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
                    }

                    loginService.setServiceName("/getAllOperation");
                    try {
                        List<Operation> operationList = new ObjectMapper().readValue(new RESTfulClientUtil().restFullService(loginService.getServerUrl(), loginService.getServiceName()), new TypeReference<List<Operation>>() {
                        });
                        ThreadPoolManager.loadPermissions(operationList);
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                    JOptionPane.showMessageDialog(new JFrame(), "خوش آمدید ");

                    ComponentOrientation direction;
                    if (ThreadPoolManager.currentLanguage.isRtl()) {
                        direction = ComponentOrientation.RIGHT_TO_LEFT;
                    } else {
                        direction = ComponentOrientation.LEFT_TO_RIGHT;
                    }

                    mainForm.setJMenuBar(mainForm.createMenuBar(direction));
                    mainForm.getLoginForm().dispose();
                }
            }
        });


        userName.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField1ActionPerformed(evt);
            }
        });

        userNameLabel.setText(ThreadPoolManager.getLangValue("TMS_USERNAME"));

        passwordLabel.setText(ThreadPoolManager.getLangValue("TMS_PASSWORD"));

        langLabel.setText(ThreadPoolManager.getLangValue("TMS_LANGUAGE"));

        javax.swing.GroupLayout TMSPanel1Layout = new javax.swing.GroupLayout(TMSPanel1);
        TMSPanel1.setLayout(TMSPanel1Layout);
        TMSPanel1Layout.setHorizontalGroup(
                TMSPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(TMSPanel1Layout.createSequentialGroup()
                                .addGroup(TMSPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(TMSPanel1Layout.createSequentialGroup()
                                                .addGap(141, 141, 141)
                                                .addComponent(login)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                .addComponent(cancel))
                                        .addGroup(TMSPanel1Layout.createSequentialGroup()
                                                .addContainerGap(109, Short.MAX_VALUE)
                                                .addGroup(TMSPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                                        .addComponent(userNameLabel)
                                                        .addComponent(langLabel)
                                                        .addComponent(passwordLabel))
                                                .addGap(29, 29, 29)
                                                .addGroup(TMSPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                                        .addComponent(password)
                                                        .addComponent(language)
                                                        .addComponent(userName, javax.swing.GroupLayout.DEFAULT_SIZE, 113, Short.MAX_VALUE))))
                                .addContainerGap(94, Short.MAX_VALUE))
        );
        TMSPanel1Layout.setVerticalGroup(
                TMSPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, TMSPanel1Layout.createSequentialGroup()
                                .addGap(49, 49, 49)
                                .addGroup(TMSPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(userNameLabel)
                                        .addComponent(userName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(18, 18, 18)
                                .addGroup(TMSPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(passwordLabel)
                                        .addComponent(password, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(18, 18, 18)
                                .addGroup(TMSPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(langLabel)
                                        .addComponent(language, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 22, Short.MAX_VALUE)
                                .addGroup(TMSPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(login)
                                        .addComponent(cancel))
                                .addGap(25, 25, 25))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addGap(37, 37, 37)
                                .addComponent(TMSPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addContainerGap(28, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addGap(65, 65, 65)
                                .addComponent(TMSPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addContainerGap(65, Short.MAX_VALUE))
        );

        setSize(500, 400);
        //pack();
    }

    private void jTextField1ActionPerformed(java.awt.event.ActionEvent evt) {
// TODO add your handling code here:
    }

}
