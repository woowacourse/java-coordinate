package coordinate.model.creator;

import coordinate.model.Figure;
import coordinate.model.Rectangle;
import coordinate.model.Vertices;

public class RectangleCreator implements FigureCreator {
    @Override
    public Figure create(Vertices vertices) {
        return new Rectangle(vertices);
    }
}
