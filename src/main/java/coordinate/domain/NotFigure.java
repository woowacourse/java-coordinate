package coordinate.domain;

import coordinate.AbstractFigure;

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
}
