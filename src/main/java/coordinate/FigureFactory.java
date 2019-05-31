package coordinate;

import coordinate.domain.Point;

import java.util.List;

public interface FigureFactory {
    Figure create(final List<Point> points);
}
