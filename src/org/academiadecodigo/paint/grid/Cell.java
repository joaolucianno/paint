package org.academiadecodigo.paint.grid;

import org.academiadecodigo.paint.Grid;
import org.academiadecodigo.simplegraphics.graphics.Rectangle;

public class Cell {
    //Fields
    private int row;
    private int col;
    private Rectangle cell;
    private boolean painted;


    //Constructor
    public Cell(int row, int col){
        this.row = row;
        this.col = col;
        painted = false;
        cell = new Rectangle(row * Grid.CELL_SIZE + Grid.PADDING, col * Grid.CELL_SIZE + Grid.PADDING, Grid.CELL_SIZE, Grid.CELL_SIZE);
        cell.draw();

    }

}
