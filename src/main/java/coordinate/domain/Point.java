package coordinate.domain;

import java.util.Objects;

public class Point {
    private double pointX;
    private double pointY;

    public Point(String x, String y) {
        checkPoint(x, y);
        pointX = Double.parseDouble(x);
        pointY = Double.parseDouble(y);
    }

    double subPointX(double x) {
        return (this.pointX - x);
    }

    double subPointY(double y) {
        return (this.pointY - y);
    }

    private void checkPoint(String x, String y) {
        if (isBlank(x, y)) {
            throw new IllegalArgumentException("공백 넣지 마세요.");
        }
        if (!isDouble(x, y)) {
            throw new IllegalArgumentException("숫자를 입력해 주세요.");
        }
        double tempX = Double.parseDouble(x);
        double tempY = Double.parseDouble(y);
        if (isNotAllowedNumber(tempX, tempY)) {
            throw new IllegalArgumentException("0 이상 24 이하의 수를 입력하세요.");
        }
    }

    private boolean isNotAllowedNumber(double point_x, double point_y) {
        return (point_x > 24 || point_x < 0) || (point_y > 24 || point_y < 0);
    }

    private boolean isDouble(String x, String y) {
        try {
            Double.parseDouble(x);
            Double.parseDouble(y);
            return true;
        } catch (IllegalArgumentException e) {
            return false;
        }
    }

    private boolean isBlank(String x, String y) {
        return x.contains(" ") || y.contains(" ");
    }

    public double findLength(Point point) {
        return Math.sqrt(Math.pow(subPointX(point.pointX), 2) + Math.pow(subPointY(point.pointY), 2));
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
