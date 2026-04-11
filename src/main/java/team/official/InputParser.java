package main.java.team.official;

import java.util.Scanner;

/**
 * Reads a Minesweeper field from input and returns it as a 2D char array.
 *
 * Author: Anthony Co
 */

public final class InputParser {

    public char[][] readField(Scanner sc, int rows, int cols) {
        char[][] field = new char[rows][cols];

        sc.nextLine(); // consumes the blank line before the field

        for (int r = 0; r < rows; r++) {
            field[r] = sc.nextLine().toCharArray();
        }

        return field;
    }
}
