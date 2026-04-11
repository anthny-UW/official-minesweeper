/*
* TCSS 360 - Assignment 1 Minesweeper
* Official Solution File
* Spring 2026
*/

package main.java.team.official;

/**
 * Provides helper methods for checking mines and counting adjacent mines.
 *
 * @author Anthony Co
 * @author Ibrahim Mohamud
 * @author Jackson Steger
 * @version 4/10/2026
 */
public final class Minefield {

    /**
     * Returns true if the given cell contains a mine.
     * 
     * @param theField The 2D character array that represents the mine field
     * @param theRow The row index of the cell
     * @param theCol The column index of the cell
     * @return a boolean that return true if the index is a mine, false if it is not. 
     */
    public final boolean isMine(char[][] theField, int theRow, int theCol) {
        if (theRow < 0 || theRow >= theField.length || theCol < 0 || theCol >= theField[0].length) {
            return false;
        }
        return theField[theRow][theCol] == '*';
    }

    /**
     *  Counts the number of mines adjacent to the given cell.
     * 
     * @param theField The 2D character array that represents the mine field
     * @param theRow The row index of the cell
     * @param theCol The column index of the cell
     * @return The count of mines adjacent to the tile (0-8)
     */
    public final int countAdjacentMines(char[][] theField, int theRow, int theCol) {
        int count = 0;

        int[][] adjacentTiles = {     // all tiles around the cell
                {-1, -1}, {-1, 0}, {-1, 1},
                { 0, -1},          { 0, 1},
                { 1, -1}, { 1, 0}, { 1, 1}
        };

        for (int[] d : adjacentTiles) {
            int nextRow = theRow + d[0];
            int nextCol = theCol + d[1];
            if (isMine(theField, nextRow, nextCol)) {
                count++;
            }
        }

        return count;
    }
}
