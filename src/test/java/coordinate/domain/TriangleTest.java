package coordinate.domain;

import coordinate.domain.figure.Triangle;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.offset;

class TriangleTest {
    List<Point> points;

    @Test
    public void 넓이가_6인_직각삼각형을_생성하고_넓이를_제대로_반환하는지() {
        points = Arrays.asList(
                Point.of(0, 0),
                Point.of(0, 3),
                Point.of(4, 0));
        Triangle triangle = Triangle.of(points);
        assertThat(triangle.getArea()).isEqualTo(6.0, offset(0.00099));
    }

    @Test
    public void 넓이가_2인_삼각형을_생성하고_넓이를_제대로_반환하는지() {
        points = Arrays.asList(
                Point.of(0, 0),
                Point.of(2, 0),
                Point.of(1, 2));
        Triangle triangle = Triangle.of(points);
        assertThat(triangle.getArea()).isEqualTo(2.0, offset(0.00099));
    }
}