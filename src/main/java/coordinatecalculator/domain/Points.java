package coordinatecalculator.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;

public class Points {
    private final List<Point> points;

    public Points(final List<Point> points) {
        this.points = points;
    }

    public double differenceBy(int pointIndex1, int pointIndex2) {
        return points.get(pointIndex1).differenceBetween(points.get(pointIndex2));
    }

    public List<Point> getSortedPoints() {
        List<Point> clonedPoints = new ArrayList<>(points);

        Collections.sort(clonedPoints);

        return Collections.unmodifiableList(clonedPoints);
    }

    public int size() {
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