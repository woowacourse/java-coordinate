package coordinatecalculator.domain;

public class Line extends AbstractFigure {
    private static final String LINE_NAME = "선";
    private static final int EMPTY = 0;

    Line(final PointGroup points) {
        super(points);
    }

    public double getLength() {
        Point startPoint = getPoint(FigureConstant.FIRST_POINT);
        Point endPoint = getPoint(FigureConstant.SECOND_POINT);

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
}
