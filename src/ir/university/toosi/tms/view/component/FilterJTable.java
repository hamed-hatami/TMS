package ir.university.toosi.tms.view.component;


import javax.swing.*;
import javax.swing.border.MatteBorder;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.table.*;
import java.awt.*;
import java.awt.event.*;
import java.lang.Object;
import java.util.*;
import java.util.List;
/**
 * @author a_hadadi
 */

public class FilterJTable extends JTable {

    private TableColumn column;
    private JTextField text;
    private JPopupMenu filterPopup;
    private TableRowSorter sorter;
    private int currentColumnIndex = -1;
    private final String labelPrefix ="@#";


   // private String headerTextStartWith = "";

    public FilterJTable(Object[][] data, Object[] headers) {
       // super(data, headers);

        for(int i = 0;i< headers.length;i++){
            headers[i] = labelPrefix + headers[i].toString() ;
        }


        DefaultTableModel model = new DefaultTableModel(data, headers);
        setModel(model);
        init();

       /* for (int column = 0; column < getColumnModel().getColumnCount(); column++) {
            TableColumn tableColumn = getColumnModel().getColumn(column);
            TableCellRenderer renderer = tableColumn.getHeaderRenderer();
            if (renderer == null) {
                renderer = getTableHeader().getDefaultRenderer();
            }
            Component component = renderer.getTableCellRendererComponent(this,
                    //tableColumn.getHeaderValue(), false, false, -1, column);
                    headers[column].toString(), false, false, -1, column);

            if(component instanceof MyPanel){
               // ((MyPanel) component).setLabelText(getModel().getColumnName(column));
                ((MyPanel) component).setLabelText(headers[column].toString());

                MyPanel component1 = new MyPanel();
                component1.setLabelText(headers[column].toString());
                component=component1;
                this.getCellEditor(-1,column).
            }
        }*/


        // this.headerTextStartWith = headerTextStartWith;
    }



    public void init(){

        MyPanel tableHeaderRenderer = new MyPanel();
        getTableHeader().setDefaultRenderer(tableHeaderRenderer);
        getTableHeader().addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent event) {
                if (event.getButton() == MouseEvent.BUTTON3) {
                    editColumnAt(event.getPoint());
                }
            }
        });

        String headerToolTipText ;
        if(getAutoCreateRowSorter()){
            headerToolTipText = "Click to sort; Shift-Click to sort in reverse order;Right-Click to Filter";
        }else{
            headerToolTipText = "Right-Click to Filter";
        }
        getTableHeader().setToolTipText(headerToolTipText);

        text = new JTextField();
        text.setBorder(null);
        text.setBackground(new Color(242, 235, 255));
        text.setForeground(new Color(10, 10, 150));
        text.setSelectionColor(new Color(150, 147, 255));
        text.setSelectedTextColor(new Color(0, 0, 0));


        text.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                finalizeFilterModification();
            }
        });

        text.addFocusListener(new FocusListener() {
            @Override
            public void focusGained(FocusEvent e) {
            }

            @Override
            public void focusLost(FocusEvent e) {
                finalizeFilterModification();
            }
        });

        text.getDocument().addDocumentListener(new DocumentListener() {

            @Override
            public void insertUpdate(DocumentEvent e) {
                doMultiFilter(text.getText());
            }

           @Override
            public void removeUpdate(DocumentEvent e) {
               doMultiFilter(text.getText());
            }

            @Override
            public void changedUpdate(DocumentEvent e) {
                doMultiFilter(text.getText());
            }
        });

        text.addKeyListener(new KeyListener() {
            @Override
            public void keyTyped(KeyEvent e) {
            }

            @Override
            public void keyPressed(KeyEvent e) {
            }

            @Override
            public void keyReleased(KeyEvent e) {
                doMultiFilter(text.getText());
            }
        });


        filterPopup = new JPopupMenu();
        filterPopup.setBorder(new MatteBorder(0, 0, 0, 0, Color.DARK_GRAY));
        filterPopup.add(text);

        sorter = new TableRowSorter<TableModel>(getModel());
        sorter.setSortsOnUpdates(true);
        setRowSorter(sorter);

       /* getSelectionModel().addListSelectionListener(new ListSelectionListener(){
            public void valueChanged(ListSelectionEvent event) {
                System.out.println(getSelectedRow()+1);
            }
        });*/


    }



    private void finalizeFilterModification() {
        column.setHeaderValue(text.getText());
        filterPopup.setVisible(false);
      //  getTableHeader().repaint();
    }

    private void editColumnAt(Point p) {

        currentColumnIndex = getTableHeader().columnAtPoint(p);
        if (currentColumnIndex != -1) {
            column = getTableHeader().getColumnModel().getColumn(currentColumnIndex);
            Rectangle columnRectangle = getTableHeader().getHeaderRect(currentColumnIndex);
             String headerValue = column.getHeaderValue().toString();
            text.setText(headerValue);
            /*if(!headerValue.startsWith(labelPrefix)){
                text.setText(headerValue);
            }*/
            filterPopup.setPreferredSize(new Dimension(columnRectangle.width - 8, columnRectangle.height - (getTableHeader().getHeight() / 2) - 4));
            filterPopup.show(getTableHeader(), columnRectangle.x+4, columnRectangle.height - (getTableHeader().getHeight() / 2));
            text.requestFocusInWindow();
        }


    }

    private void doMultiFilter(String text) {
        final List<RowFilter<TableModel, Object>> filters = new ArrayList<RowFilter<TableModel, Object>>();
        for( int i = 0; i < getTableHeader().getColumnModel().getColumnCount() ;i++ ){
            String currentColumnFilterText =  getTableHeader().getColumnModel().getColumn(i).getHeaderValue().toString();
            if(currentColumnIndex == i){
                currentColumnFilterText =text;//add current typed text to filter
            }
            final RowFilter<TableModel, Object> rowFilter;
            try{
                //If current expression doesn't parse, don't update.
                rowFilter = RowFilter.regexFilter(currentColumnFilterText, i);
            }catch (java.util.regex.PatternSyntaxException e){
                return;
            }
            filters.add(rowFilter);
        }
        final RowFilter<TableModel, Object>  compoundRowFilter = RowFilter.andFilter(filters);
        sorter.setRowFilter(compoundRowFilter);
    }

    private void doSingleFilter(String text) {
       // single row filter with OK test
        RowFilter<TableModel, Object> rowFilter = null;
        //If current expression doesn't parse, don't update.
        try {
            rowFilter = RowFilter.regexFilter(text, currentColumnIndex);
        } catch (java.util.regex.PatternSyntaxException e) {
            return;
        }
        sorter.setRowFilter(rowFilter);
    }

    private class MyPanel extends JPanel implements TableCellRenderer {
        private javax.swing.JLabel label;
        private javax.swing.JTextField textField;

        public MyPanel() {
            setLayout(new java.awt.BorderLayout());
            label = new javax.swing.JLabel();
            textField = new javax.swing.JTextField("");
            setBorder(javax.swing.BorderFactory.createEtchedBorder());
            label.setHorizontalAlignment(SwingConstants.CENTER);
            add(textField, java.awt.BorderLayout.PAGE_END);
            add(label, java.awt.BorderLayout.CENTER);
        }

        public void setLabelText(String text) {
            label.setText(text);
        }

        public void setTextFieldText(String text) {
            textField.setText(text);
        }


        public javax.swing.JTextField getTextFieldComponent() {
            return textField;
        }


        public String toString(){
           return  textField.getText();
        }

        //TableCellRenderer defRnd = new DefaultTableCellRenderer();



        @Override
        public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int col) {
           String textValue = value.toString();

            if(textValue.startsWith(labelPrefix)){
                setLabelText(textValue.replaceFirst(labelPrefix,""));
            }else{
                setTextFieldText(textValue);
            }

           // if(label.getText().isEmpty()){
           /* if(currentColumnIndex<0){
                setLabelText(textValue);
            }
            if(currentColumnIndex==column)  {
                setTextFieldText(textValue);
            }*/
           /* setLabelText(textValue);
            setTextFieldText(textValue);*/
            return this;

        }

    }
}
