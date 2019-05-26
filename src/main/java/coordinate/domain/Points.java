package coordinate.domain;

import java.util.*;

public class Points {
    private List<Point> points;

    private Points(List<Point> points) {
        Set<Point> duplicationCheck = new HashSet<>(points);

        if (points.size() != duplicationCheck.size()) {
            throw new IllegalArgumentException("중복된 점이 있습니다.");
        }

        this.points = points;
    }

    public static Points create() {
        return new Points(new ArrayList<>());
    }

    public void addPoint(Point point) {
        points.add(point);
    }

    public Point pointsByIndex(int index) {
        return points.get(index);
    }

    public int getSize() {
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

    @Override
    public String toString() {
        return "Points{" +
                "points=" + points +
                '}';
    }
}
