package org.academiadecodigo.paint;

import org.academiadecodigo.paint.util.KeyboardController;

public class Main {
    public static void main(String[] args) {
        Paint paint = new Paint(400, 400);
        new KeyboardController(paint);
    }
}
