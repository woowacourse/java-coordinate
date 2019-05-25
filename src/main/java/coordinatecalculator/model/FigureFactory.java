package coordinatecalculator.model;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class FigureFactory {
    private static final int NUMBER_OF_POINTS_IN_LINE = 2;
    private static final int NUMBER_OF_POINTS_IN_TRIANGLE = 3;
    private static final int NUMBER_OF_POINTS_IN_RECTANGLE = 4;

    private static final Map<Integer, FigureMaker> figures = new HashMap<>();

    static {
        figures.put(NUMBER_OF_POINTS_IN_LINE, FigureMaker.Line_MAKER);
        figures.put(NUMBER_OF_POINTS_IN_TRIANGLE, FigureMaker.TRIANGLE_MAKER);
        figures.put(NUMBER_OF_POINTS_IN_RECTANGLE, FigureMaker.RECTANGLE_MAKER);
    }

    public static Figure generateFigure(String points) {
        //split string
        List<String> values = StringSplitter.split(points);
        //make Points
        Points figurePoints = new Points(values);
        //make figure instance
        return makeInstance(figurePoints);
    }

    private static Figure makeInstance(Points points) {
        return figures.get(points.getPointCount()).makeFigure(points);
    }

}
