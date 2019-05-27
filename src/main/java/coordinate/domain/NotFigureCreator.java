package coordinate.domain;

import coordinate.Figure;
import coordinate.domain.FigureCreator;
import coordinate.domain.NotFigure;
import coordinate.domain.Point;

import java.util.List;

public class NotFigureCreator implements FigureCreator {
    @Override
    public Figure create(final List<Point> points) {
        return NotFigure.of(points);
    }
}
