package coordinatecalculator.domain;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.offset;
import static org.junit.jupiter.api.Assertions.assertThrows;

class PointTest {
    @Test
    void 좌표_입력범위() {
        assertThrows(IllegalArgumentException.class, () -> {
            Point.of(-1, 0);
        });
        assertThrows(IllegalArgumentException.class, () -> {
            Point.of(0, -1);
        });
        assertThrows(IllegalArgumentException.class, () -> {
            Point.of(25, 0);
        });
        assertThrows(IllegalArgumentException.class, () -> {
            Point.of(0, 25);
        });
    }

    @Test
    void 길이() {
        Point point1 = Point.of(0, 0);
        Point point2 = Point.of(1, 1);
        assertThat(point1.getDistance(point2)).isEqualTo(1.414, offset(0.001));
    }
}