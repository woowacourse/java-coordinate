package coordinate.domain;

        import java.util.ArrayList;
        import java.util.List;

public class FigureFactory {
    private static final int TRIANGLE_LIMIT_SIZE = 3;
    private static final int RECTANGLE_LIMIT_SIZE = 4;

    public static Figure generateFigure(PointList pointList) {
        if (pointList.getSize() == TRIANGLE_LIMIT_SIZE) {
            return new Triangle(findLine(pointList));
        }
        if (pointList.getSize() == RECTANGLE_LIMIT_SIZE) {
            return new Rectangle(findLine(pointList));
        }
        return generateLine(pointList.getPoint(0), pointList.getPoint(1));
    }

    private static List<Line> findLine(PointList points) {
        List<Line> lines = new ArrayList<>();
        for (int i = 0; i < points.getSize(); i++) {
            addLine(points, lines, i);
        }
        lines.sort(null);
        return lines;
    }

    private static void addLine(PointList points, List<Line> lines, int index) {
        for (int j = index + 1; j < points.getSize(); j++) {
            lines.add(generateLine(points.getPoint(index), points.getPoint(j)));
        }
    }

    private static Line generateLine(Point point1, Point point2) {
        return new Line(point1.findLength(point2));
    }
}
