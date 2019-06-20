package coordinatecalculator;

import coordinatecalculator.model.Point;
import coordinatecalculator.model.Triangle;
import org.assertj.core.data.Offset;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.offset;

class TriangleTest {
    final Offset epsilon = offset(0.001);
    Point p1;
    Point p2;
    Point p3;
    Triangle triangle;

    @Test
    void area1() {
        p1 = new Point(1, 1);
        p2 = new Point(15, 15);
        p3 = new Point(4, 8);
        triangle = Triangle.of(p1, p2, p3);
        assertThat(triangle.area()).isEqualTo(28, epsilon);
    }

    @Test
    void colinearCase() {
        p1 = new Point(1, 1);
        p2 = new Point(4, 4);
        p3 = new Point(8, 8);
        triangle = Triangle.of(p1, p2, p3);
        assertThat(triangle.area()).isEqualTo(0, epsilon);
    }
}