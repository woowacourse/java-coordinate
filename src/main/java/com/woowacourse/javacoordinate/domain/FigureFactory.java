package com.woowacourse.javacoordinate.domain;

import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;

public class FigureFactory {
    private static final Map<Integer, Function<Points, Figure>> figureCreator = new HashMap<>();

    static {
        figureCreator.put(Line.LINE_POINT_NUMBER, Line::new);
        figureCreator.put(Triangle.TRIANGLE_POINT_NUMBER, Triangle::new);
        figureCreator.put(Rectangle.RECTANGLE_POINT_NUMBER, Rectangle::new);
    }

    public static Figure createFigure(Points points) {
        Function<Points, Figure> function = figureCreator.get(points.getSize());
        Figure figure = null;
        try {
            figure = function.apply(points);
        } catch (NullPointerException e) {
            System.err.println("포인트 개수가 올바르지 않습니다.");
        } catch (IllegalArgumentException e) {
            System.err.println(e.getMessage());
        }
        return figure;
    }
}
