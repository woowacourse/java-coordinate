package coordinate.model.creator;

import coordinate.model.Figure;
import coordinate.model.Point;
import coordinate.model.Triangle;

import java.util.List;

public class TriangleCreator implements FigureCreator {
    @Override
    public Figure create(List<Point> points) {
        return new Triangle(points);
    }
}
