package coordinate;

import java.util.List;

public class Line {
    private static final int POW_NUM = 2;

    private final List<Point> points;

    private Line(final List<Point> points) {
        this.points = points;
    }

    public static Line of(final List<Point> points) {
        return new Line(points);
    }

    public Double length() {
        final Double tempX = points.get(0).getX().doubleValue() - points.get(1).getX().doubleValue();
        final Double tempY = points.get(0).getY().doubleValue() - points.get(1).getY().doubleValue();

        return Math.sqrt(Math.pow(tempX, POW_NUM) + Math.pow(tempY, POW_NUM));
    }
}