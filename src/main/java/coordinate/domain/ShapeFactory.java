package coordinate.domain;

import java.util.HashMap;
import java.util.function.Function;

public class ShapeFactory {
    static HashMap<Integer, Function<Points, Shape>> shapeHashMap = new HashMap<>();

    public static Shape create(Points points) {
        shapeHashMap.put(2, Line::new);
        shapeHashMap.put(3, Triangle::new);
        shapeHashMap.put(4, Rectangle::new);

        return shapeHashMap.get(points.size()).apply(points);
    }
}
