package coordinate;

import coordinate.domain.Point;

public interface Figure {

    double getArea();

    boolean hasPoint(final Point point);

    String getName();
}
