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
        if (function == null) {
            throw new IllegalArgumentException("포인트 개수가 올바르지 않습니다.");
        }
        return function.apply(points);
    }
}
