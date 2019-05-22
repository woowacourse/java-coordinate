package location.domain;

import java.util.*;

public class Points {
    private final static String POINT_NULL_OR_BLANK_MSG = "포인트가 비어있습니다.";
    private final static String DUPLICATE_MSG = "중복된 좌표가 있습니다.";
    private static List<Point> points;

    public Points(final List<Point> points) {
        isValid(points);
        compare(points);
        Points.points = points;
    }

    private void isValid(final List<Point> points) {
        isNullOrBlank(points);
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

    private void isNullOrBlank(final List<Point> points) {
        if (points == null || points.isEmpty()) {
            throw new IllegalArgumentException(POINT_NULL_OR_BLANK_MSG);
        }
    }

    private void compare(final List<Point> points) {
        points.sort((p1, p2) -> {
            if (p1.getX() == p2.getX()) {
                return p1.getY() - p2.getY();
            }
            return p1.getX() - p2.getX();
        });
    }

    public Point get(final int index) {
        return points.get(index);
    }

    public int size() {
        return points.size();
    }
}
