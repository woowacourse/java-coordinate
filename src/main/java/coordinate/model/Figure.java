package coordinate.model;

import java.util.List;

public interface Figure {
    List<Point> getPoints();

    int countOfPoints();

    double area();
}
