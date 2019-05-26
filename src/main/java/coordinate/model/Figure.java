package coordinate.model;

import java.util.List;

public abstract class Figure implements Shape {

    private Points points;

    public Figure(List<Point> points) {
        this.points = new Points(points);
    }

    public Points getPoints() {
        return points;
    }

    public Point getPoint(int index) {
        return points.get(index);
    }
}
