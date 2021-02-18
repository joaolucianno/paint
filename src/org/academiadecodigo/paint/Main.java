package org.academiadecodigo.paint;

import org.academiadecodigo.paint.util.KeyboardController;

public class Main {
    public static void main(String[] args) {
        Paint paint = new Paint(600, 600);
        new KeyboardController(paint);
    }
}
