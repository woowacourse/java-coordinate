package coordinate.domain;

import coordinate.Figure;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public abstract class AbstractFigure implements Figure {
    protected final List<Point> points;

    protected AbstractFigure(final List<Point> points) {
        validate(points);
        this.points = points;
    }

    private void validate(final List<Point> points) {
        Set checkSet = new HashSet<>(points);
        if (checkSet.size() != points.size()) {
            throw new IllegalArgumentException("위치가 같은 점이 존재합니다");
        }
    }

    @Override
    public Boolean hasPoint(final Point point) {
        return points.contains(point);
    }
}
