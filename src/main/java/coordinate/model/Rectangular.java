package coordinate.model;

import java.util.Collections;
import java.util.List;

public class Rectangular {
    private List<Point> points;

    public Rectangular(List<Point> points) {
        this.points = points;
        checkValidRectangular();
    }

    private void checkValidRectangular() {
        Collections.sort(points);
        if (!points.get(0).isEqualX(points.get(1)) ||
            !points.get(0).isEqualY(points.get(2)) ||
            !points.get(3).isEqualX(points.get(2)) ||
            !points.get(3).isEqualY(points.get(1))) {
            throw new IllegalArgumentException();
        }
    }
}
