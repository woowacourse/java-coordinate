package coordinate.domain;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class PointTest {
    @Test
    void 거리_계산() {
        Point point1 = new Point(1,1);
        Point point2 = new Point(4,5);

        assertThat(point1.calculateDistance(point2)).isEqualTo(5);
    }
}
