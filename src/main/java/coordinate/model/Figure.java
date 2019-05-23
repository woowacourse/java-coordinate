package coordinate.model;

import java.util.Collections;
import java.util.List;

public abstract class Figure implements Shape {
    List<Point> points;

    Figure(List<Point> points) {
        Collections.sort(points);
        checkDuplication(points);
        this.points = points;
    }

    private void checkDuplication(List<Point> points) {
        for (int i = 0; i < points.size() - 1; i++) {
            checkDuplicationOnePoint(points, i);
        }
    }

    private void checkDuplicationOnePoint(List<Point> points, int index) {
        if (points.get(index).equals(points.get(index + 1))) {
            throw new IllegalArgumentException("중복 좌표 오류");
        }
    }

    public List<Point> getPoints() {
        return points;
    }
}
