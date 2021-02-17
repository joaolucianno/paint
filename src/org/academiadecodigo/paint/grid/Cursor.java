package org.academiadecodigo.paint.grid;

import static org.academiadecodigo.paint.Grid.CELL_SIZE;
import org.academiadecodigo.simplegraphics.graphics.Color;

public class Cursor extends Cell{
    //Enum
    public enum Direction{
        LEFT,
        RIGHT,
        UP,
        DOWN

    }

    //Constructor
    public Cursor() {
        super(0, 0);
        paint();
        cell.setColor(Color.GREEN);
    }

    //Custom Methods
    public void moveLeft(){
        col--;
        cell.translate(-CELL_SIZE, 0);
    }

    public void moveRight(){
        col++;
        cell.translate(CELL_SIZE, 0);
    }

    public void moveUp(){
        row--;
        cell.translate(0, -CELL_SIZE);
    }

    public void moveDown(){
        row++;
        cell.translate(0, CELL_SIZE);
    }

}
