package coordinatecalculator.domain;

import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public abstract class Shape implements Figure {
    private static final String DUPLICATED_POINTS = "입력한 좌표가 중복됩니다.";

    private List<Point> points;

    public Shape(List<Point> points) {
        this.points = points;
        checkDuplicatePoints();
    }

    private void checkDuplicatePoints() {
        if (isDuplicatePoints()) {
            throw new IllegalArgumentException(DUPLICATED_POINTS);
        }
    }

    private boolean isDuplicatePoints() {
        Set<Point> uniquePoints = new HashSet<>(points);
        return uniquePoints.size() != points.size();
    }

    public Point getPoint(int index) {
        return points.get(index);
    }

    public void sortPoints() {
        Collections.sort(points);
    }
}