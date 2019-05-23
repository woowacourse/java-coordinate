package coordinatecalculator.visitor;

import coordinatecalculator.domain.Line;
import coordinatecalculator.domain.Rectangle;
import coordinatecalculator.domain.Triangle;

public interface Visitor {
    String visit(final Line line);

    String visit(final Triangle triangle);

    String visit(final Rectangle rectangle);
}
