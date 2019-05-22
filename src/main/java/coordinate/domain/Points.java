package coordinate.domain;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class Points {
    private final List<Point> points;

    private Points(final List<Point> points) {
        this.points = new ArrayList<>(points);
        validate(this.points);
    }

    public static Points of(final List<Point> points) {
        return new Points(points);
    }

    private void validate(final List<Point> points) {
        validateEmpty(points);
        validateDuplication(points);
    }

    private void validateEmpty(final List<Point> points) {
        if (points.isEmpty()) {
            throw new IllegalArgumentException("점이 없습니다.");
        }
    }

    private void validateDuplication(final List<Point> points) {
        if (new HashSet<>(points).size() != points.size()) {
            throw new IllegalArgumentException("중복되는 점은 있으면 안됩니다.");
        }
    }

    public Point get(final int index) {
        return points.get(index);
    }

    public int size() {
        return points.size();
    }
}
