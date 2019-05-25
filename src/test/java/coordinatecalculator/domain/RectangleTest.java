package coordinatecalculator.domain;

import org.junit.jupiter.api.Test;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

class RectangleTest {
    Point p1 = Point.of(0, 0);
    Point p2 = Point.of(0, 1);
    Point p3 = Point.of(1, 0);
    Point p4 = Point.of(1, 1);
    List<Point> answer1 = Arrays.asList(p1, p2, p3, p4);

    @Test
    void 좌표_정렬() {
        List<Point> points = Arrays.asList(p2, p4, p3, p1);
        new Rectangle(points);

        assertThat(points).isEqualTo(answer1);
    }

    @Test
    void 직사각형이_아닌_경우() {
        Point p5 = Point.of(1, 2);
        List<Point> points = Arrays.asList(p1, p2, p3, p5);
        assertThrows(IllegalArgumentException.class, () -> {
            new Rectangle(points);
        });
    }

    @Test
    void 넓이() {
        Shape answer2 = new Rectangle(answer1);
        assertThat(answer2.area()).isEqualTo(1);
    }
}