package coordinate.domain.figure;

import coordinate.domain.figure.line.LineCreator;
import coordinate.domain.figure.rectangle.RectangleCreator;
import coordinate.domain.figure.triangle.TriangleCreator;
import coordinate.domain.point.Point;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class FigureFactory {
    private static Map<FigureType, FigureCreator> creators = new HashMap<>();

    static {
        creators.put(FigureType.LINE, new LineCreator());
        creators.put(FigureType.TRIANGLE, new TriangleCreator());
        creators.put(FigureType.RECTANGLE, new RectangleCreator());
    }

    public static Figure getFigure(List<Point> points) {
        FigureCreator figureCreator = creators.get(FigureType.valueOf(points.size()));
        return figureCreator.create(points);
    }
}
