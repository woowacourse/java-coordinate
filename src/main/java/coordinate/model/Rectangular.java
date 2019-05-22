package coordinate.model;

import java.util.Collections;
import java.util.List;

public class Rectangular {
    private List<Point> points;

    public Rectangular(List<Point> points) {
        checkDupliation(points);
        checkTwist(points);
        this.points = points;
    }

    private void checkDupliation(List<Point> points) {
        Collections.sort(points);
        for (int i = 0; i < points.size() - 1; i++) {
            checkDuplicationOnePoint(points, i);
        }
    }

    private void checkDuplicationOnePoint(List<Point> points, int i) {
        if (points.get(i).equals(points.get(i + 1))) {
            throw new IllegalArgumentException("중복 좌표 오류");
        }
    }

    private void checkTwist(List<Point> points) {
        Collections.sort(points);
        if (!points.get(0).isEqualX(points.get(1)) ||
                !points.get(0).isEqualY(points.get(2)) ||
                !points.get(3).isEqualX(points.get(2)) ||
                !points.get(3).isEqualY(points.get(1))) {
            throw new IllegalArgumentException();
        }
    }

    public int getArea() {
        return (int) (points.get(0).getDistance(points.get(1))
                * points.get(0).getDistance(points.get(2)));
    }
}
