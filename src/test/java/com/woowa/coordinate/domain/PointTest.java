package com.woowa.coordinate.domain;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class PointTest {
    @Test
    void 유효한_Point_생성_확인() {
        Point point1 = new Point(1, 1);
        assertThat(new Point(1, 1)).isEqualTo(point1);
    }

    @Test
    void 유효한_Point_생성_확인_static_of_메서드_이용() {
        Point point1 = new Point(1, 1);
        assertThat(Point.of("1,1")).isEqualTo(point1);
    }

    @Test
    void 유효하지_않은_point_예외_처리() {
        assertThrows(IllegalArgumentException.class, () -> new Point(-1, 1));
    }

    @Test
    void subtractX_동작_테스트_예상_결과_마이너스9() {
        Point point1 = new Point(1, 1);
        Point point2 = new Point(10, 1);
        assertThat(point1.subtractX(point2)).isEqualTo(-9);
    }

    @Test
    void subtractY_동작_테스트_예상_결과_9() {
        Point point1 = new Point(1, 10);
        Point point2 = new Point(10, 1);
        assertThat(point1.subtractY(point2)).isEqualTo(9);
    }

    @Test
    void 두점의_거리_잘_구해지는지_확인() {
        Point point1 = new Point(1, 0);
        Point point2 = new Point(3, 0);
        assertThat(point1.distance(point2)).isEqualTo(new Double(2));
    }
}
