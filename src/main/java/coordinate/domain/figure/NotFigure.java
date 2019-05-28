package coordinate.domain.figure;

import coordinate.domain.AbstractFigure;
import coordinate.domain.Point;

import java.util.List;

public class NotFigure extends AbstractFigure {

    private NotFigure(final List<Point> points) {
        super(points);
    }

    public static NotFigure of(final List<Point> points) {
        return new NotFigure(points);
    }

    @Override
    public Double getArea() {
        throw new IllegalArgumentException("점이 한개입니다");
    }

    @Override
    public String getName() {
        throw new IllegalArgumentException("점이 한개입니다");
    }
}
