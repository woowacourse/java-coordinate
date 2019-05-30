package coordinate.domain;

import java.util.List;

public interface FigureCreatable {
    Figure create(List<Point> points);
}
