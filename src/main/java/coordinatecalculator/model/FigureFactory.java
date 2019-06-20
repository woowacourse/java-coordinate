package coordinatecalculator.model;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Function;

import static coordinatecalculator.model.FigureType.*;

public class FigureFactory {
    private static final Map<FigureType, Function<List<Point>, Figure>> creators;

    static {
        creators = new HashMap<>();
        creators.put(POINT, Point::new);
        creators.put(LINE, Line::new);
        creators.put(TRIANGLE, Triangle::new);
        creators.put(RECTANGLE, Rectangle::new);
    }

    public static Figure of(List<Point> points) {
        final FigureType type = FigureType.valueOf(points.size());
        return creators.get(type).apply(points);
    }
}