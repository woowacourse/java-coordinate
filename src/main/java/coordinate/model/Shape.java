package coordinate.model;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Function;

public interface Shape {
    public static final Map<Integer, Function<List<Point>, Shape>> creator = new HashMap<Integer, Function<List<Point>, Shape>>() {
        {
            put(2, Line::new);
            put(3, Triangle::new);
            put(4, Rectangular::new);
        }
    };
}
