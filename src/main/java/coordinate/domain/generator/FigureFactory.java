package coordinate.domain.generator;

import coordinate.domain.Figure;
import coordinate.domain.Points;
import coordinate.domain.Square;
import coordinate.domain.Triangle;

public class FigureFactory {
    private static final int TRIANGLE = 3;
    private static final int SQUARE = 4;

    public static Figure generate(Points points) {
        if (points.size() == SQUARE) {
            return new Square(points);
        } else if (points.size() == TRIANGLE) {
            return new Triangle(points);
        }
        throw new IllegalArgumentException("삼각형 또는 사각형만");
    }
}
