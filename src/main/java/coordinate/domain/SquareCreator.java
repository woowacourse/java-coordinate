package coordinate.domain;

import coordinate.Figure;
import coordinate.domain.figure.Square;

import java.util.List;

public class SquareCreator implements FigureCreator {
    @Override
    public Figure create(final List<Point> points) {
        return Square.of(points);
    }
}
