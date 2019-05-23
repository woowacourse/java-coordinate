package coordinate.domain;

import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;

public class FigureFactory implements FigureCreator {
    private static Map<Integer, Function<Points, Figure>> functionMap = new HashMap<>();

    static {
        functionMap.put(3, Triangle::new);
        functionMap.put(4, Rectangle::new);
    }

    @Override
    public Figure create(Points points) {
        return functionMap.get(points.size()).apply(points);
    }

}
