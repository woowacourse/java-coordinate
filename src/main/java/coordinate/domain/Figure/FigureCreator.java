package coordinate.domain.Figure;

import coordinate.domain.point.PointGroup;

import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;

public interface FigureCreator {
    Map<Integer, Function<PointGroup, Figure>> figures = new HashMap<Integer, Function<PointGroup, Figure>>() {
        {
            put(1, (points) -> null);
            put(2, (points) -> new Line(points));
            put(3, (points) -> new Triangle(points));
            put(4, (points) -> new Rectangle(points));
        }
    };

    Figure create(PointGroup points);
}
