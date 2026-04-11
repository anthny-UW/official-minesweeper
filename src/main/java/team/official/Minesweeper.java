/*
 * TCSS 360 - Minesweeper Project
 * Official Solution File
 * Author: Anthony Co
 */

package main.java.team.official;

import java.util.Scanner;

/**
 * The Minesweeper class contains the main program loop for processing
 * Minesweeper fields. It delegates input parsing and hint generation to
 * helper classes and prints the formatted results.
 *
 * @author Anthony Co
 * @version 10 April 2026
 */

public final class Minesweeper {

    /**
     * The entry point for the Minesweeper program.
     *
     * @param theArgs command-line arguments (unused)
     */

    public static void main(final String[] theArgs) {
        final Scanner inputScanner = new Scanner(System.in);
        final InputParser parser = new InputParser();
        final HintGenerator generator = new HintGenerator();

        int fieldNumber = 1;

        while (true) {
            final int rows = inputScanner.nextInt();
            final int columns = inputScanner.nextInt();

            if (rows == 0 && columns == 0) {
                break;
            }

            final char[][] field = parser.readField(inputScanner, rows, columns);
            final char[][] result = generator.generateHints(field);

            System.out.println("Field #" + fieldNumber + ":");

            for (int r = 0; r < rows; r++) {
                System.out.println(new String(result[r]));
            }

            fieldNumber++;
            System.out.println();
        }

        inputScanner.close();
    }
}
