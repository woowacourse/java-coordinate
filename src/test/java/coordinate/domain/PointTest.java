package coordinate.domain;

import org.assertj.core.data.Offset;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class PointTest {
    @Test
    void 포인트_생성() {
        Point point = new Point(1, 2);
        assertThat(point).isEqualTo(new Point(1,2));
    }

    @Test
    void X좌표_범위_초과() {
        assertThrows(InvalidPointException.class, () -> new Point(25, 10));
    }

    @Test
    void X좌표_범위_미만() {
        assertThrows(InvalidPointException.class, () -> new Point(-1, 10));
    }

    @Test
    void Y좌표_범위_초과() {
        assertThrows(InvalidPointException.class, () -> new Point(10, 25));
    }

    @Test
    void Y좌표_범위_미만() {
        assertThrows(InvalidPointException.class, () -> new Point(10, -1));
    }

    @Test
    void 두_점사이_거리_계산() {
        Point p1 = new Point(1, 2);
        Point p2 = new Point(2, 3);
        assertThat(p1.calculateDistance(p2)).isEqualTo(Math.sqrt(2), Offset.offset(0.001));
    }
}
