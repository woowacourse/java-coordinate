package coordinate.model.creator;

import coordinate.model.Figure;
import coordinate.model.Line;
import coordinate.model.Vertices;

public class LineCreator implements FigureCreator {
    @Override
    public Figure create(Vertices vertices) {
        return new Line(vertices);
    }
}
