package com.woowa.coordinate.domain.figure;

import com.woowa.coordinate.domain.Points;
import com.woowa.coordinate.domain.Vector;

public class Rectangle extends AbstractFigure {
    private static final String RECTANGLE_ERROR = "직사각형이 아닙니다.";
    private static final int START_POINT = 0;
    private static final int RECTANGLE_SIZE = 4;
    private static final String RECTANGLE_NAME = "사각형";

    public Rectangle(Points points) {
        super(points);
        validRectangle(points);
    }

    private void validRectangle(Points points) {
        if(isDotProductZero(points) || !hasRightAngle(points))  {
            throw new IllegalArgumentException(RECTANGLE_ERROR);
        }
    }

    private boolean hasRightAngle(Points points) {
        return Vector.get(points, START_POINT, 1)
                .sum(Vector.get(points, START_POINT, 2))
                .equals(Vector.get(points, START_POINT, 3));
    }

    private boolean isDotProductZero(Points points) {
        return Vector.get(points, START_POINT, 1).dotProduct(Vector.get(points, START_POINT, 2)) != 0;
    }

    @Override
    public int size() {
        return RECTANGLE_SIZE;
    }

    @Override
    public String name() {
        return RECTANGLE_NAME;
    }

    @Override
    public double area() {
        return Vector.get(super.getPoints(), START_POINT, 1)
                .absCrossProduct(Vector.get(super.getPoints(), START_POINT, 2));
    }
}
