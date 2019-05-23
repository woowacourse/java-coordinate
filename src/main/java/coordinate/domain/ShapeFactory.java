package coordinate.domain;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Function;

public class ShapeFactory implements ShapeCreator {
    private static final Map<Integer, Function<List<Point>, Shape>> FUNCTION_MAP = new HashMap<>();

    static {
        FUNCTION_MAP.put(2, Line::new);
        FUNCTION_MAP.put(3, Triangle::new);
        FUNCTION_MAP.put(4, Rectangle::new);
    }

    @Override
    public Shape create(final List<Point> points) {
        return FUNCTION_MAP.get(points.size()).apply(points);
    }
}
