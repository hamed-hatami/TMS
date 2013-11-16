package ir.university.toosi.tms.util;


import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Hashtable;
import java.util.Locale;
import java.util.Properties;
import java.util.ResourceBundle;


/**
 * @author : Hamed Hatami ,  Farzad Sedaghatbin, Atefeh Ahmadi, Mostafa Rastgar
 * @version : 0.8
 */

public class Configuration {

    private static Properties configuration = null;
    private static Hashtable<String, String> SESSION = new Hashtable<String, String>();
    private static Locale locale = new Locale("fa");

    public static void load() throws IOException {
        if (configuration != null)
            configuration = readFile();
    }

    public static Properties getProperties() {
        if (configuration == null) {
            try {
                configuration = readFile();
            } catch (IOException ioe) {
                ioe.printStackTrace();
            }
        }
        return configuration;
    }

    public static String getProperty(String key) {
        if (configuration == null || key == null) {
            try {
                configuration = readFile();
            } catch (IOException ioe) {
                ioe.printStackTrace();
            }
        }
        return configuration.getProperty(key);
    }

    public static String getProperty(String key, String defaultValue) {
        if (configuration == null || key == null) {
            try {
                configuration = readFile();
            } catch (IOException ioe) {
                ioe.printStackTrace();
            }
        }
        return configuration.getProperty(key, defaultValue);
    }

    private static Properties readFile() throws IOException {

        Properties props = new Properties();
        try {
            ClassLoader loader = Configuration.class.getClassLoader();
            //InputStream in = new FileInputStream("/home/hatami/project/TMS/tms_fa.properties");
            InputStream in = loader.getResourceAsStream("tms_fa.properties");
            props.load(in);
        } catch (FileNotFoundException e) {
            throw e;
        } catch (IOException e) {
            throw e;
        }
        return props;
    }

    public static ResourceBundle getBundle() {
        return ResourceBundle.getBundle("tms", locale);
    }

    public static Hashtable<String, String> getSESSION() {
        return SESSION;
    }

    public static Locale getLocale() {
        return locale;
    }

}
