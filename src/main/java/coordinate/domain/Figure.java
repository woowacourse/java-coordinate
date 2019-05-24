package coordinate.domain;

import java.util.List;

public class Figure {
    static final int MAX_Y = 24;
    static final int MAX_X = 24;

    protected final List<Point> points;

    Figure(List<Point> points, int validLengthOfPoints) {
        validateLengthOfPoints(points, validLengthOfPoints);
        this.points = points;
    }

    private void validateLengthOfPoints(List<Point> points, int validLengthOfPoints) {
        if (points.size() != validLengthOfPoints) {
            throw new IllegalArgumentException(this.getClass().getName()+"의 점의 개수가 올바르지 않습니다.");
        }
    }

    public PlaneCoordinates getPlaneCoordinates() {
        return new PlaneCoordinates(MAX_X, MAX_Y).plotPoints(points);
    }
}
