package coordinate.domain;

import java.util.ArrayList;
import java.util.List;

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
        for (Integer sideSquare : getAllSideSquares()) {
            sides.add(Math.sqrt(sideSquare));
        }
        return sides;
    }

    public List<Integer> getAllSideSquares() {
        List<Integer> sides = new ArrayList<>();
        for (int i = 0; i < points.size(); i++) {
            getSideSquares(sides, i);
        }
        return sides;
    }

    private void getSideSquares(List<Integer> sides, int i) {
        Point point = points.get(i);
        for (int j = i + 1; j < points.size(); j++) {
            Point otherPoint = points.get(j);
            sides.add(point.distanceSquare(otherPoint));
        }
    }
}
