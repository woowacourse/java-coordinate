package coordinate.domain;

import java.util.*;

public class Points {
    private final List<Point> points;

    public Points(List<Point> points) {
        if (isDuplicate(points)) {
            throw new IllegalArgumentException("중복된 좌표가 존재합니다");
        }
        Collections.sort(points);
        this.points = points;
    }

    int size() {
        return points.size();
    }

    Point get(int index) {
        return points.get(index);
    }

    boolean isDuplicate(List<Point> points) {
        Set<Point> set = new HashSet<>(points);
        return set.size() != points.size();
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
