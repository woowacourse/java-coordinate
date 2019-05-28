package coordinatecalculator.factory;

import coordinatecalculator.domain.Coordinates;
import coordinatecalculator.domain.Shape;
import coordinatecalculator.util.InputManager;
import coordinatecalculator.util.OutputView;

public class ShapeMaker {
    public static Shape createShape() {
        try {
            return createShape(InputManager.getCoordinates());
        } catch (IllegalArgumentException e) {
            OutputView.printErrorMessage(e.getMessage());
            return createShape();
        }
    }

    public static Shape createShape(final Coordinates coordinates) {
        return ShapeType.valueOf(coordinates.getNumberOfCoordinates()).create(coordinates);
    }

}
