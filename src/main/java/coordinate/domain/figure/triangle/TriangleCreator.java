package coordinate.domain.figure.triangle;

import coordinate.domain.figure.Figure;
import coordinate.domain.figure.FigureCreator;
import coordinate.domain.point.Point;

import java.util.List;

public class TriangleCreator implements FigureCreator {
    @Override
    public Figure create(List<Point> points) {
        return new Triangle(points);
    }
}
