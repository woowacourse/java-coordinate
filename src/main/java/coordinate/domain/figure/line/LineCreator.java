package coordinate.domain.figure.line;

import coordinate.domain.figure.Figure;
import coordinate.domain.figure.FigureCreator;
import coordinate.domain.point.Point;

import java.util.List;

public class LineCreator implements FigureCreator {
    @Override
    public Figure create(List<Point> points) {
        return new Line(points);
    }
}
