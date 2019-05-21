package coordinate;

import org.assertj.core.data.Offset;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class TriangleTest {
    @Test
    void constructor_null_test() {
        assertThrows(IllegalArgumentException.class, () -> new Triangle(null));
    }

    @Test
    void points_size_not_three_test() {
        assertThrows(IllegalArgumentException.class, () -> new Triangle(
                new Lines(Arrays.asList(
                        new Line(new Point(0, 0), new Point(0, 1)),
                        new Line(new Point(0, 1), new Point(1, 0))))));
    }

    @Test
    void check_same_slope() {
        Triangle triangle = new Triangle(
                new Lines(Arrays.asList(
                        new Line(new Point(1, 2), new Point(2, 3)),
                        new Line(new Point(2, 3), new Point(3, 4)),
                        new Line(new Point(3, 4), new Point(1, 2)))));
        assertThat(triangle.checkSameSlope()).isTrue();
    }

    @Test
    void triangle_area_test() {
        Triangle triangle = new Triangle(
                new Lines(Arrays.asList(
                        new Line(new Point(0, 0), new Point(2, 0)),
                        new Line(new Point(2, 0), new Point(0, 2)),
                        new Line(new Point(0, 2), new Point(0, 0)))));
        assertThat(triangle.area()).isEqualTo(2.0, Offset.offset(0.001));
    }
}
