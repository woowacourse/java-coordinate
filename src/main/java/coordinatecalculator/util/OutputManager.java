package coordinatecalculator.util;

import coordinatecalculator.domain.Shape;
import coordinatecalculator.visitor.ShapePrintVisitor;

public class OutputManager {
    public static void separateShape(Shape shape) {
        OutputView.printScore(shape.separateShapeByVisitor(new ShapePrintVisitor()));
    }
}
