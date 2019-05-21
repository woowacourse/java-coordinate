package coordinate.domain;

public class Point {
    private static final int MAX_COORDINATE_VALUE = 24;
    private static final int MIN_COORDINATE_VALUE = 0;

    private final double x;
    private final double y;

    public Point(double x, double y) {
        checkCoordinateValue(x);
        checkCoordinateValue(y);
        this.x = x;
        this.y = y;
    }

    private void checkCoordinateValue(double coordinateValue) {
        if (coordinateValue < MIN_COORDINATE_VALUE || coordinateValue > MAX_COORDINATE_VALUE) {
            throw new IllegalArgumentException("좌표가 범위를 벗어났습니다.");
        }
    }


}
