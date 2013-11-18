package ir.university.toosi.tms.util.ImageUtil;

import ir.university.toosi.tms.util.ComponentUtil;

import java.io.File;
import javax.swing.*;
import javax.swing.filechooser.*;
/**
 * @author a_hadadi
 */

/* ImageFileView.java is used by FileChooserDemo2.java. */
public class ImageFileView extends FileView {

    ImageIcon jpgIcon = ComponentUtil.getImageIcon("jpgIcon.gif");
    ImageIcon gifIcon = ComponentUtil.getImageIcon("gifIcon.gif");
    ImageIcon tiffIcon =ComponentUtil.getImageIcon("tiffIcon.gif");
    ImageIcon pngIcon = ComponentUtil.getImageIcon("pngIcon.png");


    public String getName(File f) {
        return null; //let the L&F FileView figure this out
    }

    public String getDescription(File f) {
        return null; //let the L&F FileView figure this out
    }

    public Boolean isTraversable(File f) {
        return null; //let the L&F FileView figure this out
    }

    public String getTypeDescription(File f) {
        String extension = SimpleImageUtils.getExtension(f);
        String type = null;

        if (extension != null) {
            if (extension.equals(SimpleImageUtils.jpeg) ||
                    extension.equals(SimpleImageUtils.jpg)) {
                type = "JPEG Image";
            } else if (extension.equals(SimpleImageUtils.gif)){
                type = "GIF Image";
           /* } else if (extension.equals(SimpleImageUtils.tiff) ||
                    extension.equals(SimpleImageUtils.tif)) {
                type = "TIFF Image";*/
            } else if (extension.equals(SimpleImageUtils.png)){
                type = "PNG Image";
            }
        }
        return type;
    }

    public Icon getIcon(File f) {
        String extension = SimpleImageUtils.getExtension(f);
        Icon icon = null;

        if (extension != null) {
            if (extension.equals(SimpleImageUtils.jpeg) ||
                    extension.equals(SimpleImageUtils.jpg)) {
                icon = jpgIcon;
            } else if (extension.equals(SimpleImageUtils.gif)) {
                icon = gifIcon;
           /* } else if (extension.equals(SimpleImageUtils.tiff) ||
                    extension.equals(SimpleImageUtils.tif)) {
                icon = tiffIcon;*/
            } else if (extension.equals(SimpleImageUtils.png)) {
                icon = pngIcon;
            }
        }
        return icon;
    }
}

