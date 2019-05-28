package coordinate.domain;


import java.util.Objects;

public class Line implements Comparable<Line>, Figure {
    static final int POINTS_NUMBER = 2;
    private double length;

    Line(double length) {
        this.length = length;
    }

    double addLength(Line line) {
        return this.length + line.length;
    }

    double addTwoLength(Line line, Line line2) {
        return this.length + line.length + line2.length;
    }

    double multipleLength(Line line) {
        return this.length * line.length;
    }


    public double getLength() {
        return length;
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


