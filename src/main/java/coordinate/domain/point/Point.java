package coordinate.domain.point;

import java.util.Objects;

public class Point implements Comparable<Point> {
    private final Coordinate xCoordinate;
    private final Coordinate yCoordinate;

    private Point(Coordinate xCoordinate, Coordinate yCoordinate) {
        this.xCoordinate = xCoordinate;
        this.yCoordinate = yCoordinate;
    }

    public static Point create(int xCoordinate, int yCoordinate) {
        return new Point(new Coordinate(xCoordinate), new Coordinate(yCoordinate));
    }

    /*
     두 점 간의 길이의 제곱 값을 반환.
     제곱근을 구해 반환할 경우 다시 제곱을 하였을 때, 값의 오차가 발생하여 Figure 객체들에서 계산이 어려운 점을 고려.
     */
    public double squaredDistanceFrom(Point point) {
        return Math.pow(this.xCoordinate.differenceFrom(point.xCoordinate), 2)
                + Math.pow(this.yCoordinate.differenceFrom(point.yCoordinate), 2);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Point point = (Point) o;
        return point.xCoordinate.equals(xCoordinate)
                && point.yCoordinate.equals(yCoordinate);
    }

    @Override
    public int hashCode() {
        return Objects.hash(xCoordinate.hashCode() + yCoordinate.hashCode());
    }

    @Override
    public int compareTo(Point point) {
        int priority = point.xCoordinate.differenceFrom(xCoordinate);
        if (priority == 0) {
            return point.yCoordinate.differenceFrom(yCoordinate);
        }
        return priority;
    }
}
