package coordinate.model;

import java.util.Objects;

public abstract class AbstractFigure implements Figure {
    protected static final int FIRST_POINT = 0;
    protected static final int SECOND_POINT = 1;
    protected static final int THIRD_POINT = 2;
    protected static final int FOURTH_POINT = 3;

    protected final Vertices vertices;

    AbstractFigure(Vertices vertices) {
        checkFigureSize(vertices);
        this.vertices = vertices;
    }

    private void checkFigureSize(Vertices vertices) {
        if (vertices.getSize() != countOfPoints()) {
            throw new IllegalArgumentException();
        }
    }

    @Override
    public Vertices getVertices() {
        return vertices;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        AbstractFigure that = (AbstractFigure) o;
        return Objects.equals(vertices, that.vertices);
    }

    @Override
    public int hashCode() {
        return Objects.hash(vertices);
    }
}
