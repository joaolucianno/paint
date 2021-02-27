package org.academiadecodigo.paint;

import org.academiadecodigo.paint.grid.Cell;

public class Grid {
    //Fields
    public static final int CELL_SIZE = 20;
    public static final int PADDING = 10;
    private final int rows;
    private final int cols;
    private Cell[][] cells;


    //Constructor
    public Grid(int width, int height){
        rows = width/CELL_SIZE;
        cols = height/CELL_SIZE;
        cells = new Cell[rows][cols];
        initializeCells();
    }

    //Getters

    /**
     *
     * @return rows of the Grid
     */
    public int getRows(){
        return rows;
    }

    /**
     *
     * @return cols of the Grid
     */
    public int getCols() {
        return cols;
    }

    /**
     *
     * @param row
     * @param col
     * @return cell specified by row and col
     */
    public Cell getCell(int row, int col){
        return cells[row][col];
    }

    //Custom Methods

    /**
     * Initialize Grid
     */
    public void initializeCells(){
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                cells[i][j] = new Cell(i,j);
            }
        }
    }

    /**
     * Clear Grid
     */
    public void clearGrid(){
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                cells[i][j].erase();
            }
        }
    }


    /**
     *
     * @param load
     */
    public void loadGrid(String load){
        clearGrid();
        int aux = 1;
        String[] loadSplit = load.split(":");

        for (int i = 0; i < getRows(); i++) {
            for (int j = 0; j < getCols(); j++) {
                Cell temp = getCell(i, j);
                if(loadSplit[aux].equals("1")){
                    temp.setPainted(true);
                    String[] colors = loadSplit[aux+1].split("/");
                    Cell.changeColor(Integer.parseInt(colors[0]), Integer.parseInt(colors[1]), Integer.parseInt(colors[2]));
                    temp.paint();
                } else {
                    temp.setPainted(false);
                }
                aux += 2;
            }
        }
    }

}
