package com.woowa.coordinate;

import java.util.Objects;

public class Point {

    private final Coordinate x;
    private final Coordinate y;

    public Point(int x, int y) {
        this.x = new Coordinate(x);
        this.y = new Coordinate(y);
    }

    public Point(Coordinate x, Coordinate y) {
        this.x = x;
        this.y = y;
    }

    public Coordinate getX() {
        return this.x;
    }

    public Coordinate getY() {
        return this.y;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Point point = (Point) o;
        return Objects.equals(x, point.x) &&
                Objects.equals(y, point.y);
    }

    @Override
    public int hashCode() {
        return Objects.hash(x, y);
    }

    public double distance(Point point) {
        double xDistance = x.subtract(point.getX());
        double yDistance = y.subtract(point.getY());
        return Math.sqrt(Math.pow(xDistance, 2) + Math.pow(yDistance, 2));
    }
}
