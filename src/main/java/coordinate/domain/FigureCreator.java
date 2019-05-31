package coordinate.domain;

import coordinate.Figure;

import java.util.List;

public interface FigureCreator {
    Figure create(final List<Point> points);
}
