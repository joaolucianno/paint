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

    /**
     * Initialize Keyboard
     */
    private void initKeyboard(){
        KeyboardEvent[] events = new KeyboardEvent[19];
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
        events[9].setKey(KeyboardEvent.KEY_1);
        events[10].setKey(KeyboardEvent.KEY_2);
        events[11].setKey(KeyboardEvent.KEY_3);
        events[12].setKey(KeyboardEvent.KEY_4);
        events[13].setKey(KeyboardEvent.KEY_5);
        events[14].setKey(KeyboardEvent.KEY_6);
        events[15].setKey(KeyboardEvent.KEY_7);
        events[16].setKey(KeyboardEvent.KEY_8);
        events[17].setKey(KeyboardEvent.KEY_9);
        events[18].setKey(KeyboardEvent.KEY_0);


        for (int i = 0; i < events.length; i++) {
            keyboard.addEventListener(events[i]);
        }

    }

    /**
     *
     * @param keyboardEvent
     */
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
                paint.save();
                break;
            case KeyboardEvent.KEY_L:
                paint.load();
                break;

            //Change Save Slots
            case KeyboardEvent.KEY_1:
                paint.changeSlot("resources/saveLoad1.txt");
                //System.out.println("resources/saveLoad1.txt");
                break;
            case KeyboardEvent.KEY_2:
                paint.changeSlot("resources/saveLoad2.txt");
                //System.out.println("resources/saveLoad2.txt");
                break;
            case KeyboardEvent.KEY_3:
                paint.changeSlot("resources/saveLoad3.txt");
                //System.out.println("resources/saveLoad3.txt");
                break;
            case KeyboardEvent.KEY_4:
                paint.changeSlot("resources/saveLoad4.txt");
                //System.out.println("resources/saveLoad4.txt");
                break;

            //Change Color
            case KeyboardEvent.KEY_5:
                paint.changeColor(255, 0, 0);
                break;
            case KeyboardEvent.KEY_6:
                paint.changeColor(0, 0, 255);
                break;
            case KeyboardEvent.KEY_7:
                paint.changeColor(0, 255, 0);
                break;
            case KeyboardEvent.KEY_8:
                paint.changeColor(255, 255, 0);
                break;
            case KeyboardEvent.KEY_9:
                paint.changeColor(255, 0 ,255);
                break;
            case KeyboardEvent.KEY_0:
                paint.changeColor(0, 0, 0);
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
