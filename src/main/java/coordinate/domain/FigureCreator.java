package coordinate.domain;

import coordinate.Figure;
import coordinate.domain.Point;

import java.util.List;

public interface FigureCreator {
    Figure create(final List<Point> points);
}
