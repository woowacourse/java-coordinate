package coordinate.domain;

public class Line extends Figure {
    private static final int VALID_LENGTH_OF_POINTS = 2;

    Line(Points points) {
        super(points, VALID_LENGTH_OF_POINTS);
    }

    double length() {
        return points.length(0, 1);
    }

    @Override
    public String toString() {
        return "두 점 사이의 거리는 " + length();
    }
}
