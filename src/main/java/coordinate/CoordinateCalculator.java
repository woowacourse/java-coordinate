package coordinate;

import coordinate.domain.Shape;
import coordinate.domain.ShapeGenerator;
import coordinate.view.InputView;

public class CoordinateCalculator {

    public static void main(String[] args) {
        Shape shape = generateShape();
        System.out.println(shape.area());
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
