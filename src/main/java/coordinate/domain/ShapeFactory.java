package coordinate.domain;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Function;

public class ShapeFactory implements ShapeCreator {
    private static Map<Integer, Function<List<Point>, Shape>> functionMap = new HashMap<>();

    static {
        functionMap.put(2, Line::new);
        functionMap.put(3, Triangle::new);
        functionMap.put(4, Rectangle::new);
    }

    @Override
    public Shape create(List<Point> points) {
        return functionMap.get(points.size()).apply(points);
    }
}
