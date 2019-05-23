package coordinate.domain;

import java.util.Objects;

public class Line extends Figure{

    public Line(Points points) {
        super("두 점 사이의 거리는 : ", points);
    }

    @Override
    public double calculateResult() {
        return points.getPoints(0).calculateDistance(points.getPoints(1));
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
