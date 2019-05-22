package coordinatecalculator.domain.parent;

import coordinatecalculator.domain.Points;

public interface Figure {
    int calculateLength(Points points);
    int calculateArea(Points points);
}
