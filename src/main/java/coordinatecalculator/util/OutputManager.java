package coordinatecalculator.util;

import coordinatecalculator.domain.Line;
import coordinatecalculator.domain.Rectangle;
import coordinatecalculator.domain.Shape;
import coordinatecalculator.domain.Triangle;

public class OutputManager {

    private static final String OUTPUT_LINE_DISTANCE = "두 점 사이 거리는 ";
    private static final String OUTPUT_TRIANGLE_AREA = "삼격형 넓이는 ";
    private static final String OUTPUT_RECTANGLE_AREA = "사각형 넓이는 ";

    public static void separateShape(Shape shape) {
        if (shape instanceof Line) {
            OutputView.printScore(OUTPUT_LINE_DISTANCE, shape.getScore());
        }

        if (shape instanceof Triangle) {
            OutputView.printScore(OUTPUT_TRIANGLE_AREA, shape.getScore());
        }

        if (shape instanceof Rectangle) {
            OutputView.printScore(OUTPUT_RECTANGLE_AREA, shape.getScore());
        }
    }
}
