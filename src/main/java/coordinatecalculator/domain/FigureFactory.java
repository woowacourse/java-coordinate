package coordinatecalculator.domain;

import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;

import static coordinatecalculator.domain.FigureType.*;

public class FigureFactory {
    private static Map<FigureType, Function<PointGroup, Figure>> figures;

    static {
        figures = new HashMap<>();
        figures.put(LINE, Line::new);
        figures.put(TRIANGLE, Triangle::new);
        figures.put(RECTANGLE, Rectangle::new);
    }

    public static Figure create(PointGroup points) {
        return figures.get(getFigureType(points)).apply(points);
    }

    private static FigureType getFigureType(PointGroup points) {
        return FigureType.valueOf(points.getPointsCount());
    }
}
