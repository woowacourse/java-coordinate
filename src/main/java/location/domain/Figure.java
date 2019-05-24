package location.domain;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public abstract class Figure implements Calculator {
    private final static String DUPLICATE_MSG = "위치가 같은 점(point)이 존재합니다.";
    private static final double MAX = Double.MAX_VALUE;

    public Figure(Points points) {
        checkValid(points.getPoints());
    }

    private void checkValid(final List<Point> points) {
        isSamePoint(points);
    }

    private void isSamePoint(final List<Point> points) {
        Set<Point> notDuplicatePoints = new HashSet<>();
        for (Point point : points) {
            notDuplicatePoints.add(point);
        }
        if (notDuplicatePoints.size() != points.size()) {
            throw new IllegalArgumentException(DUPLICATE_MSG);
        }
    }

    double calculateTilt(final Point point, final Point point1) {
        double denominator = (double) (point.getX() - point1.getX());
        double molecule = (double) (point.getY() - point1.getY());
        if (denominator == 0) {
            denominator = MAX;
        }
        return molecule / denominator;
    }

    public abstract Points getPoints();
}
