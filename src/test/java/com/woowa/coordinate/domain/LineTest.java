package com.woowa.coordinate.domain;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class LineTest {
    @Test
    void name() {
        Point point1 = new Point(1, 1);
        Point point2 = new Point(3, 3);
        List<Point> points = Arrays.asList(point1, point2);
        Line line = new Line(points);
        assertThat(line.distance()).isEqualTo(Math.sqrt((3 - 1) * (3 - 1) + (3 - 1) * (3 - 1)));
    }
}
