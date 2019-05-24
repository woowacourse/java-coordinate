package coordinate.domain.Figure;

import coordinate.domain.point.PointGroup;

import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;

public class FigureFactory implements FigureCreator {
    Map<Integer, Function<PointGroup, Figure>> figures = new HashMap<Integer, Function<PointGroup, Figure>>() {
        {
            put(1, (points) -> null);
            put(2, (points) -> new Line(points));
            put(3, (points) -> new Triangle(points));
            put(4, (points) -> new Rectangle(points));
        }
    };

    @Override
    public Figure create(PointGroup points) {
        try {
            return figures.get(points.size()).apply(points);
        } catch (NullPointerException e) {
            throw new IllegalArgumentException("허용되지 않은 형태입니다. (라인, 삼각형, 직사각형 허용)");
        }
    }
}
