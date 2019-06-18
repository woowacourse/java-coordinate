package com.woowa.coordinate.domain;

public class Triangle {
    private final Points points;

    public Triangle(Points points) {
        if (points.size() != 3) {
            throw new IllegalArgumentException("Point 수가 부족합니다.");
        }
        if (Vector.get(points, 0, 1).crossProduct(Vector.get(points, 1, 2)) == 0) {
            throw new IllegalArgumentException("삼각형이 아닙니다.");
        }
        this.points = points;
    }

    public double area() {
        return Math.abs(Vector.get(points, 0, 1).crossProduct(Vector.get(points, 1, 2)) / 2);
    }
}
