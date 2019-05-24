package coordinate.model;

import java.util.List;

public interface Figure {
    List<Point> getPoints();

    int size();

    double area();

    double distance(int originPoint, int destinationPoint);
}
