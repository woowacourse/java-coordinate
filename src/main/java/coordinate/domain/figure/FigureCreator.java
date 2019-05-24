package coordinate.domain.figure;

import coordinate.domain.point.PointGroup;

public interface FigureCreator {
    Figure create(PointGroup points);
}
