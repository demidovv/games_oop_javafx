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
            Cell[] steps = this.figures[index].way(source, dest);            // то получаем его ходы до клетки Cell dest
                                                                            // проверяем, что массив way не заполнен другими объектами класса Figure
            if (steps.length > 0 && steps[steps.length - 1].equals(dest)) { // шаги есть и последний шаг соответствует пункту назначения
                for (int i = 0; i < steps.length; i++) {
                    for (int j = 0; j < 32; j++) {
                        if (this.figures[j] != null && this.figures[j].position().equals(steps[i])) {
                            return false;
                        }
                    }
                }
                rst = true;
                this.figures[index] = this.figures[index].copy(dest);
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
