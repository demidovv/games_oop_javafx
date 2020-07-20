package ru.job4j.chess.firuges.black;

import junit.framework.TestCase;
import org.junit.Assert;
import org.junit.FixMethodOrder;
import org.junit.Test;
import ru.job4j.chess.firuges.Cell;
import ru.job4j.chess.firuges.Figure;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.*;


public class BishopBlackTest extends TestCase {

    public void testWay() {
        BishopBlack bishopBlack = new BishopBlack(Cell.C3);
        Cell[] way = {Cell.D4, Cell.E5, Cell.F6, Cell.G7};
        assertThat(bishopBlack.way(Cell.C3, Cell.G7), is (way));
    }

    public void testIsDiagonal() {
        BishopBlack bishopBlack = new BishopBlack(Cell.D6);
        assertThat(bishopBlack.isDiagonal(Cell.D6, Cell.G3), is (true));
    }

    public void testCopy() {
        BishopBlack bishopBlack = new BishopBlack(Cell.D4);
        assertThat(bishopBlack.copy(Cell.E5).position(), is (Cell.findBy(4,4)));
        System.out.println(Cell.E5.x + Cell.E5.y);
    }

    public void testPosition() {
        BishopBlack bishopBlack = new BishopBlack(Cell.D4);
        assertThat(bishopBlack.position(), is (Cell.findBy(3,3)));
    }
}