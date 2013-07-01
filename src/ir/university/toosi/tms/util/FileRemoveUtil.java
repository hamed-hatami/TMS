package ir.university.toosi.tms.util;

import java.io.File;
import java.io.IOException;

/**
 * @author : Hamed Hatami , Javad Sarhadi , Farzad Sedaghatbin, Atefeh Ahmadi, Mostafa Rastgar
 * @version : 0.8
 */

public class FileRemoveUtil implements Runnable {

    private String source;

    public FileRemoveUtil(String source) {
        this.source = source;
    }

    private void removeDirectory(File sourcePath) throws IOException {
        if (sourcePath.isDirectory()) {
            String[] files = sourcePath.list();
            for (int counter = 0; counter < files.length; counter++) {
                removeDirectory(new File(sourcePath, files[counter]));
            }
        } else {
            if (sourcePath.exists()) {
                sourcePath.delete();
            }
        }
    }


    @Override
    public void run() {
        try {
            File sourcePath = new File(source);
            removeDirectory(sourcePath);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
