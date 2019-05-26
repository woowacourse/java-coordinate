package coordinate.domain;

import java.util.Objects;

public class Point {
    private int pointX;
    private int pointY;

    public Point(int x, int y) {
        checkPoint(x, y);
        pointX = x;
        pointY = y;
    }

    double calculateLength(Point point) {
        return Math.sqrt(Math.pow(subPointX(point.pointX), 2) + Math.pow(subPointY(point.pointY), 2));
    }

    private double subPointX(int x) {
        return (this.pointX - x);
    }

    private double subPointY(int y) {
        return (this.pointY - y);
    }

    private void checkPoint(int x, int y) {
        if (isNotAllowedNumber(x, y)) {
            throw new IllegalArgumentException("0 이상 24 이하의 수를 입력하세요.");
        }
    }

    private boolean isNotAllowedNumber(int point_x, int point_y) {
        return (point_x > 24 || point_x < 0) || (point_y > 24 || point_y < 0);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Point point = (Point) o;
        return Double.compare(point.pointX, pointX) == 0 &&
                Double.compare(point.pointY, pointY) == 0;
    }

    @Override
    public int hashCode() {
        return Objects.hash(pointX, pointY);
    }
}
