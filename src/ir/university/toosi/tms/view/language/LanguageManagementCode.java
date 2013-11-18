package ir.university.toosi.tms.view.language;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import ir.university.toosi.tms.model.entity.LanguageKeyValue;
import ir.university.toosi.tms.model.entity.LanguageManagement;
import ir.university.toosi.tms.model.entity.WebServiceInfo;
import ir.university.toosi.tms.util.ComponentUtil;
import ir.university.toosi.tms.util.RESTfulClientUtil;
import ir.university.toosi.tms.util.ThreadPoolManager;
import ir.university.toosi.tms.view.TMSInternalFrame;
import org.jdesktop.beansbinding.BindingGroup;
import org.jdesktop.swingbinding.JTableBinding;

import javax.swing.*;
import java.awt.*;
import java.io.IOException;
import java.util.*;
import java.util.List;

/**
 * @author a_hadadi
 */
public class LanguageManagementCode  extends TMSInternalFrame {

    private java.util.List<LanguageKeyValue> langList = new ArrayList<>();
    private WebServiceInfo langService = new WebServiceInfo();
    private LanguageManagementPanel panel = null;

    public LanguageManagementCode(){
        super();

        panel = new LanguageManagementPanel();
        panel.setLocation(0, 0);
        panel.setSize(panel.getPreferredSize());
        panel.setVisible(true);
        setLayout(null);
        getContentPane().setBackground(Color.getColor("Control"));
        this.add(panel);

        this.setTitle(ThreadPoolManager.getLangValue("TMS_LANGMANAGEMENT"));
        panel.panel1.setBorder(BorderFactory.createTitledBorder(ThreadPoolManager.getLangValue("TMS_LANGMANAGEMENT")));
        panel.tableLanguageData.setAutoCreateRowSorter(true);
        panel.buttonSave.setText(ThreadPoolManager.getLangValue("TMS_SAVE"));
        panel.buttonCancel.setText(ThreadPoolManager.getLangValue("TMS_CANCEL"));

        try {
            refresh();
        } catch (IOException e) {
            e.printStackTrace();
        }

        Font tahoma = new Font("Tahoma", Font.PLAIN, 12);
        ComponentUtil.setFont(panel, tahoma, ThreadPoolManager.direction);
        // this.changeComonentOrientation(ThreadPoolManager.direction);
        ComponentUtil.SetJTableAlignment(panel.tableLanguageData,ThreadPoolManager.direction);

    }

    public void refresh() throws IOException {
        langList = ThreadPoolManager.getLangList();
        showData();
    }

    private void showData() {
        JTableBinding jTableBinding = org.jdesktop.swingbinding.SwingBindings.createJTableBinding(org.jdesktop.beansbinding.AutoBinding.UpdateStrategy.READ_WRITE, langList, panel.tableLanguageData, "");
        JTableBinding.ColumnBinding columnBinding = jTableBinding.addColumnBinding(org.jdesktop.beansbinding.ELProperty.create("${key}"));
        columnBinding.setColumnName(ThreadPoolManager.getLangValue("TMS_KEY"));
        columnBinding.setEditable(false);
        columnBinding.setColumnClass(String.class);
        columnBinding = jTableBinding.addColumnBinding(org.jdesktop.beansbinding.ELProperty.create("${value}"));
        columnBinding.setColumnName(ThreadPoolManager.getLangValue("TMS_VALUE"));
        columnBinding.setEditable(true);
        columnBinding.setColumnClass(String.class);
        BindingGroup bindingGroup = new BindingGroup();
        bindingGroup.addBinding(jTableBinding);
        jTableBinding.bind();
    }


    class LanguageManagementPanel extends LanguageManagementDesign{

        @Override
        protected void buttonSaveActionPerformed() {
            {
                List<LanguageManagement> languageManagements = new ArrayList<>();
                for (LanguageKeyValue languageKeyValue : langList) {
                    if (!languageKeyValue.isEdited())
                        continue;
                    LanguageManagement changedLanguageManagement = ThreadPoolManager.langHash.get(languageKeyValue.getKey());
                    changedLanguageManagement.setTitle(languageKeyValue.getValue());
                    languageManagements.add(changedLanguageManagement);
                }

                langService.setServiceName("/editLanguageManagementList");
                try {
                    new ObjectMapper().readValue(new RESTfulClientUtil().restFullService(langService.getServerUrl(), langService.getServiceName(), new ObjectMapper().writeValueAsString(languageManagements)), Boolean.class);
                } catch (IOException e) {
                    e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
                }

                langService.setServiceName("/loadLanguage");
                try {
                    ThreadPoolManager.langHash = new ObjectMapper().readValue(new RESTfulClientUtil().restFullServiceString(langService.getServerUrl(), langService.getServiceName(), ThreadPoolManager.currentLanguage.getName()), new TypeReference<Hashtable<String, LanguageManagement>>() {
                    });

                } catch (IOException e) {
                    e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
                }

                try {
                    refresh();
                } catch (IOException e) {
                    e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
                }
            }
        }

        @Override
        protected void buttonCancelActionPerformed() {
            dispose();
        }

        @Override
        protected void cellEditingStopped() {
            int index = tableLanguageData.convertRowIndexToModel(tableLanguageData.getSelectedRow());
            langList.get(index).setEdited(true);
        }
    }


}
