package org.academiadecodigo.paint;

import org.academiadecodigo.paint.grid.Cell;
import org.academiadecodigo.paint.grid.Cursor;
import org.academiadecodigo.paint.util.FileManager;

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

    //Setter

    /**
     * Set status of the cell
     * @param painting
     */
    public void setPainting(boolean painting){
        this.painting = painting;
    }

    //Custom Methods

    /**
     *
     * @param direction
     */
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

    /**
     *
     * @param direction
     * @return
     */
    public boolean cursorOnEdge(Cursor.Direction direction){
        return cursor.getCol() == 0 &&  direction == Cursor.Direction.LEFT ||
                cursor.getCol() == grid.getCols() -1 && direction == Cursor.Direction.RIGHT ||
                cursor.getRow() == 0 && direction == Cursor.Direction.UP ||
                cursor.getRow() == grid.getRows() -1 && direction == Cursor.Direction.DOWN;
    }

    /**
     * Paint cell specified by cursor position
     */
    public void paint(){
        Cell cell = grid.getCell(cursor.getRow(), cursor.getCol());
        if(cell.isPainted()){
            cell.erase();
        } else{
            painting = true;
            cell.paint();
        }
    }

    /**
     * Clear Grid
     */
    public void clear(){
        grid.clearGrid();
    }

    /**
     * Change static property currentColor in Cell Class
     * @param r
     * @param g
     * @param b
     */
    public void changeColor(int r, int g, int b){
        Cell.changeColor(r, g, b);
    }

    /**
     * Save
     */
    public void save(){
        String text = "";
        for (int i = 0; i < grid.getCols(); i++) {
            for (int j = 0; j < grid.getRows(); j++) {
                text += grid.getCell(i, j).toString() ;
            }
            text += "\n";
        }
        FileManager.save(text);
    }

    /**
     * Load
     */
    public void load(){
        grid.loadGrid(FileManager.load());
    }

    /**
     * Change slot to save and load
     * @param newLoadPath
     */
    public void changeSlot(String newLoadPath){
        FileManager.setSaveLoadPath(newLoadPath);
    }


}
