package coordinate.domain;

import java.util.Objects;

public class Line {
    private static final int SQUARE = 2;
    private Point startPoint;
    private Point endPoint;

    public Line(Point startPoint, Point endPoint) {
        this.startPoint = startPoint;
        this.endPoint = endPoint;
    }

    public double getLength() {
        int xDistance = startPoint.getDistanceX(endPoint);
        int yDistance = startPoint.getDistanceY(endPoint);

        return Math.sqrt(Math.pow(xDistance, SQUARE) + Math.pow(yDistance, SQUARE));
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Line line = (Line) o;
        return Objects.equals(startPoint, line.startPoint) &&
                Objects.equals(endPoint, line.endPoint);
    }

    @Override
    public int hashCode() {
        return Objects.hash(startPoint, endPoint);
    }
}
