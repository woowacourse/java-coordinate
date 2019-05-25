package coordinate;

import coordinate.domain.Point;

import java.util.List;

public interface Factory {
    Figure create(final List<Point> points);
}
