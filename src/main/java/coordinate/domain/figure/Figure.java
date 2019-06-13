package coordinate.domain.figure;

import coordinate.domain.point.Point;

import java.util.List;

public interface Figure {
    List<Point> getPoints();
    int size();
    String getName();
    double area();
    boolean contain(Point point);
}
