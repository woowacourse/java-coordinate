package coordinate.domain;

import java.util.List;

public interface CalculableFigure {
    double calculateArea();

    List<Point> getPoints();

    int getNumOfPoints();
}
