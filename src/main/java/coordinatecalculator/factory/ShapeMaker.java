package coordinatecalculator.factory;

import coordinatecalculator.domain.*;

import java.util.List;

public class ShapeMaker {
    private static final int COORDINATES_FOR_LINE = 2;
    private static final int COORDINATES_FOR_TRIANGLE = 3;
    private static final int COORDINATES_FOR_RECTANGLE = 4;

    public static Shape createShape(final List<Coordinate> coordinates) {
        if (coordinates.size() == COORDINATES_FOR_TRIANGLE) {
            return new Triangle(coordinates);
        }

        if (coordinates.size() == COORDINATES_FOR_RECTANGLE) {
            return new Rectangle(coordinates);
        }

        if (coordinates.size() == COORDINATES_FOR_LINE) {
            return new Line(coordinates);
        }

        throw new IllegalArgumentException("도형을 생성할 수 없어요");
    }
}
