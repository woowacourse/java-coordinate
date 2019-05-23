package com.woowacourse.javacoordinate.domain;

import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;

public class FigureFactory {
    private static final Map<Integer, Function<Points, Figure>> figureCreator = new HashMap<>();

    static {
        figureCreator.put(2, Line::new);
        figureCreator.put(3, Triangle::new);
        figureCreator.put(4, Rectangle::new);
    }

    public static Figure createFigure(Points points) {
        Function<Points, Figure> function = figureCreator.get(points.getSize());
        return function.apply(points);
    }
}
