package coordinate.model;

public class Triangle extends AbstractFigure {
    private static final int TRIANGLE_COUNT_OF_POINT = 3;

    public Triangle(Vertices vertices) {
        super(vertices);
        validateTriangle(vertices);
    }

    private void validateTriangle(Vertices vertices) {
        if (vertices.getVector(FIRST_POINT, SECOND_POINT).equals(vertices.getVector(SECOND_POINT, THIRD_POINT))) {
            throw new IllegalArgumentException();
        }
    }

    @Override
    public int countOfPoints() {
        return TRIANGLE_COUNT_OF_POINT;
    }

    @Override
    public double getDistance() {
        return 0;
    }

    @Override
    public double getArea() {
        double lengthA = vertices.calculatorDistance(FIRST_POINT, SECOND_POINT);
        double lengthB = vertices.calculatorDistance(SECOND_POINT, THIRD_POINT);
        double lengthC = vertices.calculatorDistance(THIRD_POINT, FIRST_POINT);
        double s = (lengthA + lengthB + lengthC) / 2;

        return Math.sqrt(s * (s - lengthA) * (s - lengthB) * (s - lengthC));
    }
}
