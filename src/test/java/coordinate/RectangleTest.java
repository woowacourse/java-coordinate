package coordinate;

import org.assertj.core.data.Offset;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class RectangleTest {
    @Test
    void notRectangleTest() {
        assertThrows(IllegalArgumentException.class, () -> new Rectangle(
                new Lines(Arrays.asList(
                new Line(new Point(0, 0), new Point(5, 0)),
                new Line(new Point(5, 0), new Point(5, 1)),
                new Line(new Point(5, 1), new Point(0, 2)),
                new Line(new Point(0, 2), new Point(0, 0)))))
        );
    }

    @Test
    void calculateAreaTest() {
        Rectangle rectangle = new Rectangle(
                new Lines(Arrays.asList(
                    new Line(new Point(0, 0), new Point(5, 0)),
                    new Line(new Point(5, 0), new Point(5, 2)),
                    new Line(new Point(5, 2), new Point(0, 2)),
                    new Line(new Point(0, 2), new Point(0, 0))))
        );
        assertThat(rectangle.area()).isEqualTo(10);
    }

    @Test
    void calculateAreaTest2() {
        Rectangle rectangle = new Rectangle(
                new Lines(Arrays.asList(
                        new Line(new Point(1, 0), new Point(2, 1)),
                        new Line(new Point(2, 1), new Point(1, 2)),
                        new Line(new Point(1, 2), new Point(0, 1)),
                        new Line(new Point(0, 1), new Point(1, 0))))
        );
        assertThat(rectangle.area()).isEqualTo(2, Offset.offset(0.001));
    }
}

