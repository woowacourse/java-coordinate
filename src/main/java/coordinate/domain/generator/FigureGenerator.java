package coordinate.domain.generator;

import coordinate.domain.Figure;
import coordinate.domain.Points;

@FunctionalInterface
public interface FigureGenerator {
    Figure create(Points points);
}