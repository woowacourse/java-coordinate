package coordinate.domain.figure.line;

import coordinate.domain.figure.AbstractFigure;
import coordinate.domain.point.Point;

import java.util.List;

public class Line extends AbstractFigure {
    public static final int LINE_SIZE = 2;
    private static final String LINE_NAME = "선";

    public Line(List<Point> points) {
        super(points);
    }

    @Override
    public int size() {
        return LINE_SIZE;
    }

    @Override
    public String getName() {
        return LINE_NAME;
    }

    @Override
    public double area() {
        return getPoint(0).calculateDistance(getPoint(1));
    }
}
