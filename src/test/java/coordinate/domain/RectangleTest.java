package coordinate.domain;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class RectangleTest {
    @Test
    void 좌표값_3개가_중복되는_경우() {
        Points points = new Points(Arrays.asList(new Point(1, 10), new Point(10, 10), new Point(1, 1), new Point(1, 1)));
        assertThatThrownBy(() -> new Rectangle(points)).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 좌표값_4개가_중복되는_경우() {
        Points points = new Points(Arrays.asList(new Point(1, 10), new Point(1, 10), new Point(1, 1), new Point(1, 1)));
        assertThatThrownBy(() -> new Rectangle(points)).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 사각형_넓이_구하기() {
        Points points = new Points(Arrays.asList(new Point(0, 5), new Point(0, 0), new Point(5, 0), new Point(5, 5)));
        Rectangle rectangle = new Rectangle(points);
        assertThat(rectangle.area()).isEqualTo(25);
    }
}
