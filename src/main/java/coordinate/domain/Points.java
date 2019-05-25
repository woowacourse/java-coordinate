package coordinate.domain;

import java.util.*;
import java.util.stream.Collectors;

public class Points {
    private final List<Point> points;

    public Points(List<Point> points) {
        checkDuplicateCoordinate(points);
        Collections.sort(points);
        this.points = points;
    }

    private void checkDuplicateCoordinate(List<Point> points) {
        Set<Point> set = new HashSet<>(points);
        if (set.size() != points.size()) {
            throw new IllegalArgumentException("중복된 좌표는 허용하지 않습니다.");
        }
    }

    public int nonDuplicateXSize() {
        return points.stream()
                .map(Point::getX)
                .collect(Collectors.toSet())
                .size();
    }

    public int nonDuplicateYSize() {
        return points.stream()
                .map(Point::getY)
                .collect(Collectors.toSet())
                .size();
    }

    public Point getPoints(int index) {
        return points.get(index);
    }

    public int size() {
        return points.size();
    }

    public List<Point> getPoints() {
        return Collections.unmodifiableList(points);
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
