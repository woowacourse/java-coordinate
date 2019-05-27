package com.woowa.coordinate.domain;

import java.util.List;

public class Line {
    private final Points points;

    public Line(List<Point> points) {
        if (points.size() != 2) {
            throw new IllegalArgumentException("Line 은 점 2개로 생성이 가능합니다.");
        }
        this.points = new Points(points);
    }

    public double distance() {
        return points.get(0).distance(points.get(1));
    }
}
