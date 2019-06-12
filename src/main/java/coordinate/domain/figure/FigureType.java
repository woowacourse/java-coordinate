package coordinate.domain.figure;

import java.util.Arrays;

public enum FigureType {
    LINE(2),
    TRIANGLE(3),
    RECTANGLE(4);

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
