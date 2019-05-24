package coordinate.domain.nonefigure;

import coordinate.domain.figure.Line;

import java.util.ArrayList;
import java.util.List;

public class PointGroup {
    private final List<Point> points;

    public PointGroup(List<Point> points) {
        this.points = points;
    }


    public List<Line> getLines() {
        List<Line> lines = new ArrayList<>();
        for (int i = 0; i < points.size(); i++) {
            lines.add(new Line(points.get(i), points.get((i + 1) % points.size())));
        }
        return lines;
    }

    public boolean have(int x, int y) {
        return points.contains(Point.create(x, y));
    }

    public int size() {
        return points.size();
    }

    public Point getPoint(int index) {
        return points.get(index);
    }
}
