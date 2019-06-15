package com.woowa.coordinate.domain;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class RectangleTest {
    @Test
    void invalid_generate_square_empty_point() {
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
    void invalid_generate_square_not_rectangle() {
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
    void area() {
        Point leftDown = new Point(1, 1);
        Point rightDown = new Point(4, 1);
        Point leftUp = new Point(4, 3);
        Point rightUp = new Point(1, 3);
        List<Point> points = Arrays.asList(leftDown, rightDown, leftUp, rightUp);
        assertThat(new Rectangle(new Points(points)).area()).isEqualTo(6);
    }
}
