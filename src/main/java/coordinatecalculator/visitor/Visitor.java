package coordinatecalculator.visitor;

import coordinatecalculator.domain.Line;
import coordinatecalculator.domain.Rectangle;
import coordinatecalculator.domain.Triangle;

public interface Visitor {
    String visit(Line line);

    String visit(Triangle triangle);

    String visit(Rectangle rectangle);
}
