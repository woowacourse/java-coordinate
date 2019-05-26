package coordinate;

import coordinate.domain.Point;

public interface Figure {

    Double getArea();

    Boolean hasPoint(final Point point);

    String getName();
}
