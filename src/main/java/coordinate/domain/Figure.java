package coordinate.domain;

import java.util.HashSet;
import java.util.List;

public abstract class Figure {
    List<Point> points;

    Figure(List<Point> points) {
        validateDuplicate(points);
    }

    private void validateDuplicate(List<Point> points) {
        if (points.size() != (new HashSet<>(points)).size()) {
            throw new IllegalArgumentException("같은 점은 입력할 수 없습니다.");
        }
    }

    public List<Point> getPoints() {
        return points;
    }

    public int getNumOfPoints() {
        return points.size();
    }

    public abstract double calculateArea();
}
