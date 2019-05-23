package coordinatecalculator.factory;

import coordinatecalculator.domain.*;
import coordinatecalculator.util.InputManager;
import coordinatecalculator.util.OutputView;

import java.util.List;

public class ShapeMaker {
    static final int COORDINATES_FOR_LINE = 2;
    static final int COORDINATES_FOR_TRIANGLE = 3;
    static final int COORDINATES_FOR_RECTANGLE = 4;

    public static Shape createShape() {
        try {
            return createShape(InputManager.getCoordinates());
        } catch (IllegalArgumentException e) {
            OutputView.PrintErrorMessage(e.getMessage());
            return createShape();
        }
    }

    public static Shape createShape(final List<Coordinate> coordinates) {
        return ShapeType.valueOf(coordinates.size()).create(coordinates);
    }

}
