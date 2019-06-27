package coordinatecalculator.domain;

import coordinatecalculator.domain.parent.Figure;

import java.util.Arrays;
import java.util.function.Function;

public enum FigureType {
    LINE(2, Line::newInstance),
    TRIANGLE(3, Triangle::newInstance),
    RECTANGLE(4, Rectangle::newInstance);

    private static final String INVALID_FIGURE_MESSAGE = "허용된 도형이 아닙니다. 다시 입력해주세요.";

    private int countOfPoints;
    private Function<Points, Figure> figureFunction;

    FigureType(int countOfPoints, Function<Points, Figure> figureFunction) {
        this.countOfPoints = countOfPoints;
        this.figureFunction = figureFunction;
    }

    public static Figure routing(Points points) {
        return FigureType.selectFigure(points);
    }

    private static Figure selectFigure(Points points) {
        return Arrays.stream(values())
                .filter(p -> p.countOfPoints == points.size())
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException(INVALID_FIGURE_MESSAGE))
                .figureFunction.apply(points);
    }
}
