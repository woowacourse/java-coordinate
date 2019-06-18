package com.woowa.coordinate.domain;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class TriangleTest {
    @Test
    void not_enough_points_to_generate_triangle() {
        Point point1 = new Point(1, 5);
        Point point2 = new Point(1, 2);
        List<Point> points = Arrays.asList(point1, point2);
        assertThrows(IllegalArgumentException.class, () -> {
            new Triangle(new Points(points));
        });
    }

    @Test
    void not_triangle_but_three_points_on_a_line() {
        Point point1 = new Point(1, 5);
        Point point2 = new Point(1, 2);
        Point point3 = new Point(1, 8);
        List<Point> points = Arrays.asList(point1, point2, point3);
        assertThrows(IllegalArgumentException.class, () -> {
            new Triangle(new Points(points));
        });
    }

    @Test
    void area() {
        Point top = new Point(3, 5);
        Point leftBottom = new Point(1, 2);
        Point rightBottom = new Point(1, 8);
        List<Point> points = Arrays.asList(top, leftBottom, rightBottom);
        assertThat(new Triangle(new Points(points)).area()).isEqualTo(6);
    }
}