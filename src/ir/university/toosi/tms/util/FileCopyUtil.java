package ir.university.toosi.tms.util;

import java.io.*;

/**
 * @author : Hamed Hatami ,  Farzad Sedaghatbin, Atefeh Ahmadi, Mostafa Rastgar
 * @version : 0.8
 */

public class FileCopyUtil implements Runnable {

    private String source;
    private String destination;

    public FileCopyUtil(String source, String destination) {
        this.source = source;
        this.destination = destination;
    }

    @Override
    public void run() {
        try {
            InputStream in = new FileInputStream(new File(source));
            File dir = null;
            if (System.getProperty("os.name").equalsIgnoreCase("Linux")) {
                dir = new File(destination.substring(0, destination.lastIndexOf("/")));
            } else {
                dir = new File(destination.substring(0, destination.lastIndexOf("\\")));
            }
            if (!dir.exists()) {
                dir.mkdir();
            }
            OutputStream out = new FileOutputStream(destination);

            byte[] buf = new byte[1024];
            int len;
            while ((len = in.read(buf)) > 0) {
                out.write(buf, 0, len);
            }
            in.close();
            out.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
