package coordinatecalculator;

import java.text.DecimalFormat;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Objects;

public class Line extends Polygon {
    private Point start;
    private Point end;

    Line(List<Point> points) {
        super(points);
        start = this.points.get(0);
        end = this.points.get(1);
    }

    public static Line of(Point start, Point end) {
        return new Line(Arrays.asList(start, end));
    }

    Point getStartPoint() {
        return this.start;
    }

    Point getEndPoint() {
        return this.end;
    }

    double getLength() {
        return this.start.getDistance(this.end);
    }

    /* 선의 기울기를 알아내는 메소드.
     * 참고: https://www.geeksforgeeks.org/orientation-3-ordered-points/ */
    double getSlope() {
        return (end.getY() - start.getY()) / (end.getX() - start.getX());
    }

    @Override
    public String getName() {
        return "Line";
    }

    @Override
    public int getPointsCount() {
        return 2;
    }

    @Override
    public double area() {
        return 0;
    }

    @Override
    public List<Point> getPoints() {
        return Arrays.asList(this.start, this.end);
    }

    @Override
    public boolean equals(Object another) {
        if (this == another) return true;
        if (another == null || getClass() != another.getClass()) return false;
        final Line line = (Line) another;
        return start.equals(line.start) &&
                end.equals(line.end);
    }

    @Override
    public int hashCode() {
        return Objects.hash(start, end);
    }

    int compareToSlope(Line another) {
        return Comparator
                .comparingDouble(Line::getSlope)
                .compare(this, another);
    }

    @Override
    public String toString() {
        DecimalFormat format = new DecimalFormat("0.###");
        return "두 점 사이의 거리는 "
                + format.format(getLength())
                + "입니다.";
    }
}
