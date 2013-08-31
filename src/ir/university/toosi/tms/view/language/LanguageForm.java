package ir.university.toosi.tms.view.language;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import ir.university.toosi.tms.model.entity.Languages;
import ir.university.toosi.tms.model.entity.WebServiceInfo;
import ir.university.toosi.tms.util.RESTfulClientUtil;
import ir.university.toosi.tms.util.ThreadPoolManager;
import ir.university.toosi.tms.view.TMSInternalFrame;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.List;

/**
 * @author farzad
 */
public class LanguageForm extends TMSInternalFrame {

    private JDesktopPane jdpDesktop;

    /**
     * Creates new form Language
     *
     * @param jdpDesktop
     */
    public LanguageForm(JDesktopPane jdpDesktop) {

        this.jdpDesktop = jdpDesktop;
        name = new JTextField();
        rtlCheckBox = new JCheckBox();
        defaultCheckBox = new JCheckBox();
        addButton = new JButton();
        nameLabel = new JLabel();

        initComponents();
    }

    private void initComponents() {


        setClosable(true);
        this.addInternalFrameListener(ThreadPoolManager.mainForm);
        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle(ThreadPoolManager.getLangValue("TMS_LANGUAGE_FORM"));


        nameLabel.setText(ThreadPoolManager.getLangValue("TMS_NAME"));

        rtlCheckBox.setText(ThreadPoolManager.getLangValue("TMS_ISRTL"));
        defaultCheckBox.setText(ThreadPoolManager.getLangValue("TMS_DEFAULTED"));

        langServiceInfo.setServiceName("/getAllLanguage");
        try {
            List<Languages> langList = new ObjectMapper().readValue(new RESTfulClientUtil().restFullService(langServiceInfo.getServerUrl(), langServiceInfo.getServiceName()), new TypeReference<List<Languages>>() {
            });

            for (Languages languages : langList) {
                if (languages.isDefaulted())
                    hasDefaulted = true;
            }
        } catch (IOException e) {
            e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
        }

        defaultCheckBox.setEnabled(!hasDefaulted);


        addButton.setText(ThreadPoolManager.getLangValue("TMS_ADD"));
        addButton.setBorder(javax.swing.BorderFactory.createTitledBorder(""));
        addButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                addActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(layout.createSequentialGroup()
                                                .addGap(28, 28, 28)
                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                        .addComponent(rtlCheckBox)
                                                        .addComponent(defaultCheckBox)
                                                        .addGroup(layout.createSequentialGroup()
                                                                .addComponent(nameLabel)
                                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                                .addComponent(name, javax.swing.GroupLayout.PREFERRED_SIZE, 210, javax.swing.GroupLayout.PREFERRED_SIZE))))
                                        .addGroup(layout.createSequentialGroup()
                                                .addGap(125, 125, 125)
                                                .addComponent(addButton, javax.swing.GroupLayout.PREFERRED_SIZE, 96, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addContainerGap(34, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addGap(34, 34, 34)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(nameLabel)
                                        .addComponent(name, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(18, 18, 18)
                                .addComponent(rtlCheckBox)
                                .addGap(18, 18, 18)
                                .addComponent(defaultCheckBox)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(addButton)
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }

    private void addActionPerformed(ActionEvent evt) {

        Languages languages = new Languages();
        languages.setName(name.getText());
        languages.setRtl(rtlCheckBox.isSelected());
        languages.setDefaulted(defaultCheckBox.isSelected());
        langServiceInfo.setServiceName("/createLanguage");

        try {
            new ObjectMapper().readValue(new RESTfulClientUtil().restFullService(langServiceInfo.getServerUrl(), langServiceInfo.getServiceName(), new ObjectMapper().writeValueAsString(languages)), Languages.class);
        } catch (IOException e) {
            e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
        }

        this.dispose();
    }

    private JButton addButton;
    private JTextField name;
    private JCheckBox rtlCheckBox;
    private JCheckBox defaultCheckBox;
    private WebServiceInfo langServiceInfo = new WebServiceInfo();
    private JLabel nameLabel;
    private boolean hasDefaulted = false;
}
