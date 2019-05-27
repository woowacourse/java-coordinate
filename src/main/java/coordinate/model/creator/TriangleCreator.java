package coordinate.model.creator;

import coordinate.model.Figure;
import coordinate.model.Triangle;
import coordinate.model.Vertices;

public class TriangleCreator implements FigureCreator {
    @Override
    public Figure create(Vertices vertices) {
        return new Triangle(vertices);
    }
}
