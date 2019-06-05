package coordinate.domain;

import java.util.List;

import static coordinate.domain.ShapeType.LINE;

public class Line extends Shape {
    public Line(final List<Point> points) {
        super(points);
        validateShape(points.size());
    }

    private void validateShape(int size) {
        if (size != LINE.getPointSize()) {
            throw new IllegalArgumentException("라인이 아닙니다.");
        }
    }

    @Override
    public String toString() {
        return String.valueOf(getDistance());
    }

    public double getDistance() {
        return getSides().get(0);
    }
}
