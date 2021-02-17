package org.academiadecodigo.paint;

import org.academiadecodigo.paint.grid.Cell;
import org.academiadecodigo.simplegraphics.graphics.Color;
import org.academiadecodigo.simplegraphics.graphics.Rectangle;

public class Grid {
    //Fields
    public static final int CELL_SIZE = 20;
    public static final int PADDING = 10;
    private int rows;
    private int cols;
    private Cell[][] cells;


    //Constructor
    public Grid(int width, int height){
        rows = width/CELL_SIZE;
        cols = height/CELL_SIZE;
        cells = new Cell[rows][cols];
        initializeCells();
    }

    public int getRows(){
        return rows;
    }

    public int getCols() {
        return cols;
    }

    public Cell getCells(int row, int col){
        return cells[row][col];
    }


    //Custom Methods
    public void initializeCells(){
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                cells[i][j] = new Cell(i,j);
            }
        }
    }

    public void clearGrid(){
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                cells[i][j].erase();
            }
        }
    }

}
