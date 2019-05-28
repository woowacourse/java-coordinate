package coordinate.domain;

import java.util.HashMap;
import java.util.Map;

public class ShapeFactory {
    private static final Map<Integer, ShapeCreator> FUNCTION_MAP = new HashMap<>();

    static {
        FUNCTION_MAP.put(2, Line::new);
        FUNCTION_MAP.put(3, Triangle::new);
        FUNCTION_MAP.put(4, Rectangle::new);
    }

    public Shape create(final Points points) {
        Shape shape;
        try {
            shape = FUNCTION_MAP.get(points.size()).create(points);
        } catch (NullPointerException e) {
            throw new IllegalArgumentException("올바른 점의 갯수를 입력해 주세요");
        }
        return shape;
    }
}
