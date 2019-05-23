package coordinate.domain;

import java.util.List;

public class Line extends Shape {
    public Line(final List<Point> points) {
        super(points);
    }

    @Override
    public String toString() {
        return "두점 사이의 거리는 " + getDistance();
    }

    public double getDistance() {
        return getSides().get(0);
    }
}
