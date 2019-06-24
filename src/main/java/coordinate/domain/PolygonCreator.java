package coordinate.domain;

import java.util.ArrayList;
import java.util.List;

public abstract class PolygonCreator implements FigureCreator {
    public Lines getLinesFromPoints(List<Point> points) {
        List<Line> lines = new ArrayList<>();
        for (int i = 0; i < points.size(); i++) {
            lines.add(new Line(points.get(i), points.get((i + 1) % points.size())));
        }
        return new Lines(lines);
    }
}
