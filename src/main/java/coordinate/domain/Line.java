package coordinate.domain;

import java.util.List;

public class Line {
    private static final int VALID_LENGTH_OF_POINTS = 2;

    private final List<Point> points;

    public Line(List<Point> points) {
        validateLengthOfPoints(points);
        this.points = points;
    }

    private void validateLengthOfPoints(List<Point> points) {
        if (points.size() != VALID_LENGTH_OF_POINTS) {
            throw new IllegalArgumentException("Line을 만들기 위해서는 점이 두개여야 합니다.");
        }
    }

    public double length() {
        return Math.sqrt(Math.pow(points.get(0).getX() - points.get(1).getX(), 2) + Math.pow(points.get(0).getY() - points.get(1).getY(), 2));
    }

    @Override
    public String toString() {
        return "두 점 사이의 거리는 " + length();
    }
}
