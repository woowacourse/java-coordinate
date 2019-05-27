package coordinate.domain;

import java.util.List;

public interface FigureFactory {
    Figure create(List<Line> lines);
}
