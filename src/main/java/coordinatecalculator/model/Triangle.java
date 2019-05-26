package coordinatecalculator.model;

public class Triangle extends AbstractFigure{
    private static final int NUMBER_OF_POINTS_IN_TRIANGLE = 3;

    private static final int FIRST_POINT_INDEX = 0;
    private static final int SECOND_POINT_INDEX = 1;
    private static final int THIRD_POINT_INDEX = 2;

    public Triangle(Points points) {
        super(points);
        this.validateTriangle(points);
    }

    private void validateTriangle(Points points) {
        if (points.getPointCount() != NUMBER_OF_POINTS_IN_TRIANGLE) {
            throw new IllegalArgumentException();
        }
        if (this.getPoint(0).getSlope(this.getPoint(1)) == this.getPoint(0).getSlope(this.getPoint(2))) {
            throw new IllegalArgumentException();
        }
    }

    @Override
    public double area() {
        double a = distance(FIRST_POINT_INDEX, SECOND_POINT_INDEX);
        double b = distance(SECOND_POINT_INDEX, THIRD_POINT_INDEX);
        double c = distance(THIRD_POINT_INDEX, FIRST_POINT_INDEX);
        double s = (a + b + c) / 2;
        return Math.sqrt(s * (s - a) * (s - b) * (s - c));
    }

}
