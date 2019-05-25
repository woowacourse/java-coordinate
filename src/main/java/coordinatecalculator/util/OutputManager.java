package coordinatecalculator.util;

import coordinatecalculator.domain.Shape;
import coordinatecalculator.visitor.ShapePrintViewVisitor;

public class OutputManager {
    public static void separateShape(final Shape shape) {
        OutputView.printScore(shape.separateByVisitor(new ShapePrintViewVisitor()));
    }
}
