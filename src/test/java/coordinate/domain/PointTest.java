package coordinate.domain;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.offset;

public class PointTest {

    @Test
    void subtract_() {
        Point p1 = new DefaultPoint(1, 2);
        Point p2 = new DefaultPoint(1, 1);

        assertThat(p1.subtract(p2)).isEqualTo(Vector2.of(0, 1));
    }

    @Test
    void distance() {
        Point p1 = new DefaultPoint(0, 0);
        Point p2 = new DefaultPoint(1, 1);

        assertThat(p1.distance(p2)).isEqualTo(1.414, offset(0.00099));
    }
}
