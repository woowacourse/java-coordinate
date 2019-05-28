package coordinatecalculator.domain;

import java.util.List;

public interface Figure {
    double area();

    List<Point> getPoints();

    String getName();
}
