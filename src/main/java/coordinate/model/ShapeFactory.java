package coordinate.model;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Function;

public class ShapeFactory {

    public static final int LINE_NUMBER_OF_POINTS = 2;
    public static final int TRIANGLE_NUMBER_OF_POINTS = 3;
    public static final int SQUARE_NUMBER_OF_POINTS = 4;

    private static final Map<Integer, Function<List<Point>, Shape>> creator
            = new HashMap<Integer, Function<List<Point>, Shape>>() {
        {
            put(LINE_NUMBER_OF_POINTS, Line::new);
            put(TRIANGLE_NUMBER_OF_POINTS, Triangle::new);
            put(SQUARE_NUMBER_OF_POINTS, Square::new);
        }
    };

    public static Shape create(List<Point> points) {
        return creator.get(points.size()).apply(points);
    }
}
