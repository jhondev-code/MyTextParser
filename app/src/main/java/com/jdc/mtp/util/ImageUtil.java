package com.jdc.mtp.util;

import java.awt.*;

@SuppressWarnings("unused")
public class ImageUtil {

    private ImageUtil() {}

    public static Image loadPNG(String path) {
        if (path.toLowerCase().endsWith(".png")) {
            return Toolkit.getDefaultToolkit().getImage(ImageUtil.class.getResource(path));
        }
        return null;
    }

    public static Image loadJPG(String path) {
        if (path.toLowerCase().endsWith(".jpg") || path.toLowerCase().endsWith(".jpge")) {
            return Toolkit.getDefaultToolkit().getImage(ImageUtil.class.getResource(path));
        }
        return null;
    }

}
