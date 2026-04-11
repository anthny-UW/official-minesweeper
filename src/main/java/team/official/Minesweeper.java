package main.java.team.official;

import java.util.Scanner;

/**
 * Official Minesweeper Solution
 * This class contains the main minesweeper loop.
 *
 * Author: Anthony Co
 */

public final class Minesweeper {
    static  void main() {
        Scanner sc = new Scanner(System.in);
        InputParser parser = new InputParser();
        HintGenerator generator = new HintGenerator();

        int fieldNumber = 1;

        while (true){
            int rows = sc.nextInt();
            int columns = sc.nextInt();

            if (rows == 0 && columns == 0) {
                break;
            }

            char[][] field = parser.readField(sc, rows, columns); // creates the char[][] minefield
            char[][] result = generator.generateHints(field); // scans the minefield and generates the hints

            System.out.println("Field: #" + fieldNumber + ":");

            for (int r = 0; r < rows; r++) {
                System.out.println(new String(result[r]));
            }

            fieldNumber++;
            System.out.println();
        }



    }
}
