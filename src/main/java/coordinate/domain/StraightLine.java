package coordinate.domain;

import java.util.List;

public class StraightLine extends Figure {
    private static final int START_INDEX = 0;
    private static final int END_INDEX = 1;
    private static final int NUM_OF_POINT = 2;
    private static final int SQUARE = 2;

    public StraightLine(List<Point> points) {
        super(points);
        validateSizeOf(points);
        this.points = points;
    }

    @Override
    public double calculateAttribute() {
        return calculateLength();
    }

    private void validateSizeOf(List<Point> points) {
        if (points.size() != NUM_OF_POINT) {
            throw new IllegalArgumentException("점의 갯수가 두개여야 합니다.");
        }
    }

    public double calculateLength() {
        Point startPoint = points.get(START_INDEX);
        Point endPoint = points.get(END_INDEX);
        return Math.sqrt(Math.pow(startPoint.getDeltaXTo(endPoint), SQUARE)
                + Math.pow(startPoint.getDeltaYTo(endPoint), SQUARE));
    }

    public double calculateSlope() {
        Point startPoint = points.get(START_INDEX);
        Point endPoint = points.get(END_INDEX);
        if (startPoint.getDeltaXTo(endPoint) == 0) {
            return Double.POSITIVE_INFINITY;
        }
        return startPoint.getDeltaYTo(endPoint) / startPoint.getDeltaXTo(endPoint);
    }
}
