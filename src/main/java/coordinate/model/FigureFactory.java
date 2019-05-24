package coordinate.model;

import coordinate.model.creator.LineCreator;
import coordinate.model.creator.FigureCreator;
import coordinate.model.creator.RectangleCreator;
import coordinate.model.creator.TriangleCreator;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class FigureFactory {
    private final static int LINE = 2;
    private final static int TRIANGLE = 3;
    private final static int RECTANGLE = 4;

    private static final Map<Integer, FigureCreator> figures;

    static {
        figures = new HashMap<>();
        figures.put(LINE, new LineCreator());
        figures.put(TRIANGLE, new TriangleCreator());
        figures.put(RECTANGLE, new RectangleCreator());
    }

    public static Figure getInstance(List<Point> points) {
        return figures.get(points.size()).create(points);
    }
}
