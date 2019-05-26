package coordinatecalculator.domain;

import java.util.List;

public class Line extends AbstractFigure {
    private static final int FIRST_POINT = 0;
    private static final int SECOND_POINT = 1;
    private static final String LINE_NAME = "선";
    private static final int LINE_SIZE = 2;
    private static final int EMPTY = 0;

    Line(final List<Point> points) {
        super(points);
    }

    public double getLength() {
        Point startPoint = getPoint(FIRST_POINT);
        Point endPoint = getPoint(SECOND_POINT);

        return startPoint.getDistance(endPoint);
    }

    @Override
    public double area() {
        return EMPTY;
    }

    @Override
    public String getName() {
        return LINE_NAME;
    }

    @Override
    public int size() {
        return LINE_SIZE;
    }
}
