package coordinatecalculator.model;

import java.util.Objects;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Point {
    private static final String PATTERN = "\\(([0-9]*),([0-9]*)\\)";
    private static final int FIRST_GROUP = 1;
    private static final int SECOND_GROUP = 2;
    private static final int SQUARE_NUMBER = 2;
    private static final int ZERO = 0;

    private final XPoint xPoint;
    private final YPoint yPoint;

    public Point(String inputPoint) {
        Matcher matcher = Pattern.compile(PATTERN).matcher(inputPoint);
        if (!matcher.find()) {
            throw new IllegalArgumentException("잘못된 입력 형식입니다.");
        }
        this.xPoint = new XPoint(matcher.group(FIRST_GROUP));
        this.yPoint = new YPoint(matcher.group(SECOND_GROUP));
    }

    public XPoint getxPoint() {
        return xPoint;
    }

    public YPoint getyPoint() {
        return yPoint;
    }

    public int square(Point anotherPoint) {
        return (int) (Math.pow(this.xPoint.subtract(anotherPoint.xPoint.getValue()), SQUARE_NUMBER)
                + Math.pow(this.yPoint.subtract(anotherPoint.yPoint.getValue()), SQUARE_NUMBER));
    }

    public boolean isDifferentXYValue(Point point) {
        return !xPoint.equals(point.xPoint) && !yPoint.equals(point.yPoint);
    }

    public double getSlope(Point point) {
        if (xPoint.subtract(point.xPoint.getValue()) == ZERO) {
            return Double.MAX_VALUE;
        }
        return yPoint.subtract(point.yPoint.getValue()) / xPoint.subtract(point.xPoint.getValue());
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Point point = (Point) o;
        return Objects.equals(xPoint, point.xPoint) &&
                Objects.equals(yPoint, point.yPoint);
    }

    @Override
    public int hashCode() {
        return Objects.hash(xPoint, yPoint);
    }
}
