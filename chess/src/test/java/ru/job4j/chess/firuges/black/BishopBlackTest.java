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
        BishopBlack bishopBlack = new BishopBlack(Cell.D4);
//        bishopBlack.way(Cell.C1, Cell.G5);
        Cell[] way = {Cell.D2, Cell.E3, Cell.F4, Cell.G5};
        assertThat(bishopBlack.way(Cell.D4, Cell.D7), is (way));
    }

    public void testIsDiagonal() {

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