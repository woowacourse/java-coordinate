package coordinate.domain;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Function;

import static coordinate.domain.ShapeType.*;

public class ShapeFactory{
    private static final Map<ShapeType, ShapeCreator> FUNCTION_MAP = new HashMap<>();

    static {
        FUNCTION_MAP.put(LINE, Line::new);
        FUNCTION_MAP.put(TRIANGLE, Triangle::new);
        FUNCTION_MAP.put(RECTANGLE, Rectangle::new);
    }

    public static Shape create(final List<Point> points) {
        ShapeType shapeType = ShapeType.vauleOf(points.size());
        if (shapeType == null) {
            throw new IllegalArgumentException("올바름 점의 개수를 입력하세요");
        }
        return FUNCTION_MAP.get(shapeType).create(points);
    }
}
