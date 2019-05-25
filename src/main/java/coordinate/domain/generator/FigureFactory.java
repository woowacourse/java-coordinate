package coordinate.domain.generator;

import coordinate.domain.*;

public enum FigureFactory {
    LINE(Line.NUMBER_OF_POINTS, Line::new),
    TRIANGLE(Triangle.NUMBER_OF_POINTS, Triangle::new),
    SQUARE(Square.NUMBER_OF_POINTS, Square::new);

    private final int numberOfPoints;
    private final FigureGenerator figureGenerator;

    FigureFactory(final int numberOfPoints, final FigureGenerator figureGenerator) {
        this.numberOfPoints = numberOfPoints;
        this.figureGenerator = figureGenerator;
    }

    public static Figure generate(Points points) {
        for (FigureFactory type : FigureFactory.values()) {
            if (type.numberOfPoints == points.size()) {
                return type.figureGenerator.create(points);
            }
        }
        throw new IllegalArgumentException("삼각형 또는 사각형만");
    }
}
