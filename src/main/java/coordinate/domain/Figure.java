package coordinate.domain;

import java.util.List;

public class Figure {
    protected final List<Point> points;

    public Figure(List<Point> points, int validLengthOfPoints) {
        validateLengthOfPoints(points, validLengthOfPoints);
        this.points = points;
    }

    private void validateLengthOfPoints(List<Point> points, int validLengthOfPoints) {
        if (points.size() != validLengthOfPoints) {
            throw new IllegalArgumentException("점의 개수가 올바르지 않습니다.");
        }
    }

    public String drawPlane() {
        return null;
    }
}
