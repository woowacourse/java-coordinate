package coordinatecalculator;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class RectangleTest {
    Point p1 = Point.of(0, 0);
    Point p2 = Point.of(0, 1);
    Point p3 = Point.of(1, 0);
    Point p4 = Point.of(1, 1);
    List<Point> answer1 = Arrays.asList(p1, p2, p3, p4);

    @Test
    void 정렬_검사() {
        Point a = Point.of(1, 0);
        Point b = Point.of(0, 1);
        Point c = Point.of(1, 1);
        Point d = Point.of(0, 0);
        List<Point> points = Arrays.asList(a, b, c, d);
        new Rectangle(points);

        assertThat(points).isEqualTo(answer1);
    }

    @Test
    void 넓이() {
        Rectangle answer2 = new Rectangle(answer1);
        assertThat(answer2.area()).isEqualTo(1);
    }
}