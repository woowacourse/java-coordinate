package coordinatecalculator.domain.parent;

import coordinatecalculator.domain.Points;

public interface Figure {
    double calculateResult();

    String makeResult();

    Points getPoints();
}
