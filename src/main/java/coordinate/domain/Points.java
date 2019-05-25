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

    public int getNonDuplicateXSize() {
        return points.stream()
                .map(Point::getXCoordinate)
                .collect(Collectors.toSet())
                .size();
    }

    public int getNonDuplicateYSize() {
        return points.stream()
                .map(Point::getYCoordinate)
                .collect(Collectors.toSet())
                .size();
    }

    public Point getPoint(int index) {
        return points.get(index);
    }

    public int size() {
        return points.size();
    }

    public List<Point> getPoint() {
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
