package coordinatecalculator.domain;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.offset;
import static org.junit.jupiter.api.Assertions.assertThrows;

class TriangleTest {
    Point point1 = Point.of(0, 0);
    Point point2 = Point.of(1, 1);

    @Test
    void 좌표가_한_줄에_있는_경우() {
        Point point3 = Point.of(2, 2);
        List<Point> points = Arrays.asList(point1, point2, point3);

        assertThrows(IllegalArgumentException.class, () -> {
           new Triangle(points);
        });
    }

    @Test
    void 넓이() {
        Point point3 = Point.of(2, 0);
        List<Point> points = Arrays.asList(point1, point2, point3);
        Shape triangle = new Triangle(points);
        assertThat(triangle.area()).isEqualTo(1, offset(0.001));
    }
}