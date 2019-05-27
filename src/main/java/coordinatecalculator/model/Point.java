package coordinatecalculator.model;


import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Point implements Comparable<Point> {

    private static final Pattern PATTERN = Pattern.compile("\\(([0-9]*),([0-9]*)\\)");
    private static final int ZERO = 0;
    private static final int SQUARE = 2;
    private final Coordinate xPoint;
    private final Coordinate yPoint;

    public Point(String inputPoint) {
        Matcher matcher = PATTERN.matcher(inputPoint);
        if (!matcher.find()) {
            throw new IllegalArgumentException("잘못된 입력 형식입니다.");
        }
        this.xPoint = new Coordinate(matcher.group(1));
        this.yPoint = new Coordinate(matcher.group(2));
    }

    public Coordinate getXPoint() {
        return xPoint;
    }

    public Coordinate getYPoint() {
        return yPoint;
    }

    public int calculateSquareOfTwoPointsSubtract(Point anotherPoint) {
        return (int) (Math.pow(this.xPoint.subtract(anotherPoint.xPoint), SQUARE)
                + Math.pow(this.yPoint.subtract(anotherPoint.yPoint), SQUARE));
    }

    public boolean isDifferBothXY(Point point) {
        return !xPoint.equals(point.xPoint) && !yPoint.equals(point.yPoint);
    }

    public double calculateSlope(Point point) {
        if (xPoint.subtract(point.xPoint) == ZERO) {
            return Double.MAX_VALUE;
        }
        return yPoint.subtract(point.yPoint) / xPoint.subtract(point.xPoint);
    }

    public Distance calculateDistance(Point anotherPoint) {
        return new Distance(this, anotherPoint);
    }

    @Override
    public String toString() {
        return "xPoint : " + xPoint + " yPoint : " + yPoint;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Point point = (Point) o;
        if (!xPoint.equals(point.xPoint)) return false;
        return yPoint.equals(point.yPoint);

    }

    @Override
    public int hashCode() {
        int result = xPoint.hashCode();
        result = 31 * result + yPoint.hashCode();
        return result;
    }

    @Override
    public int compareTo(Point o) {
        if (xPoint.equals(o.xPoint)) {
            return yPoint.compareTo(o.yPoint);
        }
        return xPoint.compareTo(o.xPoint);
    }
}
