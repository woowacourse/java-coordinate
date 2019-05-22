package coordinatecalculator.domain;

import java.util.List;

public interface Shape {
    double getScore();

    void isValidShape(List<Coordinate> coordinates);
}
