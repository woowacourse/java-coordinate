package coordinate;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public abstract class AbstractFigure {
    protected final List<Point> points;

    protected AbstractFigure(final List<Point> points) {
        validate(points);
        this.points = points;
    }

    private void validate(final List<Point> points) {
        Set checkSet = new HashSet<>(points);
        if (checkSet.size() != points.size()) {
            throw new IllegalArgumentException("도형을 만들 수 없습니다");
        }
    }

    public abstract Double getArea();
}
