package coordinate.model.creator;

import coordinate.model.Figure;
import coordinate.model.Point;

import java.util.List;

public interface FigureCreator {
    Figure create(List<Point> points);
}
