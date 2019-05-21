package coordinate.domain;

import java.util.List;

public class Line extends Figure {
    private static final int VALID_LENGTH_OF_POINTS = 2;

    public Line(List<Point> points) {
        super(points, VALID_LENGTH_OF_POINTS);
    }

    public double length() {
        return Math.sqrt(Math.pow(points.get(0).getX() - points.get(1).getX(), 2) + Math.pow(points.get(0).getY() - points.get(1).getY(), 2));
    }

    @Override
    public String toString() {
        return "두 점 사이의 거리는 " + length();
    }
}
