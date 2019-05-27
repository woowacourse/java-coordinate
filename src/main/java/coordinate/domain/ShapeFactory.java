package coordinate.domain;

import java.util.HashMap;
import java.util.function.Function;

public class ShapeFactory {
    static final int MIN_POINTS_SIZE = 2;
    static final int MAX_POINTS_SIZE = 4;
    private static HashMap<Integer, Function<Points, Shape>> shapeHashMap = new HashMap<>();

    public static Shape create(Points points) {
        if (points == null) {
            throw new IllegalArgumentException("Points가 null이면 안됩니다");
        }
        if (points.size() < MIN_POINTS_SIZE || points.size() > MAX_POINTS_SIZE) {
            throw new IllegalArgumentException(String.format("Points의 길이는 %d ~ %d 입니다", MIN_POINTS_SIZE, MAX_POINTS_SIZE));
        }
        initShapeHashMap();
        return shapeHashMap.get(points.size()).apply(points);
    }

    private static void initShapeHashMap() {
        if (shapeHashMap != null) {
            shapeHashMap = new HashMap<>();
            shapeHashMap.put(2, Line::new);
            shapeHashMap.put(3, Triangle::new);
            shapeHashMap.put(4, Rectangle::new);
        }
    }
}
