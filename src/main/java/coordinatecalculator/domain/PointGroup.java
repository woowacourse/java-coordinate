package coordinatecalculator.domain;

import java.util.*;

public class PointGroup {
    private static final String ERROR_DUPLICATED_POINTS = "입력한 좌표가 중복됩니다.";

    private List<Point> points;

    public PointGroup(List<Point> points) {
        checkDuplicatePoints(points);
        Collections.sort(points);
        this.points = points;
    }

    private static void checkDuplicatePoints(final List<Point> points) {
        if (isDuplicatePoints(points)) {
            throw new IllegalArgumentException(ERROR_DUPLICATED_POINTS);
        }
    }

    private static boolean isDuplicatePoints(final List<Point> points) {
        Set<Point> uniquePoints = new HashSet<>(points);
        return uniquePoints.size() != points.size();
    }

    double getLength(final int firstPoint, final int secondPoint) {
        Point startPoint = points.get(firstPoint);
        Point endPoint = points.get(secondPoint);

        return startPoint.getDistance(endPoint);
    }

    double getAngle(final int firstPoint, final int secondPoint, final int thirdPoint) {
        Point startPoint = points.get(firstPoint);
        Point middlePoint = points.get(secondPoint);
        Point endPoint = points.get(thirdPoint);

        return startPoint.getAngle(middlePoint, endPoint);
    }

    public boolean isContainsPoint(Point point) {
        return points.contains(point);
    }

    public int getPointsCount() {
        return points.size();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        final PointGroup that = (PointGroup) o;
        return Objects.equals(points, that.points);
    }

    @Override
    public int hashCode() {
        return Objects.hash(points);
    }
}
