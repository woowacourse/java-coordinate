package coordinatecalculator.domain;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.offset;
import static org.junit.jupiter.api.Assertions.assertThrows;

class TriangleTest {
    @Test
    void 좌표가_한_줄에_있는_경우() {
        List<Point> points = Arrays.asList(PointTest.zero_zero, PointTest.one_one, Point.of(2, 2));

        assertThrows(IllegalArgumentException.class, () -> {
            new Triangle(points);
        });
    }

    @Test
    void 넓이() {
        List<Point> points = Arrays.asList(PointTest.zero_zero, PointTest.one_one, Point.of(2, 0));
        Figure triangle = new Triangle(points);

        assertThat(triangle.area()).isEqualTo(1, offset(0.001));
    }
}