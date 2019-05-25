package coordinatecalculator.domain;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.offset;
import static org.junit.jupiter.api.Assertions.assertThrows;

class TriangleTest {
    @Test
    void 좌표가_한_줄에_있는_경우() {
        List<Point> points = new ArrayList<>(PointTest.triangle);
        points.set(2, Point.of(0, 2));

        assertThrows(IllegalArgumentException.class, () -> {
            new Triangle(points);
        });
    }

    @Test
    void 넓이() {
        AbstractFigure triangle = new Triangle(PointTest.triangle);
        assertThat(triangle.area()).isEqualTo(0.5, offset(0.001));
    }
}