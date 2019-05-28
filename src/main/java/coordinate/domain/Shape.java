package coordinate.domain;

import java.util.*;

public abstract class Shape {
    private List<Point> points;

    public Shape(final List<Point> points) {
        this.points = points;
    }

    public List<Point> getPoints() {
        return new ArrayList<>(points);
    }

    public List<Double> getSides() {
        List<Double> sides = new ArrayList<>();
        for (Integer sideSquare : getSideSquares()) {
            sides.add(Math.sqrt(sideSquare));
        }
        return sides;
    }

    public List<Integer> getSideSquares() {
        List<Integer> sides = new ArrayList<>();
        for (int i = 0; i < points.size(); i++) {
            Point firstPoint = points.get(i);
            for (int j = i + 1; j < points.size(); j++) {
                Point secondPoint = points.get(j);
                sides.add(firstPoint.distanceSquare(secondPoint));
            }
        }
        return sides;
    }
}
