package coordinate.model;

public class Rectangle extends AbstractFigure {
    private static final int RECTANGLE_COUNT_OF_POINT = 4;

    public Rectangle(Vertices vertices) {
        super(vertices);
        checkRectangle(vertices);
    }

    private void checkRectangle(Vertices vertices) {
        Vector firstNearVector = vertices.getVector(FIRST_POINT, SECOND_POINT);
        Vector secondNearVector = vertices.getVector(FIRST_POINT, THIRD_POINT);

        if (!(firstNearVector.getDotProduct(secondNearVector) == 0 &&
                vertices.getTheFarthestPoint()
                        .equals(vertices.getStandardPoint()
                                .move(firstNearVector.sum(secondNearVector))))) {
            throw new IllegalArgumentException();
        }
    }

    @Override
    public int countOfPoints() {
        return RECTANGLE_COUNT_OF_POINT;
    }

    @Override
    public double getDistance() {
        return 0;
    }

    @Override
    public double getArea() {
        return vertices.getVector(FIRST_POINT, SECOND_POINT)
                .getCrossProduct(vertices.getVector(SECOND_POINT, THIRD_POINT));
    }
}
