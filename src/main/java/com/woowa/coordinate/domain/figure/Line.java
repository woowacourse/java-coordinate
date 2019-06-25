package com.woowa.coordinate.domain.figure;

import com.woowa.coordinate.domain.Points;

public class Line extends AbstractFigure {
    private static final int LINE_SIZE = 2;
    private static final String LINE_NAME = "선";
    private static final int START_POINT = 0;
    private static final int END_POINT = 1;

    public Line(Points points) {
        super(points);
    }

    @Override
    public int size() {
        return LINE_SIZE;
    }

    @Override
    public String name() {
        return LINE_NAME;
    }

    @Override
    public double area() {
        return super.getPoints().get(START_POINT).distance(super.getPoints().get(END_POINT));
    }
}
