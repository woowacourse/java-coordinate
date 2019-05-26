package coordinatecalculator.domain;

import java.util.List;

public interface FigureCreator {
    Figure create(final List<Point> points);
}
