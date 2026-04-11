/*
 * TCSS 360 - Assignment 1 Minesweeper
 * Official Solution File
 * Spring 2026
 */

package main.java.team.official;

import java.util.Scanner;

/**
 * The InputParser class reads a Minesweeper field from input and returns it
 * as a 2D character array.
 *
 * @author Anthony Co
 * @author Ibrahim Mohamud
 * @author Jackson Steger
 * @version 4/10/2026
 */

public final class InputParser {

    /**
     * Reads a Minesweeper field of the specified size from the provided Scanner.
     *
     * @param theInputScanner the Scanner used to read input
     * @param theRows the number of rows in the field
     * @param theColumns the number of columns in the field
     * @return a 2D char array representing the field
     */

    public char[][] readField(final Scanner theInputScanner,
                              final int theRows,
                              final int theColumns) {

        final char[][] field = new char[theRows][theColumns];

        // consume leftover newline after reading dimensions
        theInputScanner.nextLine();

        for (int row = 0; row < theRows; row++) {
            field[row] = theInputScanner.nextLine().toCharArray();
        }

        return field;
    }
}
