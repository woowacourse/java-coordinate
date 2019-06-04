package coordinate.domain;

import java.util.*;

public class Points {
    private static final String ERROR_DUPLICATE = "중복된 점이 있습니다.";
    private static final String ERROR_NULL = "null은 허용하지 않습니다.";
    private static final int POINT_SIZE = 2;

    private List<Point> points;

    Points(List<Point> points) {
        if (Objects.isNull(points)) {
            throw new NullPointerException(ERROR_NULL);
        }

        this.points = points;
    }

    public static Points create() {
        return new Points(new ArrayList<>());
    }

    public void addPoint(Point point) {
        if (points.contains(point)) {
            throw new IllegalArgumentException(ERROR_DUPLICATE);
        }

        points.add(point);
    }

    public Point getPoints(int index) {
        return points.get(index);
    }

    public int getSize() {
        return points.size();
    }

    boolean check(String x) {
        Set<Integer> checkers = new HashSet<>();

        for (Point checker : points) {
            checkers.add(checker.get(x).getNumber());
        }

        return checkers.size() == POINT_SIZE;
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
