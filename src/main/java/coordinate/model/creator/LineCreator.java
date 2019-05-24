package coordinate.model.creator;

import coordinate.model.Figure;
import coordinate.model.Line;
import coordinate.model.Point;

import java.util.List;

public class LineCreator implements FigureCreator {
    @Override
    public Figure create(List<Point> points) {
        return new Line(points);
    }
}
