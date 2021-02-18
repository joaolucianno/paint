package org.academiadecodigo.paint;

import org.academiadecodigo.paint.grid.Cell;
import org.academiadecodigo.paint.grid.Cursor;
import org.academiadecodigo.paint.util.FileManager;
import org.academiadecodigo.simplegraphics.graphics.Color;

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
        Cell cell = grid.getCell(cursor.getRow(), cursor.getCol());
        if(cell.isPainted()){
            //painting = false;
            cell.erase();
        } else{
            painting = true;
            cell.paint();
            System.out.println(cell.getCurrentColor());
        }
    }

    public void clear(){
        grid.clearGrid();
    }

    public void changeColor(Color newColor){
        Cell.changeColor(newColor);
    }

    public void save(){
        String text = "";
        for (int i = 0; i < grid.getCols(); i++) {
            for (int j = 0; j < grid.getRows(); j++) {
                text += grid.getCell(i, j).toString();
            }
            text += "\n";
        }
        FileManager.save(text);
    }

    public void load(){
        clear();
        String load = FileManager.load();
        int aux = 0;
        for (int i = 0; i < grid.getRows(); i++) {
            for (int j = 0; j < grid.getCols(); j++) {
                Cell temp = grid.getCell(i, j);
                if(load.charAt(i+j+aux) == '1'){
                    temp.setPainted(true);
                    temp.paint();
                } else {
                    temp.setPainted(false);
                }
                System.out.println(load.charAt(i+j+aux));
            }
            aux += grid.getRows();
        }
        painting = false;
        //System.out.println(load);
    }

    public void changeSlot(String newLoadPath){
        FileManager.setSaveLoadPath(newLoadPath);
    }


}
