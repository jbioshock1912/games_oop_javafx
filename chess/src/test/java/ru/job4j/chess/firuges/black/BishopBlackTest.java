package ru.job4j.chess.firuges.black;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import ru.job4j.chess.firuges.Cell;
import ru.job4j.chess.firuges.Figure;

import static org.junit.Assert.*;
import static ru.job4j.chess.firuges.Cell.*;


public class BishopBlackTest {

    @Test
    public void position() {
        BishopBlack test = new BishopBlack(Cell.B1);
        test.position();
        assertEquals(test.position(), Cell.B1);
    }

    @Test
    public void way() {
        BishopBlack test = new BishopBlack(Cell.C1);
        Cell[] wayTest = test.way(Cell.C1, Cell.G5);
        Cell[] result = {D2, E3, F4, G5, null, null, null};
        Assert.assertArrayEquals(result, wayTest);
    }


    @Test
    public void copy() {
        Figure test1 = new BishopBlack(Cell.B1);
        Figure test2 = test1.copy(Cell.A1);
        Assert.assertEquals(test2.position(), Cell.A1);
    }

    @Test
    public void testIsDiagonalWhenTrue() {
        Cell source = B1;
        Cell distance = E4;
        BishopBlack test = new BishopBlack(Cell.B1);
        boolean result = test.isDiagonal(B1, E4);
        assertTrue(result);
    }

    @Test
    public void testIsDiagonalWhenFalse() {
        BishopBlack test = new BishopBlack(Cell.B1);
        boolean result = test.isDiagonal(B1, B4);
        assertFalse(false);

    }
}
