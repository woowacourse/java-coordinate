package coordinatecalculator.domain;

import java.util.List;

public class Line extends AbstractFigure {
    private static final int FIRST_POINT = 0;
    private static final int SECOND_POINT = 1;

    public Line(List<Point> points) {
        super(points);
    }

    public double getLength() {
        Point startPoint = getPoint(FIRST_POINT);
        Point endPoint = getPoint(SECOND_POINT);

        return startPoint.getDistance(endPoint);
    }

    @Override
    public double area() {
        return 0;
    }
}
