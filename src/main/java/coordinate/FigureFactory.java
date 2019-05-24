package coordinate;

import coordinate.domain.*;

import java.util.HashMap;
import java.util.List;
import java.util.function.Function;

class FigureFactory {
    private static final int POINTS_NUMBER_IN_LINE = 2;
    private static final int POINTS_NUMBER_IN_TRIANGLE = 3;
    private static final int POINTS_NUMBER_IN_RECTANGLE = 4;

    private final static HashMap<Integer, Function<List<Point>, Figure>> map = new HashMap<>();

    static {
        map.put(POINTS_NUMBER_IN_LINE, StraightLine::create);
        map.put(POINTS_NUMBER_IN_TRIANGLE, Triangle::create);
        map.put(POINTS_NUMBER_IN_RECTANGLE, Rectangle::create);
    }

    static Figure getFigureOf(List<Point> points) {
        if (map.containsKey(points.size())) {
            return map.get(points.size()).apply(points);
        }

        throw new IllegalArgumentException("도형을 만들 수 없습니디.");
    }
}
