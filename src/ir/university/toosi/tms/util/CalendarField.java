package ir.university.toosi.tms.util;


import com.ghasemkiani.util.SimplePersianCalendar;
import com.ghasemkiani.util.icu.PersianCalendar;
import com.ibm.icu.util.Calendar;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.util.Date;
import java.util.Locale;

public class CalendarField extends JPanel {

    private static final String pubVer = "01.001.0001";

    public static final String DATE_CHANGED_EVENT_NAME = "dateChanged";
    private static final Font NORMAL_FONT = new Font("Tahoma", Font.PLAIN, 10);
    private static final Font BOLD_FONT = new Font("Tahoma", Font.BOLD, 10);

    private static final long serialVersionUID = -468196403406490878L;
    private JTextField textField;
    private JButton button;
    private JPopupMenu popupMenu;
    private CalendarPanel calendarPanel;

    public CalendarField() {
        this(true);
    }

    public CalendarField(boolean showButton) {
        textField = new JTextField();
        textField.setColumns(10);
        textField.setFont(NORMAL_FONT);
        textField.setEditable(false);

        button = new JButton();
        button.setIcon(new ImageIcon("./images/calendar.png"));
        button.setPreferredSize(new Dimension(25, 0));
        button.setFont(NORMAL_FONT);

        setLayout(new BorderLayout());
        add(button, BorderLayout.WEST);
        add(textField, BorderLayout.CENTER);

        button.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                popupMenu.show(textField, textField.getWidth() - popupMenu.getWidth(), textField.getHeight());
            }
        });

        popupMenu = new JPopupMenu();
        calendarPanel = new CalendarPanel();
        popupMenu.add(calendarPanel);
        popupMenu.addPropertyChangeListener(new PropertyChangeListener() {
            public void propertyChange(PropertyChangeEvent evt) {
                if (evt.getPropertyName().equals("visible") && ((Boolean) evt.getNewValue())) {
                    calendarPanel.curMonth = calendarPanel.selectedMonth;
                    calendarPanel.curYear = calendarPanel.selectedYear;
                    calendarPanel.draw();
                }
            }
        });
        popupMenu.setVisible(true);
        popupMenu.setVisible(false);

        setDate(getDate());
        if (!showButton) {
            calendarPanel.btnPrevMonth.setEnabled(false);
            calendarPanel.btnNextMonth.setEnabled(false);
            calendarPanel.btnNextYear.setEnabled(false);
            calendarPanel.btnPrevYear.setEnabled(false);
        }
    }

    @Override
    public Dimension getPreferredSize() {
        return new Dimension(100, 30);
    }


    public void setDate(String date) {
        PersianCalendar pc = CalendarUtil.getPersianCalendar(CalendarUtil.toGregorian(date));
        calendarPanel.curYear = calendarPanel.selectedYear = pc.get(Calendar.YEAR);
        calendarPanel.curMonth = calendarPanel.selectedMonth = pc.get(Calendar.MONTH);
        calendarPanel.selectedDay = pc.get(Calendar.DAY_OF_MONTH);
        String persianDate = getDate();
        textField.setText(persianDate);
        firePropertyChange(DATE_CHANGED_EVENT_NAME, null, persianDate);
    }

    public String getDate() {
        return String.format("%04d/%02d/%02d", calendarPanel.selectedYear, calendarPanel.selectedMonth + 1, calendarPanel.selectedDay);
    }

    public void setEditable(boolean editable) {
        button.setEnabled(editable);
    }

    @Override
    public void setEnabled(boolean enabled) {
        textField.setEnabled(enabled);
        button.setEnabled(enabled);
    }


    private class CalendarPanel extends JPanel {

        private static final long serialVersionUID = -5072017015312186286L;
        private int[] monthDays = new int[]{31, 31, 31, 31, 31, 31, 30, 30, 30, 30, 30, 29};
        private String[] monthNames = new String[]{"فروردین", "اردیبهشت", "خرداد", "تیر", "مرداد", "شهریور", "مهر", "آبان", "آذر", "دی", "بهمن", "اسفند"};
        private JLabel[] buttons;
        private JPanel[] panels;

        private JLabel lblMonthYear;
        public JButton btnPrevMonth, btnNextMonth, btnPrevYear, btnNextYear;

        int curMonth, curYear;
        int selectedDay, selectedMonth, selectedYear;
        private static final int WIDTH = 220;
        private static final int HEIGHT = 180;

        public CalendarPanel() {
            UIManager.getDefaults().put("Label.font", NORMAL_FONT);
            UIManager.getDefaults().put("Button.font", NORMAL_FONT);

            lblMonthYear = new JLabel();
            lblMonthYear.setHorizontalAlignment(SwingConstants.CENTER);
            lblMonthYear.setFont(NORMAL_FONT);
            btnPrevMonth = new JButton(">");
            btnPrevMonth.setFont(NORMAL_FONT);
            btnPrevMonth.setMargin(new Insets(0, 0, 0, 0));
            btnPrevMonth.setPreferredSize(new Dimension(25, 20));
            btnNextMonth = new JButton("<");
            btnNextMonth.setFont(NORMAL_FONT);
            btnNextMonth.setMargin(new Insets(0, 0, 0, 0));
            btnNextMonth.setPreferredSize(new Dimension(25, 20));
            btnPrevYear = new JButton(">>");
            btnPrevYear.setFont(NORMAL_FONT);
            btnPrevYear.setMargin(new Insets(0, 0, 0, 0));
            btnPrevYear.setPreferredSize(new Dimension(25, 20));
            btnNextYear = new JButton("<<");
            btnNextYear.setFont(NORMAL_FONT);
            btnNextYear.setMargin(new Insets(0, 0, 0, 0));
            btnNextYear.setPreferredSize(new Dimension(25, 20));

            setSize(WIDTH, HEIGHT);
            setPreferredSize(new Dimension(WIDTH, HEIGHT));
            setMinimumSize(new Dimension(WIDTH, HEIGHT));

            PersianCalendar pc = CalendarUtil.getPersianCalendar(new Date());

            curYear = selectedYear = pc.get(Calendar.YEAR);
            curMonth = selectedMonth = pc.get(Calendar.MONTH);
            selectedDay = pc.get(Calendar.DAY_OF_MONTH);

            setLayout(new BorderLayout());

            JPanel panel = new JPanel();
            panel.setComponentOrientation(ComponentOrientation.RIGHT_TO_LEFT);

            panel.setLayout(new GridLayout(7, 1));
            panels = new JPanel[8];
            for (int i = 0; i < 7; i++) {
                panels[i] = new JPanel();
                panels[i].setComponentOrientation(ComponentOrientation.RIGHT_TO_LEFT);

                panel.add(panels[i]);
                panels[i].setLayout(new GridLayout(1, 7));
                if (i == 0) {
                    JLabel label = new JLabel("ش", SwingConstants.CENTER);
                    label.setFont(NORMAL_FONT);
                    panels[i].add(label);
                    label = new JLabel("ی", SwingConstants.CENTER);
                    label.setFont(NORMAL_FONT);
                    panels[i].add(label);
                    label = new JLabel("د", SwingConstants.CENTER);
                    label.setFont(NORMAL_FONT);
                    panels[i].add(label);
                    label = new JLabel("س", SwingConstants.CENTER);
                    label.setFont(NORMAL_FONT);
                    panels[i].add(label);
                    label = new JLabel("چ", SwingConstants.CENTER);
                    label.setFont(NORMAL_FONT);
                    panels[i].add(label);
                    label = new JLabel("پ", SwingConstants.CENTER);
                    label.setFont(NORMAL_FONT);
                    panels[i].add(label);
                    label = new JLabel("ج", SwingConstants.CENTER);
                    label.setFont(NORMAL_FONT);
                    panels[i].add(label);
                }
            }

            buttons = new JLabel[42];
            for (int i = 0; i < 42; i++) {
                buttons[i] = new JLabel(PersianUtil.toPersianNumber(String.valueOf(i)));
                buttons[i].setFont(NORMAL_FONT);
                buttons[i].addMouseListener(new MouseAdapter() {
                    public void mouseClicked(MouseEvent e) {
                        int day = new Integer(((JLabel) e.getSource()).getText());
                        selectedDay = day;
                        selectedMonth = curMonth;
                        selectedYear = curYear;
                        setDate(String.format("%04d/%02d/%02d", curYear, curMonth + 1, day));
                        popupMenu.setVisible(false);
                    }
                });

                buttons[i].setBorder(BorderFactory.createEtchedBorder());
                buttons[i].setHorizontalAlignment(SwingConstants.CENTER);

                panels[(i / 7) + 1].add(buttons[i]);
            }

            JPanel pnlMonthYear = new JPanel(new BorderLayout());
            pnlMonthYear.add(lblMonthYear, BorderLayout.CENTER);
            JPanel pnlPrev = new JPanel();
            pnlPrev.add(btnPrevMonth);
            pnlPrev.add(btnPrevYear);
            pnlMonthYear.add(pnlPrev, BorderLayout.EAST);

            JPanel pnlNext = new JPanel();
            pnlNext.add(btnNextYear);
            pnlNext.add(btnNextMonth);
            pnlMonthYear.add(pnlNext, BorderLayout.WEST);

            btnNextMonth.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    if (curMonth == 11) {
                        curYear++;
                    }
                    curMonth = (curMonth + 1) % 12;
                    draw();
                }
            });

            btnPrevMonth.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    if (curMonth == 0) {
                        curYear--;
                    }

                    curMonth = (curMonth + 11) % 12;
                    draw();
                }
            });

            btnPrevYear.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    curYear--;
                    draw();
                }
            });

            btnNextYear.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    curYear++;
                    draw();
                }
            });

            add(pnlMonthYear, BorderLayout.NORTH);
            add(panel, BorderLayout.CENTER);
        }

        private void draw() {
            lblMonthYear.setText(String.format("%s   %d", monthNames[curMonth], curYear));

            SimplePersianCalendar spc = new SimplePersianCalendar();
            spc.setDateFields(curYear, curMonth, 1);
            int dayOfWeek = spc.get(SimplePersianCalendar.DAY_OF_WEEK) % 7;

            for (int i = 0; i < dayOfWeek; i++) {
                buttons[i].setText(null);
                buttons[i].setVisible(false);
                buttons[i].setEnabled(false);
                buttons[i].setFont(NORMAL_FONT);
            }

            int mday = monthDays[curMonth];
            if (curMonth == 11 && CalendarUtil.isLeapYear(curYear)) {
                mday += 1;
            }

            for (int i = dayOfWeek; i < mday + dayOfWeek; i++) {
                buttons[i].setText(PersianUtil.toPersianNumber((i - dayOfWeek + 1) + ""));
                buttons[i].setEnabled(true);
                buttons[i].setVisible(true);
                buttons[i].setFont(NORMAL_FONT);
            }

            for (int i = mday + dayOfWeek; i < buttons.length; i++) {
                buttons[i].setText(null);
                buttons[i].setEnabled(false);
                buttons[i].setVisible(false);
                buttons[i].setFont(NORMAL_FONT);
            }

            if (curYear == selectedYear && curMonth == selectedMonth) {
                buttons[dayOfWeek + selectedDay - 1].setFont(BOLD_FONT);
            }
        }
    }
}


class CalendarUtil {
    public static PersianCalendar getPersianCalendar(Date date) {
        PersianCalendar pc = new PersianCalendar(new Locale("fa"));
        pc.setTime(date);
        return pc;
    }

    public static String getPersianDate(Date date) {
        PersianCalendar pc = getPersianCalendar(date);
        return String.format("%04d/%02d/%02d", pc.get(PersianCalendar.YEAR), pc.get(PersianCalendar.MONTH) + 1, pc.get(PersianCalendar.DAY_OF_MONTH));
    }

    public static Date toGregorian(String pdate) {
        String[] splitDate = pdate.split("/");
        SimplePersianCalendar spc = new SimplePersianCalendar();
        spc.setDateFields(Integer.parseInt(splitDate[0]), (Integer.parseInt(splitDate[1]) - 1), Integer.parseInt(splitDate[2]));
        return new Date(spc.getTimeInMillis());
    }

    public static boolean isLeapYear(int year) {
        SimplePersianCalendar spc = new SimplePersianCalendar();
        spc.setDateFields(year, 11, 29);
        return getPersianCalendar(new Date(spc.getTime().getTime() + 1000 * 60 * 60 * 24)).get(SimplePersianCalendar.YEAR) != year;
    }
}
