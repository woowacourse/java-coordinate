package coordinatecalculator.model;

public class Line extends AbstractFigure {
    private static final int ORIGIN_POINT_INDEX = 0;
    private static final int DESTINATION_POINT_INDEX = 1;

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
    public double calculateFigureInformation() {
        return distance(ORIGIN_POINT_INDEX, DESTINATION_POINT_INDEX );
    }
}
