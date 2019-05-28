package coordinate.domain;

import java.util.HashMap;
import java.util.function.Function;

public class FigureFactory {
    public static Figure generateFigure(Points points) {
        HashMap<Integer, Function<Points,Figure>> hashMap = new HashMap<>();

        hashMap.put(Line.POINTS_NUMBER, (c) -> {
           return LineFactory.generateLine(c.getPoint(0), c.getPoint(1));
        });
        hashMap.put(Triangle.POINT_NUMBER, (c) -> {
            return new Triangle(LineFactory.generateLines(c));
        });
        hashMap.put(Square.POINT_NUMBER, (c) -> {
            return new Square(LineFactory.generateLines(c));
        });

        return hashMap.get(points.getSize()).apply(points);
    }
}
