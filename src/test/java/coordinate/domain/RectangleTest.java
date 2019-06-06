package coordinate.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.offset;
import static org.junit.jupiter.api.Assertions.assertThrows;

class RectangleTest {
    private Points points;
    private Rectangle rectangle;

    @BeforeEach
    void setUp() {
        points = Points.create();
        points.addPoint(Point.create(10, 10));
        points.addPoint(Point.create(22, 10));
        points.addPoint(Point.create(22, 18));
        points.addPoint(Point.create(10, 18));
    }

    @Test
    void 사각형_넓이_구하기() {
        rectangle = Rectangle.create(points);
        assertThat(rectangle.getArea()).isEqualTo(96, offset(0.00099));
    }

    @Test
    void 사각형이_아닐때() {
        Points point = Points.create();
        point.addPoint(Point.create(0, 0));
        point.addPoint(Point.create(1, 4));
        point.addPoint(Point.create(5, 0));
        point.addPoint(Point.create(4, 4));

        assertThrows(IllegalArgumentException.class, () -> {
            rectangle = Rectangle.create(point);
        });
    }
}
