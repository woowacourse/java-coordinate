package coordinate.domain;

import java.util.Objects;

public class Line extends Figure {
    private static final int FIRST_POINT = 0;
    private static final int SECOND_POINT = 1;

    public Line(Points points) {
        super("두 점 사이의 거리는 : ", points);
    }

    @Override
    public double calculateResult() {
        return points.getPoint(FIRST_POINT).calculateDistance(points.getPoint(SECOND_POINT));
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
