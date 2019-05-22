package coordinate.domain;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

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
}
