package coordinate.domain;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Function;

public class ShapeFactory{
    private static final Map<Integer, Function<List<Point>, Shape>> FUNCTION_MAP = new HashMap<>();

    static {
        FUNCTION_MAP.put(2, Line::new);
        FUNCTION_MAP.put(3, Triangle::new);
        FUNCTION_MAP.put(4, Rectangle::new);
    }

    public static Shape create(final List<Point> points) {
        Shape shape;
        try {
            shape = FUNCTION_MAP.get(points.size()).apply(points);
        } catch (Exception e) {
            throw new IllegalArgumentException("올바른 점의 갯수를 입력해 주세요");
        }
        return shape;
    }
}
