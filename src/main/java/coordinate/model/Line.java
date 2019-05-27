package coordinate.model;

public class Line extends AbstractFigure {
    private static final int LINE_COUNT_OF_POINT = 2;

    public Line(Vertices vertices) {
        super(vertices);
    }

    @Override
    public int countOfPoints() {
        return LINE_COUNT_OF_POINT;
    }

    @Override
    public double getDistance() {
        return vertices.calculatorDistance(FIRST_POINT, SECOND_POINT);
    }

    @Override
    public double getArea() {
        return 0;
    }
}
