package coordinate.domain;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;

public class RectangleTest {

    @Test
    void 사각형_넓이_구하기() {
        Points points = new Points(Arrays.asList(new Point(1, 5), new Point(1, 1), new Point(5, 1), new Point(5, 5)));
        Rectangle rectangle = new Rectangle(points);
        assertThat(rectangle.area()).isEqualTo(16);
    }
}
