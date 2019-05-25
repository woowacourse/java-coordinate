package com.woowacourse.javacoordinate.domain;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;

public class ResultTest {
    @Test
    void 생성자에_라인이_인자로_들어왔을_때_생성_확인() {
        Points points = new Points(Arrays.asList(new Point(1, 1), new Point(1, 2)));
        Figure figure = FigureFactory.createFigure(points);
        Result result = new Result(figure);

        assertThat(result).isEqualTo(new Result(new Line(
                new Points(Arrays.asList(
                        new Point(1, 1), new Point(1, 2))))));
    }

    @Test
    void 생성자에_삼각형이_인자로_들어왔을_때_생성_확인() {
        Points points = new Points(Arrays.asList(new Point(1, 1), new Point(1, 2), new Point(2, 1)));
        Figure figure = FigureFactory.createFigure(points);
        Result result = new Result(figure);

        assertThat(result).isEqualTo(new Result(new Triangle(
                new Points(Arrays.asList(
                        new Point(1, 1), new Point(1, 2), new Point(2, 1))))));
    }

    @Test
    void 생성자에_사각형이_인자로_들어왔을_때_생성_확인() {
        Points points = new Points(Arrays.asList(
                new Point(1, 1), new Point(1, 2), new Point(2, 1), new Point(2, 2)));
        Figure figure = FigureFactory.createFigure(points);
        Result result = new Result(figure);

        assertThat(result).isEqualTo(new Result(new Rectangle(
                new Points(Arrays.asList(
                        new Point(1, 1), new Point(1, 2), new Point(2, 1), new Point(2, 2))))));
    }
}
