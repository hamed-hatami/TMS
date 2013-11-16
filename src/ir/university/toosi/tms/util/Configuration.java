package ir.university.toosi.tms.util;


import java.io.*;
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
    private static Locale locale = new Locale("fa");//todo why???
    private static final  String propFileName = "tms_fa.properties";

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
            InputStream inputStream;
            if (!ThreadPoolManager.isDebugMode) {
                ClassLoader loader = Configuration.class.getClassLoader();
                inputStream = loader.getResourceAsStream(propFileName);
            } else {
                inputStream = new FileInputStream(propFileName);//work with IDE
            }
            props.load(inputStream);
        } catch (FileNotFoundException e) {
            System.out.println("prop File not found.. '" + propFileName + "'");
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



    public static  void saveSettings(String key,String value) {
        try {
            if (configuration == null) {
                    configuration = readFile();
            }
            FileOutputStream propFileOutputStream = new FileOutputStream(propFileName);
            configuration.setProperty(key, value);
            configuration.store(propFileOutputStream,"Configuration file for TMS, please don't delete file or modify content."); // FileOutputStream or whatever
            propFileOutputStream.close();
        } catch (IOException ioException) {
            ioException.printStackTrace();
        }
    }

}
