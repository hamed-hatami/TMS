package ir.university.toosi.tms.util;

public class PersianUtil {
    public static String toPersianNumber(String strText) {
        StringBuilder strPersian = new StringBuilder(128);

        for (int i = 0; i < strText.length(); i++) {
            char ch = strText.charAt(i);
            if (ch >= '0' && ch <= '9') {
                ch = (char)((ch - '0') + 0x06F0);
            }
            strPersian.append(ch);
        }
        return strPersian.toString();
    }
}
