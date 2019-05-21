package coordinate;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class RectangleTest {
    @Test
    void notRectangleTest() {
        assertThrows(IllegalArgumentException.class, () -> new Rectangle(new Points(Arrays.asList(
                new Point(0, 0),
                new Point(5, 0),
                new Point(5, 2),
                new Point(1,2))))
        );
    }

    @Test
    void calculateAreaTest() {
        Rectangle rectangle = new Rectangle(
                new Points(Arrays.asList(
                    new Point(0, 0),
                    new Point(5, 0),
                    new Point(5, 2),
                    new Point(0,2)))
        );
        assertThat(rectangle.area()).isEqualTo(10);
    }
}

