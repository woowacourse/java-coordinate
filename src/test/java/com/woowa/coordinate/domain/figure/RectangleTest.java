package com.woowa.coordinate.domain.figure;

import com.woowa.coordinate.domain.Point;
import com.woowa.coordinate.domain.Points;
import com.woowa.coordinate.domain.figure.Rectangle;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class RectangleTest {
    @Test
    void 부족한_수의_Point로_생성시_예외_확인() {
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
    void 마름모인_경우_예외_처리() {
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
    void 사다리꼴인_경우_예외_처리() {
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
    void 직사각형_넓이_확인() {
        Point leftDown = new Point(1, 1);
        Point rightDown = new Point(4, 1);
        Point leftUp = new Point(4, 3);
        Point rightUp = new Point(1, 3);
        List<Point> points = Arrays.asList(leftDown, rightDown, leftUp, rightUp);
        assertThat(new Rectangle(new Points(points)).area()).isEqualTo(6);
    }

    @Test
    void 정사각형_넓이_확인() {
        Point leftDown = new Point(3, 4);
        Point rightDown = new Point(4, 3);
        Point leftUp = new Point(3, 3);
        Point rightUp = new Point(4, 4);
        List<Point> points = Arrays.asList(leftDown, rightDown, leftUp, rightUp);
        assertThat(new Rectangle(new Points(points)).area()).isEqualTo(1);
    }
}
