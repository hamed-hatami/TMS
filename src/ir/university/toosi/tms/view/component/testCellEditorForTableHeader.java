package ir.university.toosi.tms.view.component;

import javax.swing.*;
import javax.swing.table.TableCellRenderer;
import javax.swing.table.TableColumn;
import java.awt.*;

public class testCellEditorForTableHeader {

    private FilterJTable jTable;

    public static void main(String[] args) {

        testCellEditorForTableHeader testCellEditorForTableHeader = new testCellEditorForTableHeader();
        testCellEditorForTableHeader.creatUI();


    }

    private void creatUI() {

        int rows = 32, cols = 4;
        Object[] headers = new String[cols];
        Object[][] data = new Object[rows][cols];
        for (int row = 0; row < rows; row++)
            for (int col = 0; col < cols; col++) {
                if (row == 0)
                    headers[col] = "header " + (col + 1);
                data[row][col] = "item " + (row * cols + col + 1);
            }

        //jTable = new FilterJTable(data, headers,"#@");

        jTable = new FilterJTable(data, headers);
       // jTable.initHeader = false;
        //jTable = new FilterJTable();
       // jTable.setH
        jTable.setSize(400, 300);
        jTable.setLocation(20, 20);
       // jTable.setAutoCreateRowSorter(true);




        JFrame f = new JFrame();
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.add(new JScrollPane(jTable));
        f.setSize(400, 400);
        f.setLocation(200, 200);
        f.setVisible(true);



    }



}
