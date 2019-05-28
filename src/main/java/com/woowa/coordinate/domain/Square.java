package com.woowa.coordinate.domain;

public class Square {
    private final Points points;

    public Square(Points points) {
        if(points.size() != 4) {
            throw new IllegalArgumentException("사각형은 점 4개로 생성 가능 합니다.");
        }
        if(isDotProductNonZero(points) || hasRightAngle(points))  {
            throw new IllegalArgumentException("직사각형이 아닙니다.");
        }
        this.points = points;
    }

    private boolean hasRightAngle(Points points) {
        return Vector.get(points, 0, 1).sum(Vector.get(points, 0, 2)).sum(points.get(0).toVector()).equals(points.get(3).toVector());
    }

    private boolean isDotProductNonZero(Points points) {
        return Vector.get(points, 0, 3).dotProduct(Vector.get(points, 1, 2)) != 0;
    }

    public double area() {
        return Vector.get(points, 0, 3).crossProduct(Vector.get(points, 1, 2));
    }
}
