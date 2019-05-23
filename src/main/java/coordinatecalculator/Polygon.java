package coordinatecalculator;

import java.util.*;

abstract class Polygon implements Figure {
    protected List<Point> points = new ArrayList<>();
    protected List<Segment> segments = new ArrayList<>();

    private int nextNumber(int number, int max) {
        return (number + 1) % max;
    }

    private void checkDuplicate(List<Point> points) throws IllegalArgumentException {
        Set<Point> set = new HashSet<>();
        for (Point p : points) {
            if (!set.add(p)) { // Set은 중복된 객체를 넣으면 false를 반환한다.
                throw new IllegalArgumentException(ERROR_POINTS_DUPLICATE);
            }
        }
    }

    protected List<Segment> makeSegment(List<Point> points) {
        checkDuplicate(points);
        List<Segment> segments = new ArrayList<>();
        for (int i = 0, length = points.size(), nextNumber; i < length; i++) {
            nextNumber = nextNumber(i, length);
            segments.add(new Segment(points.get(i), points.get(nextNumber)));
        }
        return segments;
    }

    /* 헤론의 공식. 삼각형의 세 변의 길이를 통해 넓이를 구한다.
     * 참고: https://ko.wikipedia.org/wiki/%ED%97%A4%EB%A1%A0%EC%9D%98_%EA%B3%B5%EC%8B%9D */
    protected double heronFormula(double a, double b, double c) {
        double s = (a + b + c) / 2;
        return Math.sqrt(s * (s - a) * (s - b) * (s - c));
    }

    @Override
    public boolean equals(Object another) {
        if (this == another) return true;
        if (another == null || getClass() != another.getClass()) return false;
        final Polygon polygon = (Polygon) another;
        return this.points.equals(polygon.points);
    }

    @Override
    public int hashCode() {
        return Objects.hash(this.points);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Triangle: {");
        for (Point p : points) {
            sb.append(p.toString());
            sb.append(", ");
        }
        sb.append("area: ");
        sb.append(this.area());
        sb.append("}");
        return sb.toString();
    }
}
