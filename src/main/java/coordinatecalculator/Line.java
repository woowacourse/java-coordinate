package coordinatecalculator;

import java.text.DecimalFormat;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;

public class Line extends Polygon {
    private Point start;
    private Point end;

    private static final DecimalFormat FORMAT = new DecimalFormat("0.###");

    Line(List<Point> points) {
        super(points);
        start = this.points.get(0);
        end = this.points.get(1);
    }

    public static Line of(Point start, Point end) {
        return new Line(Arrays.asList(start, end));
    }

    double getLength() {
        return this.start.getDistance(this.end);
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

    @Override
    public String toString() {
        return "두 점 사이의 거리는 "
                + FORMAT.format(getLength())
                + "입니다.";
    }
}
