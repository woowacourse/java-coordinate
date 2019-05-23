package com.woowacourse.javacoordinate.domain;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatExceptionOfType;

public class FigureFactoryTest {
    @Test
    void 라인_생성_확인() {
        Points points = new Points(Arrays.asList(
                new Point(1, 1),
                new Point(2, 2)));
        assertThat(FigureFactory.createFigure(points)).isEqualTo(new Line(points));
    }

    @Test
    void 삼각형_생성_확인() {
        Points points = new Points(Arrays.asList(
                new Point(1, 1),
                new Point(2, 2),
                new Point(1, 5)));
        assertThat(FigureFactory.createFigure(points)).isEqualTo(new Triangle(points));
    }

    @Test
    void 사각형_생성_확인() {
        Points points = new Points(Arrays.asList(
                new Point(1, 1),
                new Point(2, 2),
                new Point(1, 2),
                new Point(2, 1)));
        assertThat(FigureFactory.createFigure(points)).isEqualTo(new Rectangle(points));
    }

    @Test
    void 생성오류_확인() {
        Points points = new Points(Arrays.asList(
                new Point(1, 1),
                new Point(2, 2),
                new Point(1, 2),
                new Point(2, 1),
                new Point(3, 3)));
        assertThatExceptionOfType(IllegalArgumentException.class)
                .isThrownBy(() -> FigureFactory.createFigure(points))
                .withMessage("포인트 개수가 올바르지 않습니다.");
    }
}
