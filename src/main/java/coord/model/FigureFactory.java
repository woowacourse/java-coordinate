package coord.model;

import coord.view.ConsoleMessages;

import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;

public abstract class FigureFactory {
    private static final int TRIANGLE = 3;
    private static final int QUADRANGLE = 4;
    private static Map<Integer, Function<Points, Figure>> figureMap;

    private FigureFactory() {
    }

    public static Figure getInstance(Points points) {
        if (figureMap == null) {
            setFigureMap();
        }
        try {
            return figureMap.get(points.size()).apply(points);
        } catch (NullPointerException e) {
            throw new IllegalArgumentException(ConsoleMessages.ERR_FIGURE.message());
        }
    }

    private static void setFigureMap() {
        figureMap = new HashMap<>();
        figureMap.put(TRIANGLE, point -> new Triangle(point));
        figureMap.put(QUADRANGLE, point -> new Quadrangle(point));
    }
}
