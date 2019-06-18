package com.woowa.coordinate.domain;

public class Line {
    private final Points points;

    public Line(Points points) {
        if (points.size() != 2) {
            throw new IllegalArgumentException("Point 수가 부족합니다.");
        }
        this.points = points;
    }

    public double distance() {
        return points.get(0).distance(points.get(1));
    }
}
