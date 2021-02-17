package org.academiadecodigo.paint.grid;

import org.academiadecodigo.paint.Grid;
import org.academiadecodigo.simplegraphics.graphics.Color;
import org.academiadecodigo.simplegraphics.graphics.Rectangle;

public class Cell {
    //Fields
    protected int row;
    protected int col;
    protected Rectangle cell;
    private boolean painted;


    //Constructor
    public Cell(int row, int col){
        this.row = row;
        this.col = col;
        painted = false;
        cell = new Rectangle(col * Grid.CELL_SIZE + Grid.PADDING, row * Grid.CELL_SIZE + Grid.PADDING, Grid.CELL_SIZE, Grid.CELL_SIZE);
        cell.draw();
    }

    //Getters
    public int getRow() {
        return row;
    }

    public int getCol() {
        return col;
    }

    public Rectangle getCell(){
        return cell;
    }

    public boolean isPainted() {
        return painted;
    }

    //Custom Methods
    public void paint(){
        painted = true;
        cell.setColor(Color.RED);
        cell.fill();
    }

    public void erase(){
        painted = false;
        cell.setColor(Color.BLACK);
        cell.draw();
    }

    @Override
    public String toString(){
        return isPainted() ? "1" : "0";
    }

}
