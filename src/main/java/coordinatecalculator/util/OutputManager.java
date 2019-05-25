package coordinatecalculator.util;

import coordinatecalculator.domain.Shape;
import coordinatecalculator.visitor.ShapeViewVisitor;

public class OutputManager {
    public static void separateShape(final Shape shape) {
        OutputView.printScore(shape.separateByVisitor(new ShapeViewVisitor()));
    }
}
