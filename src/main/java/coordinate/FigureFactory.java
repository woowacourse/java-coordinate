package coordinate;

import coordinate.domain.*;

import java.util.List;

public class FigureFactory {
    private static final int POINTS_NUMBER_IN_LINE = 2;
    private static final int POINTS_NUMBER_IN_TRIANGLE = 3;
    private static final int POINTS_NUMBER_IN_RECTANGLE = 4;

    public static Figure getFigureOf(List<Point> points) {
        if (points.size() == POINTS_NUMBER_IN_LINE) {
            return new StraightLine(points);
        }

        if (points.size() == POINTS_NUMBER_IN_TRIANGLE) {
            return new Triangle(points);
        }

        if (points.size() == POINTS_NUMBER_IN_RECTANGLE) {
            return new Rectangle(points);
        }

        throw new IllegalArgumentException("도형을 만들 수 없습니디.");
    }
}
