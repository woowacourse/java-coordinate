package com.woowa.coordinate.domain.figure;

import com.woowa.coordinate.domain.Points;
import com.woowa.coordinate.domain.Vector;

public class Triangle extends AbstractFigure {
    private static final int TRIANGLE_SIZE = 3;
    private static final String TRIANGLE_NAME = "삼각형";
    private static final String TRIANGLE_ERROR = "삼각형이 아닙니다.";
    private static final int AREA_DIVIDE_FACTOR = 2;

    public Triangle(Points points) {
        super(points);
        validTriangle(points);
    }

    private void validTriangle(Points points) {
        if (Vector.get(points, 0, 1)
                .absCrossProduct(Vector.get(points, 1, 2)) == 0) {
            throw new IllegalArgumentException(TRIANGLE_ERROR);
        }
    }

    @Override
    public int size() {
        return TRIANGLE_SIZE;
    }

    @Override
    public String name() {
        return TRIANGLE_NAME;
    }

    @Override
    public double area() {
        return Vector.get(super.getPoints(), 0, 1)
                .absCrossProduct(Vector.get(super.getPoints(), 1, 2)) / AREA_DIVIDE_FACTOR;
    }
}
