package coordinate.domain;

import coordinate.Figure;
import coordinate.domain.figure.Triangle;

import java.util.List;

public class TriangleCreator implements FigureCreator {

    @Override
    public Figure create(final List<Point> points) {
        return Triangle.of(points);
    }
}
