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

}
