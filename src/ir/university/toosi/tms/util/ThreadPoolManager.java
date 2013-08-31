package ir.university.toosi.tms.util;

import ir.university.toosi.tms.model.entity.*;
import ir.university.toosi.tms.view.MainForm;

import java.util.ArrayList;
import java.util.Hashtable;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ForkJoinPool;

/**
 * @author : Hamed Hatami ,  Farzad Sedaghatbin, Atefeh Ahmadi, Mostafa Rastgar
 * @version : 0.8
 */

public class ThreadPoolManager {

    public static final ExecutorService executors = Executors.newCachedThreadPool();
    public static MainForm mainForm;
    public static User me;
    public static Languages currentLanguage;
    public static Hashtable<String, LanguageManagement> langHash = new Hashtable<>();
    public static Hashtable<String, Boolean> permissionHash = new Hashtable<>();
    public static final ForkJoinPool forkJoinPool = new ForkJoinPool(Runtime.getRuntime().availableProcessors());

    public static String getLangValue(String key) {
        if (langHash.containsKey(key))
            return langHash.get(key).getTitle();
        return key + "_NOT_DEF";
    }

    public static List<LanguageKeyValue> getLangList() {

        List<LanguageKeyValue> langList = new ArrayList<>();
        for (String s : langHash.keySet()) {
            LanguageKeyValue languageKeyValue = new LanguageKeyValue();
            languageKeyValue.setKey(s);
            languageKeyValue.setValue(langHash.get(s).getTitle());
            langList.add(languageKeyValue);
        }
        return langList;
    }

    public static boolean hasPermission(String checkledOperation) {

        if (permissionHash.containsKey(checkledOperation))
            return permissionHash.get(checkledOperation);

        return false;
    }

    public static void loadPermissions(List<Operation> operations) {

        for (Operation operation : operations) {
            for (WorkGroup workGroup : me.getWorkGroups()) {
                for (Role role : workGroup.getRoles()) {
                    for (Operation innerOperation : role.getOperations()) {
                        if (innerOperation.getName().equalsIgnoreCase(operation.getName())) {
                            permissionHash.put(operation.getName(), Boolean.TRUE);
                        }
                    }
                }
            }
            if (!permissionHash.containsKey(operation.getName()))
                permissionHash.put(operation.getName(), Boolean.FALSE);
        }

    }
}
