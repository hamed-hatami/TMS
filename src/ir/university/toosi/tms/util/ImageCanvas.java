package ir.university.toosi.tms.util;

import java.awt.*;

public class ImageCanvas extends Panel {
    Image im;

    public ImageCanvas(Image im) {
        this.im = im;
    }

    public void paint(Graphics g) {
        g.drawImage(im, 0, 0, getWidth(), getHeight(), this);
    }

    public void update(Graphics g) {
        g.drawImage(im, 0, 0, getWidth(), getHeight(), this);
    }

}