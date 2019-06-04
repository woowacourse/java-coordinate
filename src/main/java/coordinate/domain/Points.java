package coordinate.domain;

import java.util.HashSet;
import java.util.List;
import java.util.Objects;
import java.util.Set;

public class Points {
    private final List<Point> points;

    public Points(List<Point> points) {
        validateDuplication(points);
        this.points = points;
    }

    private void validateDuplication(List<Point> points) {
        Set<Point> nonDuplicatedPoints = new HashSet<>(points);
        if (nonDuplicatedPoints.size() != points.size()) {
            throw new IllegalArgumentException("중복된 좌표가 입력되었습니다.");
        }
    }

    boolean hasSameSizeWith(int size) {
        return points.size() == size;
    }

    private int getXDifference(int a, int b) {
        return points.get(a).getX() - points.get(b).getX();
    }

    private int getYDifference(int a, int b) {
        return points.get(a).getY() - points.get(b).getY();
    }

    double length(int a, int b) {
        return Math.sqrt(Math.pow(getXDifference(a, b), 2) + Math.pow(getYDifference(a, b), 2));
    }

    double getSForTriangle() {
        return (length(0, 1) + length(0, 2) + length(1, 2)) / 2;
    }

    Set<Integer> getProjectedXAxis() {
        Set<Integer> projectedXAxis = new HashSet<>();
        for (Point point : points) {
            projectedXAxis.add(point.getX());
        }
        return projectedXAxis;
    }

    Set<Integer> getProjectedYAxis() {
        Set<Integer> projectedYAxis = new HashSet<>();
        for (Point point : points) {
            projectedYAxis.add(point.getY());
        }
        return projectedYAxis;
    }

    int getX(int index) {
        return points.get(index).getX();
    }

    int getY(int index) {
        return points.get(index).getY();
    }

    int getPointsSize() {
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
