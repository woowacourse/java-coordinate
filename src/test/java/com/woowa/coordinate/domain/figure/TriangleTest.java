package com.woowa.coordinate.domain.figure;

import com.woowa.coordinate.domain.Point;
import com.woowa.coordinate.domain.Points;
import com.woowa.coordinate.domain.figure.Triangle;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class TriangleTest {
    @Test
    void 부족한_수의_Point로_삼각형_생성시_예외처리() {
        Point point1 = new Point(1, 5);
        Point point2 = new Point(1, 2);
        List<Point> points = Arrays.asList(point1, point2);
        assertThrows(IllegalArgumentException.class, () -> {
            new Triangle(new Points(points));
        });
    }

    @Test
    void 세_점이_선분_위에_있는_경우_예외처리() {
        Point point1 = new Point(1, 5);
        Point point2 = new Point(1, 2);
        Point point3 = new Point(1, 8);
        List<Point> points = Arrays.asList(point1, point2, point3);
        assertThrows(IllegalArgumentException.class, () -> {
            new Triangle(new Points(points));
        });
    }

    @Test
    void 삼각형_넓이_확인() {
        Point top = new Point(3, 5);
        Point leftBottom = new Point(1, 2);
        Point rightBottom = new Point(1, 8);
        List<Point> points = Arrays.asList(top, leftBottom, rightBottom);
        assertThat(new Triangle(new Points(points)).area()).isEqualTo(6);
    }
}