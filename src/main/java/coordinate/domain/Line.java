package coordinate.domain;

import java.util.Objects;

public class Line {

    private final Points points;

    private Line(Point point1, Point point2) {
        if (Objects.isNull(point1) || Objects.isNull(point2)) {
            throw new IllegalArgumentException("점이 하나밖에 입력되지 않았습니다.");
        }

        this.points = Points.create();
        points.addPoint(point1);
        points.addPoint(point2);
    }

    public static Line create(Point point1, Point point2) {
        return new Line(point1, point2);
    }

    public double calculateDistance() {
        return points.pointsByIndex(0).getDistance(points.pointsByIndex(1));
    }

    public Points getPoints() {
        return points;
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
        return "Line{" +
                "points=" + points +
                '}';
    }
}
