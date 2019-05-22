package coordinate.domain;

import org.assertj.core.data.Offset;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class TriangleTest {
    @Test
    void constructorNullTest() {
        assertThrows(IllegalArgumentException.class, () -> new Triangle(null));
    }

    @Test
    void linesSizeNotThreeTest() {
        assertThrows(IllegalArgumentException.class, () -> new Triangle(
                new Lines(Arrays.asList(
                        new Line(new Point(0, 0), new Point(0, 1)),
                        new Line(new Point(0, 1), new Point(1, 0))
                ))
        ));
    }

    @Test
    void triangleAreaTest() {
        Lines lines = new Lines(Arrays.asList(
                new Line(new Point(0, 0), new Point(2, 0)),
                new Line(new Point(2, 0), new Point(0, 2)),
                new Line(new Point(0, 2), new Point(0, 0))));
        Triangle triangle = new Triangle(lines);
        assertThat(triangle.area()).isEqualTo(2.0, Offset.offset(0.001));
    }
}
