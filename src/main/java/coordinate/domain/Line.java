package coordinate.domain;


import java.util.Objects;

public class Line implements Comparable<Line>, Figure {
    private PointList points;
    private Double length;

    Line(PointList points) {
        this.points = points;
        length = findArea();
    }

    double findSquareArea(Line length) {
        return this.length * length.length;
    }

    boolean isTriangle(Line length, Line longestLine) {
        return (this.length + length.length) > longestLine.length;
    }

    double findTriangleArea(Line line, Line line2) {
        double s = (this.length + line.length + line2.length) / 2;
        return Math.sqrt(s * (s - this.length) * (s - line.length) * (s - line2.length));
    }

    @Override
    public int compareTo(Line o) {
        return Double.compare(o.length, length);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Line line = (Line) o;
        return Objects.equals(length, line.length);
    }

    @Override
    public int hashCode() {
        return Objects.hash(points, length);
    }

    @Override
    public double findArea() {
        return  this.points.getPoint(0).findLength(points.getPoint(1));
    }

    @Override
    public String findResult() {
        return "두 점 사이의 거리는 "+length+" 입니다.";
    }

}
