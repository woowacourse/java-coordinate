package coordinate.domain;

import java.util.List;

public class StraightLine {
    private static final int START_INDEX = 0;
    private static final int END_INDEX = 1;
    private static final int NUM_OF_POINT = 2;
    private static final int SQUARE = 2;

    private final Point startPoint;
    private final Point endPoint;

    public StraightLine(List<Point> points) {
        validateSizeOf(points);
        validateEqualityOf(points.get(START_INDEX), points.get(END_INDEX));
        this.startPoint = points.get(START_INDEX);
        this.endPoint = points.get(END_INDEX);
    }

    private void validateSizeOf(List<Point> points) {
        if (points.size() != NUM_OF_POINT) {
            throw new IllegalArgumentException("점의 갯수가 두개여야 합니다.");
        }
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
