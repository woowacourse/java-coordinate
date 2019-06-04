package coordinate.domain;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class FigureFactory {
    private static final int LINE = 2;
    private static final int TRIANGLE = 3;
    private static final int RECTANGLE = 4;

    private static Map<Integer, FigureCreatable> creators = new HashMap<>();

    static {
        creators.put(LINE, new LineCreator());
        creators.put(TRIANGLE, new TriangleCreator());
        creators.put(RECTANGLE, new RectangleCreator());
    }

    public static Figure figure(List<Point> points) {
        FigureCreatable figureCreator = creators.get(points.size());
        if (figureCreator == null) {
            throw new IllegalArgumentException(ExceptionMessages.INVALID_COORDI.message());
        }

        try {
            return figureCreator.create(points);
        } catch (NullPointerException e) {
            throw new IllegalArgumentException(ExceptionMessages.INVALID_COORDI.message());
        }
    }
}

class LineCreator implements FigureCreatable {
    @Override
    public Figure create(List<Point> points) {
        return new Line(points);
    }
}

class TriangleCreator implements FigureCreatable {
    @Override
    public Figure create(List<Point> points) {
        return new Triangle(points);
    }
}

class RectangleCreator implements FigureCreatable {
    @Override
    public Figure create(List<Point> points) {
        return new Rectangle(points);
    }
}
