package com.woowa.coordinate.domain;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class CoordinateTest {
    @Test
    void 최소값_0_초과시_예외처리_테스트() {
        assertThrows(IllegalArgumentException.class, () -> {
            new Coordinate(-1);
        });
    }

    @Test
    void 최댓값_24_초과시_예외처리_테스트() {
        assertThrows(IllegalArgumentException.class, () -> {
            new Coordinate(25);
        });
    }

    @Test
    void 객체_뺄셈_메서드_테스트() {
        Coordinate coordinate1 = new Coordinate(10);
        Coordinate coordinate2 = new Coordinate(1);
        assertThat(coordinate1.subtract(coordinate2)).isEqualTo(9);
    }

    @Test
    void 객체_뺄셈_메서드_반대로_계산해보기() {
        Coordinate coordinate1 = new Coordinate(1);
        Coordinate coordinate2 = new Coordinate(10);
        assertThat(coordinate1.subtract(coordinate2)).isEqualTo(-9);
    }
}
