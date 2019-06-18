package com.woowa.coordinate.domain;

public class Rectangle extends AbstractFigure {
    public Rectangle(Points points) {
        super(points);
        validRectangle(points);
    }

    private void validRectangle(Points points) {
        if(isDotProductZero(points) || !hasRightAngle(points))  {
            throw new IllegalArgumentException("직사각형이 아닙니다.");
        }
    }

    private boolean hasRightAngle(Points points) {
        return Vector.get(points, 0, 1)
                .sum(Vector.get(points, 0, 2))
                .equals(Vector.get(points, 0, 3));
    }

    private boolean isDotProductZero(Points points) {
        return Vector.get(points, 0, 1).dotProduct(Vector.get(points, 0, 2)) != 0;
    }

    @Override
    public int size() {
        return 4;
    }

    @Override
    public String name() {
        return "사각형";
    }

    @Override
    public double area() {
        return Math.abs(Vector.get(super.getPoints(), 0, 1).crossProduct(Vector.get(super.getPoints(), 0, 2)));
    }
}
