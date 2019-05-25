package coordinatecalculator.domain;

import java.util.List;

public interface FigureCreator {
    Area create(List<Point> points);
}
