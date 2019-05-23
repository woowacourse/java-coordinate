package coordinatecalculator;

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
        p1 = new Point(0, 0);
        p2 = new Point(10, 10);
        p3 = new Point(4, 8);
        triangle = new Triangle(p1, p2, p3);
        assertThat(triangle.area()).isEqualTo(20, epsilon);
    }

    @Test
    void colinearCase() {
        p1 = new Point(0, 0);
        p2 = new Point(4, 4);
        p3 = new Point(8, 8);
        triangle = new Triangle(p1, p2, p3);
        assertThat(triangle.area()).isEqualTo(0, epsilon);
    }
}