package coordinate.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;

public abstract class AbstractFigure implements Figure {
    private List<Point> points;

    AbstractFigure(List<Point> points) {
        this.points = Collections.unmodifiableList(valid(points));
    }

    private List<Point> valid(List<Point> points) {
        duplicate(points);
        return sort(points);
    }

    private List<Point> sort(List<Point> points) {
        points.sort((a, b) -> {
            if (a.y() == b.y()) {
                return a.x() - b.x();
            }
            return a.y() - b.y();
        });
        return points;
    }

    private void duplicate(List<Point> points) {
        if (new HashSet<Point>(points).size() != points.size()) {
            throw new IllegalArgumentException();
        }
    }

    Point point(int index) {
        return points.get(index);
    }

    abstract void valid();

    @Override
    public List<Point> points() {
        return new ArrayList<>(points);
    }

    @Override
    public abstract double area();

    protected abstract String name();

    @Override
    public String toString() {
        return name() + "의 넓이는 " + area() + "입니다.";
    }
}
