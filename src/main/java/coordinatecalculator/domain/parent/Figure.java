package coordinatecalculator.domain.parent;

import coordinatecalculator.domain.Points;

public interface Figure {
    double calculateResult();
    Points getPoints();
    String getResultType();
    String getName();
}
