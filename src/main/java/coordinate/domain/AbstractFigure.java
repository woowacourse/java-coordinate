package coordinate.domain;

import coordinate.Figure;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public abstract class AbstractFigure implements Figure {
    private final List<Point> points;

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

    protected double getDistance(final int fromIndex, final int toIndex) {
        Point from = points.get(fromIndex);
        Point to = points.get(toIndex);

        return from.getDistance(to);
    }


    protected double sameX(final int origin) {
        Point originPoint = points.get(origin);
        Point sameXPoint = points.subList(1, points.size()).stream()
                .filter(point -> originPoint.isSameX(point))
                .findFirst()
                .orElseThrow(IllegalArgumentException::new);
        return originPoint.getDistance(sameXPoint);
    }

    protected double sameY(final int origin) {
        Point originPoint = points.get(origin);

        Point sameYPoint = points.subList(1, points.size()).stream()
                .filter(point -> originPoint.isSameY(point))
                .findFirst()
                .orElseThrow(IllegalArgumentException::new);
        return originPoint.getDistance(sameYPoint);
    }

    @Override
    public Boolean hasPoint(final Point point) {
        return points.contains(point);
    }
}
