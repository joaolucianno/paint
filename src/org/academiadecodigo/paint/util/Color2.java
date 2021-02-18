package org.academiadecodigo.paint.util;

public class Color2 {
    private int red;
    private int green;
    private int blue;
    public static final Color2 RED = new Color2(255, 0, 0);
    public static final Color2 GREEN = new Color2(0, 255, 0);
    public static final Color2 BLUE = new Color2(0, 0, 255);
    public static final Color2 WHITE = new Color2(255, 255, 255);
    public static final Color2 LIGHT_GRAY = new Color2(192, 192, 192);
    public static final Color2 GRAY = new Color2(128, 128, 128);
    public static final Color2 DARK_GRAY = new Color2(64, 64, 64);
    public static final Color2 BLACK = new Color2(0, 0, 0);
    public static final Color2 CYAN = new Color2(0, 255, 255);
    public static final Color2 MAGENTA = new Color2(255, 0, 255);
    public static final Color2 YELLOW = new Color2(255, 255, 0);
    public static final Color2 PINK = new Color2(255, 175, 175);
    public static final Color2 ORANGE = new Color2(255, 200, 0);

    public Color2(int var1, int var2, int var3) {
        this.red = var1;
        this.green = var2;
        this.blue = var3;
    }

    public int getRed() {
        return this.red;
    }

    public int getGreen() {
        return this.green;
    }

    public int getBlue() {
        return this.blue;
    }
}
