package coordinate.domain.creator;

import coordinate.Figure;
import coordinate.domain.FigureCreator;
import coordinate.domain.Point;
import coordinate.domain.Square;

import java.util.List;

public class SquareCreator implements FigureCreator {
    @Override
    public Figure create(final List<Point> points) {
        return Square.of(points);
    }
}
