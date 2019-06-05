package coordinate.domain;

import java.util.*;

public abstract class Shape {
    private final List<Point> points;

    public Shape(final List<Point> points) {
        this.points = Collections.unmodifiableList(points);
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
        List<Point> list = getPoints();

        do {
            Point standardPoint = list.get(0);
            list.remove(0);
            addSide(sides, list, standardPoint);
        } while (list.size() != 0);

        return new ArrayList<>(sides);
    }

    private void addSide(List<Integer> sides, List<Point> list, Point standardPoint) {
        for (Point point : list) {
            sides.add(point.distanceSquare(standardPoint));
        }
    }

}
