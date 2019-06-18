package com.woowa.coordinate.domain;

import com.woowa.coordinate.domain.figure.Rectangle;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class RectangleTest {
    @Test
    void not_enought_points_to_generate_rectangle() {
        List<Point> points = Arrays.asList(
                new Point(1, 1),
                new Point(9, 1),
                new Point(5, 2)
        );
        assertThrows(IllegalArgumentException.class, () -> {
            new Rectangle(new Points(points));
        });
    }

    @Test
    void invalid_generate_diamond_not_rectangle() {
        List<Point> points = Arrays.asList(
                new Point(1, 1),
                new Point(9, 1),
                new Point(5, 2),
                new Point(0, 2)
        );
        assertThrows(IllegalArgumentException.class, () -> {
            new Rectangle(new Points(points));
        });
    }

    @Test
    void invalid_generate_trapezoid_not_rectangle() {
        List<Point> points = Arrays.asList(
                new Point(4, 2),
                new Point(4, 3),
                new Point(1, 1),
                new Point(1, 4)
        );
        assertThrows(IllegalArgumentException.class, () -> {
            new Rectangle(new Points(points));
        });
    }

    @Test
    void area() {
        Point leftDown = new Point(1, 1);
        Point rightDown = new Point(4, 1);
        Point leftUp = new Point(4, 3);
        Point rightUp = new Point(1, 3);
        List<Point> points = Arrays.asList(leftDown, rightDown, leftUp, rightUp);
        assertThat(new Rectangle(new Points(points)).area()).isEqualTo(6);
    }

    @Test
    void area2() {
        Point leftDown = new Point(3, 4);
        Point rightDown = new Point(4, 3);
        Point leftUp = new Point(3, 3);
        Point rightUp = new Point(4, 4);
        List<Point> points = Arrays.asList(leftDown, rightDown, leftUp, rightUp);
        assertThat(new Rectangle(new Points(points)).area()).isEqualTo(1);
    }
}
