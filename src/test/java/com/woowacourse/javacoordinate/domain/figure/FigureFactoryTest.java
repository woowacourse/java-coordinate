package com.woowacourse.javacoordinate.domain.figure;

import com.woowacourse.javacoordinate.domain.point.Point;
import com.woowacourse.javacoordinate.domain.point.Points;
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
    void 오각형을_생성하면_예외처리() {
        Points points = new Points(Arrays.asList(
                new Point(1, 1),
                new Point(2, 2),
                new Point(1, 2),
                new Point(2, 1),
                new Point(0, 0)));

        assertThatExceptionOfType(NullPointerException.class)
                .isThrownBy(() -> FigureFactory.createFigure(points));
    }

    @Test
    void 한_점을_생성하면_예외처리() {
        Points points = new Points(Arrays.asList(new Point(1, 1)));
        assertThatExceptionOfType(NullPointerException.class)
                .isThrownBy(() -> FigureFactory.createFigure(points));
    }

    @Test
    void null_입력되면_예외처리() {
        assertThatExceptionOfType(NullPointerException.class)
                .isThrownBy(() -> FigureFactory.createFigure(null));
    }
}
