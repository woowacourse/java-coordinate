package coordinate;

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
                new Points(Arrays.asList(
                        new Point(0, 0),
                        new Point(0, 1),
                        new Point(0, 0)))));
    }

    @Test
    void check_same_slope() {
        Triangle triangle = new Triangle(
                new Points(Arrays.asList(
                        new Point(1, 2),
                        new Point(2, 3),
                        new Point(3, 4))));
        assertThat(triangle.checkSameSlope()).isTrue();
    }
}
