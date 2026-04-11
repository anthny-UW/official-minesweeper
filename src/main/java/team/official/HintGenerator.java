package main.java.team.official;

/**
 * Generates the processed Minesweeper output grid.
 * Mines remain '*' and empty cells become '0'–'8' based on adjacent mines.
 *
 * Author: Anthony Co
 */

public final class HintGenerator {

    private final Minefield helper = new  Minefield();

    public char[][] generateHints(char[][] field) {
        int rows = field.length;
        int columns = field[0].length;

        char[][] result = new char[rows][columns];

        for (int r = 0; r < rows; r++) {
            for (int c = 0; c < columns; c++) {

                if (field[r][c] == '*') {   // if a mine, leave it alone
                    result[r][c] = '*';
                } else {
                    int count = helper.countAdjacentMines(field, r, c);   // counts the number of mines around the cell
                    result[r][c] = (char) ('0' + count);
                }
            }
        }
        return result;
    }
}
