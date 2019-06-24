package com.woowa.coordinate.domain.figure;

import com.woowa.coordinate.domain.Point;
import com.woowa.coordinate.domain.Points;
import com.woowa.coordinate.domain.figure.Line;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.offset;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class LineTest {
    @Test
    void 두_점을_전달한_생성_성공_테스트() {
        Point point1 = new Point(1, 1);
        Point point2 = new Point(2, 2);
        List<Point> points = Arrays.asList(point1, point2);
        Line line = new Line(new Points(points));
        assertThat(line).isInstanceOf(Line.class);
    }

    @Test
    void 세_점을_전달한_생성_실패_테스트() {
        Point point1 = new Point(1, 1);
        Point point2 = new Point(3, 3);
        Point point3 = new Point(3, 3);
        List<Point> points = Arrays.asList(point1, point2, point3);
        assertThrows(IllegalArgumentException.class, () -> {
            new Line(new Points(points));
        });
    }

    @Test
    void Line의_area메서드_테스트() {
        Point point1 = new Point(1, 1);
        Point point2 = new Point(2, 2);
        List<Point> points = Arrays.asList(point1, point2);
        Line line = new Line(new Points(points));
        assertThat(line.area()).isEqualTo(1.414, offset(0.00099));
    }
}
