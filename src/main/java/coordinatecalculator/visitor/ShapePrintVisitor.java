package coordinatecalculator.visitor;

import coordinatecalculator.domain.Line;
import coordinatecalculator.domain.Rectangle;
import coordinatecalculator.domain.Triangle;

public class ShapePrintVisitor implements Visitor {
    private static final String OUTPUT_LINE_DISTANCE = "두 점 사이 거리는 ";
    private static final String OUTPUT_TRIANGLE_AREA = "삼격형 넓이는 ";
    private static final String OUTPUT_RECTANGLE_AREA = "사각형 넓이는 ";

    @Override
    public String visit(final Line line) {
        return OUTPUT_LINE_DISTANCE + line.getLineLength();
    }

    @Override
    public String visit(final Triangle triangle) {
        return OUTPUT_TRIANGLE_AREA + triangle.area();
    }

    @Override
    public String visit(final Rectangle rectangle) {
        return OUTPUT_RECTANGLE_AREA + rectangle.area();
    }
}
