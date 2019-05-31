package coordinate.domain;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.offset;

public class AbstractPointTest {

    @Test
    void subtract_() {
        AbstractPoint p1 = DefaultPoint.ofInts(1, 2);
        AbstractPoint p2 = DefaultPoint.ofInts(1, 1);

        assertThat(p1.subtract(p2)).isEqualTo(Vector2.of(0, 1));
    }

    @Test
    void distance() {
        AbstractPoint p1 = DefaultPoint.ofInts(0, 0);
        AbstractPoint p2 = DefaultPoint.ofInts(1, 1);

        assertThat(p1.distance(p2)).isEqualTo(1.414, offset(0.00099));
    }
}
