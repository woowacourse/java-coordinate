package com.woowa.coordinate.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Points {
    private final List<Point> points;

    public Points(List<Point> points) {
        this.points = new ArrayList<>(points);
    }

    public Point get(int index) {
        return points.get(index);
    }

    public int size() {
        return points.size();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Points points1 = (Points) o;
        return Objects.equals(points, points1.points);
    }

    @Override
    public int hashCode() {
        return Objects.hash(points);
    }
}
