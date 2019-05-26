package coordinatecalculator.model;

public class Line extends AbstractFigure {
    private static final int LINE_AREA = 1;

    private static final int NUMBER_OF_POINTS_IN_LINE = 2;

    public Line(Points points) {
        super(points);
        validateLine(points);
    }

    private static void validateLine(Points points) {
        if (points.getPointCount() != NUMBER_OF_POINTS_IN_LINE) {
            throw new IllegalArgumentException();
        }
    }

    @Override
    public double area() {
        return LINE_AREA;
    }

}
