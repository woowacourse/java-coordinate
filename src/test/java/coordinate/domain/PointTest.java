package coordinate.domain;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class PointTest {

    @Test
    void x좌표_사이의_거리를_구하는지_테스트() {
        Point point = new Point(5, 5);
        assertThat(point.getDeltaXTo(new Point(10, 5))).isEqualTo(5);
    }

    @Test
    void y좌표_사이의_거리를_구하는지_테스트() {
        Point point = new Point(5, 5);
        assertThat(point.getDeltaYTo(new Point(5, 10))).isEqualTo(5);
    }
}