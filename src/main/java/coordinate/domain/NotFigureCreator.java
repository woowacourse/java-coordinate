package coordinate.domain;

import coordinate.Figure;
import coordinate.FigureCreator;

import java.util.List;

public class NotFigureCreator implements FigureCreator {
    @Override
    public Figure create(final List<Point> points) {
        return NotFigure.of(points);
    }
}
