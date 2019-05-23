package coordinate.domain;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Function;

public class ShapeGenerator {
    private static final int LINE_POINTS_NUMBER = 2;
    private static final int TRIANGLE_POINTS_NUMBER = 3;
    private static final int RECTANGLE_POINTS_NUMBER = 4;

    public static Shape create(List<Point> points) {
        Map<Integer, Function<List<Point>, Shape>> shapeMapper = new HashMap<>();
        shapeMapper.put(LINE_POINTS_NUMBER, Line::new);
        shapeMapper.put(TRIANGLE_POINTS_NUMBER, Triangle::new);
        shapeMapper.put(RECTANGLE_POINTS_NUMBER, Rectangle::new);
        return shapeMapper.get(points.size()).apply(points);
    }
}
