package com.woowacourse.javacoordinate.domain;

import com.woowacourse.javacoordinate.domain.figure.Figure;
import com.woowacourse.javacoordinate.domain.figure.Line;
import com.woowacourse.javacoordinate.domain.point.Point;
import com.woowacourse.javacoordinate.domain.point.Points;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.*;

public class LineTest {
    @Test
    void 생성자에_null_입력_예외처리() {
        assertThatExceptionOfType(NullPointerException.class)
                .isThrownBy(() -> new Line(null));
    }

    @Test
    void 라인_초기화_오류() {
        Point point1 = new Point(10, 10);
        Points points = new Points(Arrays.asList(point1));

        assertThatExceptionOfType(IllegalArgumentException.class)
                .isThrownBy(() -> new Line(points)).withMessage("라인은 2개의 Point가 필요합니다");
    }

    @Test
    void 두_점_사이의_거리_계산() {
        Point point1 = new Point(10, 10);
        Point point2 = new Point(14, 15);

        Points points = new Points(Arrays.asList(point1, point2));

        Figure line = new Line(points);

        assertThat(line.calculateArea()).isEqualTo(6.403124, offset(0.00099));
    }
}
