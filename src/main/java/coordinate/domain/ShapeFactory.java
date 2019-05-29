package coordinate.domain;

import java.util.HashMap;
import java.util.function.Function;

public class ShapeFactory {
    public static final int LINE_POINT_SIZE = 2;
    public static final int TRIANGLE_POINT_SIZE = 3;
    public static final int RECTANGLE_POINT_SIZE = 4;

    static HashMap<Integer, Function<Points, Shape>> shapeHashMap = new HashMap<>();

    public static Shape create(Points points) {
        shapeHashMap.put(LINE_POINT_SIZE, Line::new);
        shapeHashMap.put(TRIANGLE_POINT_SIZE, Triangle::new);
        shapeHashMap.put(RECTANGLE_POINT_SIZE, Rectangle::new);

        return shapeHashMap.get(points.size()).apply(points);
    }
}
