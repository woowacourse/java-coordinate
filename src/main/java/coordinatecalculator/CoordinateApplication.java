package coordinatecalculator;

import coordinatecalculator.domain.Shape;
import coordinatecalculator.factory.ShapeMaker;
import coordinatecalculator.util.OutputManager;
import coordinatecalculator.view.OutputView;

public class CoordinateApplication {
    public static void main(String[] args) {
        Shape shape = ShapeMaker.createShape();
        OutputView.printBoardLine(shape.getCoordinate());
        OutputManager.separateShape(shape);
    }
}
