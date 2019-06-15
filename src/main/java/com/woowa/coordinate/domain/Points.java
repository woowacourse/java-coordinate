package com.woowa.coordinate.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Points {
    private List<Point> points;

    public Points() {  }

    public Points(List<Point> input) {
        points = new ArrayList<>(input);
        Point criteria = points.get(0);
        sortPoints(criteria);
    }

    private void sortPoints(Point criteria) {
        points.sort((o1, o2) -> {
            double distance1 = criteria.distance(o1);
            double distance2 = criteria.distance(o2);
            return ((Comparable)distance1).compareTo(distance2);
        });
    }

    public void add(Point point) {
        points.add(point);
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
