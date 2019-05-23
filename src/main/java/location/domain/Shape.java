package location.domain;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public abstract class Shape {
    private final static String DUPLICATE_MSG = "중복된 좌표가 있습니다.";

    public Shape(Points points) {
        checkValid(points.getPoints());
    }

    public abstract Double calculate();

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
}
