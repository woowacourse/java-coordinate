package coordinate.model;

import java.util.List;

public abstract class Figure implements Shape {

    protected Points points;

    public Figure(List<Point> points) {
        this.points = new Points(points);
    }

    public List<Point> getPoints() {
        return points.getPoints();
    }
}
