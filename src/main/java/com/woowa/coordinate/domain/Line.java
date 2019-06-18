package com.woowa.coordinate.domain;

import java.util.List;

public class Line {
    private final Points points;

    public Line(List<Point> points) {
        this.points = new Points(points);
    }

    public double distance() {
        return points.get(0).distance(points.get(1));
    }
}
