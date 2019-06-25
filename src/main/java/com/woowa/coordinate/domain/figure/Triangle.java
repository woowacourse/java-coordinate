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
        if (isCrossProductZero(points, Vector.getVector(points, 0, 1))) {
            throw new IllegalArgumentException(TRIANGLE_ERROR);
        }
    }

    private boolean isCrossProductZero(Points points, Vector criteriaToNeighbor) {
        return criteriaToNeighbor.absCrossProduct(Vector.getVector(points, 1, 2)) == 0;
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
        return Vector.getVector(super.getPoints(), 0, 1)
                .absCrossProduct(Vector.getVector(super.getPoints(), 1, 2)) / AREA_DIVIDE_FACTOR;
    }
}
