package coordinate.model;

import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Points {
    private List<Point> points;

    public Points(List<Point> points) {
        checkDuplication(points);
        Collections.sort(points);
        this.points = points;
    }

    private void checkDuplication(List<Point> points) {
        Set<Point> checkOverlap = new HashSet<>();
        for (Point point : points) {
            checkOverlap.add(point);
        }

        if (checkOverlap.size() != points.size()) {
            throw new IllegalArgumentException("좌표는 서로 중복이 되어서는 안됩니다.");
        }
    }

    public Point get(int index) {
        return Collections.unmodifiableList(points).get(index);
    }

    public List<Point> get() {
        return Collections.unmodifiableList(points);
    }
}
