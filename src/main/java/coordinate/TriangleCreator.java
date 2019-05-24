package coordinate;

import java.util.List;

public class TriangleCreator implements FigureCreator {

    @Override
    public Figure create(final List<Point> points) {
        return Triangle.of(points);
    }
}
