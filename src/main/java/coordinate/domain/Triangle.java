package coordinate.domain;

public class Triangle extends Figure implements AvailableArea {
    private static final int VALID_LENGTH_OF_POINTS = 3;
    private static final String THREE_POINT_IN_LINE_MESSAGE = "세점이 직선 위에 있습니다.";

    public Triangle(Vertices vertices) {
        super(vertices, VALID_LENGTH_OF_POINTS);
        validateTrianglePoints();
    }

    private void validateTrianglePoints() {
        if (vertices.vector(0,1).crossProduct(vertices.vector(1,2)) == 0)
            throw new IllegalArgumentException(THREE_POINT_IN_LINE_MESSAGE);
    }

    @Override
    public double area() {
        return vertices.integrateArea();
    }

    @Override
    public String toString() {
        return "삼각형의 넓이는 " + area();
    }
}
