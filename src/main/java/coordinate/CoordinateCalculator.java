package coordinate;

import coordinate.domain.Point;
import coordinate.domain.Shape;
import coordinate.domain.ShapeGenerator;
import coordinate.view.InputView;
import coordinate.view.OutputView;

import java.util.List;

public class CoordinateCalculator {

    public static void main(String[] args) {
        Shape shape = createShape();

        OutputView.printArea(shape);
    }

    private static Shape createShape() {
        try {
            List<Point> points = ShapeGenerator.generatePoints(InputView.inputCoordinate());
            return ShapeGenerator.create(points);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return createShape();
        }
    }
}
