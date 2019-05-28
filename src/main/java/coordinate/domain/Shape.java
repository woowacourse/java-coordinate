package coordinate.domain;

import java.util.ArrayList;
import java.util.List;

public abstract class Shape {
    private Points points;

    public Shape(final Points points) {
        this.points = points;
    }

    public List<Double> getSides() {
        return points.getAllDistances();
    }

    public List<Integer> getAllSideSquares() {
        return points.getAllDistanceSquares();
    }
}
