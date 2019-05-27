package coordinate.domain;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.offset;

public class RectangleTest {
    @Test
    void 삼각형_넓이_구하기() {
        Points points = Points.create();
        points.addPoint(Point.create(10, 10));
        points.addPoint(Point.create(22, 10));
        points.addPoint(Point.create(22, 18));
        points.addPoint(Point.create(10, 118));

        Rectangle rectangle = Rectangle.create(points);
        assertThat(rectangle.getArea()).isEqualTo(96, offset(0.00099));
    }
}
