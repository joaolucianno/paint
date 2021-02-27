package org.academiadecodigo.paint.grid;

import org.academiadecodigo.paint.Grid;
import org.academiadecodigo.simplegraphics.graphics.Color;
import org.academiadecodigo.simplegraphics.graphics.Rectangle;

public class Cell {
    //Fields
    private static Color currentColor;
    private static int red;
    private static int green;
    private static int blue;
    protected int row;
    protected int col;
    protected Rectangle cell;
    private boolean painted;
    private int[] colorCode;


    //Constructor
    public Cell(int row, int col){
        this.row = row;
        this.col = col;
        painted = false;
        currentColor = Color.BLACK;
        cell = new Rectangle(col * Grid.CELL_SIZE + Grid.PADDING, row * Grid.CELL_SIZE + Grid.PADDING, Grid.CELL_SIZE, Grid.CELL_SIZE);
        cell.draw();
        colorCode = new int[]{0, 0, 0};
    }

    //Getters

    /**
     *
     * @return this row
     */
    public int getRow() {
        return row;
    }

    /**
     *
     * @return this col
     */
    public int getCol() {
        return col;
    }

    /**
     *
     * @return status of the cell
     */
    public boolean isPainted() {
        return painted;
    }

    /**
     *
     * @return this current color
     */
    public Color getCurrentColor(){
        return currentColor;
    }

    //Setters

    /**
     *  Set status of the cell
     * @param painted
     */
    public void setPainted(boolean painted){
        this.painted = painted;
    }

    //Custom Methods

    /**
     * Paint this cell
     */
    public void paint(){
        colorCode[0] = red;
        colorCode[1] = green;
        colorCode[2] = blue;
        painted = true;
        cell.setColor(currentColor);
        cell.fill();

    }

    /**
     * Clean this cell
     */
    public void erase(){
        painted = false;
        cell.setColor(Color.BLACK);
        cell.draw();
    }

    /**
     * Change current color and assign color at this cell
     * @param r
     * @param g
     * @param b
     */
    public static void changeColor(int r, int g, int b){
        currentColor = new Color(r, g, b);
        red = r;
        green = g;
        blue = b;
    }

    @Override
    public String toString(){
        return isPainted() ? ":1:" + colorCode[0] + "/" + colorCode[1] + "/" + colorCode[2] + "/" : ":0:0/0/0";
    }

}
