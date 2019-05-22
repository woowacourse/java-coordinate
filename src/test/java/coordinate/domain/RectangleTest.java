package coordinate.domain;

import org.assertj.core.data.Offset;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class RectangleTest {
    @Test
    void nullTest() {
        assertThrows(IllegalArgumentException.class, () -> new Rectangle(null));
    }

    @Test
    void numLinesOverTest() {
        assertThrows(IllegalArgumentException.class, () -> new Rectangle(
                new Lines(Arrays.asList(
                        new Line(new Point(0, 0), new Point(5, 0)),
                        new Line(new Point(5, 0), new Point(5, 1)),
                        new Line(new Point(5, 1), new Point(0, 2)),
                        new Line(new Point(0, 2), new Point(0, 4)),
                        new Line(new Point(0, 2), new Point(0, 8))
                ))
        ));
    }

    @Test
    void numLinesUnderTest() {
        assertThrows(IllegalArgumentException.class, () -> new Rectangle(
                new Lines(Arrays.asList(
                        new Line(new Point(0, 0), new Point(5, 0)),
                        new Line(new Point(5, 0), new Point(5, 1)),
                        new Line(new Point(5, 1), new Point(0, 2))
                ))
        ));
    }

    @Test
    void invalidRectangleTest() {
        assertThrows(IllegalArgumentException.class, () -> new Rectangle(
                new Lines(Arrays.asList(
                        new Line(new Point(0, 0), new Point(5, 0)),
                        new Line(new Point(5, 0), new Point(5, 1)),
                        new Line(new Point(5, 1), new Point(0, 2)),
                        new Line(new Point(0, 2), new Point(0, 0))
                ))
        ));
    }

    @Test
    void areaTest() {
        Rectangle rectangle = new Rectangle(
                new Lines(Arrays.asList(
                        new Line(new Point(0, 0), new Point(5, 0)),
                        new Line(new Point(5, 0), new Point(5, 1)),
                        new Line(new Point(5, 1), new Point(0, 1)),
                        new Line(new Point(0, 1), new Point(0, 0))
                ))
        );
        assertThat(rectangle.area()).isEqualTo(5.0, Offset.offset(0.001));
    }
}

