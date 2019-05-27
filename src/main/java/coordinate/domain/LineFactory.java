package coordinate.domain;

import java.util.ArrayList;
import java.util.List;

public class LineFactory {

    public static Lines generateLines(Points points) {
        List<Line> lines = new ArrayList<>();
        for (int i = 0; i < points.getSize(); i++) {
            for (int j = i + 1; j < points.getSize(); j++) {
                lines.add(generateLine(points.getPoint(i), points.getPoint(j)));
            }
        }
        lines.sort(Line::compareTo);
        return new Lines(lines);
    }

    public static Line generateLine(Point point1, Point point2) {
        return new Line(point1.getLength(point2));
    }
}
