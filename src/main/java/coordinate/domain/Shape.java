package coordinate.domain;

import java.util.List;

public abstract class Shape {
    public abstract Shape setShape(List<Point> points);

    public abstract double area();
}
