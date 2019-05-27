package coordinate.domain;

import coordinate.Figure;
import coordinate.domain.FigureCreator;
import coordinate.domain.Line;
import coordinate.domain.Point;

import java.util.List;

public class LineCreator implements FigureCreator {
    @Override
    public Figure create(List<Point> points) {
        return Line.of(points);
    }
}
