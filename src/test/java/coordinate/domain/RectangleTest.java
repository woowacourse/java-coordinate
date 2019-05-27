package coordinate.domain;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.offset;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class RectangleTest {

    @Test
    void of_직사각형아닌경우() {
        assertThrows(IllegalArgumentException.class, () -> Rectangle.from(
                Points.from(Arrays.asList(new Point(0, 0), new Point(2, 0), new Point(2, 10), new Point(0, 9)))));
    }

    @Test
    void area_() {
        Points points = Points.from(Arrays.asList(new Point(0, 0), new Point(2, 0), new Point(2, 10), new Point(0, 10)));
        Rectangle rectangle = Rectangle.from(points);

        assertThat(rectangle.area()).isEqualTo(20.0, offset(0.00099));
    }
}
