package coordinate.domain;

public class Figure {
    protected final Points points;

    Figure(Points points, int validLengthOfPoints) {
        validateLengthOfPoints(points, validLengthOfPoints);
        this.points = points;
    }

    private void validateLengthOfPoints(Points points, int validLengthOfPoints) {
        if (!points.hasSameSizeWith(validLengthOfPoints)) {
            throw new IllegalArgumentException("점의 개수가 올바르지 않습니다.");
        }
    }

    public PlaneCoordinates getPlaneCoordinates() {
        return new PlaneCoordinates(points);
    }
}
