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

    public double getFirstDistance() {
        int index = 1;

        while (isNotEqualX(index)) {
            index++;
        }

        return points.get(0).getDistance(points.get(index));
    }

    boolean isNotEqualX(int index) {
        return !points.get(0).isEqualX(points.get(index));
    }

    public double getSecondDistance() {
        int index = 1;

        while (isNotEqualY(index)) {
            index++;
        }

        return points.get(0).getDistance(points.get(index));
    }

    private boolean isNotEqualY(int index) {
        return !points.get(0).isEqualY(points.get(index));
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
