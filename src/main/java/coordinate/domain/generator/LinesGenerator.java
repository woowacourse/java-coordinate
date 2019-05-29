package coordinate.domain.generator;

import coordinate.domain.Line;
import coordinate.domain.Lines;
import coordinate.domain.Point;
import coordinate.domain.Points;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class LinesGenerator {
    public static Lines generateLines(Points points) {
        List<Line> lines = new ArrayList<>();
        for (int i = 0; i < points.size(); i++) {
            generateLine(lines, points, i);
        }
        return new Lines(lines);
    }

    private static void generateLine(List<Line> lines, Points points, int target) {
        Point point = points.get(target);
        for (int i = target + 1; i < points.size(); i++) {
            lines.add(new Line(Points.of(Arrays.asList(point, points.get(i)))));
        }
    }
}
