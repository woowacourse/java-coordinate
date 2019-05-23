package coordinate;

import coordinate.domain.Shape;
import coordinate.domain.ShapeGenerator;
import coordinate.view.InputView;
import coordinate.view.OutputView;

public class CoordinateCalculator {

    public static void main(String[] args) {
        Shape shape = generateShape();
        OutputView.printArea(shape);
    }

    private static Shape generateShape() {
        try {
            return ShapeGenerator.generateShape(InputView.inputCoordinate());
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return generateShape();
        }
    }
}
