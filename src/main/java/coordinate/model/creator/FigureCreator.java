package coordinate.model.creator;

import coordinate.model.Figure;
import coordinate.model.Vertices;

public interface FigureCreator {
    Figure create(Vertices vertices);
}
