package coordinate.domain.figure;

import coordinate.domain.figure.line.Line;
import coordinate.domain.figure.rectangle.Rectangle;
import coordinate.domain.figure.triangle.Triangle;

import java.util.Arrays;

public enum FigureType {
    LINE(Line.LINE_SIZE),
    TRIANGLE(Triangle.TRIANGLE_SIZE),
    RECTANGLE(Rectangle.RECTANGLE_SIZE);

    private final int numOfPoints;

    FigureType(int numOfPoints) {
        this.numOfPoints = numOfPoints;
    }

    public static FigureType valueOf(int numOfPoints) {
        return Arrays.stream(values())
                .filter((figureType) -> isEqualNumOfPoints(figureType, numOfPoints))
                .findAny()
                .orElseThrow(() -> new InvalidFigureTypeException("유효하지 않은 도형입니다."));
    }

    private static boolean isEqualNumOfPoints(FigureType figureType, int numOfPoints) {
        return figureType.numOfPoints == numOfPoints;
    }
}
