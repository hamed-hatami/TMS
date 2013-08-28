package ir.university.toosi.tms.util;

import ir.university.toosi.tms.model.entity.LanguageKeyValue;
import ir.university.toosi.tms.model.entity.Languages;
import ir.university.toosi.tms.model.entity.User;
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
    public static Hashtable<String, String> langHash = new Hashtable<>();
    public static final ForkJoinPool forkJoinPool = new ForkJoinPool(Runtime.getRuntime().availableProcessors());

    public static String getLangValue(String key) {
        if (langHash.containsKey(key))
            return langHash.get(key);
        return key + "_NOT_DEF";
    }

    public static List<LanguageKeyValue> getLangList() {

        List<LanguageKeyValue> langList = new ArrayList<>();
        for (String s : langHash.keySet()) {
            LanguageKeyValue languageKeyValue = new LanguageKeyValue();
            languageKeyValue.setKey(s);
            languageKeyValue.setValue(langHash.get(s));
            langList.add(languageKeyValue);
        }
        return langList;
    }
}
