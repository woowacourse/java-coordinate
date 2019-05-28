package coordinate.domain;

public class Line extends Figure {
    private static final int VALID_LENGTH_OF_POINTS = 2;

    public Line(Vertices vertices) {
        super(vertices, VALID_LENGTH_OF_POINTS);
    }

    public double length() {
        return getVertices().vector(0, 1).length();
    }

    @Override
    public String toString() {
        return "두 점 사이의 거리는 " + length();
    }
}
