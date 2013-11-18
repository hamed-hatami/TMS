package ir.university.toosi.tms.view.eventlog;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import ir.university.toosi.tms.model.entity.EventLog;
import ir.university.toosi.tms.model.entity.EventLogSearchItems;
import ir.university.toosi.tms.model.entity.EventLogType;
import ir.university.toosi.tms.model.entity.WebServiceInfo;
import ir.university.toosi.tms.util.RESTfulClientUtil;
import ir.university.toosi.tms.util.ThreadPoolManager;
import ir.university.toosi.tms.view.TMSInternalFrame;
import ir.university.toosi.tms.view.TMSPanel;
import org.jdesktop.beansbinding.BindingGroup;
import org.jdesktop.swingbinding.JTableBinding;

import javax.swing.*;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class EventLogList extends TMSInternalFrame {

    /**
     * Creates new form ContactEditor
     */
    public EventLogList() {
        fillSearchCombo();
        mainPanel = new TMSPanel();
        tableScroll = new JScrollPane();
        mainTable = new JTable();
        searchPanel = new TMSPanel();
        searchCombo = new JComboBox(searchItems);
        searchText = new JTextField();
        filter = new JLabel();
        by = new JLabel();
        try {
            initComponents();
        } catch (IOException e) {
            e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
        }
    }

   /* public EventLogList(JDesktopPane jDesktopPane) {
        fillSearchCombo();
        jdpDesktop = jDesktopPane;
        mainPanel = new TMSPanel();
        tableScroll = new JScrollPane();
        mainTable = new JTable();
        searchPanel = new TMSPanel();
        searchCombo = new JComboBox(searchItems);
        searchText = new JTextField();
        filter = new JLabel();
        by = new JLabel();
        try {
            initComponents();
        } catch (IOException e) {
            e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
        }
    }*/

    private void fillSearchCombo() {
        searchItems = new String[EventLogSearchItems.values().length];
        int i = 0;
        for (EventLogSearchItems logSearchItems : EventLogSearchItems.values()) {
            searchItems[i++] = logSearchItems.getDescription();
        }
    }

    /**
     * This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    public void initComponents() throws IOException {

       // this.addInternalFrameListener(ThreadPoolManager.mainForm);
        //setClosable(true);
       // setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setTitle(ThreadPoolManager.getLangValue("TMS_EVENTLOGLIST"));

        mainPanel.setBorder(BorderFactory.createTitledBorder(ThreadPoolManager.getLangValue("TMS_EVENTLOGLIST")));

        mainTable.setAutoCreateRowSorter(true);
        refresh();


        mainTable.setRowSelectionAllowed(true);
        tableScroll.setViewportView(mainTable);

        org.jdesktop.layout.GroupLayout TMSPanel1Layout = new org.jdesktop.layout.GroupLayout(mainPanel);
        mainPanel.setLayout(TMSPanel1Layout);
        TMSPanel1Layout.setHorizontalGroup(
                TMSPanel1Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                        .add(TMSPanel1Layout.createSequentialGroup()
                                .add(36, 36, 36)
                                .add(TMSPanel1Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                                        .add(TMSPanel1Layout.createSequentialGroup()
//                                                .add(add)
                                                .addPreferredGap(org.jdesktop.layout.LayoutStyle.UNRELATED)
//                                                .add(delete)
                                                .add(18, 18, 18)
//                                                .add(edit)
                                        )
                                        .add(tableScroll, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
                                .addContainerGap(45, Short.MAX_VALUE))
        );
        TMSPanel1Layout.setVerticalGroup(
                TMSPanel1Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                        .add(TMSPanel1Layout.createSequentialGroup()
                                .addContainerGap()
                                .add(TMSPanel1Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.BASELINE)
//                                        .add(add)
//                                        .add(delete)
//                                        .add(edit)
                                )
                                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .add(tableScroll, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 136, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                                .add(133, 133, 133))
        );

        searchPanel.setBorder(BorderFactory.createTitledBorder(ThreadPoolManager.getLangValue("TMS_SEARCH")));

        searchText.setToolTipText("");
        searchText.getDocument().addDocumentListener(new DocumentListener() {
            @Override
            public void insertUpdate(DocumentEvent e) {
                try {
                    search(e);
                } catch (IOException e1) {
                    e1.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
                }
            }

            @Override
            public void removeUpdate(DocumentEvent e) {
                try {
                    search(e);
                } catch (IOException e1) {
                    e1.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
                }
            }

            @Override
            public void changedUpdate(DocumentEvent e) {
                try {
                    search(e);
                } catch (IOException e1) {
                    e1.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
                }
            }
        });

        filter.setText(ThreadPoolManager.getLangValue("TMS_FILTER"));

        by.setText(ThreadPoolManager.getLangValue("TMS_BY"));

        org.jdesktop.layout.GroupLayout TMSPanel2Layout = new org.jdesktop.layout.GroupLayout(searchPanel);
        searchPanel.setLayout(TMSPanel2Layout);
        TMSPanel2Layout.setHorizontalGroup(
                TMSPanel2Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                        .add(TMSPanel2Layout.createSequentialGroup()
                                .addContainerGap()
                                .add(filter)
                                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                                .add(searchText, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 122, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                                .add(18, 18, 18)
                                .add(by)
                                .add(18, 18, 18)
                                .add(searchCombo, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                                .addContainerGap(194, Short.MAX_VALUE))
        );
        TMSPanel2Layout.setVerticalGroup(
                TMSPanel2Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                        .add(TMSPanel2Layout.createSequentialGroup()
                                .addContainerGap()
                                .add(TMSPanel2Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.BASELINE)
                                        .add(filter)
                                        .add(searchText, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                                        .add(searchCombo, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                                        .add(by))
                                .addContainerGap(org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        org.jdesktop.layout.GroupLayout layout = new org.jdesktop.layout.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                        .add(layout.createSequentialGroup()
                                .addContainerGap()
                                .add(searchPanel, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                                .addContainerGap(org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .add(org.jdesktop.layout.GroupLayout.TRAILING, layout.createSequentialGroup()
                                .addContainerGap(org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .add(mainPanel, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                                .addContainerGap())
        );
        layout.setVerticalGroup(
                layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                        .add(org.jdesktop.layout.GroupLayout.TRAILING, layout.createSequentialGroup()
                                .addContainerGap()
                                .add(searchPanel, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(org.jdesktop.layout.LayoutStyle.UNRELATED)
                                .add(mainPanel, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 221, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                                .addContainerGap(org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        mainPanel.getAccessibleContext().setAccessibleName("ADDUser");

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void getAll() throws IOException {
        eventLogService.setServiceName("/getAllEventLog");
        logs = new ObjectMapper().readValue(new RESTfulClientUtil().restFullService(eventLogService.getServerUrl(), eventLogService.getServiceName()), new TypeReference<List<EventLog>>() {
        });
    }

    public void refresh() throws IOException {
        getAll();
        showData();
    }

    private void showData() {

        JTableBinding jTableBinding = org.jdesktop.swingbinding.SwingBindings.createJTableBinding(org.jdesktop.beansbinding.AutoBinding.UpdateStrategy.READ_WRITE, logs, mainTable, "");
        JTableBinding.ColumnBinding columnBinding = jTableBinding.addColumnBinding(org.jdesktop.beansbinding.ELProperty.create("${operation}"));
        columnBinding.setColumnName(ThreadPoolManager.getLangValue("TMS_OPERATION"));
        columnBinding.setColumnClass(EventLogType.class);
        columnBinding.setEditable(false);
        columnBinding = jTableBinding.addColumnBinding(org.jdesktop.beansbinding.ELProperty.create("${objectId}"));
        columnBinding.setColumnName(ThreadPoolManager.getLangValue("TMS_OBJECT_ID"));
        columnBinding.setColumnClass(String.class);
        columnBinding.setEditable(false);
        columnBinding = jTableBinding.addColumnBinding(org.jdesktop.beansbinding.ELProperty.create("${tableName}"));
        columnBinding.setColumnName(ThreadPoolManager.getLangValue("TMS_TABLE_NAME"));
        columnBinding.setColumnClass(String.class);
        columnBinding.setEditable(false);
        columnBinding = jTableBinding.addColumnBinding(org.jdesktop.beansbinding.ELProperty.create("${username}"));
        columnBinding.setColumnName(ThreadPoolManager.getLangValue("TMS_USERNAME"));
        columnBinding.setColumnClass(String.class);
        columnBinding.setEditable(false);
        columnBinding = jTableBinding.addColumnBinding(org.jdesktop.beansbinding.ELProperty.create("${date}"));
        columnBinding.setColumnName(ThreadPoolManager.getLangValue("TMS_DATE"));
        columnBinding.setColumnClass(String.class);
        columnBinding.setEditable(false);
        columnBinding = jTableBinding.addColumnBinding(org.jdesktop.beansbinding.ELProperty.create("${time}"));
        columnBinding.setColumnName(ThreadPoolManager.getLangValue("TMS_TIME"));
        columnBinding.setColumnClass(String.class);
        columnBinding.setEditable(false);
        BindingGroup bindingGroup = new BindingGroup();
        bindingGroup.addBinding(jTableBinding);
        jTableBinding.bind();
    }


    private void search(DocumentEvent documentEvent) throws IOException {

        EventLog searchEventLog = new EventLog();
        if (EventLogSearchItems.values()[searchCombo.getSelectedIndex()].equals(EventLogSearchItems.TABLE)) {
            eventLogService.setServiceName("/getEventLogByTable");
            searchEventLog.setTableName(searchText.getText());
        }

        searchEventLog.setEffectorUser(ThreadPoolManager.me.getUsername());
        logs = new ObjectMapper().readValue(new RESTfulClientUtil().restFullService(eventLogService.getServerUrl(), eventLogService.getServiceName(), new ObjectMapper().writeValueAsString(searchEventLog)), new TypeReference<List<EventLog>>() {
        });

        showData();
    }

    /**
     * @param args the command line arguments
     */

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private JComboBox searchCombo;
    private JLabel by;
    private JLabel filter;
    private TMSPanel mainPanel;
    private TMSPanel searchPanel;
    private JScrollPane tableScroll;
    private JTable mainTable;
    private JDesktopPane jdpDesktop;
    private JTextField searchText;
    private WebServiceInfo eventLogService = new WebServiceInfo();
    private List<EventLog> logs = new ArrayList<>();
    private String[] searchItems;

    public JTable getMainTable() {
        return mainTable;
    }
    // End of variables declaration//GEN-END:variables
}
