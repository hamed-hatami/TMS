package ir.university.toosi.tms.util.ImageUtil;

//import com.jhlabs.image.ContrastFilter;
//import com.jhlabs.image.GlowFilter;

import com.sun.image.codec.jpeg.JPEGCodec;
import com.sun.image.codec.jpeg.JPEGDecodeParam;
import com.sun.image.codec.jpeg.JPEGEncodeParam;
import com.sun.image.codec.jpeg.JPEGImageEncoder;
import net.coobird.thumbnailator.Thumbnails;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;

import javax.imageio.ImageIO;
import javax.imageio.ImageReader;
import javax.imageio.stream.ImageInputStream;
import javax.swing.*;
import javax.swing.filechooser.FileFilter;
import javax.swing.filechooser.FileNameExtensionFilter;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.*;
import java.util.Iterator;


public class ImageUtils {

    /*
    ImageWriter writer = ImageIO.getImageWritersByFormatName("jpeg").next();
ImageWriteParam param = writer.getDefaultWriteParam();
param.setCompressionMode(ImageWriteParam.MODE_EXPLICIT); // Needed see javadoc
param.setCompressionQuality(1.0F); // Highest quality
writer.write(image);
    * */
    public static int getResolution(File file) throws IOException {

        ImageInputStream iis = ImageIO.createImageInputStream(file);
        Iterator<ImageReader> readers = ImageIO.getImageReaders(iis);

        if (!readers.hasNext()) {
            System.out.println("No reader for this format");
        }
        ImageReader reader = readers.next();
        reader.setInput(iis);

        int hdpi = 96;
        int vdpi = 96;
        double mm2inch = 25.4;

        NodeList lst;
        Element node = (Element) reader.getImageMetadata(0).getAsTree("javax_imageio_1.0");
        lst = node.getElementsByTagName("HorizontalPixelSize");
        if (lst != null && lst.getLength() == 1)
            hdpi = (int) (mm2inch / Float.parseFloat(((Element) lst.item(0)).getAttribute("value")));

        lst = node.getElementsByTagName("VerticalPixelSize");
        if (lst != null && lst.getLength() == 1)
            vdpi = (int) (mm2inch / Float.parseFloat(((Element) lst.item(0)).getAttribute("value")));

        // System.out.println("horizontal dpi is" + hdpi);
        // System.out.println("vertical dpi is" + vdpi);
        return hdpi;
    }

    public static Dimension getDimension(BufferedImage bufferedImage) {
        return new Dimension(bufferedImage.getWidth(), bufferedImage.getHeight());
    }

    public static BufferedImage convertByteArrayToBufferedImage(byte[] imageBytes) {
        if(imageBytes == null){
            return null;
        }
        try {
            return ImageIO.read(new ByteArrayInputStream(imageBytes));
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }

    public static byte[] imageToByteArray(BufferedImage bufferedImage)  {
        if(bufferedImage == null){
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
            // System.out.println("start directory not found.  open dialog start directory set to default.");
        }
        fc.setCurrentDirectory(fileStartDirectory);
        fc.setMultiSelectionEnabled(false);
        fc.setFileView(new ImageFileView());
        fc.setAccessory(new DialogImagePreview(fc));

        int returnVal = fc.showOpenDialog(parent);

        if (returnVal == JFileChooser.APPROVE_OPTION) {
            File file = fc.getSelectedFile();
            System.out.println("file Name: " + file.getName());
            System.out.println("file Path: " + file.getPath());
            return file;

        } else {
            System.out.println("Open command cancelled by user.");
            return null;
        }
    }

    public static float calculateScaleRatio(int originalWidth, int targetWidth) {
        //calculate  ratio for scaling
        return (float) targetWidth / originalWidth;
    }

    public static float calculateQualityDPIRatio(int originalQualityDPI, int targetQualityDPI) {
        //calculate  ratio for manipulating quality dpi
        return (float) targetQualityDPI / originalQualityDPI;
    }

    public static BufferedImage scaleImage(BufferedImage bufferedImage, float scaleRatio) throws IOException {
        //apply scale
        return Thumbnails.of(bufferedImage).scale(scaleRatio).asBufferedImage();
    }

    public static BufferedImage createEmptyBufferedImage() {
        BufferedImage bufferedImage = new BufferedImage(100, 100, BufferedImage.TYPE_INT_RGB);
        return bufferedImage;
    }

    public static BufferedImage convertImageIconToBufferedImage(ImageIcon imageIcon) {
/*
        File img = new File("C:\\..\\image.jpg");
        BufferedImage bufferedImage = ImageIO.read(img);
        ImageIcon imageIcon = new ImageIcon(bufferedImage);
*/
        BufferedImage bufferedImage = new BufferedImage(
                imageIcon.getIconWidth(),
                imageIcon.getIconHeight(),
                BufferedImage.TYPE_INT_RGB);
        Graphics g = bufferedImage.createGraphics();
        // paint the Icon to the BufferedImage.
        imageIcon.paintIcon(null, g, 0, 0);
        g.dispose();
        return bufferedImage;
    }

    public static ImageIcon convertToImageIcon(BufferedImage bufferedImage) {
        if(bufferedImage == null){
         return null;
        }
        return new ImageIcon(bufferedImage);
    }

    public static long getFileSize(BufferedImage bufferedImage) {


        //it works
        long contentLength = 0;
        try {
            File tempFile = File.createTempFile("temp-file-name", ".tmp");
            FileOutputStream fos = new FileOutputStream(tempFile);
            ImageIO.write(bufferedImage, "JPG", fos);
            contentLength = tempFile.length();
        } catch (Exception e) {
        }
        return contentLength / 1024;
    }

    public static BufferedImage changeDPI(BufferedImage bufferedImage, int targetDPI, float dpiRatio) throws IOException {

        JPEGEncodeParam jpegEncodeParam = JPEGCodec.getDefaultJPEGEncodeParam(bufferedImage);
        jpegEncodeParam.setXDensity(targetDPI);
        jpegEncodeParam.setYDensity(targetDPI);
        jpegEncodeParam.setDensityUnit(JPEGDecodeParam.DENSITY_UNIT_DOTS_INCH);
        jpegEncodeParam.setQuality(dpiRatio, false);

        // ByteArrayOutputStream tmp = new ByteArrayOutputStream();

        File tempFile = File.createTempFile("temp-file-name", ".tmp");
        FileOutputStream fos = new FileOutputStream(tempFile);
        JPEGImageEncoder jpegEncoder = JPEGCodec.createJPEGEncoder(fos);
        jpegEncoder.encode(bufferedImage, jpegEncodeParam);
        fos.flush();
        fos.close();
        return ImageIO.read(tempFile);

       /* Iterator<ImageWriter> writers = ImageIO.getImageWritersByFormatName("jpeg");

        if (!writers.hasNext())
            throw new IllegalStateException("No writers found");

        ImageWriter writer =  writers.next();
        OutputStream os = new FileOutputStream(new File(bufferedImage));
        ImageOutputStream ios = ImageIO.createImageOutputStream(os);
        writer.setOutput(ios);


        ImageWriteParam param = writer.getDefaultWriteParam();

        param.setCompressionMode(ImageWriteParam.MODE_EXPLICIT);
        param.setCompressionQuality(dpiRatio);

        writer.write(null, new IIOImage(bufferedImage, null, null), param);

        os.close();
        ios.close();
        writer.dispose();*/

    }

    public static String saveFile(BufferedImage bufferedImage, String startDirectory, java.awt.Component parent) throws IOException {

        //write modified image
        final JFileChooser fc = new JFileChooser();
        String url = startDirectory;
        fc.setDialogTitle("Specify an image file to save");//todo use bundle
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
            //System.out.println("start directory not found.  open dialog start directory set to default.");
        }
        fc.setCurrentDirectory(fileStartDirectory);


        fc.setMultiSelectionEnabled(false);
        fc.setFileView(new ImageFileView());

        int userSelection = fc.showSaveDialog(parent);
        File fileToSave = null;
        if (userSelection == JFileChooser.APPROVE_OPTION) {
            fileToSave = fc.getSelectedFile();
            String fileExtension = "jpg";
            url = fileToSave.getPath();
            if (url.lastIndexOf(".") == -1) {
                if (fc.getFileFilter() == ftAll) {
                    fileExtension = "jpg";
                }
                if (fc.getFileFilter() == ftGif) {
                    fileExtension = "gif";
                }
                if (fc.getFileFilter() == ftJpg) {
                    fileExtension = "jpg";
                }
                if (fc.getFileFilter() == ftPng) {
                    fileExtension = "png";
                }
                url += "." + fileExtension;
            }
            FileOutputStream fos = new FileOutputStream(url);
            ImageIO.write(bufferedImage, fileExtension, fos);
            fos.flush();
            fos.close();
            System.out.println("Save as file: " + url);
        }

        return fileToSave != null ? fileToSave.getParent() : null;
    }

    public static BufferedImage getBufferedImage(String sourceImagePath) {
        File tempFile = new File(sourceImagePath);
        return getBufferedImage(tempFile);
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

    public static BufferedImage removeBackground(BufferedImage originalImage) {
        //it's or previous work:
        BufferedImage destinationImage = new BufferedImage(1, 1, BufferedImage.TYPE_INT_RGB);
        //filter by matrix
           /* float[] matrix = {
                    0,1,0,
                    1,2,1,
                    0,1,0,

            };
            Kernel kernel = new Kernel(3, 3, matrix);
            BufferedImageOp op = new ConvolveOp(kernel);


            FileOutputStream fos = new FileOutputStream(writeAddress1);
            ImageIO.write(op.filter(originalImage, null), "jpg", fos);
            fos.flush();
            fos.close();

            */

        //filter modify contrast direct mode
      /*  ContrastFilter contrastFilter = new ContrastFilter();
        contrastFilter.setContrast(1.1f);
        destinationImage = contrastFilter.filter(originalImage, destinationImage);

        //filter modify contrast and sharpness
        GlowFilter glowFilter = new GlowFilter();
        glowFilter.setAmount(0.03f);
        destinationImage = glowFilter.filter(destinationImage, destinationImage);*/

        //filter remove details and smoothing picture
           /* ReduceNoiseFilter reduceNoiseFilter = new ReduceNoiseFilter();
            destinationImage = reduceNoiseFilter.filter(originalImage, destinationImage);*/

        return destinationImage;
    }


}
