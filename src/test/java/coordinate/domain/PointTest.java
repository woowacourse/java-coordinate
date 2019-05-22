package coordinate.domain;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class PointTest {
    @Test
    void 포인트_생성_테스트() {
        Point point = new Point(1, 2);
        assertThat(point).isEqualTo(new Point(1, 2));
    }

    @Test
    void 두_점의_거리_테스트() {
        Point point = new Point(1, 2);
        assertThat(point.sub(new Point(1, 5))).isEqualTo(3);
    }
}

