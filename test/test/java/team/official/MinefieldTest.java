/*
 * TCSS 360 - Assignment 1 Minesweeper
 * Official Solution File
 * Spring 2026
 */

package test.java.team.official;

import main.java.team.official.Minefield;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Unit tests for the Minefield class.
 *
 * @author Anthony Co
 * @author Ibrahim Mohamud
 * @author Jackson Steger
 * @version 4/10/2026
 */

public class MinefieldTest {

    private Minefield myMineField;
    private char[][] myGivenField;

    @Before
    public void setUp() {
        myMineField = new Minefield();
        myGivenField = new char[][] {
                {'*', '.', '.', '*'},
                {'.', '.', '*', '.'},
                {'.', '.', '.', '.'},
                {'*', '.', '.', '.'}
        };
    }

    // isMine()

    @Test
    public void testIsMine_TopLeftCorner_ReturnTrue() {
        assertTrue(myMineField.isMine(myGivenField,0,0));
    }

    @Test
    public void testIsMine_TopRightCorner_ReturnTrue() {
        assertTrue(myMineField.isMine(myGivenField,0,3));
    }

    @Test
    public void testIsMine_BottomLeftCorner_ReturnTrue() {
        assertTrue(myMineField.isMine(myGivenField,3,0));
    }

    @Test
    public void testIsMine_BottomRightCorner_ReturnFalse() {
        //Should return false, there is no mine at (3, 3)
        assertFalse(myMineField.isMine(myGivenField,3,3));
    }

    @Test
    public void testIsMine_OutOfBounds_ReturnFalse() {
        //Should return false
        assertFalse(myMineField.isMine(myGivenField,-1,0));
    }

    // countAdjacentMines()

    @Test
    public void testCountAdjacentMines_OneMine() {
        //There should be one mine adjacent to cell (1, 0)
        assertEquals(1, myMineField.countAdjacentMines(myGivenField, 1, 0));
    }

    @Test
    public void testCountAdjacentMines_TwoMines() {
        //There should be two mines adjacent to cell (0, 2)
        assertEquals(2, myMineField.countAdjacentMines(myGivenField, 0, 2));
    }

    @Test
    public void testCountAdjacentMines_NoMines() {
        //There should be no mines adjacent to cell (3, 3)
        assertEquals(0, myMineField.countAdjacentMines(myGivenField, 3, 3));
    }

    @Test
    public void testCountAdjacentMines_CellSurroundedByAllMines() {
        char[][] field = {
                {'*', '*', '*'},
                {'*', '.', '*'},
                {'*', '*', '*'}
        };
        assertEquals(8, myMineField.countAdjacentMines(field, 1, 1));
    }

    @Test
    public void testCountAdjacentMines_CenterCellNoAdjacentMines() {
        char[][] field = {
                {'.', '.', '.'},
                {'.', '.', '.'},
                {'.', '.', '.'}
        };
        assertEquals(0, myMineField.countAdjacentMines(field, 1, 1));
    }
}
