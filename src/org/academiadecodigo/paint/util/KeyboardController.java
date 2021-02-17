package org.academiadecodigo.paint.util;

import org.academiadecodigo.paint.Paint;
import org.academiadecodigo.paint.grid.Cursor;
import org.academiadecodigo.simplegraphics.keyboard.Keyboard;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardEvent;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardEventType;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardHandler;

public class KeyboardController implements KeyboardHandler {
    //Fields
    private Keyboard keyboard;
    private Paint paint;


    //Constructor
    public  KeyboardController(Paint paint){
        keyboard = new Keyboard(this);
        this.paint = paint;
        initKeyboard();
    }

    private void initKeyboard(){
        KeyboardEvent[] events = new KeyboardEvent[9];
        for (int i = 0; i < events.length; i++) {
            events[i] = new KeyboardEvent();
            if(i == 5){
                events[i].setKeyboardEventType(KeyboardEventType.KEY_RELEASED);
                continue;
            }
            events[i].setKeyboardEventType(KeyboardEventType.KEY_PRESSED);
        }

        events[0].setKey(KeyboardEvent.KEY_LEFT);
        events[1].setKey(KeyboardEvent.KEY_RIGHT);
        events[2].setKey(KeyboardEvent.KEY_UP);
        events[3].setKey(KeyboardEvent.KEY_DOWN);
        events[4].setKey(KeyboardEvent.KEY_SPACE);
        events[5].setKey(KeyboardEvent.KEY_SPACE);
        events[6].setKey(KeyboardEvent.KEY_C);
        events[7].setKey(KeyboardEvent.KEY_S);
        events[8].setKey(KeyboardEvent.KEY_L);


        for (int i = 0; i < events.length; i++) {
            keyboard.addEventListener(events[i]);
        }

    }


    @Override
    public void keyPressed(KeyboardEvent keyboardEvent) {
        switch (keyboardEvent.getKey()){
            case KeyboardEvent.KEY_LEFT:
                paint.moveCursor(Cursor.Direction.LEFT);
                break;
            case KeyboardEvent.KEY_RIGHT:
                paint.moveCursor(Cursor.Direction.RIGHT);
                break;
            case KeyboardEvent.KEY_UP:
                paint.moveCursor(Cursor.Direction.UP);
                break;
            case KeyboardEvent.KEY_DOWN:
                paint.moveCursor(Cursor.Direction.DOWN);
                break;
            case KeyboardEvent.KEY_SPACE:
                paint.setPainting(true);
                paint.paint();
                break;
            case KeyboardEvent.KEY_C:
                paint.clear();
                break;
            case KeyboardEvent.KEY_S:
                //paint.save();
                break;
            case KeyboardEvent.KEY_L:
                //paint.load();
                break;
        }
    }

    @Override
    public void keyReleased(KeyboardEvent keyboardEvent) {
        if(keyboardEvent.getKey() == KeyboardEvent.KEY_SPACE){
            paint.setPainting(false);
        }
    }
}
