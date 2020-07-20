package ru.job4j.chess.firuges.black;

import ru.job4j.chess.firuges.Cell;
import ru.job4j.chess.firuges.Figure;

public class BishopBlack implements Figure {
    private final Cell position;

    public BishopBlack(final Cell position) {

        this.position = position;
    }

    @Override
    public Cell position() {

        return this.position;
    }

    @Override
    public Cell[] way(Cell source, Cell dest) {
        if (!isDiagonal(source, dest)) {
            throw new IllegalStateException(
                    String.format("Could not move by diagonal from %s to %s", source, dest)
            );
        }

        int size = source.x > dest.x ? source.x - dest.x: dest.x - source.x;
        Cell[] steps = new Cell[size];
        int deltaX = source.x > dest.x ? -1 : 1;
        int deltaY = source.y > dest.y ? -1 : 1;
        for (int index = 0; index < size; index++) {
            steps[index] = Cell.findBy(source.x + deltaX + index * deltaX, source.y + deltaY + index * deltaY);
        }
        return steps;
    }


    public boolean isDiagonal(Cell source, Cell dest) {
        if (dest.y == source.y - source.x + dest.x || dest.y == source.y + source.x - dest.x) {
            return true;
        }
        return false;
    }

    @Override
    public Figure copy(Cell dest) {

        return new BishopBlack(dest);
    }
}
