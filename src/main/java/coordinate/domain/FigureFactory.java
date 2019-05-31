package coordinate.domain;

import java.util.*;

public class FigureFactory implements FigureCreator {
    private static Map<FigureType, FigureCreator> methodMapping = new HashMap<>();

    static {
        methodMapping.put(FigureType.RECTANGLE, new RectangleCreator());
        methodMapping.put(FigureType.TRIANGLE, new TriangleCreator());
        methodMapping.put(FigureType.LINE, new LineCreator());
    }

    @Override
    public Figure create(List<Point> points) {
        FigureCreator factory = methodMapping.get(FigureType.valueOf(points.size()));
        return factory.create(points);
    }
}