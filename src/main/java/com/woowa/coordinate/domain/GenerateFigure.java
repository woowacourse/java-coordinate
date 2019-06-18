package com.woowa.coordinate.domain;

import com.woowa.coordinate.domain.figure.Figure;
import com.woowa.coordinate.domain.figure.Line;
import com.woowa.coordinate.domain.figure.Rectangle;
import com.woowa.coordinate.domain.figure.Triangle;

import java.util.HashMap;
import java.util.Map;

public class GenerateFigure {
    private static Map<Integer, FigureMaker> generators = new HashMap<>();

    static {
        generators.put(2, Line::new);
        generators.put(3, Triangle::new);
        generators.put(4, Rectangle::new);
    }

    public static Figure getFigure(Points points) {
        FigureMaker figureMaker = generators.get(points.size());
        if (figureMaker == null) {
            throw new IllegalArgumentException("유효하지 않은 도형입니다.");
        }
        return figureMaker.make(points);
    }
}
