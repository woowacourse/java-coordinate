package coordinatecalculator.model;

import java.util.*;

public class Points {
    private final List<Point> points = new ArrayList<>();

    public Points(List<String> values) {
        for (int i = 0, n = values.size(); i < n; i += 2) {
            points.add(new Point(values.get(i), values.get(i+1)));
        }
    }

    public List<Point> getPoints() {
        return points;
    }

    public List<Point> retrivePoints() {
        List<Point> retrivedPoints = Collections.unmodifiableList(points);
        return retrivedPoints;
    }

    public int getPointCount() {
        return points.size();
    }

    public Point getPoint(int index) {
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
