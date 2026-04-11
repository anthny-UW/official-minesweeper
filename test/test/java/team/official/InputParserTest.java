/*
 * TCSS 360 - Assignment 1 Minesweeper
 * Official Solution File
 * Spring 2026
 */

package test.java.team.official;

import main.java.team.official.InputParser;
import org.junit.Before;
import org.junit.Test;

import java.util.Scanner;

import static org.junit.Assert.assertEquals;

/**
 * Unit tests for the InputParser class.
 *
 * @author Anthony Co
 * @author Ibrahim Mohamud
 * @author Jackson Steger
 * @version 4/11/2026
 */
public class InputParserTest {

    private InputParser myParser;

    @Before
    public void setUp() {
        myParser = new InputParser();
    }

    @Test
    public void testReadField_generalField_checkDimensionsAndValues() {
        // Field:
        //   * . . .
        //   . . * .
        //   . . . .
        //   * . . .
        Scanner scanner = new Scanner("4 4\n*...\n..*.\n....\n*...\n");
        scanner.nextInt();
        scanner.nextInt();
        char[][] field = myParser.readField(scanner, 4, 4);

        assertEquals(4, field.length);
        assertEquals(4, field[0].length);
        assertEquals('*', field[0][0]);
        assertEquals('.', field[0][1]);
        assertEquals('*', field[1][2]);
        assertEquals('*', field[3][0]);
        assertEquals('.', field[2][2]);
    }

    @Test
    public void testReadField_singleMine_checkDimensionsAndValues() {
        // Field:
        //   *
        Scanner scanner = new Scanner("1 1\n*\n");
        scanner.nextInt();
        scanner.nextInt();
        char[][] field = myParser.readField(scanner, 1, 1);

        assertEquals(1, field.length);
        assertEquals(1, field[0].length);
        assertEquals('*', field[0][0]);
    }

    @Test
    public void testReadField_singleEmpty_checkDimensionsAndValues() {
        // Field:
        //   .
        Scanner scanner = new Scanner("1 1\n.\n");
        scanner.nextInt();
        scanner.nextInt();
        char[][] field = myParser.readField(scanner, 1, 1);

        assertEquals(1, field.length);
        assertEquals(1, field[0].length);
        assertEquals('.', field[0][0]);
    }

    @Test public void testReadField_singleRow_checkDimensionsAndValues() {
        // Field:
        //   * . * . *
        Scanner scanner = new Scanner("1 5\n*.*.*\n");
        scanner.nextInt();
        scanner.nextInt();
        char[][] field = myParser.readField(scanner, 1, 5);

        assertEquals(1, field.length);
        assertEquals(5, field[0].length);
        assertEquals('*', field[0][0]);
        assertEquals('.', field[0][1]);
        assertEquals('*', field[0][2]);
        assertEquals('.', field[0][3]);
        assertEquals('*', field[0][4]);
    }

    @Test
    public void testReadField_singleColumn_checkDimensionsAndValues() {
        // Field:
        //   *
        //   .
        //   *
        //   .
        Scanner scanner = new Scanner("4 1\n*\n.\n*\n.\n");
        scanner.nextInt();
        scanner.nextInt();
        char[][] field = myParser.readField(scanner, 4, 1);

        assertEquals(4, field.length);
        assertEquals(1, field[0].length);
        assertEquals('*', field[0][0]);
        assertEquals('.', field[1][0]);
        assertEquals('*', field[2][0]);
        assertEquals('.', field[3][0]);
    }

    @Test
    public void testReadField_allMines_checkDimensionsAndValues() {
        // Field:
        //   * * *
        //   * * *
        Scanner scanner = new Scanner("2 3\n***\n***\n");
        scanner.nextInt();
        scanner.nextInt();
        char[][] field = myParser.readField(scanner, 2, 3);

        assertEquals(2, field.length);
        assertEquals(3, field[0].length);
        for (char[] row : field) {
            for (char cell : row) {
                assertEquals('*', cell);
            }
        }
    }

    @Test
    public void testReadField_noMines_checkDimensionsAndValues() {
        // Field:
        //   . . .
        //   . . .
        Scanner scanner = new Scanner("2 3\n...\n...\n");
        scanner.nextInt();
        scanner.nextInt();
        char[][] field = myParser.readField(scanner, 2, 3);

        assertEquals(2, field.length);
        assertEquals(3, field[0].length);
        for (char[] row : field) {
            for (char cell : row) {
                assertEquals('.', cell);
            }
        }
    }
}
