package coordinatecalculator.model;

import java.util.*;

abstract class Polygon implements Figure {
    protected List<Point> points;
    protected List<Line> lines = new ArrayList<>();

    Polygon(List<Point> points) {
        if (points.size() != getPointsCount()) {
            throw new IllegalArgumentException(getName() + "의 길이는 " + getPointsCount() + "이어야 합니다.");
        }
        this.points = points;
    }

    private int nextNumber(int number, int max) {
        return (number + 1) % max;
    }

    private void checkDuplicate(List<Point> points) throws IllegalArgumentException {
        Set<Point> set = new HashSet<>();
        for (Point p : points) {
            if (!set.add(p)) {
                throw new IllegalArgumentException(ERROR_POINTS_DUPLICATE);
            }
        }
    }

    protected List<Line> makeSegment(List<Point> points) {
        checkDuplicate(points);
        List<Line> lines = new ArrayList<>();
        for (int i = 0, length = points.size(), nextNumber; i < length; i++) {
            nextNumber = nextNumber(i, length);
            lines.add(new Line(Arrays.asList(points.get(i), points.get(nextNumber))));
        }
        return lines;
    }

    @Override
    public List<Point> getPoints() {
        return this.points;
    }

    @Override
    public boolean equals(Object another) {
        if (this == another) return true;
        if (another == null || getClass() != another.getClass()) return false;
        final Polygon polygon = (Polygon) another;
        return this.points.equals(polygon.points);
    }

    @Override
    public int hashCode() {
        return Objects.hash(this.points);
    }

    @Override
    public String toString() {
        StringBuilder result = new StringBuilder();
        result.append(getName());
        result.append(": {");
        for (Point p : points) {
            result.append(p.toString());
            result.append(", ");
        }
        result.append("area: ");
        result.append(this.area());
        result.append("}");
        return result.toString();
    }
}
