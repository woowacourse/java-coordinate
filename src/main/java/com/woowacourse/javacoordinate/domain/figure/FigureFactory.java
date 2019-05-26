package com.woowacourse.javacoordinate.domain.figure;

import com.woowacourse.javacoordinate.domain.point.Points;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import java.util.function.Function;

public class FigureFactory {
    private static final Map<Integer, Function<Points, Figure>> figureCreator = new HashMap<>();

    static {
        figureCreator.put(Line.LINE_POINT_NUMBER, Line::new);
        figureCreator.put(Triangle.TRIANGLE_POINT_NUMBER, Triangle::new);
        figureCreator.put(Rectangle.RECTANGLE_POINT_NUMBER, Rectangle::new);
    }

    public static Figure createFigure(Points points) {
        if (Objects.isNull(points)) {
            throw new NullPointerException();
        }

        Function<Points, Figure> function = figureCreator.get(points.getSize());
        if (Objects.isNull(function)) {
            throw new NullPointerException();
        }

        return function.apply(points);
    }
}
