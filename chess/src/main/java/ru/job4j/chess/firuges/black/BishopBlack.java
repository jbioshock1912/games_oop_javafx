package ru.job4j.chess.firuges.black;

import ru.job4j.chess.Logic;
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

        int stepsNumber = Math.abs(dest.x - source.x);
        Cell[] steps = new Cell[stepsNumber];
        int deltaX = 0;
        int deltaY = 0;
        int x;
        int y;

        if (dest.x > source.x && dest.y > source.y) {
            deltaX = 1;
            deltaY = 1;
        } else if (dest.x > source.x && dest.y < source.y) {
            deltaX = 1;
            deltaY = -1;
        } else if (dest.x < source.x && dest.y < source.y) {
            deltaX = -1;
            deltaY = -1;
        } else if (dest.x < source.x && dest.y > source.y) {
            deltaX = -1;
            deltaY = 1;
        }

        for (int index = 0; index < stepsNumber; index++) {
            x = source.x + deltaX + index * deltaX;
            y = source.y + deltaY + index * deltaY;
            steps[index] = Cell.findBy(x, y);
        }
        return steps;

    }

    public boolean isDiagonal(Cell source, Cell dest) {

        if (Math.abs(source.x - dest.x) == (Math.abs(source.y - dest.y))) {
            return true;
        }
        return false;
    }

    @Override
    public Figure copy(Cell dest) {
        return new BishopBlack(dest);
    }
}
