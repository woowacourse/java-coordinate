package coordinate.domain;

import java.util.List;

public interface Shape {
    Shape setShape(List<Point> points);

    double area();
}
