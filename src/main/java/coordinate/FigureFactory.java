package coordinate;

import coordinate.domain.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class FigureFactory {
    private static final Map<Integer, FigureCreator> MAP;

    static {
        MAP = new HashMap<>();
        MAP.put(Integer.valueOf(1), new NotFigureCreator());
        MAP.put(Integer.valueOf(2), new LineCreator());
        MAP.put(Integer.valueOf(3), new TriangleCreator());
        MAP.put(Integer.valueOf(4), new SquareCreator());
    }

    private FigureFactory() {
    }

    public static FigureFactory getInstance() {
        return SingleTon.SINGLETON_INSTANCE;
    }

    private static class SingleTon {
        public static final FigureFactory SINGLETON_INSTANCE = new FigureFactory();
    }

    public Figure create(final List<Point> points) {
        try {
            return MAP.get(points.size()).create(points);
        } catch (RuntimeException e) {
            throw new IllegalArgumentException();
        }
    }
}
