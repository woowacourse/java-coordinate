package coordinate.model;

import java.util.*;

public class Points {
    private final List<Point> points;

    public Points(List<Point> points) {
        this.points = new ArrayList<>(points);
        checkDuplication();
        Collections.sort(this.points);
    }

    private void checkDuplication() {
        Set<Point> checkOverlap = new HashSet<>();
        for (Point point : points) {
            checkOverlap.add(point);
        }

        if (checkOverlap.size() != points.size()) {
            throw new IllegalArgumentException("좌표는 서로 중복이 되어서는 안됩니다.");
        }
    }

    public int minusX(int index1, int index2) {
        return points.get(index1).minusX(points.get(index2));
    }

    public int minusY(int index1, int index2) {
        return points.get(index1).minusY(points.get(index2));
    }

    public boolean isEqualX(int index1, int index2) {
        return points.get(index1).isEqualX(points.get(index2));
    }

    public boolean isEqualY(int index1, int index2) {
        return points.get(index1).isEqualY(points.get(index2));
    }

    public List<Point> get() {
        return Collections.unmodifiableList(points);
    }
}
