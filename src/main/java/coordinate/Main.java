package coordinate;

import coordinate.model.*;
import coordinate.view.InputView;
import coordinate.view.OutputView;

public class Main {

    public static void main(String[] args) {
        Shape shape = createShape();
        OutputView.printCoordinate(shape);
        OutputView.printResult(shape);
    }

    private static Shape createShape() {
        try {
            PointGenerator converter = new ConsolePointGenerator(InputView.inputPoint());
            return ShapeFactory.create(converter.generate());
        } catch (IllegalArgumentException e) {
            System.err.println(e.getMessage());
            return createShape();
        }
    }
}
