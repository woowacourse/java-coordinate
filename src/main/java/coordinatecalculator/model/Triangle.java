package coordinatecalculator.model;

public class Triangle extends AbstractFigure{
    private static final int NUMBER_OF_POINTS_IN_TRIANGLE = 3;

    public Triangle(Points points) {
        super(points);
        validateTriangle(points);
    }

    private static void validateTriangle(Points points) {
        if (points.getPointCount() != NUMBER_OF_POINTS_IN_TRIANGLE) {
            throw new IllegalArgumentException();
        }
    }

    @Override
    public double area() {
        return 0;
    }

    @Override
    public double distance(int originPointIndex, int destinationPointIndex) {
        return 0;
    }
}
