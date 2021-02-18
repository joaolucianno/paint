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
    private static Color currentColor;


    //Constructor
    public Cell(int row, int col){
        this.row = row;
        this.col = col;
        painted = false;
        currentColor = Color.BLACK;
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

    public Color getCurrentColor(){
        return currentColor;
    }

    //Setters
    public void setPainted(boolean painted){
        this.painted = painted;
    }

    //Custom Methods
    public void paint(){
        painted = true;
        cell.setColor(currentColor);
        cell.fill();
    }

    public void erase(){
        painted = false;
        cell.setColor(Color.BLACK);
        cell.draw();
    }

    public static void changeColor(Color newColor){
        currentColor = newColor;
    }

    @Override
    public String toString(){
        return isPainted() ? "1" : "0";
    }

}
