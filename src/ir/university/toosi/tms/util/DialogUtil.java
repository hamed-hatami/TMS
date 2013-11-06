package ir.university.toosi.tms.util;

import javax.swing.*;
import java.awt.*;

/**
 * User: a_hadadi
 */
public class DialogUtil {


    public static void showOKDialog(Component parentComponent
            ,String mainMessage
            ,String titleMessage){
        Object[] options = {"باشد"}; //and every desire text unlimited
        JOptionPane.showOptionDialog(parentComponent,
                mainMessage,
                titleMessage,
                JOptionPane.OK_OPTION,
                JOptionPane.INFORMATION_MESSAGE,
                null,
                options,
                options[0]);
    }

    public static void showErrorDialog(Component parentComponent
            ,String mainMessage
            ,String titleMessage){
        Object[] options = {"باشد"}; //and every desire text unlimited
        JOptionPane.showOptionDialog(parentComponent,
                mainMessage,
                titleMessage,
                JOptionPane.OK_OPTION,
                JOptionPane.ERROR_MESSAGE,
                null,
                options,
                options[0]);
    }

    public static boolean showDeleteQuestionDialog(Component parentComponent){
        //todo read from bundle
        Object[] options = {"بله، حذف شود",
                "خیر، حذف نشود"}; //and every desire text unlimited
        int confirm = JOptionPane.showOptionDialog(parentComponent,
                ThreadPoolManager.getLangValue("deleteMessage"),
                "تایید حذف",
                JOptionPane.YES_NO_OPTION,
                JOptionPane.QUESTION_MESSAGE,
                null,
                options,
                options[1]);
        return confirm == JOptionPane.YES_OPTION;
    }

     public static boolean showExitQuestionDialog(Component parentComponent){
        //todo read from bundle
         String msg = "آیا برای خروج مطمئن هستید ؟" ;
         // msg =  ThreadPoolManager.getLangValue("closeConfirm");//todo load from bundle
         //Custom button text
         Object[] options = {"بله، خارج می شوم",
                 "خیر، ادامه کار"}; //and every desire text unlimited
         int confirm = JOptionPane.showOptionDialog(parentComponent,
                 msg,
                 "تایید خروج",
                 JOptionPane.YES_NO_OPTION,
                 JOptionPane.QUESTION_MESSAGE,
                 null,
                 options,
                 options[1]);
         return confirm == JOptionPane.YES_OPTION;
    }


}
