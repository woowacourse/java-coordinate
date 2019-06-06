package coordinate.domain;

import coordinate.domain.exceptions.FigureShapeMismatchException;

public class Figure {
    private final Vertices vertices;

    Figure(Vertices vertices, int validLengthOfPoints) {
        validateLengthOfPoints(vertices, validLengthOfPoints);
        this.vertices = vertices;
    }

    protected Vertices getVertices() {
        return vertices;
    }

    private void validateLengthOfPoints(Vertices vertices, int validLengthOfPoints) {
        if (vertices.size() != validLengthOfPoints) {
            throw new FigureShapeMismatchException(this.getClass().getName() + "의 점의 개수가 올바르지 않습니다.");
        }
    }

    public PlaneCoordinates getPlaneCoordinates() {
        return new PlaneCoordinates(Point.MAX_X, Point.MAX_Y).plotPoints(vertices.getPoints());
    }
}
