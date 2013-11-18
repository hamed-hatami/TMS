package ir.university.toosi.tms.view.person;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import ir.university.toosi.tms.model.entity.WebServiceInfo;
import ir.university.toosi.tms.model.entity.personnel.Person;
import ir.university.toosi.tms.model.entity.personnel.PersonSearchItems;
import ir.university.toosi.tms.util.ComponentUtil;
import ir.university.toosi.tms.util.DialogUtil;
import ir.university.toosi.tms.util.RESTfulClientUtil;
import ir.university.toosi.tms.util.ThreadPoolManager;
import ir.university.toosi.tms.view.TMSInternalFrame;

import javax.imageio.ImageIO;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Vector;

/**
 * @author a_hadadi
 */
public class PersonManagementCode extends TMSInternalFrame {

    private final int imageHeight = 127;//change to desire height
    private PersonManagementPanel panel = null;
    private WebServiceInfo personService = new WebServiceInfo();
    private List<Person> personList = new ArrayList<>();
    private String[] filterItems;

    public PersonManagementCode() {
        super();

        panel = new PersonManagementPanel();
        panel.setLocation(0, 0);
        panel.setSize(panel.getPreferredSize());
        panel.setVisible(true);
        setLayout(null);
        getContentPane().setBackground(Color.getColor("Control"));

        this.setTitle(ThreadPoolManager.getLangValue("TMS_PERSON_MANAGEMENT")); //
        panel.panelPersonList.setBorder(javax.swing.BorderFactory.createTitledBorder(ThreadPoolManager.getLangValue("TMS_PERSON_LIST"))); //
        panel.panelSearch.setBorder(javax.swing.BorderFactory.createTitledBorder(ThreadPoolManager.getLangValue("TMS_SEARCH")));
        panel.labelFilter.setText(ThreadPoolManager.getLangValue("TMS_FILTER"));
        panel.labelFilterBy.setText(ThreadPoolManager.getLangValue("TMS_BY"));
        panel.buttonDelete.setText(ThreadPoolManager.getLangValue("TMS_DELETE"));
        //panel.buttonDelete.setEnabled(ThreadPoolManager.hasPermission("DELET_PERSON")); //todo

        panel.buttonEdit.setText(ThreadPoolManager.getLangValue("TMS_EDIT"));
        panel.buttonEdit.setEnabled(ThreadPoolManager.hasPermission("EDIT_PERSON"));

        panel.buttonAdd.setText(ThreadPoolManager.getLangValue("TMS_ADD"));
        panel.buttonAdd.setEnabled(ThreadPoolManager.hasPermission("ADD_PERSON"));

        panel.buttonCancel.setText(ThreadPoolManager.getLangValue("TMS_CANCEL"));

        panel.buttonAllocate.setText(ThreadPoolManager.getLangValue("TMS_ASSIGN"));//todo
       // panel.buttonAllocate.setEnabled(ThreadPoolManager.hasPermission("TMS_ASSIGN"));//todo

        this.add(panel);

        fillSearchCombo();
        refresh();

    }

    private void fillSearchCombo() {
        filterItems = new String[PersonSearchItems.values().length];
        int i = 0;
        for (PersonSearchItems personSearchItem : PersonSearchItems.values()) {
            filterItems[i++] = personSearchItem.getDescription();
        }
        panel.comboBoxFilterBy.setModel(new javax.swing.DefaultComboBoxModel(filterItems));
    }

    private void refresh() {
        Font tahoma = new Font("Tahoma", Font.PLAIN, 12);
        ComponentUtil.setFont(panel, tahoma, ThreadPoolManager.direction);
        ComponentUtil.SetJTableAlignment(panel.tablePerson, ThreadPoolManager.direction);
        try {
            getAll();
            showData();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void getAll() throws IOException {

        personService.setServiceName("/getAllPerson");
        personList = new ObjectMapper().readValue(new RESTfulClientUtil().restFullService(personService.getServerUrl(), personService.getServiceName()), new TypeReference<List<Person>>() {
        });
    }

    private void showData() {
       /* org.jdesktop.swingbinding.JTableBinding jTableBinding = org.jdesktop.swingbinding.SwingBindings.createJTableBinding(org.jdesktop.beansbinding.AutoBinding.UpdateStrategy.READ_WRITE, personList, panel.tablePerson, "");
        JTableBinding.ColumnBinding columnBinding = jTableBinding.addColumnBinding(org.jdesktop.beansbinding.ELProperty.create("${name}"));
        columnBinding.setColumnName(ThreadPoolManager.getLangValue("TMS_NAME"));
        columnBinding.setColumnClass(String.class);
        columnBinding.setEditable(false);
        columnBinding = jTableBinding.addColumnBinding(org.jdesktop.beansbinding.ELProperty.create("${lastName}"));
        columnBinding.setColumnName(ThreadPoolManager.getLangValue("LAST_NAME"));
        columnBinding.setColumnClass(String.class);
        columnBinding.setEditable(false);
        columnBinding = jTableBinding.addColumnBinding(org.jdesktop.beansbinding.ELProperty.create("${personnelNo}"));
        columnBinding.setColumnName(ThreadPoolManager.getLangValue("TMS_PERSONNEL_NO"));
        columnBinding.setColumnClass(String.class);
        columnBinding.setEditable(false);
        columnBinding = jTableBinding.addColumnBinding(org.jdesktop.beansbinding.ELProperty.create("${nationalCode}"));
        columnBinding.setColumnName(ThreadPoolManager.getLangValue("TMS_NATIONAL_CODE"));
        columnBinding.setColumnClass(String.class);
        columnBinding.setEditable(false);
        columnBinding = jTableBinding.addColumnBinding(org.jdesktop.beansbinding.ELProperty.create("${pin}"));
        columnBinding.setColumnName(ThreadPoolManager.getLangValue("TMS_PIN"));
        columnBinding.setColumnClass(String.class);
        columnBinding.setEditable(false);
        BindingGroup bindingGroup = new BindingGroup();
        bindingGroup.addBinding(jTableBinding);
        jTableBinding.bind();*/


        panel.tablePerson.setModel(createModel());
        panel.tablePerson.setRowHeight(imageHeight);
        ComponentUtil.SetJTableAlignment(panel.tablePerson, ThreadPoolManager.direction);
        panel.tablePerson.setSelectionMode(ListSelectionModel.SINGLE_INTERVAL_SELECTION);
        panel.tablePerson.getTableHeader().setReorderingAllowed(false);
        panel.tablePerson.setColumnSelectionAllowed(false);

    }

    private DefaultTableModel createTestModel() {
        ImageIcon icon1 = null;// new ImageIcon( "c://test1.gif"); //its not worked with gif
        ImageIcon icon2 = null;// new ImageIcon( "c://test2.jpg"); //it work with jpg
        try {
            BufferedImage bufferedImage1 = ImageIO.read(new File("c://test1.png"));
            icon1 = new ImageIcon(bufferedImage1); //it work with all type images
            //todo scale imageHeight
            BufferedImage bufferedImage2 = ImageIO.read(new File("c://test2.png"));
            icon2 = new ImageIcon(bufferedImage2); //it work with all type images
        } catch (IOException e) {
            e.printStackTrace();
        }

        Vector columnNames = new Vector();
        columnNames.add("name");
        columnNames.add("picture");

        Vector rowData = new Vector();
        Vector row1 = new Vector();
        Vector row2 = new Vector();
        row1.add("me");
        row1.add(icon1);
        row2.add("boss");
        row2.add(icon2);
        rowData.add(row1);
        rowData.add(row2);

        DefaultTableModel tableModel = new DefaultTableModel(rowData, columnNames) {
            private final int columnNO = 1;

            @Override
            public Class getColumnClass(int column) {
                if (column == columnNO) return ImageIcon.class;
                return Object.class;
            }

            @Override
            public boolean isCellEditable(int row, int column) {
                return false;
            }

        };
        return tableModel;
    }

    private DefaultTableModel createModel() {

        Vector columnNames = new Vector();
        columnNames.add("تصویر");//todo bundle
        columnNames.add("نام و نام خانوادگی");//todo bundle

        Vector rowData = new Vector();
        ImageIcon personNotFoundImageIcon = ComponentUtil.getImageIcon("image_not_found.png");
        for (Person currentPerson : personList) {
            Vector rowCurrent = new Vector();
            ImageIcon currentPersonelImageIcon;

            if (currentPerson.getPicture() == null) {
                currentPersonelImageIcon = personNotFoundImageIcon;
            } else {
                currentPersonelImageIcon = new ImageIcon(currentPerson.getPicture());
            }

            rowCurrent.add(currentPersonelImageIcon);
            rowCurrent.add(currentPerson.getName() + " " + currentPerson.getLastName());
            rowData.add(rowCurrent);
        }


        DefaultTableModel tableModel = new DefaultTableModel(rowData, columnNames) {
            private final int columnNO = 0;

            @Override
            public Class getColumnClass(int column) {
                if (column == columnNO) return ImageIcon.class;
                return Object.class;
            }

            @Override
            public boolean isCellEditable(int row, int column) {
                return false;
            }

        };
        return tableModel;
    }

    private void applyFilter() {

        if (PersonSearchItems.values()[panel.comboBoxFilterBy.getSelectedIndex()].equals(PersonSearchItems.NAME)) {
            personService.setServiceName("/getPersonByName");
        } else if (PersonSearchItems.values()[panel.comboBoxFilterBy.getSelectedIndex()].equals(PersonSearchItems.LASTNAME)) {
            personService.setServiceName("/getPersonByLastName");
        } else if (PersonSearchItems.values()[panel.comboBoxFilterBy.getSelectedIndex()].equals(PersonSearchItems.NATIONALCODE)) {
            personService.setServiceName("/getPersonByNationalCode");
        } else if (PersonSearchItems.values()[panel.comboBoxFilterBy.getSelectedIndex()].equals(PersonSearchItems.PERSONNELNO)) {
            personService.setServiceName("/getPersonByPersonnelNo");
        }

        try {
            personList = new ObjectMapper().readValue(new RESTfulClientUtil().restFullServiceString(personService.getServerUrl(), personService.getServiceName(), panel.textFieldFilter.getText()), new TypeReference<List<Person>>() {
            });
            showData();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    private void deletePerson() {

        int[] indexes = new int[panel.tablePerson.getSelectedRows().length];
        int j = 0;
        for (int i : panel.tablePerson.getSelectedRows()) {
            indexes[j++] = panel.tablePerson.convertRowIndexToModel(i);
        }

        List<Person> deletedPersons = new ArrayList<>();
        for (int index : indexes) {
            deletedPersons.add(personList.get(index));
        }

        personService.setServiceName("/deletePersons");
        try {
            String result = new ObjectMapper().readValue(new RESTfulClientUtil().restFullService(personService.getServerUrl(), personService.getServiceName(), new ObjectMapper().writeValueAsString(deletedPersons)), String.class);
            if (!result.equalsIgnoreCase("true"))
               //ThreadPoolManager.getLangValue("UNSUCCESSFUL_DELETE")
                //todo read from bundle
                DialogUtil.showOKDialog(this
                        ,"در حذف شخص مورد نظر، خطا رخ داده است."
                        ,"خطای سیستمی"
                );
            else
                //todo read from bundle
                DialogUtil.showOKDialog(this
                        ,"شخص مورد نظر حذف شد."
                        ,"اطلاع رسانی"
                );
            refresh();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    class PersonManagementPanel extends PersonManagementDesign {

        @Override
        protected void buttonCancelActionPerformed() {
            dispose();
        }

        @Override
        protected void buttonEditActionPerformed() {

            if (panel.tablePerson.getSelectedRow() == -1) {
                //todo read from bundle
                DialogUtil.showErrorDialog(this
                        , "شخص مورد نظر را جهت ویرایش انتخاب نمائید."
                        , "خطای ورودی"
                );
                return;
            }

            Person person = personList.get(panel.tablePerson.convertRowIndexToModel(panel.tablePerson.getSelectedRow()));

            PersonCode personCode = new PersonCode(person);
            personCode.setVisible(true);
            ThreadPoolManager.mainForm.getDesktopPane().add(personCode);
            try {
                personCode.setSelected(true);
            } catch (Exception e) {
                e.printStackTrace();
            }
            dispose();

        }

        @Override
        protected void buttonAddActionPerformed() {

            PersonCode personCode = new PersonCode(null);
            personCode.setVisible(true);
            ThreadPoolManager.mainForm.getDesktopPane().add(personCode);
            try {
                personCode.setSelected(true);
            } catch (Exception e) {
                e.printStackTrace();
            }
            dispose();

        }

        @Override
        protected void buttonDeleteActionPerformed() {

            if (panel.tablePerson.getSelectedRow() == -1) {
                //todo read from bundle
                DialogUtil.showErrorDialog(this
                        , "شخص مورد نظر را جهت حذف انتخاب کنید"
                        , "خطای ورودی"
                );
                return;
            }

            if (!DialogUtil.showDeleteQuestionDialog(this)) {
            //if (!DialogUtil.showDeleteQuestionDialog(this,ThreadPoolManager.getLangValue("DELETE_PERSON") )) { //todo
                return;
            }

            deletePerson();

        }

        @Override
        protected void buttonAllocateActionPerformed() {
            //todo
        }

        @Override
        protected void filterEvent() {
            applyFilter();
        }

    }
}

