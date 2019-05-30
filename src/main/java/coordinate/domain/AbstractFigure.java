package coordinate.domain;

import java.util.Collections;
import java.util.List;

public abstract class AbstractFigure implements Figure {
    private List<Point> points;

    AbstractFigure(List<Point> points) {
        this.points = Collections.unmodifiableList(sort(points));
    }

    private List<Point> sort(List<Point> points) {
        points.sort((a, b) -> {
            if (a.y == b.y) {
                return a.x - b.x;
            }
            return a.y - b.y;
        });
        return points;
    }

    Point point(int index) {
        return points.get(index);
    }

    @Override
    public abstract double area();

    protected abstract String name();

    @Override
    public String toString() {
        return name() + "의 넓이는 " + area() + "입니다.";
    }
}
