package coordinate.domain;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.offset;

public class RectangleTest {
    @Test
    void 삼각형_넓이_구하기() {
        Rectangle rectangle = Rectangle.create(Point.create(10, 10), Point.create(22, 10),
                Point.create(22, 18), Point.create(10, 18));
        assertThat(rectangle.getArea()).isEqualTo(96, offset(0.00099));
    }
}
