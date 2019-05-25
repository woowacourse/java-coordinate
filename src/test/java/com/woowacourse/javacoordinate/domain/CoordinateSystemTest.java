package com.woowacourse.javacoordinate.domain;

import com.woowacourse.javacoordinate.domain.coordinate.CoordinateSystem;
import com.woowacourse.javacoordinate.domain.point.Point;
import com.woowacourse.javacoordinate.domain.point.Points;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;

public class CoordinateSystemTest {
    @Test
    void 좌표_평면_한_점_초기화() {
        Points points = new Points(Arrays.asList(new Point(20, 0)));

        CoordinateSystem coordinateSystem = new CoordinateSystem(points);

        assertThat(coordinateSystem.isMarked(20, 0)).isTrue();
        assertThat(coordinateSystem.isMarked(19, 0)).isFalse();
    }
}
