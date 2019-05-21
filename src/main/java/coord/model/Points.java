package coord.model;

import java.util.HashSet;
import java.util.List;

public class Points {
    private final List<Point> points;

    public Points(List<Point> points) {
        if (points.size() != new HashSet<>(points).size()) {
            throw new IllegalArgumentException();
        }
        this.points = points;
    }

    public Points sortByDescYAscX() {
        points.sort((a, b) -> {
            if (a.y == b.y) {
                return a.x - b.x;
            }
            return b.y - a.y;
        });
        return this;
    }

    public Figure toFigure() {
        switch (points.size()) {
            case 2:
                return new Line(this);
            case 3:
                return new Triangle(this);
            case 4:
                return new Rectangle(this);
            default:
                throw new IllegalArgumentException();
        }
    }

    public Point get(int index) {
        return points.get(index);
    }

    public List<Point> getPoints() {
        return points;
    }
}