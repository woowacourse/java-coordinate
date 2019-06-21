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
    void 유효하지_않은_point_예외_처리() {
        assertThrows(IllegalArgumentException.class, () -> {
            new Point(-1, 1);
        });
    }
}
