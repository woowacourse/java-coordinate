package coordinate.domain;


import java.util.Objects;

public class Line implements Comparable<Line>, Figure {
    static final int POINTS_NUMBER = 2;
    private Double length;

    Line(double length) {
        this.length = length;
    }

    double calculateSquareArea(Line length) {
        return this.length * length.length;
    }

    boolean isTriangle(Line secondLongest, Line thirdLongest) {
        return (secondLongest.length + thirdLongest.length) > this.length;
    }

    double calculateTriangleArea(Line secondLongest, Line thirdLongest) {
        double s = (this.length + secondLongest.length + thirdLongest.length) / 2;
        return Math.sqrt(s * (s - this.length) * (s - secondLongest.length) * (s - thirdLongest.length));
    }

    @Override
    public int compareTo(Line o) {
        return Double.compare(o.length, length);
    }

    public double getArea() {
        return length;
    }

    @Override
    public String getResult() {
        return "두 점 사이의 거리는 %.2f 입니다.";
    }


    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Line line = (Line) o;
        return Objects.equals(length, line.length);
    }

    @Override
    public int hashCode() {
        return Objects.hash(length);
    }
}


