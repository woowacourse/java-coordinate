package coordinate.domain;

import java.util.*;

public class Points {
    private static final int MIN_POINTS_NUMBER = 2;
    private static final int MAX_POINTS_NUMBER = 4;
    private final List<Point> points;

    public Points(List<Point> points) {
        if (isNotCorrectSize(points)) {
            throw new IllegalArgumentException("좌표는 2~4개를 입력해 주세요.");
        } ;
        this.points = checkDuplicate(points);
    }

    private boolean isNotCorrectSize(List<Point> points) {
        if (!(points.size() >= MIN_POINTS_NUMBER && points.size() <= MAX_POINTS_NUMBER)) {
            return true;
        }
        return false;
    }

    private List<Point> checkDuplicate(List<Point> points) {
        if (isDuplicate(points)) {
            throw new IllegalArgumentException("중복되지 않는 좌표를 입력해주세요.");
        }
        return points;
    }

    private boolean isDuplicate(List<Point> points) {
        Set<Point> set = new HashSet<>(points);
        return set.size() != points.size();
    }

    public boolean isContain(Point point) {
        return points.contains(point);
    }

    int getSize() {
        return this.points.size();
    }

    Point getPoint(int index) {
        return points.get(index);
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
