package coordinate.domain.shape;

import coordinate.domain.point.Point;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public abstract class AbstractShape implements Shape {
    private static final int START_POINT = 0;

    List<Double> lines = new ArrayList<>();

    AbstractShape(List<Point> points) {
        List<Point> copiedPoints = new ArrayList<>(points);
        extractLinesInPolygon(copiedPoints);
    }

    private void extractLinesInPolygon(List<Point> points) {
        while (!points.isEmpty()) {
            Point startPoint = points.remove(START_POINT);
            extractLinesFromOnePoint(startPoint, points);
        }
    }

    private void extractLinesFromOnePoint(Point startPoint, List<Point> otherPoints) {
        for (Point otherPoint : otherPoints) {
            double lineLength = new Line(Arrays.asList(startPoint, otherPoint)).area();
            lines.add(lineLength);
        }
    }
}
