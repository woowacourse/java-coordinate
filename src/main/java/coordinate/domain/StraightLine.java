package coordinate.domain;

public class StraightLine {
    public static final int SQUARE = 2;

    final Point startPoint;
    final Point endPoint;

    StraightLine(Point startPoint, Point endPoint) {
        validateEqualityOf(startPoint, endPoint);
        this.startPoint = startPoint;
        this.endPoint = endPoint;
    }

    private void validateEqualityOf(Point startPoint, Point endPoint) {
        if (startPoint.equals(endPoint)) {
            throw new IllegalArgumentException("서로 다른 두 점을 입력해야 합니다.");
        }
    }

    public double calculateLength() {
        return Math.sqrt(Math.pow(startPoint.getDeltaXTo(endPoint), SQUARE)
                + Math.pow(startPoint.getDeltaYTo(endPoint), SQUARE));
    }
}
