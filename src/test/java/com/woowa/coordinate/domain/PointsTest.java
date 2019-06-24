package com.woowa.coordinate.domain;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;

class PointsTest {
    @Test
    void sortPoints_메서드가_올바르게_정렬하는지_확인() {
        Points points = new Points(Arrays.asList(
                new Point(7, 3),
                new Point(1, 3),
                new Point(1, 1),
                new Point(7, 1)
        ));
        assertThat(points.get(0)).isEqualTo(new Point(7, 3));
        assertThat(points.get(1)).isEqualTo(new Point(7, 1));
        assertThat(points.get(2)).isEqualTo(new Point(1, 3));
        assertThat(points.get(3)).isEqualTo(new Point(1, 1));
    }
}