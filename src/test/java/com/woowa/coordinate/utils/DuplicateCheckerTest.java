package com.woowa.coordinate.utils;

import com.woowa.coordinate.domain.Point;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

class DuplicateCheckerTest {
    private List<Point> points;

    @Test
    void 중복_Point_입력시_예외_처리() {
        points = Arrays.asList(new Point(1, 1), new Point(1, 1));
        assertThrows(IllegalArgumentException.class, () ->
                DuplicateChecker.check(points)
        );
    }

    @Test
    void 중복되지_않은_Point_입력시_올바른_배열_반환() {
        points = Arrays.asList(new Point(1, 2), new Point(2, 1));
        assertThat(DuplicateChecker.check(points)).isEqualTo(points);
    }
}