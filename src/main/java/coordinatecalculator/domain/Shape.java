package coordinatecalculator.domain;

import java.util.Collections;
import java.util.List;

public abstract class Shape implements Figure {

    private List<Point> points;

    public Shape(List<Point> points) {
        this.points = points;
    }

    public Point getPoint(int index) {
        return points.get(index);
    }

    public void sortPoints() {
        Collections.sort(points);
    }
}