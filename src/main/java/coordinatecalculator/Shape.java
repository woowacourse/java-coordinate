package coordinatecalculator;

import java.util.List;

public abstract class Shape implements Figure{
    private List<Point> points;

    public Shape(List<Point> points) {
        this.points = points;
    }

    public List<Point> getPoints() {
        return points;
    }
}
