package com.woowa.coordinate.domain;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;

class PointsTest {
    @Test
    void sortPoints_0() {
        Points points = new Points(Arrays.asList(
                new Point(7, 3),
                new Point(1, 3),
                new Point(1, 1),
                new Point(7, 1)
        ));
        assertThat(points.get(0)).isEqualTo(new Point(7, 3));
    }

    @Test
    void sortPoints_1() {
        Points points = new Points(Arrays.asList(
                new Point(7, 3),
                new Point(1, 3),
                new Point(1, 1),
                new Point(7, 1)
        ));
        assertThat(points.get(1)).isEqualTo(new Point(7, 1));
    }

    @Test
    void sortPoints_2() {
        Points points = new Points(Arrays.asList(
                new Point(7, 3),
                new Point(1, 3),
                new Point(1, 1),
                new Point(7, 1)
        ));
        assertThat(points.get(2)).isEqualTo(new Point(1, 3));
    }

    @Test
    void sortPoints_3() {
        Points points = new Points(Arrays.asList(
                new Point(7, 3),
                new Point(1, 3),
                new Point(1, 1),
                new Point(7, 1)
        ));
        assertThat(points.get(3)).isEqualTo(new Point(1, 1));
    }
}