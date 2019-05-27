package coordinate.domain;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.offset;

public class TriangleTest {
    @Test
    void 삼각형_넓이_구하기() {
        Points points = Points.create();
        points.addPoint(Point.create(10, 10));
        points.addPoint(Point.create(14, 15));
        points.addPoint(Point.create(20, 8));

        Triangle triangle = Triangle.create(points);
        assertThat(triangle.getArea()).isEqualTo(29, offset(0.00099));
    }
}
