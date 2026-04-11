package main.java.team.official;

/**
 * Provides helper methods for checking mines and counting adjacent mines.
 *
 * Author: Anthony Co
 */
public final class Minefield {

    /**
     * Returns true if the given cell contains a mine.
     */
    public boolean isMine(char[][] field, int r, int c) {
        if (r < 0 || r >= field.length || c < 0 || c >= field[0].length) {
            return false;
        }
        return field[r][c] == '*';
    }

    /**
     * Counts the number of mines adjacent to the given cell.
     */
    public int countAdjacentMines(char[][] field, int r, int c) {
        int count = 0;

        int[][] dirs = {     // all directions around the cell
                {-1, -1}, {-1, 0}, {-1, 1},
                { 0, -1},          { 0, 1},
                { 1, -1}, { 1, 0}, { 1, 1}
        };

        for (int[] d : dirs) {
            int nr = r + d[0];
            int nc = c + d[1];
            if (isMine(field, nr, nc)) {
                count++;
            }
        }

        return count;
    }
}
