package com.woowa.coordinate.domain;

import com.woowa.coordinate.domain.figure.Line;
import com.woowa.coordinate.domain.figure.Rectangle;
import com.woowa.coordinate.domain.figure.Triangle;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class GenerateFigureTest {
    @Test
    void GenerateFigure로_라인_생성하기() {
        Points points = new Points(Arrays.asList(
                new Point(1, 1),
                new Point(2, 2)
        ));
        assertThat(GenerateFigure.getFigure(points)).isEqualTo(new Line(points));
    }

    @Test
    void GenerateFigure로_삼각형_생성하기() {
        Points points = new Points(Arrays.asList(
                new Point(1, 1),
                new Point(2, 2),
                new Point(1, 2)
        ));
        assertThat(GenerateFigure.getFigure(points)).isEqualTo(new Triangle(points));
    }

    @Test
    void GenerateFigure로_사각형_생성하기() {
        Points points = new Points(Arrays.asList(
                new Point(1, 1),
                new Point(2, 2),
                new Point(2, 1),
                new Point(1, 2)
        ));
        assertThat(GenerateFigure.getFigure(points)).isEqualTo(new Rectangle(points));
    }
}