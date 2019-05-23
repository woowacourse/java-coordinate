package coord.model;

import java.util.*;

public final class Points {
    private final List<Point> points;

    public Points(List<Point> points) {
        if (points.size() != new HashSet<>(points).size()) {
            throw new IllegalArgumentException("동일한 점은 입력할 수 없습니다.");
        }
        this.points = Collections.unmodifiableList(points);
    }

    public Points(Point ... points) {
        this(Arrays.asList(points));
    }

    public int number() {
        return points.size();
    }

    public Point get(int index) {
        return points.get(index);
    }

    public List<Point> getPoints() {
        return points;
    }

    @Override
    public String toString() {
        String result = points.toString();
        return result.substring(1, result.length() - 1);
    }
}