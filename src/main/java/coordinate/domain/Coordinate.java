package coordinate.domain;

import java.util.List;

public class Coordinate {
    private List<Point> points;

    public Coordinate(List<Point> points) {
        this.points = points;
    }

    public Point getPoint(int index) {
        return points.get(index);
    }
}
