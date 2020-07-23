package ru.job4j.chess;

import ru.job4j.chess.firuges.Cell;
import ru.job4j.chess.firuges.Figure;

import java.util.Arrays;
import java.util.Optional;

/**
 * //TODO add comments.
 *
 * @author Petr Arsentev (parsentev@yandex.ru)
 * @version $Id$
 * @since 0.1
 */
public class Logic {
    private final Figure[] figures = new Figure[32];
    private int index = 0;

    public void add(Figure figure) {

        this.figures[this.index++] = figure;
    }

    public boolean move(Cell source, Cell dest) {
        boolean rst = false;
        int index = this.findBy(source);                                     // получаем индекс фигуры в массиве figures
        if (index != -1) {                                                   // если объект найден,
            try {
                Cell[] steps = this.figures[index].way(source, dest);            // то получаем его ходы до клетки Cell dest
                if (steps.length > 0 && steps[steps.length - 1].equals(dest)            // проверяем, что массив way не заполнен другими объектами класса Figure
                        && freeWay(steps)) {                                            // шаги есть и последний шаг соответствует пункту назначения
                    rst = true;
                    this.figures[index] = this.figures[index].copy(dest);
                }
            } catch (IllegalStateException e) {
                e.printStackTrace();
            }
        }
        return rst;
    }


    public void clean() {
        for (int position = 0; position != this.figures.length; position++) {
            this.figures[position] = null;
        }
        this.index = 0;
    }

    private boolean freeWay (Cell[] steps) {        //проверка свободного пути
        for (Cell cell: steps) {
            if (findBy(cell) != -1) {
                return false;
            }
        }
        return true;
    }

    private int findBy(Cell cell) {
        int rst = -1;
        for (int index = 0; index != this.figures.length; index++) {
            if (this.figures[index] != null && this.figures[index].position().equals(cell)) {
                rst = index;
                break;
            }
        }
        return rst;
    }

    @Override
    public String toString() {
        return "Logic{" +
                "figures=" + Arrays.toString(this.figures) +
                '}';
    }
}
