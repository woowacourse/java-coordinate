package com.woowa.coordinate.domain;

public class Triangle extends AbstractFigure {
    public Triangle(Points points) {
        super(points);
        validTriangle(points);
    }

    private void validTriangle(Points points) {
        if (Vector.get(points, 0, 1).crossProduct(Vector.get(points, 1, 2)) == 0) {
            throw new IllegalArgumentException("삼각형이 아닙니다.");
        }
    }

    @Override
    public int size() {
        return 3;
    }

    @Override
    public String name() {
        return "삼각형";
    }

    @Override
    public double area() {
        return Math.abs(Vector.get(super.getPoints(), 0, 1).crossProduct(Vector.get(super.getPoints(), 1, 2)) / 2);
    }
}
