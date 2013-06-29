package ir.university.toosi.tms.controller;

import ir.university.toosi.tms.util.LangUtils;

import java.text.MessageFormat;
import java.util.Locale;
import java.util.MissingResourceException;
import java.util.ResourceBundle;

public class LanguageAction {

    private static final String BUNDLE_NAME = "ir.university.toosi.tms.resources.Messages";
    public static Locale locale = new Locale("fa");

    private static ResourceBundle getBundle() {
        return ResourceBundle.getBundle(BUNDLE_NAME, getLocale());
    }

    public static String getBundleMessage(String bundleKey, String... arguments) {
        if (bundleKey == null)
            return "?";
        try {
            return MessageFormat.format(getBundle().getString(bundleKey), arguments);
        } catch (MissingResourceException mre) {
            return bundleKey;
        }
    }

    public static Locale getLocale() {
        return LangUtils.refine(locale);
    }

    public static void changeLocale(String language) {
        String currentLanguage = locale.getLanguage();

        if (currentLanguage == null) {
            locale = LangUtils.LOCALE_FARSI;
        }

        if (currentLanguage.equalsIgnoreCase("fa")) {
            locale = new Locale(language);
        } else {
            locale = LangUtils.LOCALE_FARSI;
        }
    }
}