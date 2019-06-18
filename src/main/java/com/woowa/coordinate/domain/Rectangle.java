package com.woowa.coordinate.domain;

public class Rectangle {
    private final Points points;

    public Rectangle(Points points) {
        if (points.size() != 4) {
            throw new IllegalArgumentException("Point 수가 부족합니다.");
        }
        if(isDotProductZero(points) || !hasRightAngle(points))  {
            throw new IllegalArgumentException("직사각형이 아닙니다.");
        }
        this.points = points;
    }

    private boolean hasRightAngle(Points points) {
        return Vector.get(points, 0, 1)
                .sum(Vector.get(points, 0, 2))
                .equals(Vector.get(points, 0, 3));
    }

    private boolean isDotProductZero(Points points) {
        return Vector.get(points, 0, 1).dotProduct(Vector.get(points, 0, 2)) != 0;
    }

    public double area() {
        return Math.abs(Vector.get(points, 0, 1).crossProduct(Vector.get(points, 0, 2)));
    }
}
