package coordinatecalculator;

import coordinatecalculator.model.Figure;
import coordinatecalculator.model.FigureFactory;
import coordinatecalculator.model.Point;
import coordinatecalculator.view.Board;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;

class BoardTest {

    @Test
    void lineTest() {
        Point p1 = Point.of(10, 10);
        Point p2 = Point.of(14, 15);
        Figure figure = FigureFactory.of(Arrays.asList(p1, p2));
        Board board = new Board(figure);
        String expected
                = "24|                                                \n" +
                "  |                                                \n" +
                "22|                                                \n" +
                "  |                                                \n" +
                "20|                                                \n" +
                "  |                                                \n" +
                "18|                                                \n" +
                "  |                                                \n" +
                "16|                                                \n" +
                "  |                           ●                    \n" +
                "14|                                                \n" +
                "  |                                                \n" +
                "12|                                                \n" +
                "  |                                                \n" +
                "10|                   ●                            \n" +
                "  |                                                \n" +
                " 8|                                                \n" +
                "  |                                                \n" +
                " 6|                                                \n" +
                "  |                                                \n" +
                " 4|                                                \n" +
                "  |                                                \n" +
                " 2|                                                \n" +
                "  |                                                \n" +
                "  +――――――――――――――――――――――――――――――――――――――――――――――――\n" +
                " 0    2   4   6   8  10  12  14  16  18  20  22  24";
        assertThat(board.getString()).isEqualTo(expected);
    }

    @Test
    void triangleTest() {
        Point p1 = Point.of(10, 10);
        Point p2 = Point.of(14, 15);
        Point p3 = Point.of(20, 8);
        Figure figure = FigureFactory.of(Arrays.asList(p1, p2, p3));
        Board board = new Board(figure);
        String expected
                = "24|                                                \n" +
                "  |                                                \n" +
                "22|                                                \n" +
                "  |                                                \n" +
                "20|                                                \n" +
                "  |                                                \n" +
                "18|                                                \n" +
                "  |                                                \n" +
                "16|                                                \n" +
                "  |                           ●                    \n" +
                "14|                                                \n" +
                "  |                                                \n" +
                "12|                                                \n" +
                "  |                                                \n" +
                "10|                   ●                            \n" +
                "  |                                                \n" +
                " 8|                                       ●        \n" +
                "  |                                                \n" +
                " 6|                                                \n" +
                "  |                                                \n" +
                " 4|                                                \n" +
                "  |                                                \n" +
                " 2|                                                \n" +
                "  |                                                \n" +
                "  +――――――――――――――――――――――――――――――――――――――――――――――――\n" +
                " 0    2   4   6   8  10  12  14  16  18  20  22  24";
        assertThat(board.getString()).isEqualTo(expected);
    }

    @Test
    void rectangleTest() {
        Point p1 = Point.of(10, 10);
        Point p2 = Point.of(22, 10);
        Point p3 = Point.of(22, 18);
        Point p4 = Point.of(10, 18);
        Figure figure = FigureFactory.of(Arrays.asList(p1, p2, p3, p4));
        Board board = new Board(figure);
        String expected
                = "24|                                                \n" +
                "  |                                                \n" +
                "22|                                                \n" +
                "  |                                                \n" +
                "20|                                                \n" +
                "  |                                                \n" +
                "18|                   ●                       ●    \n" +
                "  |                                                \n" +
                "16|                                                \n" +
                "  |                                                \n" +
                "14|                                                \n" +
                "  |                                                \n" +
                "12|                                                \n" +
                "  |                                                \n" +
                "10|                   ●                       ●    \n" +
                "  |                                                \n" +
                " 8|                                                \n" +
                "  |                                                \n" +
                " 6|                                                \n" +
                "  |                                                \n" +
                " 4|                                                \n" +
                "  |                                                \n" +
                " 2|                                                \n" +
                "  |                                                \n" +
                "  +――――――――――――――――――――――――――――――――――――――――――――――――\n" +
                " 0    2   4   6   8  10  12  14  16  18  20  22  24";
        assertThat(board.getString()).isEqualTo(expected);
    }
}