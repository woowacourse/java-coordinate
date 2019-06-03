package coordinate.domain;

public class StraightLine extends Figure implements CalculableFigure{
    private static final int START_POINT = 0;
    private static final int END_POINT = 1;
    private static final int NUM_OF_POINT = 2;
    private static final int SQUARE = 2;

    StraightLine(Points points) {
        super(points);
    }

    @Override
    void validateConfigurableBy(Points points) {
        validateSizeOf(points);
    }

    void validateSizeOf(Points points) {
        if (points.size() != NUM_OF_POINT) {
            throw new IllegalArgumentException("점의 갯수가 두개여야 합니다.");
        }
    }

    double calculateSlope() {
        Point startPoint = points.get(START_POINT);
        Point endPoint = points.get(END_POINT);
        if (startPoint.matchX(endPoint)) {
            return Double.POSITIVE_INFINITY;
        }
        return (double) startPoint.getDeltaYTo(endPoint) / startPoint.getDeltaXTo(endPoint);
    }

    @Override
    public double calculateArea() {
        Point startPoint = points.get(START_POINT);
        Point endPoint = points.get(END_POINT);
        return Math.sqrt(Math.pow(startPoint.getDeltaXTo(endPoint), SQUARE)
                + Math.pow(startPoint.getDeltaYTo(endPoint), SQUARE));
    }
}
