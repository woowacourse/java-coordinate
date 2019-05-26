package coordinate.domain.creator;

import coordinate.Figure;
import coordinate.domain.FigureCreator;
import coordinate.domain.Point;
import coordinate.domain.Triangle;

import java.util.List;

public class TriangleCreator implements FigureCreator {

    @Override
    public Figure create(final List<Point> points) {
        return Triangle.of(points);
    }
}
