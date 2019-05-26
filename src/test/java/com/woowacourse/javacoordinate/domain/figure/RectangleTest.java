package com.woowacourse.javacoordinate.domain.figure;

import com.woowacourse.javacoordinate.domain.point.Point;
import com.woowacourse.javacoordinate.domain.point.Points;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.*;

public class RectangleTest {
    private Points points;

    @BeforeEach
    void setUp() {
        Point point1 = new Point(10, 10);
        Point point2 = new Point(22, 10);
        Point point3 = new Point(22, 18);
        Point point4 = new Point(10, 18);

        points = new Points(Arrays.asList(point1, point2, point3, point4));
    }

    @Test
    void 사각형_초기화() {
        assertThatCode(() -> new Rectangle(points)).doesNotThrowAnyException();
    }

    @Test
    void 생성자에_null_입력_예외처리() {
        assertThatExceptionOfType(NullPointerException.class)
                .isThrownBy(() -> new Rectangle(null));
    }

    @Test
    void 사각형_초기화_오류_포인트_개수가_4개가_아닐_때() {
        points = new Points(Arrays.asList(new Point(10, 10),
                new Point(22, 10), new Point(22, 18)));
        assertThatExceptionOfType(IllegalArgumentException.class)
                .isThrownBy(() -> new Rectangle(points)).withMessage("사각형은 4개의 Point가 필요합니다");
    }

    @Test
    void 사각형_초기화_오류_사다리꼴_모양일_때() {
        points = new Points(Arrays.asList(new Point(1, 1),
                new Point(1, 2), new Point(2, 1), new Point(2, 10)));
        assertThatExceptionOfType(IllegalArgumentException.class)
                .isThrownBy(() -> new Rectangle(points)).withMessage("유효한 사각형이 아닙니다");
    }

    @Test
    void 사각형_넓이() {
        Figure rectangle = new Rectangle(points);

        assertThat(rectangle.calculateArea()).isEqualTo(96);
    }
}
