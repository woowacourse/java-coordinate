package coordinate.domain;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class FigureFactory {
    private static Map<Integer, FigureCreatable> creators = new HashMap<>();

    static {
        creators.put(2, new LineCreator());
        creators.put(3, new TriangleCreator());
        creators.put(4, new RectangleCreator());
    }

    public static Figure figure(List<Point> points) {
        FigureCreatable figureCreator = creators.get(points.size());
        if (figureCreator == null) {
            throw new IllegalArgumentException("유효하지 않은 도형입니다.");
        }
        return figureCreator.create(points);
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
