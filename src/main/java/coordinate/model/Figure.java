package coordinate.model;

import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public abstract class Figure implements Shape {

    protected List<Point> points;

    public Figure(List<Point> points) {
        Collections.sort(points);
        checkDuplication(points);
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

    public List<Point> getPoints() {
        List<Point> readOnlyPoints = Collections.unmodifiableList(points);
        return readOnlyPoints;
    }
}
