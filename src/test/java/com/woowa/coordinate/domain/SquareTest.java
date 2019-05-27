package com.woowa.coordinate.domain;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class SquareTest {
    @Test
    void invalid_generate_square_empty_point() {
        Point point1 = new Point(1, 1);
        Point point2 = new Point(9, 1);
        Point point3 = new Point(5, 2);
        List<Point> points = Arrays.asList(point1, point2, point3);
        assertThrows(IllegalArgumentException.class, () -> {
            new Square(points);
        });
    }

    @Test
    void area() {
        Point leftDown = new Point(1, 1);
        Point rightDown = new Point(4, 1);
        Point leftUp = new Point(4, 3);
        Point rightUp = new Point(1, 3);
        List<Point> points = Arrays.asList(leftDown, rightDown, leftUp, rightUp);
        assertThat(new Square(points).area()).isEqualTo(6);
    }
}
