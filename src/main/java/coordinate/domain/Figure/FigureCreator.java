package coordinate.domain.Figure;

import coordinate.domain.point.PointGroup;

public interface FigureCreator {
    Figure create(PointGroup points);
}
