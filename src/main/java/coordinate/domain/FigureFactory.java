package coordinate.domain;

import java.util.HashMap;
import java.util.List;

public class FigureFactory {
    private static final int NUMBER_OF_POINTS_IN_LINE = 2;
    private static final int NUMBER_OF_POINTS_TRIANGLE = 3;
    private static final int NUMBER_OF_POINTS_IN_RECTANGLE = 4;

    private static final HashMap<Integer, FigureCreator> figureCreators = new HashMap<>();

    static {
        figureCreators.put(NUMBER_OF_POINTS_IN_LINE, new FigureCreator(StraightLine::create));
        figureCreators.put(NUMBER_OF_POINTS_TRIANGLE, new FigureCreator(Triangle::create));
        figureCreators.put(NUMBER_OF_POINTS_IN_RECTANGLE, new FigureCreator(Rectangle::create));
    }

    public static CalculableFigure getFigureOf(List<Point> points) {
        if (figureCreators.containsKey(points.size())) {
            return figureCreators.get(points.size()).createFigureBy(points);
        }

        throw new IllegalArgumentException("도형을 만들 수 없습니디.");
    }
}
