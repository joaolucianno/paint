package org.academiadecodigo.paint;

import org.academiadecodigo.paint.grid.Cell;
import org.academiadecodigo.paint.grid.Cursor;
import org.academiadecodigo.paint.util.KeyboardController;

public class Paint {
    //Fields
    private Grid grid;
    private Cursor cursor;
    private boolean painting;


    //Constructor
    public Paint(int width, int height){
        grid = new Grid(width, height);
        cursor = new Cursor();
    }

    //Getters
    public boolean isPainting(){
        return painting;
    }

    //Setters
    public void setPainting(boolean painting){
        this.painting = painting;
    }

    //Custom Methods
    public void moveCursor(Cursor.Direction direction){
        if(cursorOnEdge(direction)){
            return;
        }

        switch (direction){
            case LEFT:
                cursor.moveLeft();
                break;
            case RIGHT:
                cursor.moveRight();
                break;
            case UP:
                cursor.moveUp();
                break;
            case DOWN:
                cursor.moveDown();
                break;
        }

        if(painting){
            paint();
        }
    }

    public boolean cursorOnEdge(Cursor.Direction direction){
        return cursor.getCol() == 0 &&  direction == Cursor.Direction.LEFT ||
                cursor.getCol() == grid.getCols() -1 && direction == Cursor.Direction.RIGHT ||
                cursor.getRow() == 0 && direction == Cursor.Direction.UP ||
                cursor.getRow() == grid.getRows() -1 && direction == Cursor.Direction.DOWN;
    }

    public void paint(){
        Cell cell = grid.getCells(cursor.getRow(), cursor.getCol());
        if(cell.isPainted()){
            cell.erase();
        } else{
            painting = true;
            cell.paint();
        }
    }

    public void clear(){
        grid.clearGrid();
    }


}
