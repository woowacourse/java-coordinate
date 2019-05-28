package coordinate.domain.shape;

import coordinate.domain.point.Point;

import java.util.List;
import java.util.Objects;

public class Line implements Shape {
    private static final int SQUARE = 2;
    private static final int START_POINT = 0;
    private static final int END_POINT = 1;

    private final List<Point> points;

    public Line(List<Point> points) {
        this.points = points;
        validateShape();
    }

    @Override
    public void validateShape() {
        if (points.get(START_POINT).equals(points.get(END_POINT))) {
            throw new IllegalArgumentException("위치가 같은 점이 존재합니다.");
        }
    }

    @Override
    public double area() {
        int xDistance = points.get(START_POINT).getDistanceX(points.get(END_POINT));
        int yDistance = points.get(START_POINT).getDistanceY(points.get(END_POINT));

        return Math.sqrt(Math.pow(xDistance, SQUARE) + Math.pow(yDistance, SQUARE));
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Line line = (Line) o;
        return Objects.equals(points, line.points);
    }

    @Override
    public int hashCode() {
        return Objects.hash(points);
    }

    @Override
    public String toString() {
        return "두 점 사이 거리는 " + area();
    }
}
