package coordinatecalculator.model;

public class Rectangle extends AbstractFigure{

    private static final int NUMBER_OF_POINTS_IN_RECTANGLE = 4;

    public Rectangle(Points points) {
        super(points);
        validateRectangle(points);
    }

    private static void validateRectangle(Points points) {
        if (points.getPointCount() != NUMBER_OF_POINTS_IN_RECTANGLE) {
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
