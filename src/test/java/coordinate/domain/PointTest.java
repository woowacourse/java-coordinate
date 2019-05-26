package coordinate.domain;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class PointTest {

    @Test
    void subtract_() {
        Point p1 = new Point(1, 2);
        Point p2 = new Point(1, 1);

        assertThat(p1.subtract(p2)).isEqualTo(Vector2.of(0, 1));
    }


}
