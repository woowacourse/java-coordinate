package coordinatecalculator;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Function;

class FigureFactory {
    private static final Map<Integer, Function<List<Point>, Figure>> map;

    static {
        map = new HashMap<>();
        map.put(1, Point::new);
        map.put(2, Line::new);
        map.put(3, Triangle::new);
        map.put(4, Rectangle::new);
    }

    static Figure of(List<Point> points) throws IllegalArgumentException {
        try {
            return map.get(points.size()).apply(points);
        } catch (NullPointerException e) {
            throw new IllegalArgumentException("유효하지 않은 도형입니다.");
        }
    }
}
