package coordinate.domain.figure;

import coordinate.domain.point.PointGroup;

import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;

public class FigureFactory {
    private static final Map<Integer, Function<PointGroup, Figure>> figures = new HashMap<Integer, Function<PointGroup, Figure>>() {
        {
            put(Line.POINT_COUNT, (points) -> new Line(points));
            put(Triangle.POINT_COUNT, (points) -> new Triangle(points));
            put(Rectangle.POINT_COUNT, (points) -> new Rectangle(points));
        }
    };

    public static Figure create(PointGroup points) {
        try {
            return figures.get(points.size()).apply(points);
        } catch (NullPointerException e) {
            throw new IllegalArgumentException("허용되지 않은 형태입니다. (라인, 삼각형, 직사각형 허용)");
        }
    }
}
