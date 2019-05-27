package com.woowa.coordinate.domain;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class LineTest {
    @Test
    void generate_line() {
        Point point1 = new Point(1, 1);
        Point point2 = new Point(3, 3);
        List<Point> points = Arrays.asList(point1, point2);
        Line line = new Line(points);
        assertThat(line.distance()).isEqualTo(Math.sqrt((3 - 1) * (3 - 1) + (3 - 1) * (3 - 1)));
    }

    @Test
    void invalid_generate_line() {
        Point point1 = new Point(1, 1);
        Point point2 = new Point(3, 3);
        Point point3 = new Point(3, 3);
        List<Point> points = Arrays.asList(point1, point2, point3);
        assertThrows(IllegalArgumentException.class, () -> {
            new Line(points);
        });
    }
}
