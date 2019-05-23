package coordinatecalculator.util;

import coordinatecalculator.domain.Shape;
import coordinatecalculator.view.OutputView;
import coordinatecalculator.visitor.ShapePrintVisitor;

public class OutputManager {
    public static void separateShape(Shape shape) {
        OutputView.printScore(shape.separateByVisitor(new ShapePrintVisitor()));
    }
}
