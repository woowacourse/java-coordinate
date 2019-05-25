package coordinatecalculator.domain;

import java.util.Collections;
import java.util.List;

public abstract class Figure implements Area {

    private final List<Point> points;

    public Figure(final List<Point> points) {
        this.points = points;
        Collections.sort(points);
    }

    public Point getPoint(final int index) {
        return points.get(index);
    }

    public int size() {
        return points.size();
    }
}