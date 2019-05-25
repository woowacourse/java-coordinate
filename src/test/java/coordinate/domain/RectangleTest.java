package coordinate.domain;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class RectangleTest {
    @Test
    void 사각형_넓이_구하기() {
        Points points = new Points(Arrays.asList(
                new Point(1, 5),
                new Point(1, 1),
                new Point(5, 1),
                new Point(5, 5)));
        Rectangle rectangle = new Rectangle(points);
        assertThat(rectangle.calculateResult()).isEqualTo(16);
    }

    @Test
    void 직사각형이_아닌_경우() {
        Points points = new Points(Arrays.asList(
                new Point(1, 5),
                new Point(1, 1),
                new Point(5, 1),
                new Point(5, 4)));
        assertThatThrownBy(() -> new Rectangle(points)).isInstanceOf(IllegalArgumentException.class);
    }
}