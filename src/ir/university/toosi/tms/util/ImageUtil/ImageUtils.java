package ir.university.toosi.tms.util.ImageUtil;

import net.coobird.thumbnailator.Thumbnails;

import javax.imageio.ImageIO;
import javax.swing.*;
import javax.swing.filechooser.FileFilter;
import javax.swing.filechooser.FileNameExtensionFilter;
import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;


public class ImageUtils {

    public static BufferedImage convertByteArrayToBufferedImage(byte[] imageBytes) {
        if (imageBytes == null) {
            return null;
        }
        try {
            return ImageIO.read(new ByteArrayInputStream(imageBytes));
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }

    public static byte[] imageToByteArray(BufferedImage bufferedImage) {
        if (bufferedImage == null) {
            return null;
        }
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        try {
            ImageIO.write(bufferedImage, "png", baos);
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
        return baos.toByteArray();
    }

    public static File OpenImageDialog(String startDirectory, java.awt.Component parent) {
        final JFileChooser fc = new JFileChooser();
        fc.setDialogTitle("Specify an image to open");//todo use bundle
        FileFilter ftJpg = new FileNameExtensionFilter("*.jpg, *.jpeg", "jpg", "jpeg");
        FileFilter ftPng = new FileNameExtensionFilter("*.png", "png");
        FileFilter ftGif = new FileNameExtensionFilter("*.gif", "gif");
        FileFilter ftAll = new FileNameExtensionFilter("Image Files (*.png,*.jpg,*.jpeg,*.gif)", "png", "jpg", "jpeg", "gif");
        fc.removeChoosableFileFilter(fc.getFileFilter());
        fc.addChoosableFileFilter(ftAll);
        fc.addChoosableFileFilter(ftJpg);
        fc.addChoosableFileFilter(ftPng);
        fc.addChoosableFileFilter(ftGif);

        File fileStartDirectory = new File(startDirectory);
        if (!fileStartDirectory.isDirectory()) {
            fileStartDirectory = fileStartDirectory.getParentFile();
        }
        fc.setCurrentDirectory(fileStartDirectory);
        fc.setMultiSelectionEnabled(false);
        fc.setFileView(new ImageFileView());
        fc.setAccessory(new DialogImagePreview(fc));

        int returnVal = fc.showOpenDialog(parent);

        if (returnVal == JFileChooser.APPROVE_OPTION) {
            File file = fc.getSelectedFile();
            return file;
        } else {
            return null;
        }
    }

    public static float calculateScaleRatio(int originalWidth, int targetWidth) {
        //calculate  ratio for scaling
        return (float) targetWidth / originalWidth;
    }

    public static BufferedImage scaleImage(BufferedImage bufferedImage, float scaleRatio) throws IOException {
        //apply scale
        return Thumbnails.of(bufferedImage).scale(scaleRatio).asBufferedImage();
    }

    public static ImageIcon convertToImageIcon(BufferedImage bufferedImage) {
        if (bufferedImage == null) {
            return null;
        }
        return new ImageIcon(bufferedImage);
    }

    public static BufferedImage getBufferedImage(File tempFile) {
        BufferedImage bufferedImage = null;
        try {
            bufferedImage = ImageIO.read(tempFile);
        } catch (IOException e) {
            System.out.println("cant convert file to Buffered image" + tempFile.getPath());
            e.printStackTrace();
        }
        return bufferedImage;
    }


}
