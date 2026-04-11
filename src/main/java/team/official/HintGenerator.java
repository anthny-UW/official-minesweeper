/*
 * TCSS 360 - Assignment 1 Minesweeper
 * Official Solution File
 * Spring 2026
 */

package main.java.team.official;

/**
 * The HintGenerator class produces the processed Minesweeper output grid.
 * Mines remain '*' and empty cells are replaced with digits representing the
 * number of adjacent mines.
 *
 * @author Anthony Co
 * @author Ibrahim Mohamud
 * @author Jackson Steger
 * @version 4/10/2026
 */

public final class HintGenerator {

    /** Helper object for mine-checking operations. */
    private final Minefield myMineChecker = new Minefield();

    /**
     * Generates a processed Minesweeper grid with numeric hints.
     *
     * @param theField the original Minesweeper field
     * @return a new 2D char array containing the processed field
     */

    public char[][] generateHints(final char[][] theField) {

        final int rowCount = theField.length;
        final int columnCount = theField[0].length;

        final char[][] result = new char[rowCount][columnCount];

        for (int row = 0; row < rowCount; row++) {
            for (int column = 0; column < columnCount; column++) {

                if (theField[row][column] == '*') {
                    result[row][column] = '*';
                } else {
                    final int mineCount =
                            myMineChecker.countAdjacentMines(theField, row, column);

                    result[row][column] = (char) ('0' + mineCount);
                }
            }
        }
        return result;
    }
}