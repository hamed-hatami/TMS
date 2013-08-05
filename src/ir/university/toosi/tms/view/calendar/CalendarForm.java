package ir.university.toosi.tms.view.calendar;

import com.fasterxml.jackson.databind.ObjectMapper;
import ir.university.toosi.tms.model.entity.WebServiceInfo;
import ir.university.toosi.tms.model.entity.calendar.Calendar;
import ir.university.toosi.tms.util.RESTfulClientUtil;
import ir.university.toosi.tms.util.ThreadPoolManager;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.beans.PropertyVetoException;
import java.io.IOException;

public class CalendarForm extends JInternalFrame {

    /**
     * Creates new form ContactEditor
     */
    public CalendarForm() {

        mainPanel = new JPanel();
        nameLabel = new JLabel();
        codeLabel = new JLabel();
        name = new JTextField();
        code = new JTextField();
        desc = new JTextField();
        descLabel = new JLabel();
        defaultCal = new JCheckBox();
        addWeekDay = new JButton();
        addExceptionDate = new JButton();
        add = new JButton();
        close = new JButton();
        initComponents();
    }

    public CalendarForm(JDesktopPane jDesktopPane, boolean editMode, Calendar calendar, CalendarManagement calendarManagement) {

        mainPanel = new JPanel();
        nameLabel = new JLabel();
        codeLabel = new JLabel();
        name = new JTextField();
        code = new JTextField();
        desc = new JTextField();
        descLabel = new JLabel();
        defaultCal = new JCheckBox();
        addWeekDay = new JButton();
        addExceptionDate = new JButton();
        add = new JButton();
        close = new JButton();
        this.jDesktopPane = jDesktopPane;
        this.calendar = calendar;
        this.editMode = editMode;
        this.added = editMode;
        this.calendarManagement = calendarManagement;
        initComponents();
    }


    private void initComponents() {

        this.addInternalFrameListener(ThreadPoolManager.mainForm);
        setClosable(true);
        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Calendar Info");

        mainPanel.setBorder(javax.swing.BorderFactory.createTitledBorder("CalendarInfo"));

        nameLabel.setText("NAME");
        if (editMode)
            name.setText(calendar.getName());
        else
            name.setText("");

        codeLabel.setText("CODE");
        if (editMode)
            code.setText(calendar.getCode());
        else
            code.setText("");

        descLabel.setText("DESCRIPTION");
        if (editMode)
            desc.setText(calendar.getDescription());
        else
            desc.setText("");

        defaultCal.setText("DEFAULT");
        if (editMode)
            defaultCal.setSelected(calendar.isDefaultCalendar());
        else
            defaultCal.setSelected(false);

        org.jdesktop.layout.GroupLayout jPanel1Layout = new org.jdesktop.layout.GroupLayout(mainPanel);
        mainPanel.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
                jPanel1Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                        .add(jPanel1Layout.createSequentialGroup()
                                .add(50, 50, 50)
                                .add(jPanel1Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.TRAILING)
                                        .add(jPanel1Layout.createSequentialGroup()
                                                .add(nameLabel)
                                                .add(16, 16, 16))
                                        .add(jPanel1Layout.createSequentialGroup()
                                                .add(descLabel)
                                                .addPreferredGap(org.jdesktop.layout.LayoutStyle.UNRELATED)))
                                .add(jPanel1Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING, false)
                                        .add(desc)
                                        .add(name, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, 107, Short.MAX_VALUE))
                                .add(82, 82, 82)
                                .add(codeLabel)
                                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                                .add(jPanel1Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                                        .add(code, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 112, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                                        .add(defaultCal))
                                .addContainerGap(29, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
                jPanel1Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                        .add(jPanel1Layout.createSequentialGroup()
                                .add(jPanel1Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.BASELINE)
                                        .add(nameLabel)
                                        .add(name, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                                        .add(codeLabel)
                                        .add(code, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
                                .add(26, 26, 26)
                                .add(jPanel1Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.BASELINE)
                                        .add(desc, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                                        .add(descLabel)
                                        .add(defaultCal))
                                .addContainerGap(22, Short.MAX_VALUE))
        );

        addWeekDay.setText("ADDWEEKDAY");

        addWeekDay.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                try {
                    addWeekDay(evt);
                } catch (PropertyVetoException e) {
                    e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
                }
            }
        });

        addExceptionDate.setText("ADDEXCEPTIONDATE");
        addExceptionDate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                try {
                    addExceptionDate(evt);
                } catch (PropertyVetoException e) {
                    e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
                }
            }
        });

        addExceptionDate.setEnabled(added);
        addWeekDay.setEnabled(added);

        if (editMode)
            add.setText("EDIT");
        else
            add.setText("ADD");

        add.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                if (editMode)
                    editCalendar(evt);
                else
                    addCalendar(evt);
            }
        });

        close.setText("CLOSE");
        close.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                    close(evt);
            }
        });

        org.jdesktop.layout.GroupLayout layout = new org.jdesktop.layout.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                        .add(layout.createSequentialGroup()
                                .addContainerGap()
                                .add(mainPanel, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                                .addContainerGap())
                        .add(org.jdesktop.layout.GroupLayout.TRAILING, layout.createSequentialGroup()
                                .addContainerGap(106, Short.MAX_VALUE)
                                .add(add)
                                .add(7, 7, 7)
                                .add(close)
                                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                                .add(addExceptionDate)
                                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                                .add(addWeekDay)
                                .add(74, 74, 74))
        );

        layout.linkSize(new java.awt.Component[]{addWeekDay, addExceptionDate}, org.jdesktop.layout.GroupLayout.HORIZONTAL);

        layout.setVerticalGroup(
                layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                        .add(layout.createSequentialGroup()
                                .addContainerGap()
                                .add(mainPanel, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                                .add(18, 18, 18)
                                .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.BASELINE)
                                        .add(add)
                                        .add(addExceptionDate)
                                        .add(close)
                                        .add(addWeekDay))
                                .addContainerGap(27, Short.MAX_VALUE))
        );

        getAccessibleContext().setAccessibleName("PersonnalInfo");

        pack();
    }// </editor-fold>

    private void addExceptionDate(ActionEvent evt) throws PropertyVetoException {

        ExceptionDayManagement exceptionDayManagement = new ExceptionDayManagement(jDesktopPane, calendar);
        exceptionDayManagement.setVisible(true);
        jDesktopPane.add(exceptionDayManagement);
        exceptionDayManagement.setSelected(true);
    }

    private void addWeekDay(ActionEvent evt) throws PropertyVetoException {

        WeekDayManagement weekDayManagement = new WeekDayManagement(jDesktopPane, calendar);
        weekDayManagement.setVisible(true);
        jDesktopPane.add(weekDayManagement);
        weekDayManagement.setSelected(true);
    }

    private void addCalendar(ActionEvent evt) {

        Calendar newCalendar = new Calendar();
        newCalendar.setName(name.getText());
        newCalendar.setCode(code.getText());
        newCalendar.setDescription(desc.getText());
        newCalendar.setDefaultCalendar(defaultCal.isSelected());

        calendarService.setServiceName("/createCalendar");

        try {
            calendar = new ObjectMapper().readValue(new RESTfulClientUtil().restFullService(calendarService.getServerUrl(), calendarService.getServiceName(), new ObjectMapper().writeValueAsString(newCalendar)), Calendar.class);
        } catch (IOException e) {
            e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
        }

        added = true;
        addExceptionDate.setEnabled(true);
        addWeekDay.setEnabled(true);
    }

    private void editCalendar(ActionEvent evt) {

        calendar.setName(name.getText());
        calendar.setCode(code.getText());
        calendar.setDescription(desc.getText());
        calendar.setDefaultCalendar(defaultCal.isSelected());

        calendarService.setServiceName("/editCalendar");

        try {
            new ObjectMapper().readValue(new RESTfulClientUtil().restFullService(calendarService.getServerUrl(), calendarService.getServiceName(), new ObjectMapper().writeValueAsString(calendar)), Boolean.class);
        } catch (IOException e) {
            e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
        }
    }

    private void close(ActionEvent evt) {
        this.dispose();
        try {
            calendarManagement.refresh();
        } catch (IOException e) {
            e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
        }
    }

    /**
     * @param args the command line arguments
     */

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private JButton add;
    private JButton addWeekDay;
    private JButton addExceptionDate;
    private JButton close;
    private JCheckBox defaultCal;
    private JLabel nameLabel;
    private JLabel codeLabel;
    private JLabel descLabel;
    private JPanel mainPanel;
    private JTextField name;
    private JTextField code;
    private JTextField desc;

    private boolean added;
    private boolean editMode;
    private Calendar calendar;
    private CalendarManagement calendarManagement;

    private JDesktopPane jDesktopPane;
    private WebServiceInfo calendarService = new WebServiceInfo();

    // End of variables declaration//GEN-END:variables
}