package coordinate.domain;

public class Triangle extends Figure implements AvailableArea {
    private static final int VALID_LENGTH_OF_POINTS = 3;

    public Triangle(Vertices vertices) {
        super(vertices, VALID_LENGTH_OF_POINTS);
        validateTrianglePoints();
    }

    private void validateTrianglePoints() {
        if (getVertices().vector(0,1).crossProduct(getVertices().vector(1,2)) == 0)
            throw new IllegalArgumentException("세점이 직선 위에 있습니다.");
    }

    @Override
    public double area() {
        return getVertices().integrateArea();
    }
}
