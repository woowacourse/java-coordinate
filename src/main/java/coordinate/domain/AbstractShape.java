package coordinate.domain;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public abstract class AbstractShape implements Shape {
    private static final int START_POINT = 0;

    List<Double> lines = new ArrayList<>();

    AbstractShape(List<Point> points) {
        extractLinesFromPolygon(points);
    }

    private void extractLinesFromPolygon(List<Point> points) {
        while (!points.isEmpty()) {
            extractLinesFromOnePoint(points.remove(START_POINT), points);
        }
    }

    private void extractLinesFromOnePoint(Point startPoint, List<Point> endPoints) {
        for (Point endPoint : endPoints) {
            double lineLength = new Line(Arrays.asList(startPoint, endPoint)).area();
            lines.add(lineLength);
        }
    }
}
