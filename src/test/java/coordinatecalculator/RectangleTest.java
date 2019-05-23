package coordinatecalculator;

import org.assertj.core.data.Offset;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.offset;

class RectangleTest {
    final Offset epsilon = offset(0.001);
    Point p1;
    Point p2;
    Point p3;
    Point p4;
    Rectangle rectangle;

    @Test
    void area1() {
        p1 = new Point(0, 0);
        p2 = new Point(0, 10);
        p3 = new Point(10, 0);
        p4 = new Point(10, 10);
        rectangle = new Rectangle(p1, p2, p3, p4);
        assertThat(rectangle.area()).isEqualTo(100, epsilon);
    }

    @Test
    void area2() {
        p1 = new Point(1, 1);
        p2 = new Point(3, 5);
        p3 = new Point(4, 0);
        p4 = new Point(5, 2);
        rectangle = new Rectangle(p1, p2, p3, p4);
        assertThat(rectangle.area()).isEqualTo(10.5, epsilon);
    }
}