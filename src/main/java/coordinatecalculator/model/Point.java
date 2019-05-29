package coordinatecalculator.model;

import java.util.Objects;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Point {
    private static final String PATTERN = "([0-9]*),([0-9]*)";
    private static final int FIRST_GROUP = 1;
    private static final int SECOND_GROUP = 2;
    private static final int SQUARE_NUMBER = 2;
    private static final int ZERO = 0;

    private final PointValue pointXValue;
    private final PointValue pointYValue;

    public Point(String inputPoint) {
        Matcher matcher = Pattern.compile(PATTERN).matcher(inputPoint);
        if (!matcher.find()) {
            throw new IllegalArgumentException("잘못된 입력 형식입니다.");
        }
        this.pointXValue = new PointFactory().create("x", matcher.group(FIRST_GROUP));
        this.pointYValue = new PointFactory().create("y", matcher.group(SECOND_GROUP));
    }

    public PointValue getXPoint() {
        return pointXValue;
    }

    public PointValue getYPoint() {
        return pointYValue;
    }

    public int square(Point anotherPoint) {
        return (int) (Math.pow(this.pointXValue.subtract(anotherPoint.pointXValue.getValue()), SQUARE_NUMBER)
                + Math.pow(this.pointYValue.subtract(anotherPoint.pointYValue.getValue()), SQUARE_NUMBER));
    }

    public boolean isDifferentXYValue(Point point) {
        return !pointXValue.equals(point.pointXValue) && !pointYValue.equals(point.pointYValue);
    }

    public double getSlope(Point point) {
        if (pointXValue.subtract(point.pointXValue.getValue()) == ZERO) {
            return Double.MAX_VALUE;
        }
        return pointYValue.subtract(point.pointYValue.getValue()) / pointXValue.subtract(point.pointXValue.getValue());
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Point point = (Point) o;
        return Objects.equals(pointXValue, point.pointXValue) &&
                Objects.equals(pointYValue, point.pointYValue);
    }

    @Override
    public int hashCode() {
        return Objects.hash(pointXValue, pointYValue);
    }
}
