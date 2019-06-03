package coordinate.domain;

import java.util.List;

public interface FigureCreator {
    CalculableFigure createFigureBy(List<Point> points);
}
