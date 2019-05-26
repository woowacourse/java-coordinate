package coordinatecalculator.factory;

import coordinatecalculator.domain.*;
import coordinatecalculator.util.InputManager;
import coordinatecalculator.util.OutputView;

import java.util.List;

public class ShapeMaker {
    public static Shape createShape() {
        try {
            return createShape(InputManager.getCoordinates());
        } catch (IllegalArgumentException e) {
            OutputView.printErrorMessage(e.getMessage());
            return createShape();
        }
    }

    public static Shape createShape(final List<Coordinate> coordinates) {
        return ShapeType.valueOf(coordinates.size()).create(coordinates);
    }

}
