package coordinate.model;

import java.util.List;

public class Line implements Shape {
    private List<Point> points;

    public Line(List<Point> points) {
        this.points = points;
    }

    @Override
    public double getScore() {
        return points.get(0).getDistance(points.get(1));
    }
}
