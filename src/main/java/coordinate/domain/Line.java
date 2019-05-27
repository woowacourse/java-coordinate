package coordinate.domain;

import java.util.Objects;

public class Line {

    private final Points points;

    private Line(Points points) {
        if (points.getSize() != 2) {
            throw new IllegalArgumentException("두개의 점이 입력되지 않았습니다.");
        }

        this.points = points;
    }

    public static Line create(Points points) {
        return new Line(points);
    }

    public double calculateDistance() {
        return points.pointsByIndex(0).getDistance(points.pointsByIndex(1));
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
}
