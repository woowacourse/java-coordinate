package coordinate.domain;

import java.util.List;

public class StraightLine extends Figure {
    private static final int START_INDEX = 0;
    private static final int END_INDEX = 1;
    private static final int NUM_OF_POINT = 2;
    private static final int SQUARE = 2;

    StraightLine(List<Point> points) {
        super(points);
        validateSizeOf(points);
        this.points = points;
    }

    private void validateSizeOf(List<Point> points) {
        if (points.size() != NUM_OF_POINT) {
            throw new IllegalArgumentException("점의 갯수가 두개여야 합니다.");
        }
    }

    double calculateSlope() {
        Point startPoint = points.get(START_INDEX);
        Point endPoint = points.get(END_INDEX);
        if (startPoint.matchX(endPoint)) {
            return Double.POSITIVE_INFINITY;
        }
        return (double) startPoint.getDeltaYTo(endPoint) / startPoint.getDeltaXTo(endPoint);
    }

    @Override
    public double calculateAttribute() {
        return calculateLength();
    }

    double calculateLength() {
        Point startPoint = points.get(START_INDEX);
        Point endPoint = points.get(END_INDEX);
        return Math.sqrt(Math.pow(startPoint.getDeltaXTo(endPoint), SQUARE)
                + Math.pow(startPoint.getDeltaYTo(endPoint), SQUARE));
    }
}