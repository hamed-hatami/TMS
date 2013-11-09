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
        Object[] options = {"تائید"}; //todo
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
        return showYesNOQuestionDialog(parentComponent
                ,ThreadPoolManager.getLangValue("deleteMessage")
                ,"بله، حذف شود"
                ,"خیر، حذف نشود"
                , "تایید حذف");
    }

    public static boolean showYesNOQuestionDialog(Component parentComponent,String mainMessage,String yesMessage,String noMessage ,String titleMessage){

        Object[] options = {yesMessage,noMessage}; //and every desire text unlimited
        int confirm = JOptionPane.showOptionDialog(parentComponent,
                mainMessage,
                titleMessage,
                JOptionPane.YES_NO_OPTION,
                JOptionPane.QUESTION_MESSAGE,
                null,
                options,
                options[1]);
        return confirm == JOptionPane.YES_OPTION;
    }


     public static boolean showExitQuestionDialog(Component parentComponent){
        //todo read from bundle
         return showYesNOQuestionDialog(parentComponent
                 , "آیا برای خروج مطمئن هستید ؟"
                 ,"بله، خارج می شوم"
                 ,"خیر، ادامه کار"
                 , "تایید خروج");
    }


}
