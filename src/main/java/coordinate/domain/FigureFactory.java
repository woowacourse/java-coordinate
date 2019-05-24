package coordinate.domain;

import java.util.ArrayList;
import java.util.List;

public class FigureFactory {
    public static Figure generateFigure(PointList pointList) {
        if (pointList.getSize() == 3) {
            return new Triangle(findLine(pointList));
        }
        if (pointList.getSize() == 4) {
            return new Square(findLine(pointList));
        }
        return generateLine(pointList.getPoint(0),pointList.getPoint(1));
    }

    private static List<Line> findLine(PointList points) {
        List<Line> lines = new ArrayList<>();
        for (int i = 0; i < points.getSize(); i++) {
            for (int j = i + 1; j < points.getSize(); j++) {
                lines.add(generateLine(points.getPoint(i),points.getPoint(j)));
            }
        }
        lines.sort(null);
        return lines;
    }

    private static Line generateLine(Point point1, Point point2) {
        return new Line(point1.findLength(point2));
    }
}
