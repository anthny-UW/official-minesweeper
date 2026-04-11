/*
 * TCSS 360 - Assignment 1 Minesweeper
 * Official Solution File
 * Spring 2026
 */

package test.java.team.official;

import main.java.team.official.HintGenerator;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Unit tests for the HintGenerator class.
 *
 * @author Anthony Co
 * @author Ibrahim Mohamud
 * @author Jackson Steger
 * @version 4/11/2026
 */

public class HintGeneratorTest {

    private HintGenerator myGenerator;

    @Before
    public void setUp() {
        myGenerator = new HintGenerator();
    }

    @Test
    public void testGenerateHints_generalField_correctHintsForAllCells() {
        char[][] field = {
                {'*', '.', '.', '*'},
                {'.', '.', '*', '.'},
                {'.', '.', '.', '.'},
                {'*', '.', '.', '.'}
        };
        char[][] result = myGenerator.generateHints(field);

        // row 0
        assertEquals('*', result[0][0]);
        assertEquals('2', result[0][1]);
        assertEquals('2', result[0][2]);
        assertEquals('*', result[0][3]);
        // row 1
        assertEquals('1', result[1][0]);
        assertEquals('2', result[1][1]);
        assertEquals('*', result[1][2]);
        assertEquals('2', result[1][3]);
        // row 2
        assertEquals('1', result[2][0]);
        assertEquals('2', result[2][1]);
        assertEquals('1', result[2][2]);
        assertEquals('1', result[2][3]);
        // row 3
        assertEquals('*', result[3][0]);
        assertEquals('1', result[3][1]);
        assertEquals('0', result[3][2]);
        assertEquals('0', result[3][3]);
    }

    @Test
    public void testGenerateHints_singleMine_producesStar() {
        char[][] field = {{'*'}};
        char[][] result = myGenerator.generateHints(field);
        assertEquals('*', result[0][0]);
    }

    @Test
    public void testGenerateHints_singleEmpty_producesZero() {
        char[][] field = {{'.'}};
        char[][] result = myGenerator.generateHints(field);
        assertEquals('0', result[0][0]);
    }

    @Test
    public void testGenerateHints_noMines_allCellsAreZero() {
        char[][] field = {
                {'.', '.', '.'},
                {'.', '.', '.'},
                {'.', '.', '.'}
        };
        char[][] result = myGenerator.generateHints(field);
        for(char[] row : result) {
            for (char cell : row) {
                assertEquals('0', cell);
            }
        }
    }

    @Test
    public void testGenerateHints_middleCellSurroundedByMines_middleCellIsEight() {
        char[][] field = {
                {'*', '*', '*'},
                {'*', '.', '*'},
                {'*', '*', '*'}
        };
        char[][] result = myGenerator.generateHints(field);

        assertEquals('*', result[0][0]);
        assertEquals('*', result[0][1]);
        assertEquals('*', result[1][0]);
        assertEquals('8', result[1][1]);
        assertEquals('*', result[0][2]);
        assertEquals('*', result[2][2]);
    }

    @Test
    public void testGenerateHints_mineAtCorner_AdjacentCellsAreOne() {
        char[][] field = {
                {'*', '.', '.'},
                {'.', '.', '.'},
                {'.', '.', '.'}
        };
        char[][] result = myGenerator.generateHints(field);

        assertEquals('*', result[0][0]);
        assertEquals('1', result[0][1]);
        assertEquals('1', result[1][0]);
        assertEquals('1', result[1][1]);
        assertEquals('0', result[0][2]);
        assertEquals('0', result[2][2]);
    }
}
